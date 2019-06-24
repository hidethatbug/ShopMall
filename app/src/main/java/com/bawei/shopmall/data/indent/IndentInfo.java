package com.bawei.shopmall.data.indent;

import com.bawei.shopmall.api.ApiIndent;
import com.bawei.shopmall.bean.Indent.IndentListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Author:程金柱
 * Date:2019/6/21 20:27
 * Description：
 */

public interface IndentInfo {
    /**
     * 一个请求处理所有的list数据
     * @param userId
     * @param sessionId
     * @param status
     * @param page
     * @param count
     * @return
     */
    @GET(ApiIndent.CIRCLE_LIST)
    Observable<IndentListBean> getIndentListData(
            @Header("userId")     int userId,
            @Header("sessionId")  String sessionId,
            @Query("status")       int status,
            @Query("page")          int page,
            @Query("count")        int count

    );

}
