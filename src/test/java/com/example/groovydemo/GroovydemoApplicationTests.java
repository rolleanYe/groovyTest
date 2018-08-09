package com.example.groovydemo;

import com.example.groovydemo.test01.GroovyUtil;
import com.example.groovydemo.test01.SignInterface;
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

	String wx = "package com.example.groovydemo.test01;\n" +
			"import java.util.Map;\n" +
			"import com.example.groovydemo.signUtil.Md5Encrypt;\n" +
			"public class WXSign implements SignInterface{\n" +
			"    @Override\n" +
			"    public String getSign(Map<String, String> params) {\n" +
			"        //return \"======wxsign======\";\n" +
			"        return Md5Encrypt.md5(\"1231231\",\"utf-8\");\n" +
			"    }\n" +
			"    @Override\n" +
			"    public boolean doVerify(Map<String, String> params) {\n" +
			"        return true;\n" +
			"    }\n" +
			"}";

	@Test
	public void contextLoads() {

		try {
			String aliBeanName = "aliSign";
			String aliFilePath = "/Users/yejun/IdeaProjects/groovyTest/src/main/resources/AliSign.groovy";
			groovyUtil.registerObjByFile(aliFilePath,aliBeanName);

			String wxBeanName = "wxSign";
			String wxFilePath = "/Users/yejun/IdeaProjects/groovyTest/src/main/resources/WXSign.groovy";

			SignInterface aliSignInterface = (SignInterface)defaultListableBeanFactory.getBean(aliBeanName);

			if(!defaultListableBeanFactory.containsSingleton(wxBeanName)){
				System.out.println("初始化wxSignInterface");

				groovyUtil.registerObjByStr(wx,wxBeanName);

//				defaultListableBeanFactory.destroySingleton(wxBeanName);

//				groovyUtil.registerObjByFile(wxFilePath,wxBeanName);
			}

			SignInterface wxSignInterface = (SignInterface)defaultListableBeanFactory.getBean(wxBeanName);

			System.out.println(aliSignInterface.getSign(new HashMap<>()));
			System.out.println(wxSignInterface.getSign(new HashMap<>()));
			System.out.println(wxSignInterface.doVerify(new HashMap<>()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}




}
