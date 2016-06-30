package com.xjh1994.zhuangbi.ui.view;

import com.xjh1994.zhuangbi.presenter.HomePresenter;

/**
 * Created by xjh1994 on 2016/6/30.
 */
public interface HomeView extends BaseView<HomePresenter> {

    void showToast();

    void showImage();
}
