package com.dream.module_main.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.dream.module_base.arouter.RouteTable;
import com.dream.module_base.arouter.RouterUtil;
import com.dream.module_base.base.BaseFragment;
import com.dream.module_main.R;
import com.dream.module_main.R2;

import butterknife.OnClick;

/**
 * Created by zy on 2018/12/21.
 */
public class HomeFragment extends BaseFragment {



    public static HomeFragment getInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected Object getRootView() {
        return R.layout.main_fragment_home;
    }



    @OnClick(R2.id.tv_home)
    public void onViewClicked() {
        RouterUtil.navigation(RouteTable.USER_ACTIVITY);

    }
}
