package cn.Object;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Out2ExcelUtil {
	
	public static void write2Excel (List <Out2ExcelObject1> objects, File file) throws IOException{
		
		XSSFWorkbook excel = new XSSFWorkbook();
		Sheet sheet = excel.createSheet("Result");
		
		/*
		 * 创建第一行标题信息的Row对象
		 * 我们都知道excel是表格，即由一行一行组成的，那么这一行在java类中就是一个Row对象，
		 * 我们通过Sheet对象就可以创建Row对象
		 * 如：创建表格中的第一行（我们常用来做标题的行)  Row firstRow = sheet.createRow(0); 注意下标从0开始
		 * */
		Row firstRow = sheet.createRow(0);
		
		/*创建标题行中的Cell数组
		 * 当然，excel中每一行是由若干个单元格，我们常称为cell,它对应着java中的Cell对象
		 * 如：创建5个单元格       Cell cells[] = new Cell[5]; 
		 * 假设我们一行有五列数据
		 * */
		Cell cells[] = new Cell[5];
		
		/*
		 * 创建标题数据，并通过Cell对象的setCellValue()方法对每个单元格进行赋值
		 * 既然单元格都准备好了，那最后是不是该填充数据了呀。对的，没错。填充数据之前，得把数据准备好吧，
		 * 数据：String[] titles = new String[]{"id","name","description","price","credit"};
		 * */
		String [] titles = new String [] {"APP文件名","APP名称1","APP名称2","APP版本","测试结果"};
		for (int i = 0; i< titles.length; i++){
			cells[0] = firstRow.createCell(i);
			cells[0].setCellValue(titles[i]);
		}
		
		//写入数据
		for (int i = 0; i < objects.size(); i++){
			Row row = sheet.createRow(i+1);
			Cell cell = row.createCell(0);//创建该行的第1个cell
			cell.setCellValue(objects.get(i).getAPPfileName());//获取第一个对象的APPfileName,并写入cell
			cell = row.createCell(1);//创建该行的第2个cell
			cell.setCellValue(objects.get(i).getAPPName1());
			cell = row.createCell(2);
			cell.setCellValue(objects.get(i).getAPPName2());
			cell = row.createCell(3);
			cell.setCellValue(objects.get(i).getAPPVersion());
			cell = row.createCell(4);
			cell.setCellValue(objects.get(i).gettestResult());			
		}
		
		/*将数据真正的写入excel文件中
		 *做到这里，数据都写好了，最后就是把HSSFWorkbook对象excel写入文件中了*/
		
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream (file);
			excel.write(out);
			out.close();
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}	
				
		excel.close();
		
		System.out.println("数据已经写入excel");
		
	}

}
