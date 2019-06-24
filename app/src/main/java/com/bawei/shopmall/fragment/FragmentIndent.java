package com.bawei.shopmall.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bawei.shopmall.App;
import com.bawei.shopmall.R;

import com.bawei.shopmall.adapter.indent.ViewPagerIndentAdapter;
import com.bawei.shopmall.base.BaseFragment;
import com.bawei.shopmall.bean.Indent.IndentListBean;
import com.bawei.shopmall.fragment.indent.AllIndent;
import com.bawei.shopmall.fragment.indent.ThisOkIndent;
import com.bawei.shopmall.fragment.indent.WaitForIndent;
import com.bawei.shopmall.fragment.indent.WaitPayIndent;
import com.bawei.shopmall.fragment.indent.WaitWriteIndent;
import com.bawei.shopmall.layout.LayoutNum;
import com.bawei.shopmall.login.LoginPage;
import com.bawei.shopmall.mvp.indent.IndentContract;
import com.bawei.shopmall.mvp.indent.IndentpresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author:程金柱
 * Date:2019/6/17 20:49
 * Description：
 */

public class FragmentIndent extends BaseFragment {
    private IndentContract.IndentPresenter indentPresenter;
    @BindView(R.id.tablayout_indent)
    TabLayout tablayout_indent;
    @BindView(R.id.viewpager_indent)
    ViewPager viewpager_indent;
    private List<Fragment> list;

    @Override
    protected int bindLayout() {
        return LayoutNum.INDENT_PAGE;
    }

    @Override
    protected void ininView() {


    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        list.add(new AllIndent());
        list.add(new ThisOkIndent());
        list.add(new WaitForIndent());
        list.add(new WaitPayIndent());
        list.add(new WaitWriteIndent());
        ViewPagerIndentAdapter viewPagerIndentAdapter = new ViewPagerIndentAdapter(getChildFragmentManager(), list);
        viewpager_indent.setAdapter(viewPagerIndentAdapter);
        viewpager_indent.setOffscreenPageLimit(0);
        tablayout_indent.setTabsFromPagerAdapter(viewPagerIndentAdapter);
        tablayout_indent.setupWithViewPager(viewpager_indent);
    }

    @Override
    protected void onDie() {

    }


}
