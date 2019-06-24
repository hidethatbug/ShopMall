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

public class HomePzshAdapter extends RecyclerView.Adapter<HomePzshAdapter.RxxpHandler> {
    private Context context;
    private List<HomeListBean.ResultBean.PzshBean.CommodityListBeanX> pzshBeans;

    public HomePzshAdapter(Context context, List<HomeListBean.ResultBean.PzshBean.CommodityListBeanX> pzshBeans) {
        this.context = context;
        this.pzshBeans = pzshBeans;
    }

    @NonNull
    @Override
    public RxxpHandler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(R.layout.home_item_pzsh, viewGroup, false);
        return new RxxpHandler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpHandler rxxpHandler, int i) {
        HomeListBean.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX = pzshBeans.get(i);
        rxxpHandler.home_item_pzsh_shopname.setText(commodityListBeanX.getCommodityName());

        Glide.with(context).load(commodityListBeanX.getMasterPic())
                .placeholder(ImageNum.IMAGE_PLACEHOLDER).into(rxxpHandler.home_item_pzsh_shopimg);
    }

    @Override
    public int getItemCount() {
        if (pzshBeans!=null){
          return   pzshBeans.size();
        }
        return 0;
    }

    public class RxxpHandler extends RecyclerView.ViewHolder {
        @BindView(R.id.home_item_pzsh_shopimg)
        ImageView home_item_pzsh_shopimg;
        @BindView(R.id.home_item_pzsh_shopname)
        TextView home_item_pzsh_shopname;
        public RxxpHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
