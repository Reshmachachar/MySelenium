package testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataSupplier_11_1 {
	
	@DataProvider
	@Test()
	public String[][] loginDataOfOrangeHRM() throws Exception
	{
		FileInputStream fis=new FileInputStream(".//datafiles//LoginData.xlsx");
		XSSFWorkbook wrk=new XSSFWorkbook(fis);
		XSSFSheet sht=wrk.getSheetAt(0);
		DataFormatter dff=new DataFormatter();
		
		int rows=sht.getLastRowNum();	
		int cols=sht.getRow(0).getLastCellNum();
		
		String[][] data=new String[rows][cols];
		
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row=sht.getRow(r+1); //due to index of row of array and Excel sheet 
			for(int c=0;c<cols;c++)
			{
				data[r][c]=dff.formatCellValue(row.getCell(c));				
				System.out.print(data[r][c]+"    ");
			}
			System.out.println();
		}
				
		fis.close();
		wrk.close();
       System.out.println("Done!!");
		return data;
						
		
	}

}
