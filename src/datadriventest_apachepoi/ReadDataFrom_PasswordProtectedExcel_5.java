package datadriventest_apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFrom_PasswordProtectedExcel_5 {

	public static void main(String[] args) throws IOException {
  
		FileInputStream fis =new FileInputStream(".//datafiles//passwordprotected.xlsx");
		String password="aniket";
		
		//XSSFWorkbook wrk=new XSSFWorkbook();//getting null pointer exception because of password protected file 
		XSSFWorkbook wrk=(XSSFWorkbook) WorkbookFactory.create(fis, password);//return the Workbook interface reference object 
		                                                                     //which is implemented by XSSFWorkbook class
	                                                                         //So we can type cast here.
		
		XSSFSheet sht=wrk.getSheet("Sheet1");
		

		readDataFromExcel(sht);
		
		fis.close();
	

	}
	
	public static void readDataFromExcel(XSSFSheet sht)
	{
		int rows=sht.getLastRowNum();//start from 0  
		int cols=sht.getRow(1).getLastCellNum();//start from 1 (but in workbook start from 0)
		
		for(int r=0;r<=rows;r++)
		{
			XSSFRow row=sht.getRow(r);
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.getCell(c);
				switch(cell.getCellType())
				{
				case STRING:System.out.print(cell.getStringCellValue());break;
				case NUMERIC:System.out.print(cell.getNumericCellValue());break;
				case FORMULA:System.out.print(cell.getCellFormula());break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;	
					
				}
				System.out.print(" | ");
			}
			System.out.println();
			
		}
	}

}
