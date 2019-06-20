package com.soyeah.controller;

import com.soyeah.model.base.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/7/15.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
@RestController
@RequestMapping(value = "Videos")
public class VideosController {
    @RequestMapping(value = "getVideos", method = RequestMethod.GET)
    public BaseResult getVideos(){
        String[] videos = {"v0721mpa54b","j07219j6fgs","l0612kq3cw2","h072225m6kf"};

        BaseResult baseResult = new BaseResult();
        baseResult.setData(videos);
        return  baseResult;
    }
}
