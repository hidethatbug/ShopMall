package com.bawei.shopmall.data.user;

import com.bawei.shopmall.bean.user.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Author:程金柱
 * Date:2019/6/17 16:28
 * Description：
 */

public interface UserInfo {
    @POST
    @FormUrlEncoded
    Observable<LoginBean> isLogin(@Url String api, @Field("phone") String phone,
                                  @Field("pwd") String pwd);
    @POST
    @FormUrlEncoded
    Observable<LoginBean> isRegister(@Url String api, @Field("phone") String phone,
                                  @Field("pwd") String pwd);
}
