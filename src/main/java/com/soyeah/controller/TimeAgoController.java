package com.soyeah.controller;

import com.soyeah.model.base.BaseResult;
import com.soyeah.model.dto.TestResultRes;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authour Zhang Yanfu
 * @Date 2018/8/6.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
@RestController
@RequestMapping(value = "timeAgo")
public class TimeAgoController {

    @ApiOperation(value = "获取测试结果")
    @RequestMapping(value = "/getTestRes",method = RequestMethod.GET)
    public BaseResult getTestRes(){


        BaseResult baseResult =  new BaseResult();
        TestResultRes testResultRes =  new TestResultRes("一品","100两","三妻四妾","65","78%","89%");
        baseResult.setData(testResultRes);


        return baseResult;
    }
}
