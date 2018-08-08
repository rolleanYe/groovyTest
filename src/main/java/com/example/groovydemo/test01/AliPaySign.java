package com.example.groovydemo.test01;

import java.util.Map;

/**
 * Created by rollean.
 */
public class AliPaySign implements SignInterface{

    @Override
    public String getSign(Map<String, String> params) {
        return "1231213123";
    }

    @Override
    public boolean doVerify(Map<String, String> params) {
        return false;
    }


}
