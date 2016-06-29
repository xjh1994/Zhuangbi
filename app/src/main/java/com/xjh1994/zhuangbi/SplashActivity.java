package com.xjh1994.zhuangbi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xjh1994.zhuangbi.common.config.Constant;
import com.xjh1994.zhuangbi.event.SplashEvent;
import com.xjh1994.zhuangbi.util.AppManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.bmob.v3.Bmob;

/**
 * Created by xjh1994 on 2016/6/29.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        Bmob.initialize(this, "5ef99dd2732d7f2f477b4c9524b7413d");

        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new SplashEvent(Constant.EVENT_TO_HOME));
//        startActivity(new Intent(this, MainActivity.class));
//        finish();
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onSplashEvent(SplashEvent event) {
        switch (event.getMessage()) {
            case Constant.EVENT_TO_LOGIN:
                break;
            case Constant.EVENT_TO_HOME:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case Constant.EVENT_TO_AD:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        AppManager.getAppManager().finishActivity(this);
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
