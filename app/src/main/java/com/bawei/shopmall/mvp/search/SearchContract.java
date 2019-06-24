package com.bawei.shopmall.mvp.search;


import com.bawei.shopmall.data.DataCallBackSearch;


/**
 * Author:程金柱
 * Date:2019/6/18 10:26
 * Description：首页展示的mvp
 */

public interface SearchContract {
    public interface SearchModel {
        void getSearchListShopMsg(DataCallBackSearch dataCallBackSearch, String keyword, int page, int count);
    }

    public interface SearchView {
        void getSearchListShopMsg(Object o);
    }

    public interface SearchPresenter {

        void onBind(SearchContract.SearchView loginView);

        void unBind();

        void getSearchListShopMsg(String keyword, int page, int count);

    }
}
