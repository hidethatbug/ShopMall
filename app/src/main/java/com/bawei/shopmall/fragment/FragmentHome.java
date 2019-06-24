package com.bawei.shopmall.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.bawei.shopmall.MainActivity;
import com.bawei.shopmall.R;
import com.bawei.shopmall.adapter.shop.XRecyHomeAdapter;
import com.bawei.shopmall.base.BaseFragment;
import com.bawei.shopmall.bean.shop.HomeBannerBean;
import com.bawei.shopmall.bean.shop.HomeListBean;
import com.bawei.shopmall.layout.CadeNow;
import com.bawei.shopmall.layout.LayoutNum;
import com.bawei.shopmall.mvp.home.HomeContract;
import com.bawei.shopmall.mvp.home.HomePresenterIMpl;
import com.bawei.shopmall.ui.SearchActivity;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author:程金柱
 * Date:2019/6/17 20:49
 * Description：
 */

public class FragmentHome extends BaseFragment implements HomeContract.HomeView {
    private static final String TAG = "FragmentHome";
    private HomeContract.HomePresenter homePresenter;
    @BindView(R.id.xrecy_home)
    XRecyclerView xrecy_home;
    private XRecyHomeAdapter xRecyHomeAdapter;

    @Override
    protected int bindLayout() {
        return LayoutNum.HOME_PAGE;
    }

    @Override
    protected void ininView() {
        homePresenter = new HomePresenterIMpl();
        homePresenter.onBind(this);
        homePresenter.getHomeBannerMsg();
        homePresenter.getHomeListShopMsg();
        xrecy_home.setLayoutManager(new LinearLayoutManager(getActivity()));
        xRecyHomeAdapter = new XRecyHomeAdapter(getActivity());
        xrecy_home.setAdapter(xRecyHomeAdapter);


    }
@OnClick(R.id.home_search)
public void setXrecy_home(View view){
        startActivity(new Intent(getContext(), SearchActivity.class));
}

    @Override
    protected void initData() {

    }

    @Override
    protected void onDie() {
        homePresenter.unBind();
    }

    /**
     * banner的数据
     * @param o
     */
    @Override
    public void getHomeBannerMsg(Object o) {
        HomeBannerBean homeBannerBean= (HomeBannerBean) o;
        if (homeBannerBean!=null){
            String status = homeBannerBean.status;
            if (status.equals(CadeNow.SUCCESS)){
                xRecyHomeAdapter.setBanner(homeBannerBean.result);
                
            }
        }

    }

    /**
     *
     * @param o
     */
    @Override
    public void getHomeListShopMsg(Object o) {
        HomeListBean homeListBean= (HomeListBean) o;
        if (homeListBean!=null){
            String status = homeListBean.getStatus();
            if (status.equals(CadeNow.SUCCESS)){
//                Log.i(TAG, "getHomeListShopMsg: "+homeListBean.getMessage());
                HomeListBean.ResultBean result = homeListBean.getResult();

                xRecyHomeAdapter.setList(result);

            }
        }
    }
}
