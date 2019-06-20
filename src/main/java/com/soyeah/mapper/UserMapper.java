package com.soyeah.mapper;

import com.soyeah.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/6/30.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
@Mapper
public interface UserMapper {
    public void saveUser(User user);
}
