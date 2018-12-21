package com.dream.module_base;

import android.app.Application;

/**
 * Created by zy on 2018/12/21.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withAroute(this)
                .withUtil(this)
                .withFragmentation()
                .withApiHost("http://127.0.0.1")
                .config();
    }
}
