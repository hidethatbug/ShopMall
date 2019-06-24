package com.bawei.shopmall.login;

import com.bawei.shopmall.data.DataCallBackLogin;
import com.bawei.shopmall.data.user.UserData;

/**
 * Author:程金柱
 * Date:2019/6/17 16:54
 * Description：
 */

public class LoginModelImpl implements LoginContract.LoginModel {


    @Override
    public void getLoginMsg(String phone, String pwd, final DataCallBackLogin dataCallBackLogin) {
        UserData.userData().getLoginData(phone,pwd,dataCallBackLogin);

    }

    @Override
    public void getRegisterMsg(String phone, String pwd, DataCallBackLogin dataCallBackLogin) {

    }
}
