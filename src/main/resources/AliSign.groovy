package com.example.groovydemo.test01;

import java.util.Map;

/**
 * Created by rollean.
 */
public class AliSign implements SignInterface{

    @Override
    public String getSign(Map<String, String> params) {
        return "======alisign======";
    }

    @Override
    public boolean doVerify(Map<String, String> params) {
        return false;
    }


}