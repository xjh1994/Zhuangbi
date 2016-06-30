package com.xjh1994.zhuangbi;

import android.widget.Toast;

import com.xjh1994.zhuangbi.presenter.HomeBasePresenter;
import com.xjh1994.zhuangbi.presenter.HomePresenter;
import com.xjh1994.zhuangbi.ui.base.BaseActivity;
import com.xjh1994.zhuangbi.ui.view.HomeView;

public class MainActivity extends BaseActivity implements HomeView {

    private HomeBasePresenter mPresenter;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        new HomePresenter(this);
        mPresenter.start();
        mPresenter.addTask();
    }

    @Override
    public void showToast() {
        Toast.makeText(MainActivity.this, "showToast", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showImage() {

    }

    @Override
    public void setPresenter(HomePresenter presenter) {
        mPresenter = presenter;
    }
}
