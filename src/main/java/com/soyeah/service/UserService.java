package com.soyeah.service;

import com.soyeah.model.base.BaseResult;
import com.soyeah.model.entity.User;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/5/16.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
public interface UserService {
    public BaseResult loginByWeChat(String code);
    public void saveUser(User user);

}
