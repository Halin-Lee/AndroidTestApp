package me.halin.android.ui.fragmentretaininstance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


public class RetainFragment extends Fragment {
    private String string;

    public RetainFragment() {
    }

    public static RetainFragment createContainer(@NonNull String string) {
        RetainFragment viewModelContainer = new RetainFragment();
        viewModelContainer.setString(string);
        return viewModelContainer;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
