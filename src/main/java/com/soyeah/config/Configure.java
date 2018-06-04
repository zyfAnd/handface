package com.soyeah.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Zhang Yanfu
 * @Date 2018/4/27.
 * @Email 1105564280@qq.com
 */
//@ConfigurationProperties(locations = "")
@Component
public class Configure {
    private String accessTokenUrl;
    private String templateUrl;

}
