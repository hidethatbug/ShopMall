package com.bawei.shopmall.fragment;

import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.bawei.shopmall.App;
import com.bawei.shopmall.R;
import com.bawei.shopmall.adapter.circle.XRecyCircle;
import com.bawei.shopmall.base.BaseFragment;
import com.bawei.shopmall.bean.circle.CircleListBean;
import com.bawei.shopmall.layout.CadeNow;
import com.bawei.shopmall.layout.LayoutNum;
import com.bawei.shopmall.mvp.circle.CircleContract;
import com.bawei.shopmall.mvp.circle.CirclePresenterImpl;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author:程金柱
 * Date:2019/6/17 20:49
 * Description：圈子页面
 */

public class FragmentCircle extends BaseFragment implements CircleContract.CircleView {
    private CircleContract.CirclePresenter circlePresenter;
    @BindView(R.id.xrecy_circle)
    XRecyclerView xrecy_circle;
    private XRecyCircle xRecyCircle;
    private List<CircleListBean.ResultBean> list;

    @Override
    protected int bindLayout() {
        return LayoutNum.CIRCLE_PAGE;
    }

    @Override
    protected void ininView() {
        circlePresenter = new CirclePresenterImpl();
        circlePresenter.bind(this);
        SharedPreferences shop = App.getShop();
        int userId = shop.getInt("userId", 0);
        String sessionId = shop.getString("sessionId", "");
        circlePresenter.findCircleList(userId,sessionId,1,5);
        xrecy_circle.setLayoutManager(new LinearLayoutManager(getActivity()));
        xRecyCircle = new XRecyCircle(getActivity());
        xrecy_circle.setAdapter(xRecyCircle);
        list = new ArrayList<>();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onDie() {

    }

    @Override
    public void findCircleList(Object o) {
        CircleListBean circleListBean= (CircleListBean) o;
        
        if (circleListBean.getStatus().equals(CadeNow.SUCCESS)){
            if (circleListBean.getResult().size()>0){
                list.addAll(circleListBean.getResult());
            }else {
                Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
            }
        }
        xRecyCircle.setList(list);
    }
}
