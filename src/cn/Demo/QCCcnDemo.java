package cn.Demo;

import org.testng.annotations.Test;

import com.Util.Fileutil;
//import com.sun.jna.platform.FileUtils;
import org.apache.commons.io.FileUtils;

import cn.Object.ObjectTable;
import cn.Util.DateUtil;
import cn.Util.Log;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.apache.log4j.xml.DOMConfigurator;

public class QCCcnDemo {
	String baseUrl;
	WebDriver driver;
	
  @Test
  public void qccdemo() {
	    
//	  Log.startTestCase("开始测试");
	  driver.get(baseUrl);
//	  Log.info("打开页面");
	  driver.findElement(By.id("searchkey")).clear();
	  driver.findElement(By.id("searchkey")).sendKeys("小米科技");
//	  Log.info("输入搜索关键字");
	  driver.findElement(By.id("V3_Search_bt")).click();
//	  Log.info("单击搜索按钮");
	  
	  try{
		  Assert.assertTrue (driver.getPageSource().contains("小米科技"));
		  System.out.println("asser后继续执行了");
	  }catch(AssertionError e){
		  System.out.println("catch中的代码执行了");
		  takeTakesScreenshot (driver);
	  }
	  
//	  //Table类使用例子
//	  ObjectTable table = new ObjectTable();
//	  //获取被测试页面中的表格元，并存储到webTable中
//		WebElement webTable = driver.findElement(By.xpath("//table"));
//		//使用webTable进行Table实例化
//		table.Table(webTable);
//		WebElement cell = table.getCell(3, 2);
//		Assert.assertEquals(cell.getText(), "xxxx");
//		//获取cell中的元素
//		WebElement cellInput = table.getWebElementInCell(3, 2, By.tagName("input"));
//		cellInput.sendKeys("xxxxxs");

		
	  
	  
	  Log.endTestCase("测试结束");
  }
  @BeforeClass
  public void beforeClass() {

	  baseUrl = "www.qichacha.com";
	  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	  System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
	  driver = new InternetExplorerDriver();
	  
//	  DOMConfigurator.configure("log4j.xml");
  }

  @AfterClass
  public void afterClass() {
  }

  public void takeTakesScreenshot (WebDriver driver){
	  String currentPath = System.getProperty("user.dir");
	  try{
		  Date date = new Date ();
		  String picDir = currentPath + "\\" + String.valueOf(DateUtil.getYear(date)) + "-" + String.valueOf(DateUtil.getMonth(date))
		  + "-" + String.valueOf(DateUtil.getDay(date));
		  if(!new File (picDir).exists()){
			  Fileutil.creatDir(picDir);
		  }
		  
		  String filepath = picDir + "\\" + String.valueOf(DateUtil.getHour(date)) + "-" + String.valueOf(DateUtil.getMinute(date))
		  + "-" + String.valueOf(DateUtil.getSecond(date)) + ".png";
		  File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(srcFile, new File (filepath));
		  
	  }catch (Exception e){
		  e.printStackTrace();
	  }
  }
}
