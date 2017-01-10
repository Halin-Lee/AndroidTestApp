package me.halin.testapp.ModelExtensionDemo;

import me.halin.fundamental.ModelExtension.ModelExtension;

/**
 * 此处是UI模型，定义了里面具体实现的数据模型
 * <p>
 * Created by Halin on 9/14/16.
 */
public class ModelExtensionUIModel extends ModelExtension<ModelExtensionDBModel> {
    public ModelExtensionUIModel(ModelExtensionDBModel modelExtensionDBModel) {
        super(modelExtensionDBModel);
    }

    public int getAgeLevel() {
        return getModel().getAge() / 10;
    }

}
