package com.Util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Compare2ScreenShot {
	
	

	public static boolean compare(String ExpectFile,String ActualFile) throws IOException , InterruptedException
	{
		File fileinput = new File (ExpectFile);
		File fileoutput = new File (ActualFile);
		
		BufferedImage bufileInput = ImageIO.read(fileinput);
		DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
		int sizefileInput = dafileInput.getSize();
		BufferedImage bufileOutput = ImageIO.read(fileoutput);
		DataBuffer dafileOutput = bufileOutput.getData().getDataBuffer();
		int sizefileOutput = dafileOutput.getSize();
		
		boolean matchFlag = true;
		if(sizefileInput == sizefileOutput){
			for (int j=0 ; j<sizefileInput ; j++){
				if(dafileInput.getElem(j)!=dafileOutput.getElem(j)){
					matchFlag = false;
					break;
				}					
			}
		}else{
			matchFlag=false;
		}
		return matchFlag;
	}

}
