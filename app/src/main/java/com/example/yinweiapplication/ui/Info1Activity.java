package com.example.yinweiapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.example.yinweiapplication.Bean.Data;
import com.example.yinweiapplication.R;
import com.example.yinweiapplication.adapter.Info1_ListViewAdapter;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 刘方 on 2015/7/9.
 */
public class Info1Activity extends Activity {

    private HttpUtils httpUtils;
    private  String method="http://yinweiapi.paidui.com:81/appIndex/getTopicTagDetail.do?start=0&pageSize=15&memberId=0&memberShareTagId=%d";
    private Data data;
    private ListView listView;
    private ViewGroup topView;
//    private Data.MemberShareTag1 mem;
    private ImageView topImage,listImageView,gridImageView;
    private TextView text;
    private BitmapUtils bitmapUtils;
    private Info1_ListViewAdapter adapter;
    private List<Data.App_Share_List> apps;
    private int memberShareTagId ;
    private  String path;
    private Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("info", "fragmentwefef");
        setContentView(R.layout.activity_info1_listview);
        topView= (LinearLayout) getLayoutInflater()
                .inflate(R.layout.activity_info1_headview, null);
        handler=new Handler();
        listView= (ListView) findViewById(R.id.info1_listView);
        listView.addHeaderView(topView);
        apps=new ArrayList<Data.App_Share_List>();
        bitmapUtils=new BitmapUtils(this);
        adapter=new Info1_ListViewAdapter(apps,this,bitmapUtils);
        listView.setAdapter(adapter);
        memberShareTagId=getIntent().getIntExtra("memberShareTagId", 0);
        path=String.format(method,memberShareTagId);
        httpUtils=new HttpUtils();

        //initHeadView(topView,mem);
        loadData();
    }

    private void initHeadView(ViewGroup topView,Data data) {
        topImage= (ImageView) topView.findViewById(R.id.head_image);
        listImageView= (ImageView) topView.findViewById(R.id.list_selector);
        gridImageView= (ImageView) topView.findViewById(R.id.grid_selector);
        text= (TextView) topView.findViewById(R.id.textView_info1);
        text.setText(data.getMember_share_tag().getDesc());
        String topImageth=data.getMember_share_tag().getImage_url();
        bitmapUtils.display(topImage,topImageth);
        listImageView.setSelected(true);
    }

    private void loadData( ) {
        httpUtils.send(HttpRequest.HttpMethod.GET, path, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result=  responseInfo.result;
                try {
                    org.json.JSONObject obj=new org.json.JSONObject(result);
                    org.json.JSONObject obj1 = obj.getJSONObject("data");
                    data= JSONObject.parseObject(obj1.toString(),Data.class);
                   apps.addAll(data.getApp_share_list());
                    adapter.notifyDataSetChanged();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            initHeadView(topView, data);
                        }
                    });
             } catch (Exception e) {
                  e.printStackTrace();
                }




            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }

}
