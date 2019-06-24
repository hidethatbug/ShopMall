package com.bawei.shopmall.mvp.circle;

import com.bawei.shopmall.data.DataCallBackCircle;

/**
 * Author:程金柱
 * Date:2019/6/21 9:37
 * Description：
 */

public class CirclePresenterImpl implements CircleContract.CirclePresenter {
    private CircleContract.CircleView circleView;
    private CircleContract.CircleModel circleModel;
    @Override
    public void bind(CircleContract.CircleView circleView) {
            this.circleView=circleView;
            circleModel =new CircleModelImpl();
    }

    @Override
    public void unbind() {
        if (circleView!=null){
            circleView=null;
        }
        if (circleModel!=null){
            circleModel=null;
        }
    }

    /**
     * 圈子的列表
     * @param userId
     * @param sessionId
     * @param page
     * @param count
     */
    @Override
    public void findCircleList(int userId, String sessionId, int page, int count) {
        circleModel.findCircleList(new DataCallBackCircle() {
            @Override
            public void success(Object data) {
            circleView.findCircleList(data);
            }

            @Override
            public void error(String error) {

            }
        },userId,sessionId,page,count);
    }
}
