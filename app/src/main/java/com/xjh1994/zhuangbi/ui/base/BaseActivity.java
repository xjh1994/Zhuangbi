package com.xjh1994.zhuangbi.ui.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;
import com.xjh1994.zhuangbi.CustomApplication;
import com.xjh1994.zhuangbi.util.AppManager;

/**
 * Created by xjh1994 on 2016/6/29.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public CustomApplication mApplication;

    // 是否允许全屏
    private boolean mAllowFullScreen = false;
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = CustomApplication.getInstance();

        // 竖屏锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        AppManager.getAppManager().addActivity(this);

        setContentView(getLayoutResId());
        initViews();
    }

    /**
     * 设置布局文件
     */
    public abstract int getLayoutResId();

    /**
     * 初始化布局文件中的控件
     */
    public abstract void initViews();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:// 点击返回图标事件
                this.finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void startAnimActivity(Class<?> cla) {
        this.startActivity(new Intent(this, cla));
    }

    public void startAnimActivity(Intent intent) {
        this.startActivity(intent);
    }

    Toast mToast;

    public void toast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }

    public void toast(int textResId) {
        String text = getString(textResId);
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }

    public void toastLong(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_LONG);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }

    public void toastLong(int textResId) {
        String text = getString(textResId);
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_LONG);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.getClass().toString());
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(this.getClass().toString());
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }
}
