package com.Util;

import java.io.File;
import java.io.IOException;

public class Fileutil {
	
	public static boolean creatFile (String destFileName){
		File file = new File(destFileName);
		if(file.exists()){
			System.out.println("创建"+destFileName+"文件失败，目标文件已存在！");
			return false;
		}
		if (destFileName.endsWith(File.separator)){
			System.out.println("创建"+destFileName+"文件失败，目标文件不能为目录！");
			return false;
		}
		//判断目标文件所在的目录是否存在
		if (!file.getParentFile().exists()){
			//如果目标文件所在的目录不存在，则创建父目录
			System.out.println("目标文件所在目录不存在，创建它！");
			if(!file.getParentFile().mkdirs()){
				System.out.println("创建目标文件所在目录失败！");
				return false;
			}
		}
		//创建目标文件
		try{
			if(file.createNewFile()){
				System.out.println("创建"+destFileName+"文件成功！");
				return true;
			}else{
				System.out.println("创建"+destFileName+"文件失败！");
				return false;
			}
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("创建"+destFileName+"文件失败！"+e.getMessage());
			return false;
		}
	}
	
	public static boolean creatDir(String destDirName){
		File dir = new File(destDirName);
		if (dir.exists()){
			System.out.println("创建"+destDirName+"目录失败，目标目录已经存在！");
			return false;
		}
		//创建目录
		if(dir.mkdirs()){
			System.out.println("创建"+destDirName+"成功！");
			return true;
		}else{
			System.out.println("创建"+destDirName+"目录失败！");
			return false;
		}
	}

}
