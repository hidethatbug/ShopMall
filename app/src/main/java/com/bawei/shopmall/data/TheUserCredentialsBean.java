package com.bawei.shopmall.data;

/**
 * Author:程金柱
 * Date:2019/6/20 20:58
 * Description：
 */

public class TheUserCredentialsBean {
   private int userId;
   private String sessionId;

    public TheUserCredentialsBean(int userId, String sessionId) {
        this.userId = userId;
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
