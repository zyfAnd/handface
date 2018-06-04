package com.soyeah;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author Zhang Yanfu
 * @Date 2018/4/29.
 * @Email 1105564280@qq.com
 */

//
public class SpringBootStartApplication extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(HandfaceApplication.class);
    }
}
