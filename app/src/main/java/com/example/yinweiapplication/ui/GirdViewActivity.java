package com.example.yinweiapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.fastjson.JSONObject;
import com.example.yinweiapplication.Bean.SearchGrid;
import com.example.yinweiapplication.R;
import com.example.yinweiapplication.adapter.GridViewAdapter;
import com.example.yinweiapplication.config.UrlsConfig;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

public class GirdViewActivity extends ActionBarActivity implements View.OnClickListener{

    private PullToRefreshGridView gridView;
    private List<SearchGrid.DataEntity.App_share_dish_list_by_propertyEntity> datas = new ArrayList<>();
    private GridViewAdapter adapter;
    private BitmapUtils bitmapUtils;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gird_view);
        initBitmapUtils();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String url = UrlsConfig.GRID_URL + bundle.getString("id");
        initView();
        loadData(url);
    }


    private void initBitmapUtils() {
        bitmapUtils = new BitmapUtils(this);
        bitmapUtils.configDefaultLoadFailedImage(R.mipmap.actionbar_camera_icon);
        bitmapUtils.configDefaultLoadingImage(R.mipmap.actionbar_camera_icon);

    }


    private void loadData(String URL) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, URL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                SearchGrid searchGrid = JSONObject.parseObject(str, SearchGrid.class);
                List<SearchGrid.DataEntity.App_share_dish_list_by_propertyEntity> list = searchGrid.getData().getApp_share_dish_list_by_property();
                if (list != null && list.size() > 0) {
                    datas.addAll(list);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }

    private void initView() {
        gridView = (PullToRefreshGridView) findViewById(R.id.pull_refresh_gird_view);
        gridView.setOnScrollListener(new PauseOnScrollListener(bitmapUtils, true, false));
        adapter = new GridViewAdapter(datas,getApplicationContext(),bitmapUtils);
        gridView.setAdapter(adapter);
        button = (Button) findViewById(R.id.grid_view_back);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        finish();
    }
}
