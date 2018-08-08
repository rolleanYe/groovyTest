package com.example.groovydemo;

import com.example.groovydemo.test01.SignInterface;
import com.example.groovydemo.test01.GroovyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroovydemoApplicationTests {

	@Resource
	private GroovyUtil groovyUtil;

	@Autowired
	DefaultListableBeanFactory defaultListableBeanFactory;

	@Test
	public void contextLoads() {

		try {
			String aliBeanName = "aliSign";
			String aliFilePath = "/Users/yejun/IdeaProjects/groovyTest/src/main/resources/AliSign.groovy";
			groovyUtil.registerObj(aliFilePath,aliBeanName);


			String wxBeanName = "wxSign";
			String wxFilePath = "/Users/yejun/IdeaProjects/groovyTest/src/main/resources/WXSign.groovy";
			groovyUtil.registerObj(wxFilePath,wxBeanName);
			
			SignInterface aliSignInterface = (SignInterface)defaultListableBeanFactory.getBean(aliBeanName);
			SignInterface wxSignInterface = (SignInterface)defaultListableBeanFactory.getBean(wxBeanName);

			System.out.println(aliSignInterface.getSign(new HashMap<>()));
			System.out.println(wxSignInterface.getSign(new HashMap<>()));


		} catch (Exception e) {
			e.printStackTrace();
		}

	}




}
