package com.bawei.shopmall.mvp.search;


import com.bawei.shopmall.data.DataCallBackHomeBanner;
import com.bawei.shopmall.data.DataCallBackHomeList;
import com.bawei.shopmall.data.DataCallBackSearch;

/**
 * Author:程金柱
 * Date:2019/6/18 14:43
 * Description：
 */

public class SearchPresenterIMpl implements SearchContract.SearchPresenter{

    private SearchContract.SearchModel searchModel;
    private SearchContract.SearchView searchView;
    @Override
    public void onBind(SearchContract.SearchView loginView) {
        searchView=loginView;
        searchModel=new SearchModelImpl();
    }

    @Override
    public void unBind() {
    if (searchModel!=null){
        searchModel=null;
    }
    if (searchView!=null){
        searchView=null;
    }
    System.gc();
    }

    @Override
    public void getSearchListShopMsg(String keyword, int page, int count) {
        searchModel.getSearchListShopMsg(new DataCallBackSearch() {
            @Override
            public void getData(Object data) {
                searchView.getSearchListShopMsg(data);
            }

            @Override
            public void getError(String error) {

            }
        },keyword,page,count);
    }
}
