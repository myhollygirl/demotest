package cn.DataDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CSVDataDemo {

	String baseUrl;
	WebDriver driver;
	
	//使用注解DataProvider，将数据集合命名为 testData
	@DataProvider (name = "testData")
	public static Object[][] words () throws Exception {
		return getTestData(System.getProperty("user.dir") + "\\para.csv");
	}
  
	
  @Test(dataProvider = "testData")
  public void csvDemo(String searchWord1, String searchWord2, String searchResult) throws InterruptedException {
	  
	  baseUrl = "www.sogou.com";
	  driver.get(baseUrl);
	  driver.findElement(By.id("query")).sendKeys(searchWord1 + " " + searchWord2);
	  driver.findElement(By.id("stb")).click();
	  	  
	  //使用显示等待方式，确认页面已经加载完成，页面底部的关键字“搜索帮助”已经显示在页面上
//	  WebDriverWait wait = new WebDriverWait(driver, 10);
//	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));
//	  wait.until (new ExpectedCondition <Boolean> () {
//		  @Override
//		  public Boolean apply (WebDriver d){
//			  return d.findElement(By.id("s_footer")).getText().contains(搜索帮助);
//		  }
//	  })
	  
	  Thread.sleep(3000);
	  Assert.assertTrue(driver.getPageSource().contains(searchResult));	  
	  
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
  
  public static Object [][] getTestData(String fileName) throws Exception {
	  List <Object[]> records = new ArrayList<Object[]> ();
	  String record;
	  
	  //设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader 读取文件内容
	  FileInputStream in = new FileInputStream(fileName);
	  InputStreamReader reader = new InputStreamReader ( in ,"UTF-8");
	  BufferedReader br = new BufferedReader (reader);
	  //忽略读取csv文件的标题行（第一行）
	  br.readLine();
	  
	  /*
	   * 遍历读取文件中除第一行外的其他所有行内容
	   * 并存储在名为records的ArrayList中
	   * 每一个records中存储的对象为一个String数字
	   * */
	  while ((record = br.readLine())!= null){
		  String fields[] = record.split(",");
		  records.add(fields);
	  }	  
	  br.close();
	  
	  /*
	   * 定义函数返回值，即Object[][]
	   * 将存储测试数据的list转换为一个Object的二维数组
	   * */
	  Object [][] results = new Object [records.size()][];
	  //设置二维数组每行的值，每行是一个Object对象
	  for (int i = 0; i < records.size(); i++){
		  results [i] = records.get(i);
	  }
	  return results;
  }

}
