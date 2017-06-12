package cn.Object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ObjectTable {
	//申明一个WebElement对象，用于存储页面的表格元素对象
	private WebElement _table;
	
	/*
	 * 为构造函数传入页面表格元素对象参数，调用Table类的settable方法，将页面
	 * 表格元素赋值赋值给Table类的_table成员变量
	 * */
	public void Table (WebElement table) {
		setTable (table);
	}
	
	//获取页面表格对象的方法
	public WebElement getTable(){
		return _table;
	}
	
	//将页面表格元素赋值给Table类中的_table成员变量的方法
	public void setTable(WebElement _table){
		this._table = _table;
	}
	
	/*
	 * 获取表格元素的行数，查找表格元素有几个tr元素
	 * 有几个tr元素，就可以知道表格有几行，tr数量和表格行数相一致
	 * */
	public int getRowCount(){
		List <WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.size();
	}
	
	/*
	 * 获取表格元素的列数
	 * 使用get(0)从容器中取出表格第一行的元素，查找有几个"td",td数量和列数一致
	 * */
	public int getColumnCoun(){
		List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.get(0).findElements(By.tagName("td")).size();
	}
	
	//获取表格中某行某列的单元格对象
	public WebElement getCell (int rowNo, int colNo) throws NoSuchElementException{
		try{
			List <WebElement> tableRows = _table.findElements(By.tagName("tr"));
			System.out.println("行总数"+tableRows.size());
			System.out.println("行号："+ rowNo);
			WebElement currentRow = tableRows.get(rowNo-1);
			List <WebElement> tablecols = currentRow.findElements(By.tagName("td"));
			System.out.println("列总数" + tablecols.size());
			System.out.println("列号：" + colNo);
			WebElement cell = tablecols.get(colNo-1);
			return cell;
		}catch (NoSuchElementException e){
			throw new NoSuchElementException("没有找到相关的元素");
		}
	}
	
	/*
	 * 获得表格中的某行某列的单元格中的摸个页面元素对象，by参数用于定位某个表
	 * 表格中的页面元素，例如：by.xpath("input[@type='text']")可以定义到表格中的输入框
	 * */
	public WebElement getWebElementInCell(int rowNo,int colNo,By by) throws NoSuchElementException{
		try{
			List <WebElement> tableRows = _table.findElements(By.tagName("tr"));
			List <WebElement> tableCols = tableRows.get(colNo-1).findElements(By.tagName("td"));
			WebElement cell = tableCols.get(colNo-1);
			return cell.findElement(by);
		}catch(NoSuchElementException e){
			throw new NoSuchElementException("没有找到相关的元素");
		}
	}


}