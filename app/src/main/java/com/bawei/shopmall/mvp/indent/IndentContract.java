package com.bawei.shopmall.mvp.indent;

import com.bawei.shopmall.data.DataCallBackIndent;

/**
 * Author:程金柱
 * Date:2019/6/21 20:22
 * Description：
 */

public interface IndentContract {
    interface IndentModel{
        void getIndentListData(DataCallBackIndent dataCallBackIndent,
                                int userId,
                               String sessionId,
                               int status,
                               int page,
                               int count);
    }
    interface IndentView{
        void getIndentListData(Object data);
    }
    interface IndentPresenter{
        void bind(IndentView indentView);
        void unbind();
        void getIndentListData( int userId,
                   String sessionId,
                   int status,
                   int page,
                   int count);

    }
}
