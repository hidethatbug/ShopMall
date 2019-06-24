package com.bawei.shopmall.data.circle;

import com.bawei.shopmall.bean.circle.CircleListBean;
import com.bawei.shopmall.data.DataCallBackCircle;
import com.bawei.shopmall.data.shop.ShopData;
import com.bawei.shopmall.net.HttpUtile;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:程金柱
 * Date:2019/6/20 21:49
 * Description：
 */

public class CircleData {
    private static CircleData circleData;

    private CircleData() {

    }

    public static CircleData userData() {
        if (circleData == null) {
            circleData = new CircleData();
        }
        return circleData;
    }

    public void getCircleData(final DataCallBackCircle dataCallBackCircle,
                              int userId, String sessionId,
                              int page, int count) {
        CircleInfo netRetrofit = HttpUtile.httpUtile().getNetRetrofit(CircleInfo.class);
        final Observable<CircleListBean> circleList = netRetrofit.getCircleList(userId, sessionId, page, count);
        circleList.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                new Consumer<CircleListBean>() {
                    @Override
                    public void accept(CircleListBean circleListBean) throws Exception {
                    dataCallBackCircle.success(circleListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    dataCallBackCircle.error(throwable.toString());
                    }
                }
        );

    }
}
