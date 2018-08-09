package com.example.groovydemo.test01;

/**
 * Created by rollean.
 */
public class AliSign implements SignInterface{

    @Override
    public String getSign(Object... params) {
        return "======alisign======"+params[0];
    }

    @Override
    public boolean doVerify(Object... params) {
        return false;
    }


}