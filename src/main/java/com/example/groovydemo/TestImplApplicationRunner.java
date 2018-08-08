package com.example.groovydemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by rollean.
 */

@Component
public class TestImplApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("1=============这个是测试ApplicationRunner接口=============");
//        System.out.println(args.getOptionNames());
//        System.out.println(args.getOptionValues("aaa"));
//        System.out.println(args.getOptionValues("bb"));
//
//        System.out.println("2=============这个是测试ApplicationRunner接口=============");
    }

}
