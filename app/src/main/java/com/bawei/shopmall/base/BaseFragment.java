package com.bawei.shopmall.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:程金柱
 * Date:2019/6/17 15:28
 * Description：
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(bindLayout(), container, false);
        bind(inflate);
        ininView();
        initData();
        return inflate;
    }

    protected void bind(View inflate) {

        bind = ButterKnife.bind(this, inflate);
    }

    ;

    protected abstract int bindLayout();

    protected abstract void ininView();

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        onDie();
        onBindDie();
    }

    protected void onBindDie() {
        bind.unbind();

    }

    ;

    protected abstract void onDie();
}
