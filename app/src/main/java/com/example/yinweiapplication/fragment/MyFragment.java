package com.example.yinweiapplication.fragment;

import android.content.Intent;
import android.media.session.MediaController;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yinweiapplication.Bean.HomeBean;
import com.example.yinweiapplication.R;
import com.example.yinweiapplication.config.UrlsConfig;
import com.example.yinweiapplication.ui.MainActivity;
import com.example.yinweiapplication.wxapi.WXEntryActivity;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.utils.WXAppExtendObject;

/**
 * Created by 刘方 on 2015/7/6.
 */
public class MyFragment extends BaseFragment {
    @ViewInject(R.id.telephoneNum_myFragment)
    private EditText telephoneNum;
    @ViewInject(R.id.passWord_myFragment)
    private EditText passWord;
    private HttpUtils httpUtils;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // UMSocialService mController ;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment_layout,container,false);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        httpUtils = new HttpUtils();


    }

    @OnClick(R.id.login_button_myFragment)
    public void login(View v){
        String phone = telephoneNum.getText().toString();
        String password = passWord.getText().toString();
        if(phone!=null&&password!=null){
            httpUtils.send(HttpRequest.HttpMethod.GET, UrlsConfig.LOGIN, new RequestCallBack<String>() {
                @Override
                public void onSuccess(ResponseInfo<String> responseInfo) {

                }

                @Override
                public void onFailure(HttpException e, String s) {

                }
            });
        }else{
            Toast.makeText(getActivity(), "信息不完整", Toast.LENGTH_SHORT);
        }
    }

    @OnClick(R.id.back)
    public void back(View v){
        getActivity().startActivity(new Intent(getActivity(), MainActivity.class));

    }
    @OnClick({R.id.weixin,R.id.QQ,R.id.xinlang})
    public void logInByOther(View v) {
        switch (v.getId()) {
            case R.id.weixin:

                Platform p = ShareSDK.getPlatform(getActivity().getApplicationContext(), Wechat.NAME);


                p.showUser(null);
                p.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                        platform.removeAccount();
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });


                break;
            case R.id.QQ:
                //QQ第三方登录
                /**
                 *1.获取扣扣平台
                 *2.
                 *3.将用户的信息栏制空
                 *4.对用户的行为实时监听
                 *      1.登陆成功
                 *      2.登录失败
                 *      3.取消登录
                 */
                Platform pq = ShareSDK.getPlatform(getActivity().getApplicationContext(), QQ.NAME);

                pq.removeAccount();
                pq.showUser(null);
                pq.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });

                break;
            case R.id.xinlang:
                Platform pl = ShareSDK.getPlatform(getActivity().getApplicationContext(), SinaWeibo.NAME);

                pl.showUser(null);
                pl.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                        platform.removeAccount();
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });

                break;
        }
    }
}
