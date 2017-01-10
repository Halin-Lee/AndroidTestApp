package me.halin.testapp.SystemUI.databinding.DataObjects.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import me.halin.testapp.BR;

/**
 *
 * 被监听的子类对象
 *
 * Created by halin on 9/12/15.
 */
public class ObservableObjectModel extends BaseObservable {


    private String firstName;
    private String lastName;


    @Bindable                   //继承Bindable,使RB生成对应id
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);    //通知更新
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

}
