package com.dream.module_base.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.dream.module_base.Latte;

/**
 * Created by zy on 2018/12/21.
 */
public class CommonUtil {

    /**
     * 获取Drawable
     * @param resid resid
     * @return Drawable
     */
    public static Drawable getDrawable(int resid) {
        return getResoure().getDrawable(resid);
    }

    /**
     * 获取颜色
     * @param resid resid
     * @return int
     */
    public static int getColor(int resid) {
        return getResoure().getColor(resid);
    }

    /**
     * 获取resources
     * @return Resources
     */
    public static Resources getResoure() {
        return Latte.getApplicationContext().getResources();
    }

    /**
     * 获取数组
     * @param resid
     * @return
     */
    public static String[] getStringArray(int resid) {
        return getResoure().getStringArray(resid);
    }

    /**
     * 获取string字符串
     * @param resid
     * @return
     */
    public static String getString(int resid) {
        return getResoure().getString(resid);
    }

    /**
     * 获取Dimens
     * @param resId resId
     * @return float
     */
    public static float getDimens(int resId) {
        return getResoure().getDimension(resId);
    }


}
