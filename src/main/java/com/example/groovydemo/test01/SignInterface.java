package com.example.groovydemo.test01;

import java.util.Map;

/**
 * Created by rollean.
 */
public interface SignInterface {

    String getSign(Map<String,String> params);

    boolean doVerify(Map<String,String> params);

}
