package com.example.yinweiapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import com.example.yinweiapplication.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by 刘方 on 2015/7/6.
 */
public class WellcomeAddOurActivity extends Activity{
    @ViewInject(R.id.telePhoneNum_welcomeInOurActivity)
    private EditText telephoneNum;
    @ViewInject(R.id.passWord_welcomeInOurActivity)
    private EditText passWord;
    private HttpUtils httpUtils;
    private String mobile;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        setContentView(R.layout.activity_wellcomeinour);

        ViewUtils.inject(this);
        httpUtils=new HttpUtils();
        mobile=telephoneNum.getText().toString();

    }


    @OnClick(R.id.getCheck)
    public void getCheck(View v){
     //   httpUtils.download(UrlsConfig.GET_INFO,post,)

    }

    private RequestParams getRquestParams() {

        RequestParams params = new RequestParams();
       // ?mobile=18295072948&type=1&terminalSign=866963028306753
        params.addBodyParameter("mobile", mobile);
        params.addBodyParameter("type", "1");
        params.addBodyParameter("terminalSign", getResources().toString());

        return params;
    }

}
