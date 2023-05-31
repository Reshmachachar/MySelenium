package datadriventest_apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap_7_1 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream(".//datafiles//hashmap_to_excel.xlsx");
		
		XSSFWorkbook wrk=new XSSFWorkbook(fis);
		XSSFSheet sht=wrk.getSheet("Student_info");
		
		int rows=sht.getLastRowNum();
		int cols=sht.getRow(1).getLastCellNum();
		Map<Double,String> mapdata=new HashMap<Double,String>();
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row=sht.getRow(r);
			Double key=(Double)row.getCell(0).getNumericCellValue();
			String value=(String)row.getCell(1).getStringCellValue();
			mapdata.put(key, value);
		}
			
		for(Map.Entry entry:mapdata.entrySet())
		{
			System.out.print(entry.getKey() + " | ");
			System.out.print(entry.getValue() +"\n");
		}
		
		fis.close();
	
     System.out.println("HashMap Data Successfully retrived...");

	}
	//public static hashMap_data()

}
