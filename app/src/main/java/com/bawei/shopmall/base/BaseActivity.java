package com.bawei.shopmall.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:程金柱
 * Date:2019/6/17 15:25
 * Description：
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        onBind();
        initView();
        initData();
    }

    public void onBind() {

        bind = ButterKnife.bind(this);

    }

    protected abstract int bindLayout();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        onDieMvp();
        onDie();


    }

    protected abstract void onDieMvp();

    public   void onDie(){
        bind.unbind();


    };


}
