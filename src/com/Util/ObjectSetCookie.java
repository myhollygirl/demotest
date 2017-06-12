package com.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class ObjectSetCookie {
	
	public void setCookies(WebDriver driver){
		try{
			String currentPath = System.getProperty("user.dir");
			String cookiefile = currentPath + "\\broswerCookie.txt";
			File file = new File(cookiefile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
				StringTokenizer str = new StringTokenizer(line, ";");
				while(str.hasMoreTokens()){
					String name=str.nextToken();
					String value=str.nextToken();
					String domain=str.nextToken();
//					String path=str.nextToken();
//					String dt;
//					if(!(dt=str.nextToken()).equals(null)){
//						
//						System.out.println();
//					}
//					boolean isSecure=new Boolean(str.nextToken()).booleanValue();
					Cookie ck=new Cookie(name,value,domain);
					driver.manage().addCookie(ck);	
					
				}
				System.out.println("cookie设置成功");
				br.close();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
