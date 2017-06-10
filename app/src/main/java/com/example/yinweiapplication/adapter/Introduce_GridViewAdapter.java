package com.example.yinweiapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yinweiapplication.Bean.Introduce;
import com.example.yinweiapplication.R;
import com.example.yinweiapplication.ui.IntroduceActivity;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by 刘方 on 2015/7/9.
 */
public class Introduce_GridViewAdapter extends BaseAdapter {
    private List<Introduce.Member_Share> datas;
    private Context context;
    private BitmapUtils bitmapUtils;

    public Introduce_GridViewAdapter(IntroduceActivity context, List<Introduce.Member_Share> datas, BitmapUtils bitmapUtils) {
        this.datas = datas;
        this.context = context;
        this.bitmapUtils = bitmapUtils;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_introduce_gridview,null);
            viewHolder=new ViewHolder();
            ViewUtils.inject(viewHolder,convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.imageViewIntroduce.setImageResource(R.mipmap.xiangguanfenxiang_morentu);
        }
        Introduce.Member_Share data=datas.get(position);
        viewHolder.address.setText(data.getShop_name());
        viewHolder.timeIntroduce.setText(data.getTime_tips());
        viewHolder.dishNameIntroduce.setText(data.getDish_name());
        viewHolder.num.setText(data.getAward_count());


        bitmapUtils.display(viewHolder.imageViewIntroduce, data.getMain_photo_url());
        return convertView;
    }

  class ViewHolder{

      @ViewInject(R.id.image_main_introduce)
      ImageView imageViewIntroduce;
      @ViewInject(R.id.address_introduce)
      TextView address;
      @ViewInject(R.id.dish_name_introduce)
      TextView dishNameIntroduce;
      @ViewInject(R.id.time_introduce)
      TextView timeIntroduce;
      @ViewInject(R.id.share_introduce_num)
      TextView num;


    }
}
