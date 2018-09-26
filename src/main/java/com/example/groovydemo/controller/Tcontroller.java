package com.example.groovydemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rollean.
 * http://localhost:9005/yejun/doControll?reqStr=343424242
 */

@Api(value = "Tcontroller", description = "测试GET请求")
@RestController
public class Tcontroller {

    @ApiOperation(value = "接口描述", notes = "接口详细说明")
//    @ApiImplicitParams(
//            @ApiImplicitParam(name = "reqStr" ,value = "参数", required = true, paramType = "query", dataType = "String")
//    )
    @RequestMapping(value = "yejun/doControll" , method = RequestMethod.GET)
    public String doConttroller(String reqStr){
        return "====>接收到的请求:" + reqStr;
    }





}
