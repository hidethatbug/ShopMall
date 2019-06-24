package com.bawei.shopmall.bean.shop;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

/**
 * Author:程金柱
 * Date:2019/6/18 10:51
 * Description：
 */

public class HomeBannerBean {
    public String message;
    public String status;
    public List<Result> result;

    public class Result extends SimpleBannerInfo {
        public String imageUrl;
        public String jumpUrl;
        public String rank;
        public String title;

        @Override
        public Object getXBannerUrl() {
            return imageUrl;
        }

        public String getTitle() {
            return title;
        }

        public String getRank() {
            return rank;
        }


    }
}
