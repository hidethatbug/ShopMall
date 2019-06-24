package com.bawei.shopmall.mvp.circle;

import com.bawei.shopmall.data.DataCallBackCircle;
import com.bawei.shopmall.data.circle.CircleData;

/**
 * Author:程金柱
 * Date:2019/6/20 22:01
 * Description：
 */

public class CircleModelImpl implements CircleContract.CircleModel {
    @Override
    public void findCircleList(DataCallBackCircle dataCallBackCircle, int userId, String sessionId, int page, int count) {
        CircleData.userData().getCircleData(dataCallBackCircle,userId,sessionId,page,count);
    }
}
