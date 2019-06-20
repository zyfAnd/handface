package com.soyeah.model.entity;

import java.io.Serializable;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/7/3.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
public class Offical implements Serializable {

    private String officalName;
    private String officalRank;

    public String getOfficalName() {
        return officalName;
    }

    public void setOfficalName(String officalName) {
        this.officalName = officalName;
    }

    public String getOfficalRank() {
        return officalRank;
    }

    public void setOfficalRank(String officalRank) {
        this.officalRank = officalRank;
    }
}
