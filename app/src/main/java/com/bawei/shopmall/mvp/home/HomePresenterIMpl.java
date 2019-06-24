package com.bawei.shopmall.mvp.home;


import com.bawei.shopmall.data.DataCallBackHomeBanner;
import com.bawei.shopmall.data.DataCallBackHomeList;

/**
 * Author:程金柱
 * Date:2019/6/18 14:43
 * Description：
 */

public class HomePresenterIMpl implements HomeContract.HomePresenter {
    private HomeContract.HomeModel homeModel;
    private HomeContract.HomeView homeView;

    @Override
    public void onBind(HomeContract.HomeView loginView) {
        homeView=loginView;
        homeModel=new HomeModelImpl();
    }

    @Override
    public void unBind() {
        if (homeModel!=null){
            homeModel=null;
        }
        if (homeView!=null){
            homeView=null;
        }
    }

    @Override
    public void getHomeBannerMsg() {
        homeModel.getHomeBannerMsg(new DataCallBackHomeBanner() {
            @Override
            public void success(Object data) {
                homeView.getHomeBannerMsg(data);
            }

            @Override
            public void error(String error) {

            }
        });
    }

    @Override
    public void getHomeListShopMsg() {
        homeModel.getHomeListShopMsg(new DataCallBackHomeList() {
            @Override
            public void success(Object data) {
                homeView.getHomeListShopMsg(data);
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
