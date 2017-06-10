package com.example.yinweiapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.example.yinweiapplication.Bean.HomeBean;
import com.example.yinweiapplication.R;
import com.example.yinweiapplication.adapter.HomePtrLvAdapter;
import com.example.yinweiapplication.config.UrlsConfig;
import com.example.yinweiapplication.ui.Info1Activity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HomeFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2{
    private HttpUtils httpUtils;
    @ViewInject(R.id.home_fragment_ptrlistview)
    private PullToRefreshListView ptrlistview;
    private HomePtrLvAdapter adapter;
    private List<HomeBean.DataEntity.App_index_recommandEntity> list;
    private HomeBean homeBean;
    private LayoutInflater inflater;
    private int PAGE_COUNT = 16;
    @ViewInject(R.id.home_fragment_scoreView_linearLayout)
    private LinearLayout home_fragment_scoreView_linearLayout;
    private BitmapUtils bitMapUtils;
    private TextView firstLove,otherCountry;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.home_fragment_layout, null);
        this.inflater = inflater;
        ViewUtils.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBitmapUtils();
        ptrlistview.setMode(PullToRefreshBase.Mode.BOTH);
        ptrlistview.setOnRefreshListener(this);
        initAdapter();
        loadData(String.format(UrlsConfig.HOME_URL, 1, 15));
    }

    private void loadData(String url) {
        httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.POST, url, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String json = responseInfo.result;
                homeBean = JSON.parseObject(json, HomeBean.class);
                List<HomeBean.DataEntity.App_index_recommandEntity> list1 = homeBean.getData().getApp_index_recommand();
                if (homeBean != null) {
                    View headView = getHeadView(inflater);
                    ptrlistview.getRefreshableView().addHeaderView(headView);
                }
                list.addAll(list1);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getActivity(), "加载数据失败", Toast.LENGTH_SHORT).show();
                View view = ViewStub.inflate(getActivity(),R.layout.faild_layout,null);
            }
        });
    }

    public void initAdapter(){
        list = new ArrayList<>();
        adapter = new HomePtrLvAdapter(list,getActivity());
        ptrlistview.setAdapter(adapter);
    }

    public View getHeadView(LayoutInflater inflater){
        View headView = inflater.inflate(R.layout.home_fragment_headview,null);
        ViewUtils.inject(this, headView);
        firstLove=((TextView) headView.findViewById(R.id.home_headview_type1));
        firstLove.setText("#" + homeBean.getData().getApp_index_topic().get(0).getShare_tag_name());
        firstLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Info1Activity.class);
                intent.putExtra("memberShareTagId",8399);
                getActivity().startActivity(intent);
            }
        });
        otherCountry=((TextView)headView.findViewById(R.id.home_headview_type2));
        otherCountry.setText("#" + homeBean.getData().getApp_index_topic().get(1).getShare_tag_name());
        otherCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Info1Activity.class);
                intent.putExtra("memberShareTagId", 12963);
                getActivity().startActivity(intent);
            }
        });

        ((TextView) headView.findViewById(R.id.home_headview_type1_count)).setText(homeBean.getData().getApp_index_topic().get(0).getShare_num() + "个分享");
        ((TextView)headView.findViewById(R.id.home_headview_type2_count)).setText(homeBean.getData().getApp_index_topic().get(1).getShare_num()+"个分享");
        ((TextView)headView.findViewById(R.id.home_headview_type3)).setText("更多话题");
        ((TextView)headView.findViewById(R.id.home_headview_type3_count)).setText("11个分享");
        ImageView img = (ImageView)headView.findViewById(R.id.home_headview_top_imageView);
        bitMapUtils.display(img,"http://ww1.sinaimg.cn/large/005Lja8Zgw1etm4ix803gj30fk078mz9.jpg");
       ScrollView.LayoutParams params = initLayoutParmars();
        for (int i = 0; i < homeBean.getData().getIndex_index_latest().size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            bitMapUtils.display(imageView,homeBean.getData().getIndex_index_latest().get(i).getMain_photo_url());
            home_fragment_scoreView_linearLayout.addView(imageView);
        }
        return headView;
    }

    private  ScrollView.LayoutParams initLayoutParmars() {
        ScrollView.LayoutParams layoutParams = new FrameLayout.LayoutParams(350,350);
                return layoutParams;
    }

    public void initBitmapUtils(){
        bitMapUtils = new BitmapUtils(getActivity());
        ptrlistview.getRefreshableView().setOnScrollListener(new PauseOnScrollListener(bitMapUtils,true,false));
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        loadData(String.format(UrlsConfig.HOME_URL,PAGE_COUNT,PAGE_COUNT+10));
        PAGE_COUNT+=10;
    }
}
