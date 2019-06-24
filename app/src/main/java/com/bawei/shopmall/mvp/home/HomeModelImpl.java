package com.bawei.shopmall.mvp.home;

import com.bawei.shopmall.data.DataCallBackHomeBanner;
import com.bawei.shopmall.data.DataCallBackHomeList;
import com.bawei.shopmall.data.shop.ShopData;

/**
 * Author:程金柱
 * Date:2019/6/18 10:35
 * Description：
 */

public class HomeModelImpl implements HomeContract.HomeModel {
    /**
     * 数据回调
     * @param dataCallBackHomeBanner
     */
    @Override
    public void getHomeBannerMsg(DataCallBackHomeBanner dataCallBackHomeBanner) {
        ShopData.userData().getBannerData(dataCallBackHomeBanner);
    }

    @Override
    public void getHomeListShopMsg(DataCallBackHomeList dataCallBackHome) {
        ShopData.userData().getListData(dataCallBackHome);
    }
}
