package com.bawei.shopmall.adapter.shop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.shopmall.R;
import com.bawei.shopmall.bean.shop.HomeListBean;
import com.bawei.shopmall.layout.ImageNum;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:程金柱
 * Date:2019/6/19 11:23
 * Description：
 */

public class HomeRxxpAdapter extends RecyclerView.Adapter<HomeRxxpAdapter.RxxpHandler> {
    private Context context;
    private List<HomeListBean.ResultBean.RxxpBean.CommodityListBean> rxxpBeans;

    public HomeRxxpAdapter(Context context, List<HomeListBean.ResultBean.RxxpBean.CommodityListBean> rxxpBeans) {
        this.context = context;
        this.rxxpBeans = rxxpBeans;
    }

    @NonNull
    @Override
    public RxxpHandler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(R.layout.home_item_rxxp, viewGroup, false);
        return new RxxpHandler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpHandler rxxpHandler, int i) {

            HomeListBean.ResultBean.RxxpBean.CommodityListBean commodityListBeanXX = rxxpBeans.get(i);
            rxxpHandler.home_item_rxxp_shopname.setText(commodityListBeanXX.getCommodityName());
            Glide.with(context).load(commodityListBeanXX.getMasterPic()).placeholder(ImageNum.IMAGE_PLACEHOLDER).into(rxxpHandler.home_item_rxxp_shopimg);

    }

    @Override
    public int getItemCount() {
        if (rxxpBeans!=null){
          return   rxxpBeans.size();
        }
        return 0;
    }

    public class RxxpHandler extends RecyclerView.ViewHolder {
        @BindView(R.id.home_item_rxxp_shopimg)
        ImageView home_item_rxxp_shopimg;
        @BindView(R.id.home_item_rxxp_shopname)
        TextView home_item_rxxp_shopname;
        public RxxpHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
