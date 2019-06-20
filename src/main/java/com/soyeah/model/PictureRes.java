package com.soyeah.model;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/7/7.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
public class PictureRes {
    private int age;
    private String gender;
    private int beauty;
    private int defeat;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBeauty() {
        return beauty;
    }

    public void setBeauty(int beauty) {
        this.beauty = beauty;
    }

    public int getDefeat() {
        return defeat;
    }

    public void setDefeat(int defeat) {
        this.defeat = defeat;
    }

    @Override
    public String toString() {
        return "PictureRes{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", beauty=" + beauty +
                ", defeat=" + defeat +
                '}';
    }
}
