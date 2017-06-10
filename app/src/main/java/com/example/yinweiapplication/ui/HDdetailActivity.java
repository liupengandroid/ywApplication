package com.example.yinweiapplication.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.yinweiapplication.Bean.HomeBean;
import com.example.yinweiapplication.Bean.HuoDongBean;
import com.example.yinweiapplication.R;
import com.example.yinweiapplication.adapter.HdPtrlistviewAdapter;
import com.example.yinweiapplication.adapter.HomePtrLvAdapter;
import com.example.yinweiapplication.config.UrlsConfig;
import com.example.yinweiapplication.utils.ShareUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class HDdetailActivity extends ActionBarActivity {
    private HuoDongBean huoDongBean;
    private List<HuoDongBean.DataEntity.Activity_share_itemEntity> list;
    private BitmapUtils bitmapUtils;
    private HdPtrlistviewAdapter adapter;
    @ViewInject(R.id.huodong_detail_ptr_listview)
    private PullToRefreshListView ptrListView;
    @ViewInject(R.id.huodong_headview_img)
    private ImageView huodong_headview_img;
    @ViewInject(R.id.huodong_upimg_name)
    private TextView huodong_upimg_name;
    @ViewInject(R.id.huodong_people_time)
    private TextView huodong_people_time;
    @ViewInject(R.id.huodong_huodong_detail_textview)
    private TextView huodong_huodong_detail_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hddetail);
        ViewUtils.inject(this);
        ptrListView.setMode(PullToRefreshBase.Mode.DISABLED);
        initBitmapUtils();
        View headView =  getHeadView();
        ptrListView.getRefreshableView().addHeaderView(headView);
        list = new ArrayList<>();
        adapter = new HdPtrlistviewAdapter(list,getApplicationContext());
        ptrListView.setAdapter(adapter);
        loadData();
    }

    private void loadData() {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.POST, UrlsConfig.HUODONG_DETAIL_URL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String json = responseInfo.result;
                 huoDongBean = JSON.parseObject(json, HuoDongBean.class);
                HuoDongBean.DataEntity.Index_activity_itemEntity  itemEntivity = huoDongBean.getData().getIndex_activity_item();
                bitmapUtils.display(huodong_headview_img,itemEntivity.getImage_url());
                huodong_upimg_name.setText(itemEntivity.getName());
                huodong_people_time.setText(itemEntivity.getActivity_time_tip() + "  " + itemEntivity.getMember_count() + "人参加");
                huodong_huodong_detail_textview.setText(itemEntivity.getDesc());
                List<HuoDongBean.DataEntity.Activity_share_itemEntity> list1 = huoDongBean.getData().getActivity_share_item();
                list.addAll(list1);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getApplicationContext(), "数据加载失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initBitmapUtils() {
        bitmapUtils = new BitmapUtils(getApplicationContext());
    }

    public View getHeadView(){
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.huodong_detail_headview_layout,null);
        ViewUtils.inject(this,view);
        if (huoDongBean!=null){
            bitmapUtils.display(huodong_headview_img,huoDongBean.getData().getIndex_activity_item().getImage_url());
            huodong_upimg_name.setText(huoDongBean.getData().getIndex_activity_item().getName());
            huodong_people_time.setText(huoDongBean.getData().getIndex_activity_item().getActivity_time_tip()+"  "+huoDongBean.getData().getIndex_activity_item().getMember_count()+"人分享");
            huodong_huodong_detail_textview.setText(huoDongBean.getData().getIndex_activity_item().getDesc());
        }
        return view;
    }

    @OnClick({R.id.huodong_detail_back_img,R.id.huodong_detail_share_img})
    public void onClic(View vew){
        switch (vew.getId()){
            case R.id.huodong_detail_back_img:
                finish();
                break;
            case R.id.huodong_detail_share_img:
                ShareUtils.Share(getApplicationContext());
                break;

        }
    }
}
