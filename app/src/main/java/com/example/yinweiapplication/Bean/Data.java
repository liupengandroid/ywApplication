package com.example.yinweiapplication.Bean;

import java.util.List;

/**
 * Created by User on 2015/7/9.
 */
public class Data {

    private MemberShareTag1 member_share_tag;
    private List<App_Share_List> app_share_list;

    public Data() {
    }

    public MemberShareTag1 getMember_share_tag() {
        return member_share_tag;
    }

    public void setMember_share_tag(MemberShareTag1 member_share_tag) {
        this.member_share_tag = member_share_tag;
    }

    public List<App_Share_List> getApp_share_list() {
        return app_share_list;
    }

    public void setApp_share_list(List<App_Share_List> app_share_list) {
        this.app_share_list = app_share_list;
    }

    public class MemberShareTag1 {
//    member_share_tag": {
//            "member_share_tag_id": "12963",
//            "image_url": "http://ywimg.iyinwei.com/Content/Images/yinwei/upload/noproimage/20150701/20150701101245_347.jpg",
//            "desc": "以下获奖者将得到nabati饼干，请在7月10号前添加因味小编QQ3158639271确认兑换和详细地址。\r\n圆仔\r\n新浪微博@在别处的完美生活 \r\nqq_钻石王撕葱\r\nsina_李宛婉\r\n Mirr月牙刀\r\nweixin_yuliying\r\nSaucelife小铺\r\n weixin_浮沉、雙影踏昆仑\r\nweixin_yzihui994\r\nsina_Louis-9",
//            "share_tag_name": "异国美食",
//            "is_topic": null
//},

        private String image_url;
        private String desc;

        public MemberShareTag1() {
        }

        public MemberShareTag1(String image_url, String desc) {
            this.image_url = image_url;
            this.desc = desc;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }



    public class App_Share_List {

//    "recommand_time": "2015-07-09 13:34:22.0",
//            "is_award": "0",
//            "dish_id": "503101",
//            "member_share_id": "41511",
//            "ico": "http://ywimg.iyinwei.com/Content/Images/api/HeadPortrait/9480b938-8f2c-4c5a-ab02-86101dced366.jpg",
//            "share_desc": "5LiA55u05b6I5Zac5qyi6ams5Y2h6b6Z77yM5L2G5piv55So5qa06I6y5YGa55qE5Lmf5piv56ys5LiA5qyh5ZCD77yM5ZGz6YGT6Juu6LWe55qE77yM5qC35a2Q5Lmf5aW955yL77yM6YCC5ZCI5ZKM5aa55a2Q5LiA6LW35ZOf44CC",
//            "shop_name": "莲香袭欲榴莲蛋糕甜品(浙江中路店)",
//            "shop_id": "261195",
//            "address": "浙江中路225号(汉口路)",
//            "member_id": "258837",
//            "dish_name": "榴莲马卡龙",
//            "member_name": "TWlycuaciOeJmeWIgA==",
//            "award_count": "2",
//            "comment_count": "0",
//            "time_tips": "半小时前",
//            "main_photo_url": "http://ywimg.iyinwei.com/Content/Images/yinwei/upload/appImage/20150709/20150709133422_260.jpg",
//            "video_url": "",
//            "tag_list": "1799;二人世界@3443;美食是我的解药@4829;带你浪漫带你吃@5605;你们城里人真会吃@6513;想静静@12963;异国美食",
//            "subscribe": "0",
//            "be_subscribe": "0",
//            "distance": null,
//
//

        private String ico;
        private String member_share_id;
        private String dish_id;
        private String time_tips;
        private String main_photo_url;
        private String tag_list;
        private String dish_name;
        private List<Award_Model> award_model;
        private List<Member_Share_Tag> member_share_tags;
        private String address;
        private String shop_name;

        public App_Share_List() {
        }

        public App_Share_List(String ico, String member_share_id, String dish_id, String time_tips, String main_photo_url, String tag_list, String dish_name, List<Award_Model> award_model, List<Member_Share_Tag> member_share_tags) {
            this.ico = ico;
            this.member_share_id = member_share_id;
            this.dish_id = dish_id;
            this.time_tips = time_tips;
            this.main_photo_url = main_photo_url;
            this.tag_list = tag_list;
            this.dish_name = dish_name;
            this.award_model = award_model;
            this.member_share_tags = member_share_tags;
        }

        public String getIco() {
            return ico;
        }

        public void setIco(String ico) {
            this.ico = ico;
        }

        public String getMember_share_id() {
            return member_share_id;
        }

        public void setMember_share_id(String member_share_id) {
            this.member_share_id = member_share_id;
        }

        public String getDish_id() {
            return dish_id;
        }

        public void setDish_id(String dish_id) {
            this.dish_id = dish_id;
        }

        public String getTime_tips() {
            return time_tips;
        }

        public void setTime_tips(String time_tips) {
            this.time_tips = time_tips;
        }

        public String getMain_photo_url() {
            return main_photo_url;
        }

        public void setMain_photo_url(String main_photo_url) {
            this.main_photo_url = main_photo_url;
        }

        public String getTag_list() {
            return tag_list;
        }

        public void setTag_list(String tag_list) {
            this.tag_list = tag_list;
        }

        public String getDish_name() {
            return dish_name;
        }

        public void setDish_name(String dish_name) {
            this.dish_name = dish_name;
        }

        public List<Award_Model> getAward_model() {
            return award_model;
        }

        public void setAward_model(List<Award_Model> award_model) {
            this.award_model = award_model;
        }

        public List<Member_Share_Tag> getMember_share_tags() {
            return member_share_tags;
        }

        public void setMember_share_tags(List<Member_Share_Tag> member_share_tags) {
            this.member_share_tags = member_share_tags;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        //    member_share_tag": [
//    {
//        "member_share_tag_id": "1799",
//            "image_url": null,
//            "desc": null,
//            "share_tag_name": "二人世界",
//            "is_topic": "0"
//    },
        public class Member_Share_Tag{
            private String  member_share_tag_id;
            private String  share_tag_name;

            public Member_Share_Tag() {
            }

            public Member_Share_Tag(String member_share_tag_id, String share_tag_name) {
                this.member_share_tag_id = member_share_tag_id;
                this.share_tag_name = share_tag_name;
            }

            public String getMember_share_tag_id() {
                return member_share_tag_id;
            }

            public void setMember_share_tag_id(String member_share_tag_id) {
                this.member_share_tag_id = member_share_tag_id;
            }

            public String getShare_tag_name() {
                return share_tag_name;
            }

            public void setShare_tag_name(String share_tag_name) {
                this.share_tag_name = share_tag_name;
            }
        }


        public class Award_Model {
            //   "award_model": [
//    {
//        "ico": "http://ywimg.iyinwei.com/Content/Images/api/HeadPortrait/20150701/20150701231820_136_2.jpg",
//            "member_id": "249529"
//    },
//    {
//        "ico": "http://ywimg.iyinwei.com/Content/Images/api/HeadPortrait/20150522/6179854d-25e4-491e-b73f-dcc58ae7dda6.jpg",
//            "member_id": "245931"
//    }
//    ],
//            "comment_model": []

            private String icon;
            private String member_id;

            public Award_Model() {
            }

            public Award_Model(String icon, String member_id) {
                this.icon = icon;
                this.member_id = member_id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }
        }

    }

}
