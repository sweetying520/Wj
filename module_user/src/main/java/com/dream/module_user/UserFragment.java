package com.dream.module_user;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dream.module_base.arouter.RouteTable;
import com.dream.module_base.base.BaseFragment;

/**
 * Created by zy on 2018/12/21.
 */
@Route(path = RouteTable.USER_CENTER)
public class UserFragment extends BaseFragment {



    @Override
    protected Object getRootView() {
        return R.layout.fragment_user;
    }


    @Override
    protected void initView(View rootView) {

    }
}
