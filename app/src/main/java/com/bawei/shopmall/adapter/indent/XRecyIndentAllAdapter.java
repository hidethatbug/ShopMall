package com.bawei.shopmall.adapter.indent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bawei.shopmall.R;
import com.bawei.shopmall.bean.Indent.IndentListBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:程金柱
 * Date:2019/6/21 21:43
 * Description：
 */

public class XRecyIndentAllAdapter  extends XRecyclerView.Adapter<XRecyIndentAllAdapter.XRecyIndentAllHandler> {
    private List<IndentListBean.OrderListBean> orderListBeans;
    private Context context;

    public XRecyIndentAllAdapter(Context context) {
        this.context = context;
    }

    public void setOrderListBeans(List<IndentListBean.OrderListBean> orderListBeans) {
        this.orderListBeans = orderListBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public XRecyIndentAllHandler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.all_indent_item, viewGroup, false);
        return new XRecyIndentAllHandler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyIndentAllHandler xRecyIndentAllHandler, int i) {
        IndentListBean.OrderListBean orderListBean = orderListBeans.get(i);
        xRecyIndentAllHandler.text_allindent_orderId.setText(orderListBean.getOrderId());
        ListviewIndentAdapter listviewIndentAdapter = new ListviewIndentAdapter(context, orderListBean.getDetailList());
        xRecyIndentAllHandler.list_allindent_detailList.setAdapter(listviewIndentAdapter);
    }

    @Override
    public int getItemCount() {
        if (orderListBeans!=null&&orderListBeans.size()>0){
            return orderListBeans.size();
        }
        return 0;
    }

    public class XRecyIndentAllHandler extends XRecyclerView.ViewHolder{
        @BindView(R.id.img_allindent_img)
        ImageView img_allindent_img;
        @BindView(R.id.list_allindent_detailList)
        ListView list_allindent_detailList;
        @BindView(R.id.text_allindent_orderId)
        TextView text_allindent_orderId;
        public XRecyIndentAllHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
