package com.example.groovydemo.test01;

import groovy.lang.GroovyClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by rollean.
 */
@Component
public class GroovyUtil {

    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    //根据groovy文件初始化类
    public void registerObjByFile(String FilePath, String objName) throws Exception{
        File file = new File(FilePath);
        SignInterface signInterface = (SignInterface) new GroovyClassLoader(getClass().getClassLoader()).parseClass(file).newInstance();
        defaultListableBeanFactory.registerSingleton(objName,signInterface);
    }

    //根据groovy字符串初始化类
    public void registerObjByStr(String groovyStr, String objName) throws Exception{
        SignInterface signInterface = (SignInterface) new GroovyClassLoader(getClass().getClassLoader()).parseClass(groovyStr).newInstance();
        defaultListableBeanFactory.registerSingleton(objName,signInterface);
    }



}
