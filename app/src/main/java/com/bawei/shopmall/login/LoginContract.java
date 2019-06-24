package com.bawei.shopmall.login;

import com.bawei.shopmall.data.DataCallBackLogin;

/**
 * Author:程金柱
 * Date:2019/6/17 16:51
 * Description：
 */

public class LoginContract {
    public interface LoginModel{
        void getLoginMsg(String phone, String pwd, DataCallBackLogin dataCallBackLogin);
        void getRegisterMsg(String phone, String pwd, DataCallBackLogin dataCallBackLogin);
    }
    public interface LoginView{
        void getLoginMsg(Object o);
        void getRegisterMsg(Object o);
    }
    public interface LoginPresenter{

        void onBind(LoginView loginView);
        void unBind();
        void getData(String phone,String pwd);
        void getRegister(String phone,String pwd);
    }
}
