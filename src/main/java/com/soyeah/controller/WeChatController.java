package com.soyeah.controller;

import com.google.gson.Gson;
import com.soyeah.mapper.UserMapper;
import com.soyeah.model.KeyWord;
import com.soyeah.model.PictureRes;
import com.soyeah.model.TemplateMsg;
import com.soyeah.model.base.BaseResult;
import com.soyeah.model.entity.ImageRes;
import com.soyeah.model.entity.Offical;
import com.soyeah.model.entity.User;
import com.soyeah.service.UserService;
import com.soyeah.util.OkHttpUtil;
import com.soyeah.util.SharedImageUtils;
import com.soyeah.util.StringUtil;
import com.soyeah.util.WeChatUtil;
import com.sun.imageio.plugins.common.ImageUtil;
import org.json.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author Zhang Yanfu
 * @Date 2018/4/25.
 * @Email 1105564280@qq.com
 */
@RestController
@RequestMapping(value = "/WeChat")
public class WeChatController {
    Logger logger = LoggerFactory.getLogger(WeChatController.class);
    String [] officalName = {"纪晓岚","和珅","包拯","狄仁杰","李元芳","海瑞","武则天"};
    String [] officalRank = {"一品","一品","一品","一品","带刀侍卫","二品","武皇后"};

    @Autowired
    UserMapper userMapper;

    String resultMsg  = "";
    @Autowired
    UserService userService;
//    wx6b78cb1789ad172c
//1a971a4d16de0f4daea88f08b1fc903f
//    @Value("${wechat.access_token.url}")
    private String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx6b78cb1789ad172c&secret=3e6b96cc3b7401036370274598df4cee";
//    @Value("${wechat.template.url}")
    private String templateUrl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
    @RequestMapping(value = "/sendTemplateMsg", method = RequestMethod.POST)
    public String sendTemplateMsg(@RequestBody User user){
//        Gson
//        String form_id = request.getParameter("form_id");
//        String openId = request.getParameter("openId");
        if(user!=null) {
            logger.info(user.toString());
        }else{
            return null;
        }
        String form_id = user.getForm_id();
        String openId = user.getOpenid();


        logger.info("form_id:"+form_id);
        logger.info("opendId:"+openId);
        String template_id = "WKZv1pFfBYkQi9VfrvlGHRtN8Me0EH9RusxHCCrU_z8";

        Gson gson = new Gson();
        TemplateMsg  templateMsg =  new TemplateMsg();

        Map map =  new HashMap();
        KeyWord keyWord1 = new KeyWord();
        keyWord1.setColor("#173177");
        keyWord1.setValue("你的桃花运指数");
        map.put("keyword1",keyWord1);

        KeyWord keyWord2 = new KeyWord();
        keyWord2.setColor("#173177");
        keyWord2.setValue("小猪佩琦二号");
        map.put("keyword2",keyWord2);

        KeyWord keyWord3 = new KeyWord();
        keyWord3.setColor("#173177");

        Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
        logger.info("dateStr--"+dateStr);
        keyWord3.setValue(dateStr);
        map.put("keyword3",keyWord3);

        KeyWord keyWord4 = new KeyWord();
        keyWord4.setColor("#173177");
        keyWord4.setValue("你的桃花运指数为...");
        map.put("keyword4",keyWord4);
        templateMsg.setTouser(openId);
        templateMsg.setForm_id(form_id);
//        templateMsg.setPage("index");
        templateMsg.setTemplate_id(template_id);

        Random random = new Random();
        double source = (int)(random.nextDouble()*100);

        if(source>80){
            resultMsg = source+",今天的运势还不错哟";
        }else  if(source>60){
            resultMsg = source+",今天的运势,还可以哟";
        }else{
            resultMsg = source+",今天的运势,不是很好，需要好友带你飞";
        }


        templateMsg.setPage("pages/details/details?msg="+resultMsg);

        templateMsg.setData(map);
        String msg =  gson.toJson(templateMsg);
        logger.info("msg:"+msg);

        String accessToken  = WeChatUtil.getAccessToken(accessTokenUrl);
        String myTemplateUrl = templateUrl.replace("ACCESS_TOKEN",accessToken);
        logger.info("myTemplateUrl:"+myTemplateUrl);
        try {
            String json = OkHttpUtil.postSyncString(myTemplateUrl,msg);
            logger.info("json:"+json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userMapper.saveUser(user);

        return null;
    }
    @RequestMapping(value = "/validateToken")
    public  String validateToken(HttpServletRequest request){
       String signature =  request.getParameter("signature");
       String timestamp = request.getParameter("timestamp");
       String nonce = request.getParameter("nonce");
       String echostr = request.getParameter("echostr");
       logger.info("echostr:"+echostr);
       if(StringUtil.checkSignature(signature,timestamp,nonce)){
           return echostr;
       }else{
           //no action
       }
       return "";
    }
    @RequestMapping(value = "/loginByWeChat")
    public BaseResult loginByWeChat(@RequestParam String code){
        logger.info("=====loginByWeChat=====Entry==="+code);
        BaseResult baseResult = userService.loginByWeChat(code);
        logger.info("=====loginByWeChat=====End==="+baseResult.toString());
        return baseResult;
    }
    @RequestMapping(value = "/test")
    public String test(){
        logger.info("entry===");
        return "Hello World";
    }
    @RequestMapping(value = "/getShareImage",method = RequestMethod.POST)
    public BaseResult getShareImage(@RequestBody PictureRes res) throws Exception {

        logger.info("===getShareImage==");
        logger.info(res.toString());



        BaseResult result = new BaseResult();

        String imageUrl = "http://ouk8myx67.bkt.clouddn.com/test2.jpg";
        ImageRes imageRes = new ImageRes();
        imageRes.setImageUrl(imageUrl);
        result.setData(imageRes);
        logger.info("===getShareImage=end=");
        return  result;
    }
    @RequestMapping(value = "/getOfficalData")
    public BaseResult getOfficalData(){
        logger.info("entry===getOffical==");
        BaseResult result = new BaseResult();
        Offical offical = new Offical();

        Random random = new Random();
        int index = random.nextInt(7);

        offical.setOfficalName(officalName[index]);
        offical.setOfficalRank(officalRank[index]);


        result.setData(offical);
        return result;
    }
}
