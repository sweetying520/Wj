package com.dream.module_base;

import android.content.Context;

/**
 * Created by zy on 2018/12/21.
 */
public class Latte {

    static Configurator init(Context mContext) {
        Configurator.getInstance().getConfigMap().put(ConfigType.CONTEXT, mContext);
        return Configurator.getInstance();
    }


    public static Context getApplicationContext() {
        return Configurator.getInstance().get(ConfigType.CONTEXT);
    }

    public static String getApiHost(){
        return Configurator.getInstance().get(ConfigType.API_HOST);
    }
}
