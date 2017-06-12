package com.Object;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ObjectRobot {
	
	//Tab键
	public void pressTabKey (){
		
		Robot robot=null;
		try{
			robot = new Robot();
		}catch (AWTException e){
			e.printStackTrace();
		}		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}	
	
	//Enter键
	public void pressEnterKey(){
		
		Robot robot = null;
		try{
			robot = new Robot();
		}catch(AWTException e){
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/*封装的粘贴函数，可以将行数的string参数值放入到剪贴板中，然后再使用Robot
	 * 对象的keyPress和keyRelease函数来模拟Ctrl+V组合键完成粘贴操作
	 * */
	public void setAndctrlVClipboardData(String string){
		
		//声明StringSelection对象，并使用函数的string参数完成实例化
		StringSelection stringSlection = new StringSelection(string);
		//使用Toolkit对象的setContents方法将字符串放到剪切板中
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSlection, null);
		
		Robot robot = null;
		try{
			robot = new Robot();
		}catch(AWTException e){
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	}

}
