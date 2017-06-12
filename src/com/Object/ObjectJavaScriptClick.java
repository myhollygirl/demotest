package com.Object;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectJavaScriptClick {
	
	public class JavaScriptClick {
		
		public void JavascriptClick(WebDriver driver,WebElement element) throws Exception{
			try{
				if (element.isDisplayed() && element.isEnabled()){
					System.out.println("使用JavaScriptExcutor对元素进行单击操作");
					((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
									
				}else{
					System.out.println("页面上元素无法进行单击操作");
				}
			}catch (StaleElementReferenceException e){
				System.out.println("页面元素没有附加值网页中"+e.getStackTrace());
			}catch (NoSuchElementException e){
				System.out.println("在页面中没有找到要操作的页面元素"+e.getStackTrace());
			}
			catch(Exception e){
				System.out.println("无法完成单击动作"+e.getStackTrace());
			}
		}
	}

}
