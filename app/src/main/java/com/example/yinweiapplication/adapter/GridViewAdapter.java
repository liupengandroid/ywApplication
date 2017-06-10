package com.example.yinweiapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yinweiapplication.Bean.SearchGrid;
import com.example.yinweiapplication.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lintao on 2015/7/8.
 */
public class GridViewAdapter extends BaseAdapter {

    private List<SearchGrid.DataEntity.App_share_dish_list_by_propertyEntity> datas = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;
    private BitmapUtils bitmapUtils;

    public GridViewAdapter(List<SearchGrid.DataEntity.App_share_dish_list_by_propertyEntity> datas, Context context,BitmapUtils bitmapUtils) {
        this.bitmapUtils = bitmapUtils;
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas==null? 0 :datas.size();
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
        ViewHolder viewHolder =null;
        if (convertView==null){
            convertView = inflater.inflate(R.layout.item_grid_view,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bitmapUtils.display(viewHolder.img_user,datas.get(position).getIco());
        bitmapUtils.display(viewHolder.img_food,datas.get(position).getMain_photo_url());
        viewHolder.user_name.setText("佚名");
        viewHolder.user_place.setText(datas.get(position).getShop_name());
        viewHolder.text_food.setText(datas.get(position).getDish_name());
        viewHolder.time.setText(datas.get(position).getTime_tips());
        viewHolder.num_zan.setText(datas.get(position).getAward_count());
        return convertView;
    }
    public static class ViewHolder{
        @ViewInject(R.id.img_user)
        ImageView img_user;
        @ViewInject(R.id.user_name)
        TextView user_name;
        @ViewInject(R.id.user_place)
        TextView user_place;
        @ViewInject(R.id.img_food)
        ImageView img_food;
        @ViewInject(R.id.text_food)
        TextView text_food;
        @ViewInject(R.id.time)
        TextView time;
        @ViewInject(R.id.num_zan)
        CheckBox num_zan;
        public ViewHolder(View itemView){
            ViewUtils.inject(this,itemView);
        }
    }
}
