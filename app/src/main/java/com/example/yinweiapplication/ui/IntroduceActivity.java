package com.example.yinweiapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yinweiapplication.Bean.Introduce;
import com.example.yinweiapplication.R;
import com.example.yinweiapplication.adapter.Introduce_GridViewAdapter;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘方 on 2015/7/10.
 */
public class IntroduceActivity extends  Activity{



        private HttpUtils httpUtils;
        private  String method="http://yinweiapi.paidui.com:81/jms/fetchData.do?procedureName=app_member_page&parameters={\"_start\":\"0\",\"_end\":\"15\",\"_member_id\":\"%s\",\"_login_member_id\":\"0\"}&memberId=0 (头像)";
        private Introduce data;
        @ViewInject(R.id.gridView_introduce)
        private GridView gridView;
        private ViewGroup topView;
        private ImageView topImage;
        private TextView text;
        private BitmapUtils bitmapUtils;
        private Introduce_GridViewAdapter adapter;
        private List<Introduce.Member_Share> mem;
        private  String path;
        private Handler handler;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.introduce_gridview);
            ViewUtils.inject(this);
        path=String.format(method,getIntent().getStringExtra("_member_id"));
            initView();
            loadData();
        }



    private void initView() {
        httpUtils=new HttpUtils();
        mem=new ArrayList<Introduce.Member_Share>();
        topView= (ViewGroup) getLayoutInflater()
                .inflate(R.layout.circlr_headview_introduce,null);
        handler=new Handler();
        bitmapUtils=new BitmapUtils(this);
        adapter=new Introduce_GridViewAdapter(this,mem,bitmapUtils);
        gridView.setAdapter(adapter);

    }
    private void loadData() {

        httpUtils.send(HttpRequest.HttpMethod.GET, path, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                try {
                    JSONObject obj1 = new JSONObject(result.toString());
                    JSONObject obj = obj1.getJSONObject("data");
                    data = com.alibaba.fastjson.JSONObject.parseObject(obj1.toString(), Introduce.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        initHeadView(topView, data);

                    }


                });
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }

    private void initHeadView(ViewGroup topView, Introduce data) {

        ImageView imageBackGroud=
                (ImageView) topView.findViewById(R.id.image_backGround);
        ImageView icon=
                (ImageView) topView.findViewById(R.id.circleId);
        TextView name=
                (TextView) topView.findViewById(R.id.mem_name_circle);
        TextView degree=
                (TextView) topView.findViewById(R.id.degreeId);
        TextView jifen=
                (TextView) topView.findViewById(R.id.jifenId);
        TextView num=
                (TextView) topView.findViewById(R.id.num_member);
        imageBackGroud
                .setImageResource(R.mipmap.xiangguanfenxiang_morentu);
        bitmapUtils
                .display(imageBackGroud, data.getMember_info().getIco());
        icon.setImageResource(R.mipmap.xiangguanfenxiang_morentu);
        bitmapUtils.display(icon, data.getMember_info().getIco());
        name.setText(data.getMember_info().getMember_level_name());
        degree.setText(data.getMember_info().getLevel());
        jifen.setText(data.getMember_info().getMember_points() + "积分");
        num.setText(data.getMember_info().getShare_sum()+"分享 · "
                +data.getMember_info().getFans_sum()+"粉丝 · "
                +data.getMember_info().getBe_subscribe()+ "关注 · "
                +data.getMember_info().getAward_sum()+"赞过");

    }

}


