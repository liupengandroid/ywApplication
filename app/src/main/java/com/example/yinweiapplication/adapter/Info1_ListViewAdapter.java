package com.example.yinweiapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yinweiapplication.Bean.Data;
import com.example.yinweiapplication.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by User on 2015/7/9.
 */
public class Info1_ListViewAdapter extends BaseAdapter {
    private List<Data.App_Share_List> datas;
    private Context context;
    private BitmapUtils bitmapUtils;

    public Info1_ListViewAdapter(List<Data.App_Share_List> datas, Context context, BitmapUtils bitmapUtils) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_info1_activity_listview,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.main_imageView.setImageResource(R.mipmap.xiangguanfenxiang_morentu);
            viewHolder.icon_member.setImageResource(R.mipmap.record_theme_goddess);

        }
        Data.App_Share_List data=datas.get(position);
        viewHolder.memberName.setText(data.getAddress());

        viewHolder.icon_name.setText("佚名");
        viewHolder.icon_time.setText(data.getTime_tips());
        viewHolder.address.setText(data.getShop_name());
        viewHolder.dish_name.setText(data.getDish_name());
        bitmapUtils.display(viewHolder.main_imageView,data.getMain_photo_url());
        bitmapUtils.display(viewHolder.icon_member,data.getIco());
        return convertView;
    }

  class ViewHolder{
        @ViewInject(R.id.image_main_list)
        ImageView main_imageView;
        @ViewInject(R.id.icon_member_list)
        ImageView icon_member;
        @ViewInject(R.id.icon_member_name_list)
        TextView icon_name;
        @ViewInject(R.id.icon_member_time_list)
        TextView icon_time;
       @ViewInject(R.id.member_names_list)
        TextView memberName;
        @ViewInject(R.id.address_dish_list)
        TextView address;
      @ViewInject(R.id.dish_name_list)
        TextView dish_name;
      public ViewHolder(View itemView){
          ViewUtils.inject(this,itemView);
      }
    }
}
