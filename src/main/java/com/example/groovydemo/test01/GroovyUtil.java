package com.example.groovydemo.test01;

import groovy.lang.GroovyClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;

/**
 * Created by rollean.
 */
@Component
public class GroovyUtil {

    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    public void registerObj(String FilePath, String objName) throws Exception{
        File file = new File(FilePath);
        SignInterface signInterface = (SignInterface) new GroovyClassLoader(getClass().getClassLoader()).parseClass(file).newInstance();
        defaultListableBeanFactory.registerSingleton(objName,signInterface);

        beanFactory.autowireBean(signInterface);

    }


//    public static void main(String[] args) throws Exception{
//
//        GroovyUtil t = new GroovyUtil();
//        File file = new File("/Users/yejun/IdeaProjects/groovyTest/src/main/resources/AliSign.groovy");
//        SignInterface signInterface = (SignInterface) new GroovyClassLoader(t.getClass().getClassLoader()).parseClass(file).newInstance();
//        System.out.println(signInterface.getSign(new HashMap<>()));
//        System.out.println(signInterface.doVerify(new HashMap<>()));
//
//    }

}
