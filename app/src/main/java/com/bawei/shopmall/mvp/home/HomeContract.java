package com.bawei.shopmall.mvp.home;


import com.bawei.shopmall.data.DataCallBackHomeBanner;
import com.bawei.shopmall.data.DataCallBackHomeList;
import com.bawei.shopmall.data.DataCallBackLogin;

/**
 * Author:程金柱
 * Date:2019/6/18 10:26
 * Description：首页展示的mvp
 *
 */

public interface HomeContract {
    public interface HomeModel{
        void getHomeBannerMsg(DataCallBackHomeBanner dataCallBackHome);
        void getHomeListShopMsg(DataCallBackHomeList dataCallBackHome);
    }
    public interface HomeView{
        void getHomeBannerMsg(Object o);
        void getHomeListShopMsg(Object o);
    }
    public interface HomePresenter{

        void onBind(HomeContract.HomeView loginView);
        void unBind();
        void getHomeBannerMsg();
        void getHomeListShopMsg();
    }
}
