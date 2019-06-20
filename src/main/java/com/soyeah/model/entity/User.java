package com.soyeah.model.entity;

import java.io.Serializable;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/6/27.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
public class User implements Serializable {
    private static final long serialVersionUID = 9056145968791949376L;

    public static final int GENDER_MAN = 1;
    public static final int GENDER_WOMAN = 2;
    public static final int GENDER_UNKNOWN = 0;
    private Integer id;
    private String openid;
    private String username;
    private String imageUrl;
    private Integer point;
    private String city;
    private String country;
    private String province;
    private Integer gender;
    private String form_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public User(Integer id, String openid, String username, String imageUrl, Integer point, String city, String country, String province, Integer gender, String form_id) {
        this.id = id;
        this.openid = openid;
        this.username = username;
        this.imageUrl = imageUrl;
        this.point = point;
        this.city = city;
        this.country = country;
        this.province = province;
        this.gender = gender;
        this.form_id = form_id;
    }

    public User() {
    }
}
