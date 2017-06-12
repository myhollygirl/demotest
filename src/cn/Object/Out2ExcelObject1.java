package cn.Object;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Out2ExcelObject1 {
	
	private String APPfileName;//APP文件名
	private String APPName1;//APP名称
	private String APPName2;//APP名称
	private String APPVersion;//APP版本
	private boolean testResult;//快速查询结果
	
	public Out2ExcelObject1 (String APPfileName, String APPName1, String APPName2, String APPVersion, boolean testResult){
		super();
		this.APPfileName = APPfileName;
		this.APPName1 = APPName1;
		this.APPName2 = APPName2;
		this.APPVersion = APPVersion;
		this.testResult = testResult;
		
	}
	
	public String getAPPfileName (){
		return APPfileName;
	}
	
	public void setAPPfileName (String name) {
		this.APPfileName = name;
	}
	
	public String getAPPName1 (){
		return APPName1;
	}
	
	public void setAPPName1 (String name) {
		this.APPName1 = name;
	}
	
	public String getAPPName2 (){
		return APPName2;
	}
	
	public void setAPPName2 (String name) {
		this.APPName2 = name;
	}
	
	public String getAPPVersion (){
		return APPVersion;
	}
	
	public void setAPPVersion (String version) {
		this.APPVersion = version;
	}
	
	public boolean gettestResult (){
		return testResult;
	}
	
	public void settestResult (boolean result){
		this.testResult = result;
	}
	
	
}
