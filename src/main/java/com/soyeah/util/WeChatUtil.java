package com.soyeah.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.soyeah.model.WeChatLoginInfo;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author Zhang Yanfu
 * @Date 2018/4/25.
 * @Email 1105564280@qq.com
 */
public class WeChatUtil {
    private static String APP_ID = "wx6b78cb1789ad172c";
    private static String APP_SECRET = "3e6b96cc3b7401036370274598df4cee";

    private static final Logger log = LoggerFactory.getLogger(WeChatUtil.class);
    public static String getAccessToken(String url){
        try {
            String json = OkHttpUtil.getSyncString(url);
            log.info("json:"+json);
            try {
                JSONObject jsonObject = new JSONObject(json);
                String accessToken = (String) jsonObject.get("access_token");
                log.info("accessToken:"+accessToken);
                return accessToken;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static WeChatLoginInfo getSessionKey(String code) throws IOException {

        String authUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        WeChatLoginInfo loginInfo = null;
        authUrl = authUrl.replace("APPID", APP_ID);
        authUrl = authUrl.replace("SECRET", APP_SECRET);
        authUrl = authUrl.replace("JSCODE", code);
        System.out.println("code: " + code);
        String resultJson = OkHttpUtil.getSyncString(authUrl);
        log.info("resJson--"+resultJson);
        try {
            loginInfo = JSON.parseObject(resultJson, WeChatLoginInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("获取微信信息成功：" + loginInfo.toString());
        return loginInfo;
    }
}
