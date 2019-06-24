package com.bawei.shopmall.mvp.search;

import com.bawei.shopmall.data.DataCallBackHomeBanner;
import com.bawei.shopmall.data.DataCallBackHomeList;
import com.bawei.shopmall.data.DataCallBackSearch;
import com.bawei.shopmall.data.shop.ShopData;

/**
 * Author:程金柱
 * Date:2019/6/18 10:35
 * Description：
 */

public class SearchModelImpl implements SearchContract.SearchModel{


    @Override
    public void getSearchListShopMsg(DataCallBackSearch dataCallBackSearch, String keyword, int page, int count) {
        ShopData.userData().getSearchShopList(dataCallBackSearch,keyword,page,count);
    }
}
