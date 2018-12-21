package com.dream.module_base.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.dream.module_base.R;
import com.dream.module_base.util.CommonUtil;
import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

/**
 * Created by zy on 2018/12/21.
 */
public abstract class BaseActivity extends SwipeBackActivity {

    private Unbinder mUnbinder;
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getRootView() instanceof View){
            setContentView((View) getRootView());
        }else if(getRootView() instanceof Integer){
            setContentView((Integer) getRootView());
        }else {
            throw new ClassCastException("RootView must be View or Integer.");
        }
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        setStatusBar();
        initView();
    }

    protected abstract void initView();

    protected void setStatusBar() {
        StatusBarUtil.setColor(this,CommonUtil.getColor(R.color.colorPrimary),0);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mUnbinder != null){
            mUnbinder.unbind();
        }
    }

    protected abstract Object getRootView();
}
