package com.dream.module_user;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dream.module_base.arouter.RouteTable;
import com.dream.module_base.base.BaseActivity;

@Route(path = RouteTable.USER_ACTIVITY)
public class UserActivity extends BaseActivity {


    @Override
    protected void initView() {

    }

    @Override
    protected Object getRootView() {
        return R.layout.activity_user;
    }
}
