package com.dream.module_main.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.dream.module_base.arouter.RouteTable;
import com.dream.module_base.arouter.RouterUtil;
import com.dream.module_base.base.BaseActivity;
import com.dream.module_base.customeview.BottomBar;
import com.dream.module_base.customeview.BottomBarTab;
import com.dream.module_main.R;
import com.dream.module_main.R2;
import com.dream.module_main.ui.fragment.HomeFragment;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import me.yokeyword.fragmentation.ISupportFragment;

/**
 * Created by zy on 2018/12/21.
 */
public class MainActivity extends BaseActivity {


    private ISupportFragment userFragment = RouterUtil.getFragment(RouteTable.USER_CENTER);
    private ISupportFragment[] fragments = new ISupportFragment[]{HomeFragment.getInstance(),userFragment};
    @BindView(R2.id.bottomBar_main)
    BottomBar bottomBar;

    private int mCurrentFragmentIndex;

    public static void start(Context mContext) {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    protected void initView() {
        bottomBar.addItem(new BottomBarTab(mContext,R.drawable.main_ic_discover_white_24dp,"首页"))
                .addItem(new BottomBarTab(mContext,R.drawable.main_ic_account_circle_white_24dp,"我的"));

        bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                mCurrentFragmentIndex = position;
                showHideFragment(fragments[mCurrentFragmentIndex],fragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });


        loadMultipleRootFragment(R.id.fl_fragment_container, mCurrentFragmentIndex,fragments);
        bottomBar.setCurrentItem(mCurrentFragmentIndex);
    }

    @Override
    protected Object getRootView() {
        return R.layout.main_activity_main;
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
    }
}
