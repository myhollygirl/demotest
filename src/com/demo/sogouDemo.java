package com.demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class sogouDemo {

	public WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	
  @Test
  public void sogoudemo () throws Exception {
	  driver.get(baseUrl);
	  WebDriverWait wait = new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("query")));
	  WebElement searchInputBox = driver.findElement(By.id("query"));
	  searchInputBox.click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@type='hotword']")));	  
	  List<WebElement> suggetionOptions = driver.findElements(By.xpath("//li[@type='hotword']"));
	  System.out.println(suggetionOptions.get(1).getText());
	  for (WebElement element:suggetionOptions){
		  if (element.getText().contains("XXX")){
			  System.out.println(element.getText());
			  element.click();
			  break;
		  }
	  }
  }
  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	  baseUrl="www.sogou.com";
	  System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
	  System.setProperty("webdriver.ie.bin","C:\\Program Files\\Internet Explorer\\iexplore.exe");
	  driver = new InternetExplorerDriver();
  }

  @AfterClass
  public void afterClass() {
//	  driver.quit();
  }
}
