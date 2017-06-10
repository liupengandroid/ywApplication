package com.example.yinweiapplication;

import android.app.Application;

import com.example.yinweiapplication.utils.FileUtils;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import com.lidroid.xutils.cache.MD5FileNameGenerator;

import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.ShareSDK;

/**
 * Created by 刘鹏 on 2015/7/5.
 */
public class BaseApp extends Application {
    private static BaseApp app;
    private DbUtils dbUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        ShareSDK.initSDK(this);//初始化分享SDK
        app = this;
        initJpush();//极光推送
    }

    private void initJpush() {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }


    public static BaseApp getInstance() {
        return app;
    }
    /**
     * 图片加载框架全局配置
     */
    private void configGlobalBitmap() {

        BitmapGlobalConfig config = BitmapGlobalConfig.getInstance(this, FileUtils.getImageCache());
        config.setDefaultCacheExpiry(1000L * 60 * 60 * 24 * 30 * 12 * 100);
        config.setDiskCacheEnabled(false);
        //设置内存的大小 默认 4m 最小2m
        config.setMemoryCacheSize(5 * 1024 * 1024);
        config.setDiskCacheSize(1024 * 1024 * 100);
        //设置线程池的线程数量  默认 5
        config.setThreadPoolSize(4);
             //保存图片的名字以md5命名
        config.setFileNameGenerator(new MD5FileNameGenerator());
    }

//
//    public DbUtils getDbUtils() {
//        if (dbUtils == null) {
//            DbUtils.DaoConfig config = new DbUtils.DaoConfig(this);
//            config.setDbDir(FileUtils.getDbPath());
//            config.setDbVersion(AppConfig.VERSION);
//            config.setDbName(AppConfig.DB_NAME);
//            dbUtils = DbUtils.create(config);
//        }
//        return dbUtils;
//    }


}
