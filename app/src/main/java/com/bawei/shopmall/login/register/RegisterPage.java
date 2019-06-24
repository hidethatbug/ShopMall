package com.bawei.shopmall.login.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.shopmall.App;
import com.bawei.shopmall.R;
import com.bawei.shopmall.base.BaseActivity;
import com.bawei.shopmall.bean.user.LoginBean;
import com.bawei.shopmall.layout.CadeNow;
import com.bawei.shopmall.layout.LayoutNum;
import com.bawei.shopmall.login.LoginContract;
import com.bawei.shopmall.login.LoginPage;


import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author:程金柱
 * Date:2019/6/17 16:08
 * Description：
 */

public class RegisterPage extends BaseActivity implements LoginContract.LoginView {
    private static final String TAG = "";
    private LoginContract.LoginPresenter loginPresenter;

    @BindView(R.id.edit_phone_register)
    EditText edit_phone_register;
    @BindView(R.id.edit_pwd_register)
    EditText edit_pwd_register;
    @BindView(R.id.but_registerW)
    Button but_registerW;
    @Override
    protected int bindLayout() {
        return LayoutNum.REGISTER;
    }

    @Override
    protected void initView() {
        loginPresenter=new RegisterPresenterImpl();
        loginPresenter.onBind(this);


    }

    @Override
    protected void initData() {

    }

    /**
     * 跳转到登录页面
     * @param view
     */
    @OnClick(R.id.text_jump_login)
    public void jumpLogin(View view){
       startActivity(new Intent(RegisterPage.this, LoginPage.class));
       finish();

    }

    /**
     * 注册按钮的点击事件
     * @param view
     */
    @OnClick(R.id.but_registerW)
    public void clickRegister(View view){
        String phone = edit_phone_register.getText().toString().trim();
        String pwd = edit_pwd_register.getText().toString().trim();

        if (!phone.equals("")&&!pwd.equals("")){
            loginPresenter.getRegister(phone,pwd);

        }else {
            Toast.makeText(this, "密码账号不能为空", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onDieMvp() {
        loginPresenter.unBind();
    }

    @Override
    public void getLoginMsg(Object o) {

    }

    @Override
    public void getRegisterMsg(Object o) {
        LoginBean loginBean= (LoginBean) o;
        String message = loginBean.getMessage();
        if (loginBean.getStatus().equals(CadeNow.SUCCESS)){
            String phone = edit_phone_register.getText().toString().trim();
            String pwd = edit_pwd_register.getText().toString().trim();
            SharedPreferences shop = App.getShop();
            SharedPreferences.Editor edit = shop.edit();
            edit.putString("phone",phone);
            edit.putString("pwd",pwd);
            edit.commit();
            startActivity(new Intent(RegisterPage.this,LoginPage.class));
            finish();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
