package com.example.yinweiapplication.Bean;

import java.util.List;

/**
 * Created by User on 2015/7/10.
 */
public class Introduce {
    private List<Member_Share> member_share;
    private Member_Info member_info;

    public Introduce() {
    }

    public Introduce(List<Member_Share> member_share, Member_Info member_info) {
        this.member_share = member_share;
        this.member_info = member_info;
    }

    public List<Member_Share> getMember_share() {
        return member_share;
    }

    public void setMember_share(List<Member_Share> member_share) {
        this.member_share = member_share;
    }

    public Member_Info getMember_info() {
        return member_info;
    }

    public void setMember_info(Member_Info member_info) {
        this.member_info = member_info;
    }

    //    data": {
//            "member_share": [
//    {
//        "comment_count": "4",
//            "dish_id": "711027",
//            "main_photo_url": "http://ywimg.iyinwei.com/Content/Images/yinwei/upload/noproimage/20150703/20150703190900_495.jpg",
//            "time_tips": "07-04",
//            "shop_id": "122157",
//            "taste_score": "5",
//            "impressions_score": "5",
//            "dish_name": "脆皮BB猪",
//            "ico": "http://ywimg.iyinwei.com/Content/Images/Users/HeadPortrait/867f4b66-4150-4380-b7dd-12f423721c6c.jpg",
//            "texture_score": "5",
//            "is_award": "0",
//            "award_count": "60",
//            "shop_name": "翠园(天河区)	",
//            "member_id": "249687",
//            "member_share_id": "40477",
//            "subscribe": "0",
//            "video_url": "",
//            "share_desc": "5LuO6Imy5rO95bCx6IO955yL5Ye677yM5bCP54yq6IKJ55qu54Ok55qE6YWl6ISG55qu5aup77yM5Y+j5oSf5p6B6ISG77yM6Jm954S25piv54Ok55qE5Y205rKh5pyJ5Yi65r+A5oCn6YWx5paZ5Y+j5ZGz77yM5LiL6Z2i55qE6IKJ5Lmf5LiN6ICB77yM5aS55LiA54K55rKZ5ouJ77yM6YaL6YW46YWN552A6JSs6I+c55qE5riF6aaZ77yM6Kej6IKJ55qE5rK56IW75pyA5aW95LiN6L+H44CCDQo=",
//            "member_name": "d2VpeGluX+mbqOaZtA=="
//    },
    public class Member_Share{
        private String dish_name;
        private String shop_name;
        private String time_tips;
        private String main_photo_url;
        private String award_count;

    public Member_Share() {
    }

    public Member_Share(String dish_name, String shop_name, String time_tips, String main_photo_url, String award_count) {
        this.dish_name = dish_name;
        this.shop_name = shop_name;
        this.time_tips = time_tips;
        this.main_photo_url = main_photo_url;
        this.award_count = award_count;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
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

    public String getAward_count() {
        return award_count;
    }

    public void setAward_count(String award_count) {
        this.award_count = award_count;
    }
}


//    "member_info": {
//        "member_points": "5139",
//                "ico": "http://ywimg.iyinwei.com/Content/Images/Users/HeadPortrait/867f4b66-4150-4380-b7dd-12f423721c6c.jpg",
//                "be_subscribe": "0",
//                "award_sum": "917",
//                "share_sum": "15",
//                "member_id": "249687",
//                "member_tag_list": "",
//                "member_level_name": "美食达人",
//                "subscribe_sum": "1",
//                "level": "4",
//                "subscribe": "0",
//                "fans_sum": "61",
//                "active": "1",
//                "member_name": "d2VpeGluX+mbqOaZtA=="
    public class Member_Info{
    private  String  ico;
    private int award_sum;
    private int share_sum;
    private String member_level_name;
    private int level;
    private int fans_sum;
    private int be_subscribe;
    private int member_points;//积分

    public Member_Info() {
    }

    public Member_Info(String ico, int award_sum, int share_sum, String member_level_name, int level, int fans_sum, int be_subscribe, int member_points) {
        this.ico = ico;
        this.award_sum = award_sum;
        this.share_sum = share_sum;
        this.member_level_name = member_level_name;
        this.level = level;
        this.fans_sum = fans_sum;
        this.be_subscribe = be_subscribe;
        this.member_points = member_points;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public int getAward_sum() {
        return award_sum;
    }

    public void setAward_sum(int award_sum) {
        this.award_sum = award_sum;
    }

    public int getShare_sum() {
        return share_sum;
    }

    public void setShare_sum(int share_sum) {
        this.share_sum = share_sum;
    }

    public String getMember_level_name() {
        return member_level_name;
    }

    public void setMember_level_name(String member_level_name) {
        this.member_level_name = member_level_name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFans_sum() {
        return fans_sum;
    }

    public void setFans_sum(int fans_sum) {
        this.fans_sum = fans_sum;
    }

    public int getBe_subscribe() {
        return be_subscribe;
    }

    public void setBe_subscribe(int be_subscribe) {
        this.be_subscribe = be_subscribe;
    }

    public int getMember_points() {
        return member_points;
    }

    public void setMember_points(int member_points) {
        this.member_points = member_points;
    }
}
    }

