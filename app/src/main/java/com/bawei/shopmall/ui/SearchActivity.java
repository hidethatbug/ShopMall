package com.bawei.shopmall.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.bawei.shopmall.R;
import com.bawei.shopmall.adapter.shop.XRecySearchAdapter;
import com.bawei.shopmall.base.BaseActivity;
import com.bawei.shopmall.bean.shop.SearchBean;
import com.bawei.shopmall.mvp.search.SearchContract;
import com.bawei.shopmall.mvp.search.SearchPresenterIMpl;
import com.bawei.shopmall.view.SearchView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author:程金柱
 * Date:2019/6/20 14:45
 * Description：
 */

public class SearchActivity extends BaseActivity implements SearchContract.SearchView {
    private static final String TAG = "SearchActivity";
    private SearchContract.SearchPresenter searchPresenter;
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.xrecy_search)
    XRecyclerView xreacy_search;
    private int page = 1;
    private int count = 5;
    private XRecySearchAdapter xRecySearchAdapter;
    private String keyword;
    private List<SearchBean.ResultBean> resultBeans;

    @Override
    protected int bindLayout() {
        return R.layout.search_activity;
    }

    @Override
    protected void initView() {

        searchPresenter = new SearchPresenterIMpl();
        searchPresenter.onBind(this);
        xreacy_search.setPullRefreshEnabled(false);
        xreacy_search.setLoadingMoreEnabled(true);
        xreacy_search.setLayoutManager(new LinearLayoutManager(this));
        xRecySearchAdapter = new XRecySearchAdapter(this);
        xreacy_search.setAdapter(xRecySearchAdapter);


    }

    @Override
    protected void initData() {
        resultBeans = new ArrayList<>();
        searchView.setGetSearchView(new SearchView.getSearchView() {
            @Override
            public void getData(final String keyword) {

                searchPresenter.getSearchListShopMsg(keyword, 1, 5);

            }
        });


        xreacy_search.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                page++;
                String text = searchView.getText();
                Log.i(TAG, "onLoadMore: "+text);
                searchPresenter.getSearchListShopMsg(text, page, count);
                xreacy_search.loadMoreComplete();
            }
        });


    }

    @Override
    protected void onDieMvp() {
        searchPresenter.unBind();
    }

    @Override
    public void getSearchListShopMsg(Object o) {
        SearchBean searchBean = (SearchBean) o;
        if (searchBean != null&&searchBean.getResult().size()>0) {
            resultBeans.addAll(searchBean.getResult());
            xRecySearchAdapter.setList(resultBeans);
            xRecySearchAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "没有更多数据了", Toast.LENGTH_SHORT).show();
        }

    }
}
