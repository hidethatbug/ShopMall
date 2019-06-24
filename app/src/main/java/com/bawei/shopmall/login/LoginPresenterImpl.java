package com.bawei.shopmall.login;

import android.util.Log;

import com.bawei.shopmall.data.DataCallBackLogin;

/**
 * Author:程金柱
 * Date:2019/6/17 17:01
 * Description：
 */

public class LoginPresenterImpl implements LoginContract.LoginPresenter {
    private LoginContract.LoginModel loginModel;
    private LoginContract.LoginView loginView;
    @Override
    public void onBind(LoginContract.LoginView loginView) {
            this.loginView=loginView;
            loginModel=new LoginModelImpl();
    }

    @Override
    public void unBind() {
    if (loginModel!=null){
        loginModel=null;
    }
    if (loginView!=null){
        loginView=null;
    }
    System.gc();
    }

    @Override
    public void getData(String phone, String pwd) {
        loginModel.getLoginMsg(phone, pwd, new DataCallBackLogin() {
            private String TAG="";

            @Override
            public void getData(Object o) {
                Log.i(TAG, "getData: "+o);
                loginView.getLoginMsg(o);
            }
        });
    }

    @Override
    public void getRegister(String phone, String pwd) {

    }
}
