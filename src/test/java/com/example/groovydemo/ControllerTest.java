package com.example.groovydemo;

import com.example.groovydemo.controller.Tcontroller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by rollean.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Resource
    private Tcontroller tcontroller;

    @Test
    public void testController(){
        System.out.println("====>测试Controller");
        System.out.println(tcontroller.doConttroller("sfsfsfsd"));
    }

}
