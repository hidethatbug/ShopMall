package com.bawei.shopmall.fragment.indent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;

import com.bawei.shopmall.App;
import com.bawei.shopmall.R;
import com.bawei.shopmall.base.BaseFragment;
import com.bawei.shopmall.bean.Indent.IndentListBean;
import com.bawei.shopmall.login.LoginPage;
import com.bawei.shopmall.mvp.indent.IndentContract;
import com.bawei.shopmall.mvp.indent.IndentpresenterImpl;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * Author:程金柱
 * Date:2019/6/21 21:16
 * Description：
 */

public class AllIndent extends BaseFragment implements IndentContract.IndentView {
    private IndentContract.IndentPresenter indentPresenter;
    @BindView(R.id.xrecy_allindent)
    XRecyclerView xrecy_allindent;
    @Override
    protected int bindLayout() {
        return R.layout.all_indent;
    }

    @Override
    protected void ininView() {
        indentPresenter =new IndentpresenterImpl();
        indentPresenter.bind(this);
        xrecy_allindent.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected void initData() {
        SharedPreferences shop = App.getShop();
        int userId = shop.getInt("userId", 0);
        String sessionId = shop.getString("sessionId", "");
        if (userId == 0 && sessionId.equals("")) {
            startActivity(new Intent(getActivity(), LoginPage.class));
        }
        indentPresenter.getIndentListData(userId, sessionId, 0, 1, 5);
    }

    @Override
    protected void onDie() {

    }
    @Override
    public void getIndentListData(Object data) {
        IndentListBean indentListBean = (IndentListBean) data;


    }
}
