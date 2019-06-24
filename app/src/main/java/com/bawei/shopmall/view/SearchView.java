package com.bawei.shopmall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bawei.shopmall.R;
import com.bawei.shopmall.api.ApiShop;
import com.bawei.shopmall.bean.shop.SearchBean;
import com.bawei.shopmall.data.shop.ShopData;
import com.bawei.shopmall.data.shop.ShopInfo;
import com.bawei.shopmall.net.HttpUtile;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:程金柱
 * Date:2019/6/19 21:03
 * Description：
 */

public class SearchView extends LinearLayout {

    private Button but_search;
    private EditText text_search;
    private ImageView img_menu;
    private String text;

    public SearchView(Context context) {
        this(context,null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininData(context);
    }

    private void ininData(Context context) {
        LayoutInflater.from(context).inflate(R.layout.search_diy, this);
        but_search = findViewById(R.id.but_search);
        text_search = findViewById(R.id.text_search);
        img_menu = findViewById(R.id.img_menu);
        initView();

    }

    private getSearchView getSearchView;

    public void setGetSearchView(SearchView.getSearchView getSearchView) {
        this.getSearchView = getSearchView;
    }

    public interface getSearchView{
        void getData(String keyword);
    }


    public String getText() {
        return text;
    }

    private void initView() {
        text = text_search.getText().toString().trim();

        but_search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                but_search.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = text_search.getText().toString().trim();
                        if (text !=null){
                        getSearchView.getData(text);

                        }
                    }
                });
            }
        });
    }
}
