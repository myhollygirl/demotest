package com.Util;

public class Loglog {
	
	public static void startTestCase(String sTestCaseName){
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("**************            "+sTestCaseName+"             *************");
	}
	
	public static void endTestCase(String sTestCaseName){		
		System.out.println("**************            "+sTestCaseName+"             *************");
		System.out.println("-------------------------------------------------------------------------");
	}
	
	public static void info(String message){
		System.out.println("【Logging:"+message+"】");
	}
	
	public static void warn(String message){
		System.out.println("【Warnning："+message+"】");
	}
	
	//定义1个静态error方法，打印自定义的error级别日志信息
	public static void error(String message){
		System.out.println("【 Error："+message+"】");
	}	

}
