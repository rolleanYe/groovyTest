package com.example.groovydemo.controller;

import com.example.groovydemo.to.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.readers.operation.ResponseMessagesReader;

/**
 * Created by rollean.
 * http://localhost:9005/yejun/doControll?reqStr=343424242
 * http://localhost:9005/swagger-ui.html
 */

@Api(value = "Tcontroller", description = "测试GET请求")
@RestController
@RequestMapping(value = "/yejun")
public class Tcontroller {

    @ApiOperation(value = "测试接口", notes = "测试接口详细说明")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "reqStr" ,value = "参数", required = true, paramType = "query", dataType = "String")
    )
    @RequestMapping(value = "/doControll" , method = RequestMethod.GET)
    public String doConttroller(String reqStr){
        return "====>接收到的请求:" + reqStr;
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户查询信息获取用户信息")
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public User getUser(User user){
        User u = new User();
        u.setName(user.getName()+"##");
        u.setAge(user.getAge()+"##");

        return u;
    }


}
