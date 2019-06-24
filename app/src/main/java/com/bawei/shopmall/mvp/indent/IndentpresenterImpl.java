package com.bawei.shopmall.mvp.indent;

import com.bawei.shopmall.data.DataCallBackIndent;

/**
 * Author:程金柱
 * Date:2019/6/21 20:56
 * Description：
 */

public class IndentpresenterImpl implements IndentContract.IndentPresenter {
    private IndentContract.IndentModel indentModel;
    private IndentContract.IndentView indentView;

    @Override
    public void bind(IndentContract.IndentView indentView) {
        this.indentView = indentView;
        indentModel = new IndentModelImpl();
    }

    @Override
    public void unbind() {
        if (indentModel != null) {
            indentModel = null;
        }
        if (indentView != null) {
            indentView = null;
        }
        System.gc();
    }

    @Override
    public void getIndentListData(int userId, String sessionId, int status, int page, int count) {
        indentModel.getIndentListData(new DataCallBackIndent() {
            @Override
            public void getData(Object data) {
                indentView.getIndentListData(data);
            }

            @Override
            public void getError(String error) {

            }
        }, userId, sessionId, status, page, count);

    }



}
