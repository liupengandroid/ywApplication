package com.example.yinweiapplication.fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yinweiapplication.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class CarmaraFragment extends BaseFragment implements View.OnClickListener{

    @ViewInject(R.id.img_View_phone)
    ImageView img_View_phone;

    @ViewInject(R.id.fen_xiang)
    Button fen_xiang;

    @ViewInject(R.id.delete)
    Button delete;

    private File dir= Environment.getExternalStorageDirectory();
    private String imgFileName;

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carmara_fragment_layout,null);
        ViewUtils.inject(this, view);
        takeImage();
        return view;
    }
    public void takeImage(){
        imgFileName = sdf.format(new Date())+".jpg";

        //实例化启动Camera的意图
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(new File(dir, imgFileName)));
        intent.putExtra(MediaStore.EXTRA_SCREEN_ORIENTATION,
                ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        //以返回结果的方式启动Activity
        startActivityForResult(intent, 100);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==100 ){

            //Log.i("info","data-->"+data.getData().toString());
            //图片的二次采样过程
            //第一次采样前
            BitmapFactory.Options options=new BitmapFactory.Options(); //采样的参数
            options.inJustDecodeBounds=true; //设置只采样图片边缘区域
            options.inSampleSize=1; //采样的比例；1:原始的大小

            //开始一次采样，不会返回Bitmap对象
            BitmapFactory.decodeFile(dir+File.separator+imgFileName,options);

            //一次采样结束后，可以获取原始图片尺寸（宽和高）
            int imgWidth=options.outWidth; //原宽度 ,px
            int imgHeight=options.outHeight; //原高度，px


            //根据原图片的大小和当前显示图片控件的大小进行比较，确定一个压缩比例
            int wSampleSize=imgWidth/img_View_phone.getMeasuredWidth();
            int hSampleSize=imgHeight/img_View_phone.getMeasuredHeight();


            options.inSampleSize=Math.min(wSampleSize, hSampleSize);

            //二次采样时，获取整个压缩之后图片内容，而不只是图片边缘内容
            options.inJustDecodeBounds=false;

            //开始二次采样，并返回Bitmap对象
            Bitmap bitmap= BitmapFactory.decodeFile(dir + File.separator + imgFileName, options);


            if(bitmap!=null){
                //显示图片
                img_View_phone.setImageBitmap(bitmap);
                //imgView.setRotation(90);
            }


        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    @OnClick({R.id.delete,R.id.fen_xiang})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fen_xiang:

                break;
            case R.id.delete:
                img_View_phone.setImageBitmap(null);
                break;
        }
    }

}
