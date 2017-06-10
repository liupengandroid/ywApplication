package com.example.yinweiapplication.config;

/**
 * Created by liufang on 2015/7/6.
 */
public class UrlsConfig {

    //获取验证码
    public static String GET_INFO="http://yinweiapi.paidui.com:81/user/getVerifyCode.do?mobile=%s&type=1&terminalSign=866963028306753";

    //登陆
    public static String LOGIN="http://yinweiapi.paidui.com:81/user/login.do";

    //首页地址
    public static String HOME_URL ="http://yinweiapi.paidui.com:81/appIndex/getIndexMessage.do?start=%d&pageSize=%d&memberId=280431&cityId=0";


    //首页顶部图片详情地址

    public static  String HUODONG_DETAIL_URL = "http://yinweiapi.paidui.com:81/appIndex/getActivityDetail.do?memberId=0&activityId=51&start=0&pageSize=15&cityId=0";

    //GridView 地址
    public static final String GRID_URL="http://yinweiapi.paidui.com:81/appIndex/getShareDishListByProperty.do?start=0&pageSize=15&dishPropertyId=";
}

