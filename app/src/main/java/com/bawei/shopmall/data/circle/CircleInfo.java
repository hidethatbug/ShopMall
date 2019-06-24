package com.bawei.shopmall.data.circle;

import com.bawei.shopmall.api.ApiCircle;
import com.bawei.shopmall.bean.circle.CircleListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Author:程金柱
 * Date:2019/6/20 21:45
 * Description：
 */

public interface CircleInfo {
    /**
     * 圈子列表
     * @param userId
     * @param sessionId
     * @param page
     * @param count
     * @return
     */
    @GET(ApiCircle.CIRCLE_LIST)
    Observable<CircleListBean> getCircleList(@Header("userId")int userId,
                                             @Header("sessionId")String sessionId,
                                             @Query("page") int page,
                                             @Query("count") int count);
}
