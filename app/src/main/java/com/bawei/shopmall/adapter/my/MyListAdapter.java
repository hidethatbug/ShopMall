package com.bawei.shopmall.adapter.my;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.shopmall.R;

import java.util.List;

/**
 * Author:程金柱
 * Date:2019/6/24 20:26
 * Description：
 */

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> list;

    public MyListAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    private String[] text = new String[]{
            "个人资料", "我的圈子", "我的足迹", "我的钱包", "我的收货地址"
    };


    @Override
    public int getCount() {
        return text.length;
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
        if (convertView == null) {
            myHandler = new MyHandler();
            convertView = View.inflate(context, R.layout.my_list_item, null);
            myHandler.img = convertView.findViewById(R.id.img_my_list_item);
            myHandler.text = convertView.findViewById(R.id.text_my_list_item);
            convertView.setTag(myHandler);
        } else {
            myHandler = (MyHandler) convertView.getTag();
        }
        Integer integer = list.get(position);
        myHandler.img.setImageResource(integer);
        myHandler.text.setText(text[position]);
        return convertView;
    }

    class MyHandler {
        TextView text;
        ImageView img;
    }
}
