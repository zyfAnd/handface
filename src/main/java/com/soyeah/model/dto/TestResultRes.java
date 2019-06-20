package com.soyeah.model.dto;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/8/6.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
public class TestResultRes {
    private String offical;
    private String annualSalary;
    private String wife;
    private String age;
    private String happinessRate;
    private String defeatRate;

    public TestResultRes() {
    }

    public TestResultRes(String offical, String annualSalary, String wife, String age, String happinessRate, String defeatRate) {
        this.offical = offical;
        this.annualSalary = annualSalary;
        this.wife = wife;
        this.age = age;
        this.happinessRate = happinessRate;
        this.defeatRate = defeatRate;
    }

    public String getOffical() {
        return offical;
    }

    public void setOffical(String offical) {
        this.offical = offical;
    }

    public String getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(String annualSalary) {
        this.annualSalary = annualSalary;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHappinessRate() {
        return happinessRate;
    }

    public void setHappinessRate(String happinessRate) {
        this.happinessRate = happinessRate;
    }

    public String getDefeatRate() {
        return defeatRate;
    }

    public void setDefeatRate(String defeatRate) {
        this.defeatRate = defeatRate;
    }
}