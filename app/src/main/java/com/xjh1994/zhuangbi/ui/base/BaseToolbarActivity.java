package com.xjh1994.zhuangbi.ui.base;

import android.support.v7.widget.Toolbar;

/**
 * Created by xjh1994 on 2016/6/29.
 */
public abstract class BaseToolbarActivity extends BaseActivity {

    private ToolBarHelper mToolBarHelper;
    public Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {

        mToolBarHelper = new ToolBarHelper(this, layoutResID);
        toolbar = mToolBarHelper.getToolBar();
        setContentView(mToolBarHelper.getContentView());
        /*自定义的一些操作*/
        onCreateCustomToolBar(toolbar);
        /*把 toolbar 设置到Activity 中*/
        setSupportActionBar(toolbar);
    }

    public void onCreateCustomToolBar(Toolbar toolbar) {
        toolbar.setContentInsetsRelative(40, 0);
    }
}
