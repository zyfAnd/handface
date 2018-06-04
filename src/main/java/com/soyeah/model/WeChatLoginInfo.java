package com.soyeah.model;

import com.soyeah.model.base.BaseModel;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/5/16.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
public class WeChatLoginInfo extends BaseModel {

    private static final long serialVersionUID = -1112465849639983203L;
    private String openid;
    private String session_key;
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
