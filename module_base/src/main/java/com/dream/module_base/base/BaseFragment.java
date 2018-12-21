package com.dream.module_base.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by zy on 2018/12/21.
 */
public abstract class BaseFragment extends SwipeBackFragment {

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        if(getRootView() instanceof View){
            rootView = (View) getRootView();
        }else if(getRootView() instanceof Integer){
            rootView = inflater.inflate((Integer) getRootView(), container, false);
        }else {
            throw new ClassCastException("RootView must be View or Integer");
        }
        mUnbinder = ButterKnife.bind(this, rootView);
        initView(rootView);
        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mUnbinder != null){
            mUnbinder.unbind();
        }
    }

    protected abstract void initView(View rootView);


    protected abstract Object getRootView();

}
