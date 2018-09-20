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

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroovydemoApplicationTests {

	@Resource
	private GroovyUtil groovyUtil;

	@Autowired
	DefaultListableBeanFactory defaultListableBeanFactory;

	String wx = "package com.example.groovydemo.test01;\n" +
			"import com.example.groovydemo.signUtil.Md5Encrypt;\n" +
			"public class WXSign implements SignInterface{\n" +
			"    @Override\n" +
			"    public String getSign(Object... params) {\n" +
			"        //return \"======wxsign======\";\n" +
			"        return Md5Encrypt.md5(params[0]+\"123+\",\"utf-8\");\n" +
			"    }\n" +
			"    @Override\n" +
			"    public boolean doVerify(Object... params) {\n" +
			"        return true;\n" +
			"    }\n" +
			"}";


	String wx2 = "package com.example.groovydemo.test01;\n" +
			"import com.example.groovydemo.signUtil.Md5Encrypt;\n" +
			"public class WXSign implements SignInterface{\n" +
			"    @Override\n" +
			"    public String getSign(Object... params) {\n" +
			"        //return \"======wxsign======\";\n" +
			"        return Md5Encrypt.md5(params[0]+\"456+\",\"utf-8\");\n" +
			"    }\n" +
			"    @Override\n" +
			"    public boolean doVerify(Object... params) {\n" +
			"        return true;\n" +
			"    }\n" +
			"}";

	@Test
	public void contextLoads() {

		try {
			String aliBeanName = "aliSign";
			String aliFilePath = "/Users/yejun/IdeaProjects/groovyTest/src/main/resources/AliSign.groovy";
			//根据groovy文件初始化类
			groovyUtil.registerObjByFile(aliFilePath,aliBeanName);

			//初始化支付宝签名接口
			SignInterface aliSignInterface = (SignInterface)defaultListableBeanFactory.getBean(aliBeanName);
			System.out.println("=========>" + aliSignInterface.getSign("000111222333"));


			String wxBeanName = "wxSign";
			//初始化微信签名接口
			if(!defaultListableBeanFactory.containsSingleton(wxBeanName)){
				System.out.println("=========>" + "初始化wxSignInterface");
				//根据groovy字符串初始化类
				groovyUtil.registerObjByStr(wx,wxBeanName);
			}

			SignInterface wxSignInterface = (SignInterface)defaultListableBeanFactory.getBean(wxBeanName);
			System.out.println("=========>" + wxSignInterface.getSign("1234"));

			//刷新对象
			defaultListableBeanFactory.destroySingleton(wxBeanName);
			//根据groovy字符串初始化类
			groovyUtil.registerObjByStr(wx2,wxBeanName);
			wxSignInterface = (SignInterface)defaultListableBeanFactory.getBean(wxBeanName);

			System.out.println("=========>" + wxSignInterface.getSign("1234"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
