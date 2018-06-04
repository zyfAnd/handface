package com.soyeah.model.dto;

import com.soyeah.model.base.BaseModel;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/5/16.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
public class LoginRes extends BaseModel {

    private static final long serialVersionUID = 1179051267958070894L;
    private Integer userId;
    private String sessionId;
    private String openid;

    public LoginRes() {
    }

    public LoginRes(Integer userId, String sessionId, String openid) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.openid = openid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
