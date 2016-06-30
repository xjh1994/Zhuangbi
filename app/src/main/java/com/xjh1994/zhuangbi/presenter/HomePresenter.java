package com.xjh1994.zhuangbi.presenter;

import com.xjh1994.zhuangbi.ui.view.HomeView;

/**
 * Created by xjh1994 on 2016/6/30.
 */
public class HomePresenter implements HomeBasePresenter {

    public static final String URL_HOME = "http://zhuangbi.info/builder";
    public static final String URL = "http://zhuangbi.info/zhuangbi.info.png";

    private HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;

        homeView.setPresenter(this);
    }

    @Override
    public void addTask() {

    }

    @Override
    public void shareTask() {

    }

    @Override
    public void start() {
        homeView.showToast();
    }
}
