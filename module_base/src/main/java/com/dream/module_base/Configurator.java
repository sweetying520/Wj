package com.dream.module_base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;

import java.util.HashMap;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

/**
 * Created by zy on 2018/12/21.
 */
public class Configurator {

    private static HashMap<Object, Object> CONFIG_MAP;

    private Configurator() {
        CONFIG_MAP = new HashMap<>();
        CONFIG_MAP.put(ConfigType.INIT, false);
    }

    public static Configurator getInstance() {
        return Holder.CONFIGURATOR;
    }

    private static final class Holder {
        private static final Configurator CONFIGURATOR = new Configurator();
    }


    HashMap<Object, Object> getConfigMap() {
        return CONFIG_MAP;
    }


    Configurator withApiHost(String apiHost) {
        CONFIG_MAP.put(ConfigType.API_HOST, apiHost);
        return this;
    }

    Configurator withAroute(Application mApplication) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();  // 打印日志
            ARouter.openDebug(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication);// 尽可能早，推荐在Application中初始化
        return this;
    }

    Configurator withFragmentation() {
        Fragmentation.builder()
                // 设置 栈视图 模式为 （默认）悬浮球模式   SHAKE: 摇一摇唤出  NONE：隐藏， 仅在Debug环境生效
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG) // 实际场景建议.debug(BuildConfig.DEBUG)
                /**
                 * 可以获取到{@link me.yokeyword.fragmentation.exception.AfterSaveStateTransactionWarning}
                 * 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                 */
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(@NonNull Exception e) {

                    }
                })
                .install();
        return this;
    }


    Configurator withUtil(Context mContext) {
        Utils.init(mContext);
        return this;
    }

    void config() {
        CONFIG_MAP.put(ConfigType.INIT, true);
    }

    private void check() {
        boolean isConfig = (boolean) CONFIG_MAP.get(ConfigType.INIT);
        if (!isConfig) {
            throw new RuntimeException("Config not init");
        }
    }

    public <T> T get(ConfigType mConfigType) {
        check();
        return (T) CONFIG_MAP.get(mConfigType);
    }

}
