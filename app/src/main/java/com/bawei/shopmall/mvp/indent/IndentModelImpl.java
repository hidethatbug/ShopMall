package com.bawei.shopmall.mvp.indent;

import com.bawei.shopmall.data.DataCallBackIndent;
import com.bawei.shopmall.data.indent.IndentData;

/**
 * Author:程金柱
 * Date:2019/6/21 20:55
 * Description：
 */

public class IndentModelImpl implements IndentContract.IndentModel {
    @Override
    public void getIndentListData(DataCallBackIndent dataCallBackIndent, int userId, String sessionId, int status, int page, int count) {
        IndentData.userData().getIndentListData(dataCallBackIndent,userId,sessionId,status,page,count);
    }
}
