package halin.me.testapp.main;

import android.databinding.ObservableArrayList;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import halin.me.testapp.main.Model.TestGroup;

/**
 * Created by halin on 9/17/15.
 */
public class MainDataHolder {

    public final ObservableArrayList<TestGroup> testList = new ObservableArrayList<>();

    public List<TestGroup> getTestList() {
        return new ArrayList(testList);
    }

    public void setTestList(List<TestGroup> testList) {
        this.testList.clear();
        this.testList.addAll(testList);
    }

}
