package me.halin.testapp.ModelExtensionDemo;

import me.halin.fundamental.ModelExtension.ModelExtension;

/**
 * Created by Halin on 9/14/16.
 */
public class ModelExtensionUIModel extends ModelExtension<ModelExtensionDBModel> {
    public ModelExtensionUIModel(ModelExtensionDBModel modelExtensionDBModel) {
        super(modelExtensionDBModel);
    }

    public int getAgeLevel() {
        return model.getAge() / 10;
    }

}
