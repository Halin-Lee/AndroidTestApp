package me.halin.fundamental.ModelExtension;

/**
 * 将数据模型与UI模型分开
 * Created by halin on 12/28/16.
 */
public class ModelExtension<T> {

    public final T model;

    public ModelExtension(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

}
