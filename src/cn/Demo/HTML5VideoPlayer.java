package cn.Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HTML5VideoPlayer {
	
	String baseUrl;
	WebDriver driver;
	
  @Test
  public void testVideoPlayer() throws InterruptedException,IOException {
	  
	  //定义页面截图文件对象，用于后面的屏幕截图存储
	  File captureScreenFile = null;
	  //访问HTML5实现播放器的网页页面
	  driver.get(baseUrl);
	  //打印出HTML5视频播放器页面的源代码，供读者学习
	  System.out.println(driver.getPageSource());
	  //获取页面中的video标签
	  WebElement videoPlayer = driver.findElement(By.tagName("video"));
	  //申明一个JavascriptExecutor对象
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  //使用JavascriptExecutor 对象执行JavaScript语句，通过播放器内容的currentSrc属性获取视频文件的网络存储地址
	  String videoSrc = (String) js.executeScript("return arguments[0].currentSrc", videoPlayer);
	  //输出视频文件的网络存储地址
	  System.out.println(videoSrc);
	  //断言视频网络地址是否符合期望
	  Assert.assertEquals("http://www.w3school.com.cn/i/movie.ogg", videoSrc);
	  //使用JavascriptExecutor对象执行JavaScript语句，通过播放器内部的duraton属性获取视频文件的播放时长
	  Double videoDuration = (Double) js.executeScript("return arguments[0].duration", videoPlayer);
	  //输出视频的播放时长
	  System.out.println(videoDuration.intValue());
	  //等待5秒让视频完成加载
	  Thread.sleep(5000);
	//使用JavascriptExecutor对象执行JavaScript语句，通过播放器内部的play函数来播放影片
	  js.executeScript("return agrments[0].play()", videoPlayer);
	  Thread.sleep(2000);
	  /*
	   * 播放2s后，使用JavascriptExecutor对象执行JavaScript语句，通过调用播放器内部的pause函数来暂停播放影片
	   * */
	  js.executeScript("return agrments[0].pause()", videoPlayer);
	  //暂停3s验证暂停操作是否生效
	  Thread.sleep(3000);
	  //将暂停视频播放后的页面进行截屏，并保持XXX.png文件
	  captureScreenFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(captureScreenFile, new File("D:\\XXX.png"));
	  
  }
  @BeforeClass
  public void beforeClass() {
	  baseUrl = "www.w3school.com.cn/tiy/loadtext.asp?f=html5_video_simple";
	  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	  System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
	  driver = new InternetExplorerDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
