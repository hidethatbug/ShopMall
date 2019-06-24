package com.bawei.shopmall.adapter.indent;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Author:程金柱
 * Date:2019/6/21 21:22
 * Description：
 */

public class ViewPagerIndentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private String[] titlt=new String[]{
        "全部订单","待付款","待收货","待评价","已完成"
    };
    public ViewPagerIndentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlt[position];
    }
}
