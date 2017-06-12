package com.Util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SnapshotUtil {
	
	public static void snapshot(TakesScreenshot drivername, String filename)
	  {
	      // this method will take screen shot ,require two parameters ,one is driver name, another is file name
	      
//	    ObjectCalendar calendar = new ObjectCalendar();
//	    ObjectFileUtil fileutil = new ObjectFileUtil();
	    String currentPath = System.getProperty("user.dir"); //get current work folder
	   
	  //对象函数若是static,则不用创建对象可直接使用类.函数来使用
	    String currentdate = Calendarutil.getFormatteddate();
//	    String currenttime = Calendarutil.getFormattedDT();
//	    String currentdate = calendar.getFormatteddate();
	    Fileutil.creatDir(currentPath+"\\"+currentdate);
	    
	    System.out.println(currentPath+"\\"+currentdate);
	    File scrFile = drivername.getScreenshotAs(OutputType.FILE);//snapshot((TakesScreenshot)driver, tile+".png");
	        // Now you can do whatever you need to do with it, for example copy somewhere
	        try {
	            System.out.println("save snapshot path is:"+currentPath+"\\"+filename);
	            FileUtils.copyFile(scrFile, new File(currentPath+"\\"+currentdate+"\\"+filename));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            System.out.println("Can't save screenshot");
	            e.printStackTrace();
	        } 
	        finally
	        {
	           System.out.println("screen shot finished");
	        }
	  }

}
