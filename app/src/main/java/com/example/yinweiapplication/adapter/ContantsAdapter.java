package com.example.yinweiapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yinweiapplication.R;
import com.example.yinweiapplication.ui.GirdViewActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lintao on 2015/7/6.
 */
public class ContantsAdapter extends BaseExpandableListAdapter implements View.OnClickListener{

    private List<Integer> imgId = new ArrayList<>();
    private List<String> groupText = new ArrayList<>();
    private List<List<String>> childText = new ArrayList<>();
    private List<List<String>> childId = new ArrayList<>();
    private  Context context;
    private FlowLayout flowLayout;
    private LayoutInflater inflater;


    public ContantsAdapter(Context context, List<Integer> imgId, List<String> groupText, List<List<String>> childText,List<List<String>> childId) {
        this.context = context;
        this.groupText = groupText;
        this.imgId = imgId;
        this.childText = childText;
        inflater = LayoutInflater.from(context);
        this.childId = childId;
    }

    @Override
    public int getGroupCount() {
        return groupText == null ? 0 : groupText.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupText.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childText.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.search_item_parent_view, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.search_parent_img.setImageResource(imgId.get(groupPosition));
        viewHolder.search_parent_text.setText(groupText.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {

            convertView = inflater.inflate(R.layout.search_item_flayout, parent, false);
        }
        if(flowLayout!=null){
            flowLayout.removeAllViews();
        }
        flowLayout = (FlowLayout) convertView.findViewById(R.id.flow_layout);
        for (int i = 0; i < childText.get(groupPosition).size(); i++) {
            TextView textView = (TextView) inflater.inflate(R.layout.search_item_child_view, flowLayout, false);
            textView.setText(childText.get(groupPosition).get(i));
            textView.setTag(childId.get(groupPosition).get(i));
            textView.setOnClickListener(this);
            flowLayout.addView(textView);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, GirdViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(v.getTag()));
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    private class ViewHolder {
        @ViewInject(R.id.search_parent_img)
        ImageView search_parent_img;
        @ViewInject(R.id.search_parent_text)
        TextView search_parent_text;

        public ViewHolder(View itemView) {
            ViewUtils.inject(this, itemView);
        }
    }
}
