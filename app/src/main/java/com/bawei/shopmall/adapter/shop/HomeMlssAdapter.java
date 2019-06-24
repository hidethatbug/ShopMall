package com.bawei.shopmall.adapter.shop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import static org.greenrobot.eventbus.EventBus.TAG;

/**
 * Author:程金柱
 * Date:2019/6/19 11:23
 * Description：
 */

public class HomeMlssAdapter extends RecyclerView.Adapter<HomeMlssAdapter.RxxpHandler> {
    private Context context;
    private List<HomeListBean.ResultBean.MlssBean.CommodityListBeanXX> mlssBeans;

    public HomeMlssAdapter(Context context, List<HomeListBean.ResultBean.MlssBean.CommodityListBeanXX> mlssBeans) {
        this.context = context;
        this.mlssBeans = mlssBeans;
    }

    @NonNull
    @Override
    public RxxpHandler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(R.layout.home_item_mlss, viewGroup, false);
        return new RxxpHandler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpHandler rxxpHandler, int i) {
        if (mlssBeans!=null){

        HomeListBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX = mlssBeans.get(i);
        rxxpHandler.home_item_mlss_shopname.setText(commodityListBeanXX.getCommodityName());

        Glide.with(context).load(commodityListBeanXX.getMasterPic())
                .placeholder(ImageNum.IMAGE_PLACEHOLDER).into(rxxpHandler.home_item_mlss_shopimg);
        }

    }

    @Override
    public int getItemCount() {
        if (mlssBeans!=null){
          return   mlssBeans.size();
        }
        return 0;
    }

    public class RxxpHandler extends RecyclerView.ViewHolder {
        @BindView(R.id.home_item_mlss_shopimg)
        ImageView home_item_mlss_shopimg;
        @BindView(R.id.home_item_mlss_shopname)
        TextView home_item_mlss_shopname;
        public RxxpHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
