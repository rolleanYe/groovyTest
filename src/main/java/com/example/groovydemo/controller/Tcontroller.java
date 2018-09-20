package com.example.groovydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rollean.
 * http://localhost:9005/yejun/doControll?reqStr=343424242
 */

@RestController
public class Tcontroller {

    @RequestMapping(value = "yejun/doControll" , method = RequestMethod.GET)
    public String doConttroller(String reqStr){
        return "====>接收到的请求:" + reqStr;
    }


}
