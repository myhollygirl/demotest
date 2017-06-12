package cn.DataDemo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import cn.Object.Out2ExcelObject1;
import cn.Object.Out2ExcelUtil;

public class write2ExcelDomo {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		File file = new File ("test1.xlsx");
		if(!file.exists()){
			file.createNewFile();
		}
		List <Out2ExcelObject1> objects = new ArrayList <Out2ExcelObject1> ();
		objects.add(new Out2ExcelObject1 ("华为1", "企查查", "企查查", "V1.0", true));
		Out2ExcelUtil.write2Excel(objects, file);
		

	}

}
