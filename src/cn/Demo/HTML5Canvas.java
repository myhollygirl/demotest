package cn.Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HTML5Canvas {
	
	String baseUrl;
	WebDriver driver;
	JavascriptExecutor js;
	
  @Test
  public void testHTML5Canvas () throws InterruptedException, IOException {
	  
	  File scrFile = null;
	  
	  driver.get(baseUrl);
	  js = (JavascriptExecutor) driver;
	  
	  /*
	   * 使用JavascriptExecutor 语句在画布元素上画一个红色的矩形的图案
	   * getElementById('myCanvas')语句获取页面上的画布元素
	   * var cxt = c.getContext ('2d');设定画布为2d
	   * cxt.fillStyle = '#FF0000';设定填充色为#FF0000红色
	   * cxt.fillRect(0,0,150,150);在画布上绘制矩形
	   * */
	  Thread.sleep(3000);
	  js.executeScript("var c = document.getElementById('myCanvas');"
	  		+ "var cxt = c.getContext ('2d');"
	  		+ "cxt.fillStyle = '#FF0000;"
	  		+ "cxt.fillRect(0,0,150,150);" );
	  
	  //绘制红色矩形后，进行屏幕截屏，并保存为D盘的xx.jpg文件
	  scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrFile, new File("D:\\XXX.jpg"));  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  baseUrl = "www.w3school.com.cn/tiy/loadtext.asp?f=html5_canvas_line";
	  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	  System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
	  driver = new InternetExplorerDriver();
  }

  @AfterClass
  public void afterClass() {
  }

}
