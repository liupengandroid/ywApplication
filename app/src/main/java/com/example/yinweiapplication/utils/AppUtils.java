package com.example.yinweiapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by liuprng on 2015/6/15.
 */
public class AppUtils {
    public static boolean isFirst(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("isfirst",Context.MODE_PRIVATE);
        int version = sharedPreferences.getInt("version", 0);
        boolean isFirst = sharedPreferences.getBoolean("isFirst",true);
        if(version!= getVersion(context)||isFirst){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirst",false);
            editor.putInt("version",getVersion(context));
            editor.commit();
        }
        return isFirst;
    }
            public static int getVersion(Context context){
                int version = 0;
              try {
                PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                version = info.versionCode;
                 }catch (PackageManager.NameNotFoundException e){
                  e.printStackTrace();
              }
                return  version;
        }

}
