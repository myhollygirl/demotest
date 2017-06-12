package com.demo;

import org.testng.annotations.Test;

import com.Object.ObjectMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class Useobjectmapdemo {
	
	public WebDriver driver;
	String baseurl;
	ObjectMap objectmap;
	
  @Test
  public void Objectmapdemo() throws Exception {

	  driver.get(baseurl);
	  
	  String currentpath = System.getProperty("user.dir");
	  try{
		  //声明object对象实例
		  objectmap = new ObjectMap();
		  objectmap.Objectmap(currentpath+"\\test.properties");
		  
	  }catch(Exception e){
		  System.out.println("生成objectmap对象失败");
		  e.printStackTrace();
	  }
	  	  
	  WebDriverWait wait = new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(objectmap.getLocator("username")));
	  WebElement name = driver.findElement(objectmap.getLocator("username"));
	  WebElement password = driver.findElement(objectmap.getLocator("password"));
	  WebElement submitbutton = driver.findElement(objectmap.getLocator("submitbutton"));
	  name.clear();
	  password.clear();
	  name.sendKeys("");
	  password.sendKeys("");
	  submitbutton.click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='_mail_component_68_68']/span[2]")));
	  

	  
  }
  @BeforeClass
  public void beforeClass() {
	  baseurl = "http://www.126.com/";
	  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	  System.setProperty("webdriver.ie.bin","C:\\Program Files\\Internet Explorer\\iexplore.exe");
	  driver = new InternetExplorerDriver();	
  }

  @AfterClass
  public void afterClass() {
	  
  } 

}
