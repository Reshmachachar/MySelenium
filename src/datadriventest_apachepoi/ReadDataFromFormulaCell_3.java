package datadriventest_apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromFormulaCell_3 {

	public static void main(String[] args) throws IOException {
		
		String filePath=".//datafiles//readformulacell.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sht=workbook.getSheet("Sheet1");
		
		int rows=sht.getLastRowNum();
		int cols=sht.getRow(1).getLastCellNum();
		
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
				case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
				case FORMULA:System.out.print(cell.getNumericCellValue());break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		
		
		
		
		

	}

}
