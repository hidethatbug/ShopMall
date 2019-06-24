package com.bawei.shopmall;

import com.bawei.shopmall.data.TheUserCredentialsBean;

/**
 * Author:程金柱
 * Date:2019/6/20 20:57
 * Description：从sharesp中取出用户凭证
 */

public class TheUserCredentials {
    public static TheUserCredentialsBean getUserId (){
        int userId = App.getShop().getInt("userId", 0);
        String sessionId = App.getShop().getString("sessionId","");

        return new TheUserCredentialsBean(userId, sessionId);
    }
}
