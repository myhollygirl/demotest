package com.demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Object.ObjectMap;
import com.Util.Loglog;
import com.Util.SnapshotUtil;


  public class QCCWebDemo {
	
	public String baseUrl;
	WebDriver driver;
	ObjectMap object;
	
	String currentpath = System.getProperty("user.dir");

  @Test
  public void searchCompany() throws Exception{
	  
	  Loglog.startTestCase("Start Test");
	  driver.get(baseUrl);
	  WebDriverWait wait = new WebDriverWait(driver,10);
	  object.Objectmap (currentpath + "\\test.properties");
	  wait.until(ExpectedConditions.presenceOfElementLocated(object.getLocator("searchtext")));
	  Loglog.info("输入查询关键字");
	  driver.findElement(object.getLocator("searchtext")).clear();
	  driver.findElement(object.getLocator("searchtext")).sendKeys("小米");
	  Loglog.info("点击查询按钮");
	  driver.findElement(object.getLocator("searchbutton")).click();
	  String name = driver.getTitle();
	  SnapshotUtil.snapshot((TakesScreenshot)driver,name+".png" );
	  Loglog.endTestCase("End Test");


	  
  }
  @BeforeClass
  public void beforeClass() {
	  baseUrl = "www.qichacha.com";
	  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	  System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
	  driver = new InternetExplorerDriver();
	  object = new ObjectMap();
	  object.Objectmap (currentpath + "\\test.properties");
  }

  @AfterClass
  public void afterClass() {
	  
  }
  

}
