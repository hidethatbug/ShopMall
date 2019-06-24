package com.bawei.shopmall.adapter.shop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.shopmall.R;
import com.bawei.shopmall.bean.shop.SearchBean;
import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:程金柱
 * Date:2019/6/20 20:00
 * Description：
 */

public class XRecySearchAdapter extends XRecyclerView.Adapter<XRecySearchAdapter.XRecySearchHondler> {
    private List<SearchBean.ResultBean> list ;
    private Context context;

    public XRecySearchAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<SearchBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public XRecySearchHondler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(R.layout.search_home_xrecy, viewGroup, false);
        return new XRecySearchHondler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecySearchHondler xRecySearchHondler, int i) {
        SearchBean.ResultBean resultBean = list.get(i);
        xRecySearchHondler.text_search_item_name.setText(resultBean.getCommodityName());
        Glide.with(context).load(resultBean.getMasterPic()).into(xRecySearchHondler.text_search_item_img);
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    public class XRecySearchHondler extends XRecyclerView.ViewHolder {
        @BindView(R.id.text_search_item_img)
        ImageView text_search_item_img;
        @BindView(R.id.text_search_item_name)
        TextView text_search_item_name;
        public XRecySearchHondler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
