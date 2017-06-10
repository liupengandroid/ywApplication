package com.example.yinweiapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.yinweiapplication.Bean.Search;
import com.example.yinweiapplication.R;
import com.example.yinweiapplication.adapter.ContantsAdapter;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.heardView
 * 2.expanderableListView
 * 3.流式布局
 */
public class SearchFragment extends BaseFragment implements View.OnClickListener {

    //    private String url = "http://yinweiapi.paidui.com:81/jms/fetchData.do?procedureName=app_discover_index&parameters={\"_city_id\":\"00280001\"}&memberId=0";
    private String url = "http://yinweiapi.paidui.com:81/jms/fetchData.do?procedureName=app_discover_index&memberId=0";
    private LayoutInflater inflater;
    /**
     * heardView
     */
    private View heardView;

    /**
     * expdableList
     */
    //父控件的

    private List<Integer> groupImgId = new ArrayList<>();
    private List<String> text = new ArrayList<>();

    //子控件的
    private List<List<String>> datas = new ArrayList<>();
    private List<List<String>> numId = new ArrayList<>();
    private ExpandableListView expandableListView;
    private ContantsAdapter contantsAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        View view = inflater.inflate(R.layout.search_fragment_layout, container, false);
        initView(view);
        loadData();
        return view;
    }


    private void initView(View view) {
        expandableListView = (ExpandableListView) view.findViewById(R.id.search_listview);
        heardView = inflater.inflate(R.layout.search_item_heard_view, expandableListView, false);
        setclickListener(heardView);
        contantsAdapter = new ContantsAdapter(getActivity(), groupImgId, text, datas,numId);
        expandableListView.setAdapter(contantsAdapter);
        expandableListView.addHeaderView(heardView);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                for (int i = 0; i <groupImgId.size() ; i++) {
                    if (groupPosition !=i) {
                        expandableListView.collapseGroup(i);
                    }
                }
            }
        });
    }

    /**
     * 更新 下载数据
     *
     */
    private void loadData() {
        int[] id = {R.mipmap.caixi, R.mipmap.shicai, R.mipmap.kouwei};
        for (int i = 0; i < id.length; i++) {
            groupImgId.add(id[i]);
        }

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                Search search = JSONObject.parseObject(str, Search.class);
                Search.DataEntity.Caixi_itemEntity caixi = search.getData().getCaixi_item();
                Search.DataEntity.Shicai_itemEntity shicai = search.getData().getShicai_item();
                Search.DataEntity.Kouwei_itemEntity kouwei = search.getData().getKouwei_item();
                text.add(caixi.getProperty_name_list());
                text.add(shicai.getProperty_name_list());
                text.add(kouwei.getProperty_name_list());
                getBytes(caixi.getProperty_list());
                getBytes(shicai.getProperty_list());
                getBytes(kouwei.getProperty_list());
                contantsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(HttpException e, String s) {
//                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * 切割字符
     */
    public void getBytes(String str) {
        String replace = str.replace("@", ";");
        String[] spilt = replace.split(";");
        List<String> list = new ArrayList<>();
        List<String> idDatas = new ArrayList<>();
        for (int i = 0; i < spilt.length; i++) {
            if (i % 2 != 0) {
                list.add(spilt[i]);
            }else{
                idDatas.add(spilt[i]);
            }
        }
        datas.add(list);
        numId.add(idDatas);
    }

    /**
     * 头部点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.heard_fujin_img:
                Toast.makeText(getActivity(), "helloworld1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.heard_paihang_img:
                Toast.makeText(getActivity(), "helloworld2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.heard_daren_img:
                Toast.makeText(getActivity(), "helloworld3", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 为头部增加点击事件
     * @param v
     */
    public void setclickListener(View v) {
        ImageView fujin = (ImageView) v.findViewById(R.id.heard_fujin_img);
        ImageView paihang = (ImageView) v.findViewById(R.id.heard_paihang_img);
        ImageView daren = (ImageView) v.findViewById(R.id.heard_daren_img);
        fujin.setOnClickListener(this);
        paihang.setOnClickListener(this);
        daren.setOnClickListener(this);

    }
}
