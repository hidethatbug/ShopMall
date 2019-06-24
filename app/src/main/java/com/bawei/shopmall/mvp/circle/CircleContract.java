package com.bawei.shopmall.mvp.circle;

import com.bawei.shopmall.data.DataCallBackCircle;

/**
 * Author:程金柱
 * Date:2019/6/20 21:54
 * Description：
 */

public interface CircleContract {
    interface CircleModel {
        void findCircleList(DataCallBackCircle dataCallBackCircle,
                            int userId, String sessionId,
                            int page, int count
        );

    }

    interface CircleView {
        void findCircleList(Object o
        );
    }

    interface CirclePresenter {
        void bind(CircleView circleView);
        void unbind();
        void findCircleList(
                int userId, String sessionId,
                int page, int count
        );
    }
}
