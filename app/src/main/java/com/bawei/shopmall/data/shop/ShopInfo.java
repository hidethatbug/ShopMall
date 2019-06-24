package com.bawei.shopmall.data.shop;

import com.bawei.shopmall.bean.shop.HomeBannerBean;
import com.bawei.shopmall.bean.shop.HomeListBean;
import com.bawei.shopmall.bean.shop.SearchBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Author:程金柱
 * Date:2019/6/18 10:49
 * Description：
 */

public interface ShopInfo {
    @GET
    Observable<HomeBannerBean> getBannerHomeData(@Url String  utl);
    @GET
    Observable<HomeListBean> getListHomeData(@Url String  utl);
    @GET
    Observable<SearchBean>
    getSearchListData(@Url String url,
                      @Query("keyword")String keyword,
                      @Query("page")int page,
                      @Query("count")int count);
}
