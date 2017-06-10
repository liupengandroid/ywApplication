package com.example.yinweiapplication.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lintao on 2015/7/6.
 */
public class Search implements Serializable {

    /**
     * code : 0
     * data : {"caixi_item":{"property_list":"35;西餐@67;其他西餐@95;京菜@61;日本料理@55;川菜@29;粤菜@81;鲁菜@51;韩国料理@45;东南亚菜@53;上海菜@83;云贵菜@39;湘菜@97;新疆菜@63;意大利菜@31;香港美食@65;法国菜@77;鄂菜@47;苏菜@89;清真菜@57;晋菜@79;泰国菜@85;徽菜@75;西北菜","dish_property_type_id":"1","type_photo_url":"","property_name_list":"西餐 | 京菜 | 其他西餐","property_type_name":"菜系"},"shicai_item":{"property_list":"139;海鲜@131;蔬菜@125;牛肉@121;猪肉@127;鸡肉@129;鸭肉@143;豆制品@123;羊肉@137;河鲜@33;肉类@145;乳制品@135;药材@141;五谷杂粮@133;菌藻@119;其它肉类（鹅、鸽鹌鹑等）@147;蛋制品@27;粤菜汤","dish_property_type_id":"2","type_photo_url":"","property_name_list":"海鲜 | 蔬菜 | 牛肉","property_type_name":"食材"},"kouwei_item":{"property_list":"101;甜@113;清淡@201;鲜@37;辣@59;椒盐@115;五香@99;酸@109;咖喱@107;麻辣@111;孜然","dish_property_type_id":"3","type_photo_url":"","property_name_list":"甜 | 清淡 | 鲜","property_type_name":"口味"},"hot_share_tag_count":{"tag_count":"7"},"hot_share_tag_item":[]}
     * status : 1
     */
    private int code;
    private DataEntity data;
    private int status;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public class DataEntity {
        /**
         * caixi_item : {"property_list":"35;西餐@67;其他西餐@95;京菜@61;日本料理@55;川菜@29;粤菜@81;鲁菜@51;韩国料理@45;东南亚菜@53;上海菜@83;云贵菜@39;湘菜@97;新疆菜@63;意大利菜@31;香港美食@65;法国菜@77;鄂菜@47;苏菜@89;清真菜@57;晋菜@79;泰国菜@85;徽菜@75;西北菜","dish_property_type_id":"1","type_photo_url":"","property_name_list":"西餐 | 京菜 | 其他西餐","property_type_name":"菜系"}
         * shicai_item : {"property_list":"139;海鲜@131;蔬菜@125;牛肉@121;猪肉@127;鸡肉@129;鸭肉@143;豆制品@123;羊肉@137;河鲜@33;肉类@145;乳制品@135;药材@141;五谷杂粮@133;菌藻@119;其它肉类（鹅、鸽鹌鹑等）@147;蛋制品@27;粤菜汤","dish_property_type_id":"2","type_photo_url":"","property_name_list":"海鲜 | 蔬菜 | 牛肉","property_type_name":"食材"}
         * kouwei_item : {"property_list":"101;甜@113;清淡@201;鲜@37;辣@59;椒盐@115;五香@99;酸@109;咖喱@107;麻辣@111;孜然","dish_property_type_id":"3","type_photo_url":"","property_name_list":"甜 | 清淡 | 鲜","property_type_name":"口味"}
         * hot_share_tag_count : {"tag_count":"7"}
         * hot_share_tag_item : []
         */
        private Caixi_itemEntity caixi_item;
        private Shicai_itemEntity shicai_item;
        private Kouwei_itemEntity kouwei_item;
        private Hot_share_tag_countEntity hot_share_tag_count;
        private List<?> hot_share_tag_item;

        public void setCaixi_item(Caixi_itemEntity caixi_item) {
            this.caixi_item = caixi_item;
        }

        public void setShicai_item(Shicai_itemEntity shicai_item) {
            this.shicai_item = shicai_item;
        }

        public void setKouwei_item(Kouwei_itemEntity kouwei_item) {
            this.kouwei_item = kouwei_item;
        }

        public void setHot_share_tag_count(Hot_share_tag_countEntity hot_share_tag_count) {
            this.hot_share_tag_count = hot_share_tag_count;
        }

        public void setHot_share_tag_item(List<?> hot_share_tag_item) {
            this.hot_share_tag_item = hot_share_tag_item;
        }

        public Caixi_itemEntity getCaixi_item() {
            return caixi_item;
        }

        public Shicai_itemEntity getShicai_item() {
            return shicai_item;
        }

        public Kouwei_itemEntity getKouwei_item() {
            return kouwei_item;
        }

        public Hot_share_tag_countEntity getHot_share_tag_count() {
            return hot_share_tag_count;
        }

        public List<?> getHot_share_tag_item() {
            return hot_share_tag_item;
        }

        public class Caixi_itemEntity {
            /**
             * property_list : 35;西餐@67;其他西餐@95;京菜@61;日本料理@55;川菜@29;粤菜@81;鲁菜@51;韩国料理@45;东南亚菜@53;上海菜@83;云贵菜@39;湘菜@97;新疆菜@63;意大利菜@31;香港美食@65;法国菜@77;鄂菜@47;苏菜@89;清真菜@57;晋菜@79;泰国菜@85;徽菜@75;西北菜
             * dish_property_type_id : 1
             * type_photo_url :
             * property_name_list : 西餐 | 京菜 | 其他西餐
             * property_type_name : 菜系
             */
            private String property_list;
            private String dish_property_type_id;
            private String type_photo_url;
            private String property_name_list;
            private String property_type_name;

            public void setProperty_list(String property_list) {
                this.property_list = property_list;
            }

            public void setDish_property_type_id(String dish_property_type_id) {
                this.dish_property_type_id = dish_property_type_id;
            }

            public void setType_photo_url(String type_photo_url) {
                this.type_photo_url = type_photo_url;
            }

            public void setProperty_name_list(String property_name_list) {
                this.property_name_list = property_name_list;
            }

            public void setProperty_type_name(String property_type_name) {
                this.property_type_name = property_type_name;
            }

            public String getProperty_list() {
                return property_list;
            }

            public String getDish_property_type_id() {
                return dish_property_type_id;
            }

            public String getType_photo_url() {
                return type_photo_url;
            }

            public String getProperty_name_list() {
                return property_name_list;
            }

            public String getProperty_type_name() {
                return property_type_name;
            }
        }

        public class Shicai_itemEntity {
            /**
             * property_list : 139;海鲜@131;蔬菜@125;牛肉@121;猪肉@127;鸡肉@129;鸭肉@143;豆制品@123;羊肉@137;河鲜@33;肉类@145;乳制品@135;药材@141;五谷杂粮@133;菌藻@119;其它肉类（鹅、鸽鹌鹑等）@147;蛋制品@27;粤菜汤
             * dish_property_type_id : 2
             * type_photo_url :
             * property_name_list : 海鲜 | 蔬菜 | 牛肉
             * property_type_name : 食材
             */
            private String property_list;
            private String dish_property_type_id;
            private String type_photo_url;
            private String property_name_list;
            private String property_type_name;

            public void setProperty_list(String property_list) {
                this.property_list = property_list;
            }

            public void setDish_property_type_id(String dish_property_type_id) {
                this.dish_property_type_id = dish_property_type_id;
            }

            public void setType_photo_url(String type_photo_url) {
                this.type_photo_url = type_photo_url;
            }

            public void setProperty_name_list(String property_name_list) {
                this.property_name_list = property_name_list;
            }

            public void setProperty_type_name(String property_type_name) {
                this.property_type_name = property_type_name;
            }

            public String getProperty_list() {
                return property_list;
            }

            public String getDish_property_type_id() {
                return dish_property_type_id;
            }

            public String getType_photo_url() {
                return type_photo_url;
            }

            public String getProperty_name_list() {
                return property_name_list;
            }

            public String getProperty_type_name() {
                return property_type_name;
            }
        }

        public class Kouwei_itemEntity {
            /**
             * property_list : 101;甜@113;清淡@201;鲜@37;辣@59;椒盐@115;五香@99;酸@109;咖喱@107;麻辣@111;孜然
             * dish_property_type_id : 3
             * type_photo_url :
             * property_name_list : 甜 | 清淡 | 鲜
             * property_type_name : 口味
             */
            private String property_list;
            private String dish_property_type_id;
            private String type_photo_url;
            private String property_name_list;
            private String property_type_name;

            public void setProperty_list(String property_list) {
                this.property_list = property_list;
            }

            public void setDish_property_type_id(String dish_property_type_id) {
                this.dish_property_type_id = dish_property_type_id;
            }

            public void setType_photo_url(String type_photo_url) {
                this.type_photo_url = type_photo_url;
            }

            public void setProperty_name_list(String property_name_list) {
                this.property_name_list = property_name_list;
            }

            public void setProperty_type_name(String property_type_name) {
                this.property_type_name = property_type_name;
            }

            public String getProperty_list() {
                return property_list;
            }

            public String getDish_property_type_id() {
                return dish_property_type_id;
            }

            public String getType_photo_url() {
                return type_photo_url;
            }

            public String getProperty_name_list() {
                return property_name_list;
            }

            public String getProperty_type_name() {
                return property_type_name;
            }
        }

        public class Hot_share_tag_countEntity {
            /**
             * tag_count : 7
             */
            private String tag_count;

            public void setTag_count(String tag_count) {
                this.tag_count = tag_count;
            }

            public String getTag_count() {
                return tag_count;
            }
        }
    }
}
