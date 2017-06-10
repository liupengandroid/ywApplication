package com.example.yinweiapplication.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.widget.RadioGroup;

import com.example.yinweiapplication.R;
import com.example.yinweiapplication.fragment.CarmaraFragment;
import com.example.yinweiapplication.fragment.HomeFragment;
import com.example.yinweiapplication.fragment.MsgFragment;
import com.example.yinweiapplication.fragment.MyFragment;
import com.example.yinweiapplication.fragment.SearchFragment;
import com.example.yinweiapplication.utils.FragmentTabUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<Fragment> fragments; //5涓富fragment鐨勯泦鍚�
    @ViewInject(R.id.main_activity_radiGropu)
    private RadioGroup raiogroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        initFragments();
        FragmentTabUtils fragmentTalUtils = new FragmentTabUtils(getSupportFragmentManager(),fragments,R.id.main_activity_zhanweilayout,raiogroup);
        // 
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        HomeFragment  homeFragment = new HomeFragment();
        fragments.add(homeFragment);
        SearchFragment searchFragment = new SearchFragment();
        fragments.add(searchFragment);
        CarmaraFragment carmaraFragment = new CarmaraFragment();
        fragments.add(carmaraFragment);
        MsgFragment msgFragment = new MsgFragment();
        fragments.add(msgFragment);
        MyFragment myFragment = new MyFragment();
        fragments.add(myFragment);

    }


}
