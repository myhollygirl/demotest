package cn.DataDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;



public class arraysDatademo {
	
	String baseUrl;
	WebDriver driver;
	
	@DataProvider (name = "searchWords")
	public static Object[][] words(){
		return new Object[][]{{"蝙蝠侠","主演","迈克尔"},{"超人","导演","唐纳"},{"生化危机","编剧","安德森"}};
	}
	
  @Test (dataProvider = "searchWords")
  public void test(String searchWord1,String searchWord2, String searchResult) {
//	  pro.setProperty("file.encoding","utf-8"); 
	  
	  //设定等待时间为10S
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.get(baseUrl);
	  
	  driver.findElement(By.id("query")).sendKeys(searchWord1 + " " + searchWord2);
	  driver.findElement(By.id("stb")).click();
	  
	  try{
		  Thread.sleep(3000);
	  }catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  
	  Assert.assertTrue(driver.getPageSource().contains(searchResult));
//	  driver.quit();
  }
  @BeforeClass
  public void beforeClass() {
	  baseUrl = "www.sogou.com";
	  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	  System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
	  driver = new InternetExplorerDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
