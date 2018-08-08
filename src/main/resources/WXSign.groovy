package com.example.groovydemo.test01;

import java.util.Map;

/**
 * Created by rollean.
 */
public class WXSign implements SignInterface{

    @Override
    public String getSign(Map<String, String> params) {
        return "======wxsign======";
    }

    @Override
    public boolean doVerify(Map<String, String> params) {
        return false;
    }


}