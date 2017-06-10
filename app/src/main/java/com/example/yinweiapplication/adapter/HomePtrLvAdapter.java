package com.example.yinweiapplication.adapter;

import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yinweiapplication.BaseApp;
import com.example.yinweiapplication.Bean.HomeBean;
import com.example.yinweiapplication.R;
import com.example.yinweiapplication.ui.BdLocationActivity;
import com.example.yinweiapplication.utils.ShareUtils;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.List;

/**
 * Created by 刘鹏 on 2015/7/6.
 */
public class HomePtrLvAdapter extends BaseAdapter implements View.OnClickListener {
    private List<HomeBean.DataEntity.App_index_recommandEntity> list;
    private Context context;
    private LayoutInflater inflater;
    private BitmapUtils bitmapUtils;
    private LinearLayout.LayoutParams params;
    List<ImageView> views;
    public HomePtrLvAdapter(List<HomeBean.DataEntity.App_index_recommandEntity> list, Context context) {
        this.list = list;
        this.context =context;
        inflater = LayoutInflater.from(context);
        initBitmapUtils();
        initLayoutParms();
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Vholder vholder;
        if (convertView==null){
            convertView = inflater.inflate(R.layout.home_item_listview,null);
            vholder = new Vholder(convertView);
            convertView.setTag(vholder);
        }else {
            vholder = (Vholder) convertView.getTag();
        }
        HomeBean.DataEntity.App_index_recommandEntity bean =  list.get(position);
        bitmapUtils.display(vholder.home_item_toptouxiang_img, bean.getIco());
        vholder.home_item_time.setText(bean.getTime_tips());
        bitmapUtils.display(vholder.home_item_bigimage, bean.getMain_photo_url());
        vholder.home_item_foodname.setText(bean.getDish_name());
        vholder.home_item_food_address.setText(bean.getShop_name());
        vholder.home_item_food_address.setOnClickListener(this);
        vholder.fenxiantTextView.setOnClickListener(this);
        vholder.linearLayout.removeAllViews();
        for(int i=0;i<bean.getAward_model().size();i++){
            if (i>7){
                vholder.textView.setText(bean.getAward_model().size() - 8 + "");
                vholder.textView.setVisibility(View.VISIBLE);
            }else {
                vholder.textView.setVisibility(View.GONE);
                ImageView imageView = new ImageView(context);
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                bitmapUtils.display(imageView,bean.getAward_model().get(i).getIco());
                vholder.linearLayout.addView(imageView);
            }
        }
        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_item_food_address:
                Intent intent = new Intent(context, BdLocationActivity.class);
                context.startActivity(intent);
                break;
            case R.id.home_item_fenxiang:
                ShareUtils.Share(context);
                break;
        }

    }

    private  class  Vholder{
        @ViewInject(R.id.home_item_toptouxiang_img)
        private ImageView home_item_toptouxiang_img;
        @ViewInject(R.id.home_item_time)
        private TextView home_item_time;
        @ViewInject(R.id.home_item_bigimage)
        private ImageView home_item_bigimage;
        @ViewInject(R.id.home_item_foodname)
        private TextView home_item_foodname;
        @ViewInject(R.id.home_item_food_address)
        private TextView home_item_food_address;
        @ViewInject(R.id.home_item_liuyan_img)
        private LinearLayout linearLayout;
        @ViewInject(R.id.home_item_textview_remain)
        private TextView textView;
        @ViewInject(R.id.home_item_fenxiang)
        private TextView fenxiantTextView;
        public Vholder(View itemView){
            ViewUtils.inject(this, itemView);
        }
    }

    public void initBitmapUtils(){
        bitmapUtils = new BitmapUtils(context);
        bitmapUtils.configDefaultLoadingImage(R.mipmap.actionbar_camera_icon);
    }

    public void initLayoutParms(){
        params = new LinearLayout.LayoutParams(100,100);
        params.leftMargin = 10;
    }
}
