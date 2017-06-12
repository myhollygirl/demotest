package cn.Demo;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HTML5Storage {
	
	String baseUrlLocal;
	String baseUrlSession;
	WebDriver driver;
	JavascriptExecutor js;
	
  @Test
  public void HTML5Local() {
	  baseUrlLocal = "www.w3school.com.cn/tiy/loadtext.asp?f=html5_webstorage_local";
	  driver.get(baseUrlLocal);
	  
	  //使用JavaScript语句，return localStorage.lastname,获取存储在localStorage中的lastname
	  String lastname = (String) js.executeScript("return localStrage.lastname;");
	  Assert.assertEquals("Gates", lastname);
	  //使用JavaScript语句，localStorage.clear();清楚localStorage中的变量值
	  js.executeScript("localStorage.clear();");	  
  }
  
  @Test
  public void HTML5Session () throws InterruptedException {
	  
	  baseUrlSession = "www.w3school.com.cn/tiy/loadtext.asp?f=html5_webstorage_session";
	  driver.get(baseUrlSession);
	  
	  String lastname = (String) js.executeScript("return sessionStorage.lastname;");
	  Assert.assertEquals("XXX", lastname);
	  
	  //清楚存储在sessionStorage中的lastname项
	  js.executeScript("sessionStorage.removeItem('lastname');");
	  
	  js.executeScript("sessionStorage.clear();");
	  
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  
//	  baseUrl = "www.w3school.com.cn/tiy/loadtext.asp?f=html5_canvas_line";
	  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	  System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
	  driver = new InternetExplorerDriver();
  }

  @AfterClass
  public void afterClass() {
  }

}
