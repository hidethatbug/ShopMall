package com.bawei.shopmall.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.shopmall.App;
import com.bawei.shopmall.MainActivity;
import com.bawei.shopmall.base.BaseActivity;
import com.bawei.shopmall.bean.user.LoginBean;
import com.bawei.shopmall.R;
import com.bawei.shopmall.layout.CadeNow;
import com.bawei.shopmall.layout.LayoutNum;
import com.bawei.shopmall.login.register.RegisterPage;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author:程金柱
 * Date:2019/6/17 16:08
 * Description：
 */

public class LoginPage extends BaseActivity implements LoginContract.LoginView {
    private static final String TAG = "";
    private LoginContract.LoginPresenter loginPresenter;

    @BindView(R.id.edit_phone_login)
    EditText edit_phone_login;
    @BindView(R.id.edit_pwd_login)
    EditText edit_pwd_login;
    @BindView(R.id.but_loginW)
    Button but_loginW;
    @BindView(R.id.check_rem_num)
    CheckBox check_rem_num;
    @Override
    protected int bindLayout() {
        return LayoutNum.LOGINPAGE;
    }

    @Override
    protected void initView() {
        loginPresenter = new LoginPresenterImpl();
        loginPresenter.onBind(this);


    }

    @Override
    protected void initData() {
        SharedPreferences shop = App.getShop();
        String phone = shop.getString("phone", "");
        String pwd = shop.getString("pwd", "");
        boolean iszd = shop.getBoolean("iszd", false);
        if (phone.equals("")&&pwd.equals("")){}else {
            edit_pwd_login.setText(pwd);
            edit_phone_login.setText(phone);
            check_rem_num.setChecked(true);
            if (iszd){
                loginPresenter.getData(phone,pwd);
            }
        }

    }

    /**
     * 跳转注册页
     */
    @OnClick({R.id.text_jump_reg})
    public void jumpReg(){
        startActivity(new Intent(LoginPage.this, RegisterPage.class));
    }

    /**
     * 登录按钮的点击事件
     * @param view
     */
    @OnClick(R.id.but_loginW)
    public void clickLogin(View view){
        String phone = edit_phone_login.getText().toString().trim();
        String pwd = edit_pwd_login.getText().toString().trim();
        if (!phone.equals("")&&!pwd.equals("")){
            loginPresenter.getData(phone,pwd);
            if (check_rem_num.isChecked()){
                SharedPreferences shop = App.getShop();
                SharedPreferences.Editor edit = shop.edit();
                edit.putString("phone",phone);
                edit.putString("pwd",pwd);
                edit.putBoolean("iszd",true);
                edit.commit();
            }

        }else {
            Toast.makeText(this, "密码账号不能为空", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onDieMvp() {

    }

    @Override
    public void getLoginMsg(Object o) {
        LoginBean loginBean = (LoginBean) o;
        if (loginBean.getStatus().equals(CadeNow.SUCCESS)){
            SharedPreferences.Editor edit = App.getShop().edit();
            edit.putInt("userId",loginBean.getResult().getUserId());
            edit.putString("sessionId",loginBean.getResult().getSessionId());
            edit.commit();
            startActivity(new Intent(LoginPage.this,MainActivity.class));
            finish();
        }
        SharedPreferences.Editor edit = App.getShop().edit();
        edit.putString("phone","");
        edit.putString("pwd","");
        edit.commit();
    }


    @Override
    public void getRegisterMsg(Object o) {

    }
}
