package com.bawei.shopmall.login.register;

import com.bawei.shopmall.data.DataCallBackLogin;
import com.bawei.shopmall.login.LoginContract;

/**
 * Author:程金柱
 * Date:2019/6/17 17:01
 * Description：
 */

public class RegisterPresenterImpl implements LoginContract.LoginPresenter {
    private LoginContract.LoginView loginView;
    private LoginContract.LoginModel loginModel;


    @Override
    public void onBind(LoginContract.LoginView loginView) {
        this.loginView = loginView;
        loginModel = new RegisterModelImpl();
    }

    @Override
    public void unBind() {
        if (loginView != null) {
            loginView = null;
        }
        if (loginModel != null) {
            loginModel = null;
        }
        System.gc();
    }

    @Override
    public void getData(String phone, String pwd) {

    }


    @Override
    public void getRegister(String phone, String pwd) {
        loginModel.getRegisterMsg(phone, pwd, new DataCallBackLogin() {
            @Override
            public void getData(Object o) {
                loginView.getRegisterMsg(o);
            }
        });
    }
}
