package me.halin.testapp.ModuleLoader;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import me.halin.testapp.AnnotationAccessor.AnnotationAccessor;
import me.halin.testapp.LogUtil.Logger;

/**
 * 模块加载工具
 * <p>
 * Created by 17track on 3/26/16.
 */
public class ModuleLoader {

    private static final String TAG = ModuleLoader.class.getName();

    //region 单例
    private static final ModuleLoader mInstance = new ModuleLoader();

    public static ModuleLoader getInstance() {
        return mInstance;
    }

    private ModuleLoader() {
    }

    //endregion

    /**
     * 配置项map key:模块名称,value:配置项
     */
    private final Map<String, ConfigurableInterface> configMap = new HashMap<>();


    private Context context;

    /**
     * 模块转换表
     */
    private AnnotationAccessor moduleMap;

    /**
     * 放在assets的默认配置文件名称
     */
    private String defaultConfigFileName;

    /**
     * 配置文件
     */
    private File configFile;

    /**
     * 全局配置项
     */
    private Object globalConfiguration;

    /**
     * 加载module,只允许在启动时调用一次,更细调用update
     */
    public void loadModule(Context context, Object globalConfiguration, Class moduleMapClass, String defaultConfigFileName, File configFile) {

        //获得模块表
        this.context = context;
        this.globalConfiguration = globalConfiguration;
        moduleMap = new AnnotationAccessor(moduleMapClass, ModuleName.class);
        this.defaultConfigFileName = defaultConfigFileName;
        this.configFile = configFile;

        update();

        //调用初始化方法
        for (Object module : configMap.values()) {
            if (module instanceof InitializableInterface) {
                ((InitializableInterface) module).setup();
            }
        }

    }

    /**
     * 重新载入配置信息,(从loadModule指定的配置文件读取)
     */
    private void update() {

        //还原所有默认值
        for (ConfigurableInterface configurable : configMap.values()) {
            configurable.resetToDefaultValue();
        }

        //加载默认配置
        Document document;
        try {
            InputStream inputStream = context.getAssets().open(defaultConfigFileName);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(inputStream);
            //结果解析出错
        } catch (ParserConfigurationException e) {
            Logger.logE(TAG, "加载模块列表解析出错 :" + defaultConfigFileName);
            return;
        } catch (SAXException e) {
            Logger.logE(TAG, "加载模块列表解析出错 :" + defaultConfigFileName);
            return;
        } catch (IOException e) {
            Logger.logE(TAG, "加载模块列表解析出错 :" + defaultConfigFileName);
            return;
        }
        Element defaultEnvironmentNode = document.getDocumentElement();

        //解析Global配置
        NodeList globals = defaultEnvironmentNode.getElementsByTagName("Global");
        if (globals.getLength() != 1) {
            Logger.logE(TAG, "Global数量异常 %d", globals);
        }
        parseNodeToConfiguration(globals.item(0), globalConfiguration);

        //解析模块配置
        parseModuleConfiguration(moduleMap, defaultEnvironmentNode);


        //加载本地配置
        if (configFile == null || !configFile.exists()) {
            //本地配置文件不存在,不初始化
            return;
        }
        InputStream localFileInputStream = null;
        try {
            localFileInputStream = new FileInputStream(configFile);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(localFileInputStream);
        } catch (Exception e) {
            Logger.logE(TAG, "加载本地配置失败 %s", e);
        }

        if (document != null) {
            Element localEnvironmentNode = document.getDocumentElement();
            //解析模块配置
            parseModuleConfiguration(moduleMap, localEnvironmentNode);
        }

    }

