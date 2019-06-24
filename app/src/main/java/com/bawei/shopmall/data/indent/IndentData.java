package com.bawei.shopmall.data.indent;

import com.bawei.shopmall.bean.Indent.IndentListBean;
import com.bawei.shopmall.data.DataCallBackIndent;
import com.bawei.shopmall.data.circle.CircleData;
import com.bawei.shopmall.net.HttpUtile;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:程金柱
 * Date:2019/6/21 20:27
 * Description：
 */

public class IndentData {
    private static IndentData indentData;

    private IndentData() {

    }

    public static IndentData userData() {
        if (indentData == null) {
            indentData = new IndentData();
        }
        return indentData;
    }

    /**
     * 获取订单数据
     * @param dataCallBackIndent
     * @param userId
     * @param sessionId
     * @param status
     * @param page
     * @param count
     */
    public void getIndentListData(final DataCallBackIndent dataCallBackIndent,
                                  int userId,
                                  String sessionId,
                                  int status,
                                  int page,
                                  int count


    ) {
        IndentInfo netRetrofit = HttpUtile.httpUtile().getNetRetrofit(IndentInfo.class);
        final Observable<IndentListBean> indentListData = netRetrofit.getIndentListData(userId,
                sessionId,
                status,
                page,
                count);
        indentListData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                new Consumer<IndentListBean>() {
                    @Override
                    public void accept(IndentListBean indentListBean) throws Exception {
                        dataCallBackIndent.getData(indentListData);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        dataCallBackIndent.getError(throwable.toString());
                    }
                }
        );
    }
}
