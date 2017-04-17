package com.cc.md.business;

import android.app.Application;
import android.util.Log;


/**
 * Created by cheng.qx on 2016/12/2.
 */

public class App extends Application {
    private final String TAG=getClass().getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "用于测试的功能1");
    }
}
