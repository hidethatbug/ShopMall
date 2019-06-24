package com.bawei.shopmall.fragment;

import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.shopmall.R;
import com.bawei.shopmall.adapter.my.MyListAdapter;
import com.bawei.shopmall.base.BaseFragment;
import com.bawei.shopmall.layout.LayoutNum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author:程金柱
 * Date:2019/6/17 20:49
 * Description：
 */

public class FragmentMy extends BaseFragment {
    @BindView(R.id.list_my)
    ListView list_my;
    @BindView(R.id.constraint_my)
    ConstraintLayout constraintLayout;
    @BindView(R.id.img_my)
    ImageView img_my;

    @Override
    protected int bindLayout() {
        return LayoutNum.MY_PAGE;
    }

    @Override
    protected void ininView() {

    }

    @Override
    protected void initData() {
        List<Integer> bitmaps = new ArrayList<>();
        bitmaps.add(R.mipmap.my_icon_information_n_xxhdpi);
        bitmaps.add(R.mipmap.my_icon_circle_n_xxhdpi);
        bitmaps.add(R.mipmap.my_icon_foot_n_xxhdpi);
        bitmaps.add(R.mipmap.my_icon_wallet_n_xxhdpi);
        bitmaps.add(R.mipmap.my_icon_address_n_xxhdpi);
        MyListAdapter myListAdapter = new MyListAdapter(getActivity(), bitmaps);
        list_my.setAdapter(myListAdapter);
    }

    @Override
    protected void onDie() {

    }
}
