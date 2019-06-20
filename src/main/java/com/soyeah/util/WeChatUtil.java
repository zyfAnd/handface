package com.soyeah.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.soyeah.model.WeChatLoginInfo;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
//import java.util.*;

/**
 * @Author Zhang Yanfu
 * @Date 2018/4/25.
 * @Email 1105564280@qq.com
 */
public class WeChatUtil {
    private static String APP_ID = "wx6b78cb1789ad172c";
    private static String APP_SECRET = "3e6b96cc3b7401036370274598df4cee";

    private static final Logger logger = LoggerFactory.getLogger(WeChatUtil.class);
    public static String getAccessToken(String url){
        try {
            String json = OkHttpUtil.getSyncString(url);
            logger.info("json:"+json);
            try {
                JSONObject jsonObject = new JSONObject(json);
                String accessToken = (String) jsonObject.get("access_token");
                logger.info("accessToken:"+accessToken);
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
        logger.info("resJson--"+resultJson);
        try {
            loginInfo = JSON.parseObject(resultJson, WeChatLoginInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("获取微信信息成功：" + loginInfo.toString());
        return loginInfo;
    }
    public String getminiqrQr(String sceneStr, String accessToken) {
        RestTemplate rest = new RestTemplate();
        InputStream inputStream = null;
        String path = null;
        try {
            String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + accessToken;
            Map<String, Object> param = new HashMap<>();
            param.put("scene", "activity_" + sceneStr);
//            param.put("page", "pages/Activity/Situation/Situation");
            param.put("width", 200);
//            logger.info("调用生成微信URL接口传参：" + param);

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            org.springframework.http.HttpEntity requestEntity = new org.springframework.http.HttpEntity(param, headers);
            ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class);
            logger.info("调用小程序生成微信小程序码URL接口返回结果：" + entity.getBody());

            byte[] result = entity.getBody();
            logger.info(Base64.encodeBase64String(result));
            inputStream = new ByteArrayInputStream(result);

            //七牛上传
//            path = qiniuService.uploadByStream(inputStream);
            logger.info("----------------path：{}", path);

        } catch (Exception e) {
            logger.error("调用小程序生成微信小程序码URL接口异常", e);

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return path;
    }
    public byte[] drawPicture(String backImg, String qrCodeImg, String kaiImg, String avatarImg,String activityText, String text1) throws IOException {

        //底图
        ClassPathResource redResource = new ClassPathResource(backImg);
        BufferedImage red = ImageIO.read(redResource.getInputStream());

        //头像
        URL avatarUrl = new URL(avatarImg);
        BufferedImage avatar = ImageIO.read(avatarUrl);

        //小程序码
        URL qrCodeUrl = new URL(qrCodeImg);
        BufferedImage qrCode = ImageIO.read(qrCodeUrl);

        //开
        ClassPathResource kaiResource = new ClassPathResource(kaiImg);
        BufferedImage kai = ImageIO.read(kaiResource.getInputStream());

        //白底
        ClassPathResource whiteResource = new ClassPathResource("white.jpeg");
        BufferedImage white = ImageIO.read(whiteResource.getInputStream());

        // --- 画图 ---

        //底层空白 bufferedImage
        BufferedImage imgB = new BufferedImage(red.getWidth(), red.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        //画上头像
//        drawImgInImg(imgB, avatar, 277, 90, 145, 145);
//
//        //白底
//        drawImgInImg(imgB, white, 200, 400, 250, 250);
//
//        //画上小程序码
//        drawImgInImg(imgB, qrCode, 255, 434, 190, 190);
//
//        //画上图片
//        drawImgInImg(imgB, red, 0, 0, red.getWidth(), red.getHeight());
//
//        //画上开
//        drawImgInImg(imgB, kai, 309, 488, 83, 83);
//
//        //写上文字，上
//        drawTextInImg(imgB, text1, 350, 315);
//
//        //写上文字，活动
//        drawTextInImg(imgB, activityText, 350, 395);

        //转jpg
        BufferedImage result = new BufferedImage(imgB.getWidth(), imgB
                .getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        result.getGraphics().drawImage(imgB, 0, 0, null);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ImageIO.write(result, "jpg", bs);

        //最终byte数组
        return bs.toByteArray();
    }
}
