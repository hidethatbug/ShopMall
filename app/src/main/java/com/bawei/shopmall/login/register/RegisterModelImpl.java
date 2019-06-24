package com.bawei.shopmall.login.register;

import com.bawei.shopmall.data.DataCallBackLogin;
import com.bawei.shopmall.data.user.UserData;
import com.bawei.shopmall.login.LoginContract;

/**
 * Author:程金柱
 * Date:2019/6/17 16:54
 * Description：
 */

public class RegisterModelImpl implements LoginContract.LoginModel {


    @Override
    public void getLoginMsg(String phone, String pwd, DataCallBackLogin dataCallBackLogin) {

    }

    @Override
    public void getRegisterMsg(String phone, String pwd, DataCallBackLogin dataCallBackLogin) {
            UserData.userData().getRegisterData(phone,pwd,dataCallBackLogin);
    }
}