    /**
     * 解析所有xml module项
     */
    private void parseModuleConfiguration(AnnotationAccessor moduleMap, Element environmentNode) {
        NodeList moduleList = environmentNode.getElementsByTagName("Module");
        int count = moduleList.getLength();
        for (int index = 0; index < count; index++) {
            Node moduleNode = moduleList.item(index);
            String moduleName = moduleNode.getAttributes().getNamedItem("androidName").getTextContent();
            ConfigurableInterface moduleConfiguration = configMap.get(moduleName);
            if (moduleConfiguration == null) {
                Class<InitializableInterface> moduleClass = (Class) moduleMap.get(null, moduleName);
                try {
                    moduleConfiguration = moduleClass.newInstance();
                } catch (InstantiationException e) {
                    Logger.logE(TAG, "获得Configuration实例失败 %s", e);
                    continue;
                } catch (IllegalAccessException e) {
                    Logger.logE(TAG, "获得Configuration实例失败 %s", e);
                    continue;
                }
                configMap.put(moduleName, moduleConfiguration);
            }
            if (moduleConfiguration != null) {
                parseNodeToConfiguration(moduleNode, moduleConfiguration);
            }
        }
    }

    /**
     * 将xml node解析到configuration
     */
    private void parseNodeToConfiguration(Node elementNode, Object configuration) {

        AnnotationAccessor setter = new AnnotationAccessor(configuration.getClass(), ConfigField.class);
        NodeList nodeList = elementNode.getChildNodes();


        int count = nodeList.getLength();
        for (int index = 0; index < count; index++) {

            Node node = nodeList.item(index);
            if (node.getNodeType() != node.ELEMENT_NODE) {
                //过滤无效节点
                continue;
            }


            String type = node.getNodeName();
            String name = node.getAttributes().getNamedItem("androidName").getTextContent();
            String value = node.getTextContent();

            boolean isSetSucceed = false;
            switch (type) {
                case "string":
                    isSetSucceed = setter.set(configuration, name, value);
                    break;
                case "bool":
                    isSetSucceed = setter.set(configuration, name, Boolean.parseBoolean(value));
                    break;
                case "integer":
                    isSetSucceed = setter.set(configuration, name, Integer.parseInt(value));
                    break;
                case "float":
                    isSetSucceed = setter.set(configuration, name, Float.parseFloat(value));
                    break;
            }

            if (!isSetSucceed) {
                Logger.logE(TAG, "设置参数 %s 失败,配置项:%s,类型:%s", name, configuration.getClass(), type);
            }
        }
    }

  /* 使用setter的方式,

   private void parseNodeToConfiguration(Node elementNode, ConfigurableInterface configuration) {

        NodeList nodeList = elementNode.getChildNodes();


        int count = nodeList.getLength();
        for (int index = 0; index < count; index++) {

            Node node = nodeList.item(index);
            if (node.getNodeType() != node.ELEMENT_NODE) {
                //过滤无效节点
                continue;
            }


            String type = node.getNodeName();
            String name = node.getAttributes().getNamedItem("androidName").getTextContent();
            String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            Method method = null;
            String value = node.getTextContent();
            try {
                switch (type) {
                    case "string":
                        method = configuration.getClass().getMethod(methodName, String.class);
                        method.invoke(configuration, value);
                        break;
                    case "bool":
                        method = configuration.getClass().getMethod(methodName, boolean.class);
                        method.invoke(configuration, Boolean.parseBoolean(value));
                        break;
                    case "integer":
                        method = configuration.getClass().getMethod(methodName, int.class);
                        method.invoke(configuration, Integer.parseInt(value));
                        break;
                    case "float":
                        method = configuration.getClass().getMethod(methodName, float.class);
                        method.invoke(configuration, Float.parseFloat(value));
                        break;
                }

            } catch (NoSuchMethodException e) {
                Logger.logE(TAG, "找不到对应方法:%s Element:%s error:%s", methodName, elementNode.getNodeName(), e);
            } catch (InvocationTargetException e) {
                Logger.logE(TAG, "找不到对应方法:%s Element:%s error:%s", methodName, elementNode.getNodeName(), e);
            } catch (IllegalAccessException e) {
                Logger.logE(TAG, "找不到对应方法:%s Element:%s error:%s", methodName, elementNode.getNodeName(), e);
            }

        }


    }
*/
}
