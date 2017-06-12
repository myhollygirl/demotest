package cn.Object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exten2Excel {
	
	public static void Exten2ExcelDemo (List <Out2ExcelObject1> objects , File file) throws IOException{
		FileInputStream in = new FileInputStream (file);//获取已经存在的文件
//		POIFSFileSystem ps = new POIFSFileSystem(in);//使用POI提供的方法得到excel的信息
		Workbook excel = new XSSFWorkbook(in);
		Sheet sheet = excel.getSheetAt(0);//获取到工作表，因为一个excel可能有多个工作表
		Row row = sheet.getRow(0);//获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即 字段列头，便于赋值
		System.out.println(sheet.getLastRowNum() + " " + row.getLastCellNum());//分别得到最后一行的行号，和一条记录的最后一个单元格
		
		FileOutputStream out = new FileOutputStream (file);//向已存在的文件中写数据
		row = sheet.createRow((short) (sheet.getLastRowNum()+1));//在现有行号追加数据
		row.createCell(0).setCellValue("xxx");//第一个cell写入
		
		out.flush();
		excel.write(out);
		out.close();
		excel.close();
		System.out.print("追加成功");
		
	}

}
