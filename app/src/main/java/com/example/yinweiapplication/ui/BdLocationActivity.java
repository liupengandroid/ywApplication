package com.example.yinweiapplication.ui;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.yinweiapplication.R;
public class BdLocationActivity extends ActionBarActivity {
    private BaiduMap mbaiduMap = null;
    private Context context;
    private MapView mMapView;
    // 定位相关
    private LocationClient mLocationClient;
    private MyLocationListener mLocationListener;
    private boolean isFirstIn = true;
    private double mLatitude;//纬度
    private double mLongitude;//经度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
//        SDKInitializer.initialize(getApplicationContext());//初始化百度地图SDK
        setContentView(R.layout.activity_bd_location);
        this.context = this;
        // 初始化组件
        initView();
        // 初始化定位
        initLocation();
        onStart();
    }

    // 定位初始化
    private void initLocation() {
        mLocationClient = new LocationClient(this);
        // 定位监听器
        mLocationListener = new MyLocationListener();
        // 注册
        mLocationClient.registerLocationListener(mLocationListener);
        // 设置一些必要的配置
        setLocationOption();
        mLocationClient.start();
    }

    //定位设置
    private void setLocationOption(){
        LocationClientOption option = new LocationClientOption();
        option.setCoorType("db09ll");// 返回的定位结果是百度经纬度,默认值gcj02
        option.setAddrType("all");//返回的定位结果包含地址信息
        option.setIsNeedAddress(true);// 位置，一定要设置，否则后面得不到地址
        option.setOpenGps(true);// 打开GPS
        option.setScanSpan(10000);// 多长时间进行一次请求
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);// 网络定位优先
        mLocationClient.setLocOption(option);// 使用设置
    }

    private void initView() {
        // 获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mbaiduMap = mMapView.getMap();
        // 设置地图放大缩小参数
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
        mbaiduMap.setMapStatus(msu);
    }




    // 定位到我的位置
    private void centerToMyLocation() {
        LatLng latLng = new LatLng(mLatitude, mLongitude);
        // 设置经纬度
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        mbaiduMap.animateMapStatus(msu);
    }

    @Override
    protected void onDestroy() {
        mLocationClient.stop();
        mbaiduMap.setMyLocationEnabled(false);
        // 在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        // 在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onStart() {
        // 开启定位允许
        mbaiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted()) {
            mLocationClient.start();
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        // 停止定位
        mbaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
        super.onStop();
    }

    @Override
    protected void onPause() {
        // 在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
        super.onPause();
    }

    private class MyLocationListener implements BDLocationListener {

        // 定位成功之后的回调
        @Override
        public void onReceiveLocation(BDLocation location) {
            MyLocationData data = new MyLocationData.Builder()// 经度
                    .accuracy(location.getRadius())//
                    .latitude(location.getLatitude())//
                    .longitude(location.getLongitude())//
                    .build();

            //设置我的定位
            mbaiduMap.setMyLocationData(data);

            //取出经纬度
            mLatitude = location.getLatitude();
            mLongitude = location.getLongitude();

            //是否是第一次定位
            if (isFirstIn) {
                LatLng latLng = new LatLng(location.getLatitude(),
                        location.getLongitude());

                // 设置经纬度
                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);

                mbaiduMap.animateMapStatus(msu);

                isFirstIn = false;
            }

            Toast.makeText(
                    context,
                    "定位成功：纬度" + location.getLatitude() + "经度："
                            + location.getLongitude() + "地址是："
                            + location.getAddrStr() + "城市是：" + location.getCity(), Toast.LENGTH_SHORT).show();

        }
    }
}
