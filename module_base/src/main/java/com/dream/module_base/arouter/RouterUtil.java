package com.dream.module_base.arouter;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import me.yokeyword.fragmentation.ISupportFragment;

/**
 * Created by zy on 2018/12/21.
 */
public class RouterUtil {

    public static ISupportFragment getFragment(String routerPath){
        return (ISupportFragment) ARouter.getInstance().build(routerPath).navigation();
    }


    public static void navigation(String routerPath, Bundle bundle){
        ARouter.getInstance().build(routerPath).with(bundle).navigation();
    }


    public static void navigation(String routerPath){
        ARouter.getInstance().build(routerPath).navigation();
    }
}
