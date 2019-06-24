package com.bawei.shopmall;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.shopmall.base.BaseActivity;
import com.bawei.shopmall.data.TheUserCredentialsBean;
import com.bawei.shopmall.fragment.FragmentBuycar;
import com.bawei.shopmall.fragment.FragmentCircle;
import com.bawei.shopmall.fragment.FragmentHome;
import com.bawei.shopmall.fragment.FragmentIndent;
import com.bawei.shopmall.fragment.FragmentMy;
import com.bawei.shopmall.layout.LayoutNum;
import com.bawei.shopmall.login.LoginPage;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.rgroup_main)
    RadioGroup rgroup_main;
    @BindView(R.id.frame_main)
    FrameLayout frame_main;
    private FragmentHome fragmentHome;
    private FragmentCircle fragmentCircle;
    private FragmentBuycar fragmentBuycar;
    private FragmentIndent fragmentIndent;
    private FragmentMy fragmentMy;
    private String TAG="";
    private TheUserCredentialsBean userId;

    @Override
    protected int bindLayout() {
        return LayoutNum.MAIN_PAGE;
    }

    @Override
    protected void initView() {
        fragmentHome = new FragmentHome();
        fragmentCircle = new FragmentCircle();
        fragmentBuycar = new FragmentBuycar();
        fragmentIndent = new FragmentIndent();
        fragmentMy = new FragmentMy();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_main,fragmentHome)
                .add(R.id.frame_main, fragmentCircle)
                .add(R.id.frame_main, fragmentBuycar)
                .add(R.id.frame_main, fragmentIndent)
                .add(R.id.frame_main, fragmentMy)
                .show(fragmentHome)
                .hide(fragmentCircle)
                .hide(fragmentBuycar)
                .hide(fragmentIndent)
                .hide(fragmentMy)
                .commit();
        userId = TheUserCredentials.getUserId();
    }

    /**
     * 对fragment进行添加开启事务
     */
    @Override
    protected void initData() {


/**
 * 点击切换页面
 */
        rgroup_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId) {
                    case R.id.radiobut_home:
                        transaction.show(fragmentHome)
                                .hide(fragmentCircle)
                                .hide(fragmentBuycar)
                                .hide(fragmentIndent)
                                .hide(fragmentMy);
                        break;
                    case R.id.radiobut_circle:

                        if (userId!=null&&!userId.getSessionId().equals("")&&userId.getUserId()!=0){
                            transaction.hide(fragmentHome)
                                    .show(fragmentCircle)
                                    .hide(fragmentBuycar)
                                    .hide(fragmentIndent)
                                    .hide(fragmentMy);
                        }else {
                            startActivity(new Intent(MainActivity.this,LoginPage.class));
                        }

                        break;
                    case R.id.radiobut_buycar:

                        if (userId!=null&&!userId.getSessionId().equals("")&&userId.getUserId()!=0) {
                            transaction.hide(fragmentHome)
                                    .hide(fragmentCircle)
                                    .show(fragmentBuycar)
                                    .hide(fragmentIndent)
                                    .hide(fragmentMy);
                        }else {
                            startActivity(new Intent(MainActivity.this,LoginPage.class));
                        }
                        break;
                    case R.id.radiobut_indent:
                        if (userId!=null&&!userId.getSessionId().equals("")&&userId.getUserId()!=0) {
                        transaction.hide(fragmentHome)
                                .hide(fragmentCircle)
                                .hide(fragmentBuycar)
                                .show(fragmentIndent)
                                .hide(fragmentMy);
                }else {
                    startActivity(new Intent(MainActivity.this,LoginPage.class));
                }
                        break;
                    case R.id.radiobut_my:
                        if (userId!=null&&!userId.getSessionId().equals("")&&userId.getUserId()!=0) {
                        transaction.hide(fragmentHome)
                                .hide(fragmentCircle)
                                .hide(fragmentBuycar)
                                .hide(fragmentIndent)
                                .show(fragmentMy);
                        }else {
                            startActivity(new Intent(MainActivity.this,LoginPage.class));
                        }
                        break;
                }
                transaction.commit();
            }
        });
    }

    @Override
    protected void onDieMvp() {

    }
}
