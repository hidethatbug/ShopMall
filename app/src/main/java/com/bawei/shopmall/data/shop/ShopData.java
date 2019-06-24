package com.bawei.shopmall.data.shop;

import com.bawei.shopmall.api.ApiShop;
import com.bawei.shopmall.bean.shop.HomeBannerBean;
import com.bawei.shopmall.bean.shop.HomeListBean;
import com.bawei.shopmall.bean.shop.SearchBean;
import com.bawei.shopmall.data.DataCallBackHomeBanner;
import com.bawei.shopmall.data.DataCallBackHomeList;
import com.bawei.shopmall.data.DataCallBackSearch;
import com.bawei.shopmall.net.HttpUtile;

import java.net.URLEncoder;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:程金柱
 * Date:2019/6/18 10:44
 * Description：
 */

public class ShopData {
    private static ShopData shopData;

    private ShopData() {

    }

    public static ShopData userData() {
        if (shopData == null) {
            shopData = new ShopData();
        }
        return shopData;
    }

    /**
     * 获取首页banner的数据
     * @param dataCallBackHome
     */
    public void getBannerData(final DataCallBackHomeBanner dataCallBackHome) {
        ShopInfo netRetrofit = HttpUtile.httpUtile().getNetRetrofit(ShopInfo.class);
        Observable<HomeBannerBean> bannerHomeData = netRetrofit.getBannerHomeData(ApiShop.BANNER_HOME_URL);
        bannerHomeData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<HomeBannerBean>() {
            @Override
            public void accept(HomeBannerBean homeBannerBean) throws Exception {
                dataCallBackHome.success(homeBannerBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
    }

    /**
     * 获取首页的list的数据
     * @param dataCallBackHome
     */
    public void getListData(final DataCallBackHomeList dataCallBackHome) {
        ShopInfo netRetrofit = HttpUtile.httpUtile().getNetRetrofit(ShopInfo.class);
        netRetrofit.getListHomeData(ApiShop.SHOP_LIST_HOME_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                new Consumer<HomeListBean>() {
                    @Override
                    public void accept(HomeListBean homeListBean) throws Exception {
                        dataCallBackHome.success(homeListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        dataCallBackHome.error(throwable.toString());
                    }
                }
        );
    }

    /**
     * 获取搜索的数据
     * @param dataCallBackSearch
     * @param keyword
     * @param page
     * @param count
     */
    public void getSearchShopList(final DataCallBackSearch dataCallBackSearch, String keyword, int page, int count){

        ShopInfo netRetrofit = HttpUtile.httpUtile().getNetRetrofit(ShopInfo.class);
        Observable<SearchBean> searchListData = netRetrofit.getSearchListData(ApiShop.SEARCH_SHOP_URL, keyword , page, count);
        searchListData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<SearchBean>() {
            @Override
            public void accept(SearchBean searchBean) throws Exception {
                dataCallBackSearch.getData(searchBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                dataCallBackSearch.getError(throwable.toString());
            }
        });
    }
}
