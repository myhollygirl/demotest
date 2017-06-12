package cn.Util;

import org.apache.log4j.Logger;

//使用Log4j进行打印日志

public class Log {
	
	//初始化1个Logger对象
	private static Logger Log = Logger.getLogger(Log.class.getName());
	//定义1个静态方法，可以打印自定义的某个测试用例开始执行的日志信息
	public static void startTestCase(String sTestCaseName){
		Log.info("-----------------------------------------------------------");
	    Log.info("*********            "+sTestCaseName+"             ********");
	}
	
	//定义1个静态方法，可以打印自定义的某个测试用例结束执行的日志信息
	public static void endTestCase(String sTestCaseName){
		Log.info("*********            "+"测试用例执行结束"+"             ********");
	    Log.info("-----------------------------------------------------------");
	}
	
	//定义1个静态info方法，打印自定义的info级别日志信息
	public static void info(String message){
		Log.info(message);
	}
	
	//定义1个静态warn方法，打印自定义的warn级别日志信息
	public static void warn(String message){
		Log.info(message);
	}
	
	//定义1个静态error方法，打印自定义的error级别日志信息
	public static void error(String message){
		Log.info(message);
	}
	
	//定义1个静态fatal方法，打印自定义的fatal级别日志信息
	public static void fatal(String message){
		Log.info(message);
	}
	
	//定义1个静态debug方法，打印自定义的debug级别日志信息
	public static void debug(String message){
		Log.info(message);
	}

}
