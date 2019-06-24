package com.bawei.shopmall.adapter.indent;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.shopmall.R;
import com.bawei.shopmall.bean.Indent.IndentListBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Author:程金柱
 * Date:2019/6/21 22:06
 * Description：
 */

public class ListviewIndentAdapter extends BaseAdapter {
    private Context context;
    private List<IndentListBean.OrderListBean.DetailListBean> list;

    public ListviewIndentAdapter(Context context, List<IndentListBean.OrderListBean.DetailListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list != null && list.size() > 0) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHandler myHandler;
        IndentListBean.OrderListBean.DetailListBean bean = list.get(position);
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.indent_base_list, null);
            myHandler = new MyHandler();
            myHandler.img_indent_base = convertView.findViewById(R.id.img_indent_base);
            myHandler.text_price_indent_base = convertView.findViewById(R.id.text_price_indent_base);
            myHandler.text_name_indent_base = convertView.findViewById(R.id.text_name_indent_base);
            convertView.setTag(myHandler);
        } else {
            myHandler = (MyHandler) convertView.getTag();
        }
        myHandler.text_name_indent_base.setText(bean.getCommodityName());
        myHandler.text_price_indent_base.setText(bean.getCommodityPrice() + "");
        Glide.with(context).load(bean.getCommodityPic()).into(myHandler.img_indent_base);
        return null;
    }

    class MyHandler {
        TextView text_name_indent_base;
        TextView text_price_indent_base;
        ImageView img_indent_base;
    }
}
