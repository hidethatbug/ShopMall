package com.bawei.shopmall.data.user;

import android.util.Log;

import com.bawei.shopmall.data.DataCallBackLogin;
import com.bawei.shopmall.net.HttpUtile;
import com.bawei.shopmall.bean.user.LoginBean;
import com.bawei.shopmall.api.ApiUser;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

/**
 * Author:程金柱
 * Date:2019/6/17 16:33
 * Description：
 */

public class UserData {
    private static UserData userData;

    private UserData() {

    }

    public static UserData userData() {
        if (userData==null){
            userData=new UserData();
        }
        return userData;
    }

    /**
     * 登录获取数据
     * @param phone
     * @param pwd
     * @param dataCallBackLogin
     */
    public void getLoginData(String phone, String pwd, final DataCallBackLogin dataCallBackLogin) {
        UserInfo netRetrofit = HttpUtile.httpUtile().getNetRetrofit(UserInfo.class);

        Observable<LoginBean> login = netRetrofit.isLogin(ApiUser.LOGIN_USER_URL, phone, pwd);
        Observable<LoginBean> data = getData(login);
        data.subscribe(new Consumer<LoginBean>() {
            @Override
            public void accept(LoginBean loginBean) throws Exception {
                dataCallBackLogin.getData(loginBean);
                EventBus.getDefault().postSticky(loginBean);
                Log.i(TAG, "accept: " + loginBean.getMessage());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
    }

    /**
     * 注册获取方法
     * @param phone
     * @param pwd
     * @param dataCallBackLogin
     */
    public void getRegisterData(String phone, String pwd, final DataCallBackLogin dataCallBackLogin) {
        UserInfo netRetrofit = HttpUtile.httpUtile().getNetRetrofit(UserInfo.class);

        Observable<LoginBean> login = netRetrofit.isLogin(ApiUser.REGISTER_USER_URL, phone, pwd);
        Observable<LoginBean> data = getData(login);
        data.subscribe(new Consumer<LoginBean>() {
            @Override
            public void accept(LoginBean loginBean) throws Exception {
                dataCallBackLogin.getData(loginBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
    }
    private Observable<LoginBean> getData(Observable<LoginBean> login) {
        Observable<LoginBean> loginBeanObservable = login.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return loginBeanObservable;
    }
}
