package cn.DataDemo;

import org.testng.annotations.Test;


import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ExcelDataDemo {
	
	String baseUrl;
	WebDriver driver;
	
  @Test(dataProvider = "searchWords")
  public void ExcelDemo (String searchWord1, String searchWord2 , String searchResult) throws InterruptedException {
	  
	  driver.get(baseUrl);
	  
	  driver.findElement(By.id("query")).sendKeys(searchWord1 + " " + searchWord2);
	  driver.findElement(By.id("stb")).click();
	  
	  Thread.sleep(3000);
	  
	  Assert.assertTrue(driver.getPageSource().contains(searchResult));
	  
  }

  @DataProvider (name = "searchWords")
  public static Object [][] words () throws IOException{
	  return getTestData (System.getProperty("user.dir") + "\\" ,"data.xlsx","Sheet1");
  }
  
  
  public static Object [] [] getTestData (String filePath, String fileName, String sheetName) throws IOException {
	  //根据参数传入的数据文件路径和名称，组合出Excel数据文件的绝对路径
	  //声明一个File文件对象
	  File file = new File(filePath + "\\" + fileName);
	  //创建FileInputStream对象用于读取Excel文件
	  FileInputStream in = new FileInputStream(file);
	  
	  //声明Workbook对象
	  Workbook workbook = null;
	  //获取文件名参数的扩展名，判断是.xlsx文件还是.xls文件
//	  String fileExtensionName = fileName.split(".")[1];
	  String fileExtensionName = fileName.substring(fileName.indexOf("."));
	  
	  //判断文件类型如果是.xlsx,则使用XSSFworkbook 对象进行实例化
	  //判断文件类型如果是.xls,则使用HSSFWorkbook 对象进行实例化
	  if (fileExtensionName.equals(".xlsx")){
		  workbook = new XSSFWorkbook (in);
	  }
	  else if (fileExtensionName.equals(".xls")){
		  workbook = new HSSFWorkbook(in);
	  }
	  
	  //通过sheetName参数，生成Sheet对象
	  Sheet sheet = workbook.getSheet(sheetName);
	  
	  /*
	   * 获取Excel数据文件Sheet1中数据的行数，getLastRowNum方法获取数据的最后一行的行号
	   * getFirstRowNum方法获取数据的第一行的行号，相减之后算出数据的行数
	   * 注意：Excel文件的行号和列号都是从0开始的
	   * */
	  int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	  
	  //创建名为records的list对象来存储从Excel数据文件读取的数据
	  List <Object[]> records =  new ArrayList <Object []> ();
	  
	  /*
	   * 使用两个for循环遍历Excel数据文件的所有数据（除了第一行，第一行是数据列名称）
	   * 所以i从1开始，而不是0开始
	   * */
	  for (int i=1; i < rowCount+1; i++){
		  //使用getRow获取行对象
		  Row row = sheet.getRow(i);
		  
		  /*
		   * 声明一个数组，用来存储存储Excel数据文件每行中的3个数据，数组的大小用
		   * getLastCellNum方法来进行动态声明，实现测试数据个数和数据大小相一致
		   * */
		  String fields [] = new String [row.getLastCellNum()];
		  for (int j = 0; j < row.getLastCellNum(); j++){
			  //调用getCell和getStringCellValue方法获取Excel文件中的单元格数据
			  fields [j] = row.getCell(j).getStringCellValue();
		  }
		  //将fields的数据对象存储到records的list中
		  records.add(fields);
	  }
	  
	  //定义函数的返回值，即 Object[][]
	  //将存储测试数据的list转换为一个Object的二维数据
	  Object [][] results = new Object [records.size()][];
	  //设置二维数组每行的值，每行是一个Object对象
	  for (int i = 0; i < records.size(); i++){
		  results [i] = records.get(i);
	  }
	  return results;
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  baseUrl = "www.sogou.com";
	  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	  System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
	  driver = new InternetExplorerDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
