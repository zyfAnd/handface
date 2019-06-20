package com.soyeah.service.impl;

import com.soyeah.model.WeChatLoginInfo;
import com.soyeah.model.base.BaseResult;
import com.soyeah.model.dto.LoginRes;
import com.soyeah.model.entity.User;
import com.soyeah.service.UserService;
import com.soyeah.util.WeChatUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/5/16.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public BaseResult loginByWeChat(String code) {
        BaseResult baseResult =  new BaseResult();
        WeChatLoginInfo loginInfo = null;
        try {
             loginInfo =  WeChatUtil.getSessionKey(code);
            baseResult.setData(new LoginRes(0,"",loginInfo.getOpenid()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseResult;
    }

    @Override
    public void saveUser(User user) {

    }
}
