package com.Object;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;


//使用Properties 类

public class ObjectMap {
	Properties properties;

	public void Objectmap(String propFile){
		properties = new Properties();
		try{
			FileInputStream in = new FileInputStream(propFile);
			properties.load(in);
			in.close();
		}catch(IOException e){
			System.out.println("读取对象文件出错");
			e.printStackTrace();
		}
	}
	
	public By getLocator(String ElementNameInproFile) throws Exception{
		//根据变量 ElementNameInproFile,从属性配置文件中读取对应的配置对象
		String locator = properties.getProperty(ElementNameInproFile);
	
		//将配置对象中的定位类型存储到locatorType变量，将定位表达式的值存储到locatorValue变量中
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		
		//输出locatorType变量值和locatorValue变量值，验证是否赋值正确
		System.out.println("获取的定位类型："+locatorType+"\t 获取的定位表达式："+locatorValue);
	
		//根据locatorType的变量值内容判断返回何种定位方式的By对象
		if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		if (locatorType.toLowerCase().equals("classname"))
			return By.className(locatorValue);
		if (locatorType.toLowerCase().equals("tagname"))
			return By.tagName(locatorValue);
		if (locatorType.toLowerCase().equals("linktext"))
			return By.linkText(locatorValue);
		if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		if (locatorType.toLowerCase().equals("cssselector"))
			return By.cssSelector(locatorValue);
		if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("输入的locator type未在程序中被定义;"+locatorType);
	
	}
	

}
