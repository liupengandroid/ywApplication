package com.example.yinweiapplication.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yinweiapplication.R;
import com.example.yinweiapplication.utils.AppUtils;

import cn.jpush.android.api.JPushInterface;

public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startAction();
    }
    //判断是否为第一次启动
    private void startAction() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1500);
                    Intent intent;
                    if (AppUtils.isFirst(getApplicationContext())){
                        intent = new Intent(SplashActivity.this,GuidActivity.class);
                    }else {
                        intent = new Intent(SplashActivity.this,MainActivity.class);
                    }
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(getApplicationContext());
    }
}
