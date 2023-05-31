package datadriventest_apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.*;

/*DataDrivenTest-->
 * 1.It means maintain the excel sheet and read data from it.
 * 2.Data is nothing but possible combination of input data for single test case.
 * 
 * Apache POI-->
 * 1.It is an API provided by Apache foundation which is a collection of different java libraries.
 * 2.These libraries give the facilities to read ,write and manipulate different Microsoft files
 *   such as excel-sheet,power-point,word files.
 * 3.Selenium does not w=support to these files
 * 4.Interface-->Cell->Row->Sheet->Workbook
 * 5.xlsx-->XSSFCell->XSSFRow->XSSFSheet->XSSFWorkbook--(now we are using these classes)
 * 6.xls-->HSSFCell->HSSFRow->HSSFSheet->HSSFWorkbook (till excel version 97 ,support these classes)
 */

public class ReadDataFromExcel_1 {

	public static void main(String[] args) throws IOException {

		String filepath=".//datafiles//contries.xlsx";//we can use any path
		
		//now we are reading file stream
		
		FileInputStream fis=new FileInputStream(filepath);//got file
		
		XSSFWorkbook wrbook=new XSSFWorkbook(fis);//collection of sheets..
		
		//XSSFSheet sht=wrbook.getSheet("Sheet1");//BY the name..got sheet 
		XSSFSheet sht=wrbook.getSheetAt(0);//BY the index..got sheet..index start by zero
		
		//By for loop
	//	dataReadingByForLoop(sht);
		
		//By iterator
		dataReadingByIterator(sht);
		fis.close();
			
	}
	public static void dataReadingByIterator(XSSFSheet sht)
	{
		System.out.println("data by iterator_1"+"\n");
		
		Iterator it_sht=sht.iterator();
		 while(it_sht.hasNext())
		 {
			 XSSFRow row=(XSSFRow) it_sht.next();
			 
			Iterator it_row= row.iterator();
			while(it_row.hasNext())
			{
				XSSFCell cell=(XSSFCell) it_row.next();
				
				switch(cell.getCellType())//we get type so we use switch case
				{
				case STRING:System.out.print(cell.getStringCellValue());break;
		    	case NUMERIC:System.out.print(cell.getNumericCellValue());break;
		    	case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
				}
				
				System.out.print(" | ");		
			}
			System.out.println();
		 }
	}


	
	public static void dataReadingByForLoop(XSSFSheet sht)
	{
		int rows=sht.getLastRowNum();//rows size from sheet
		int cols=sht.getRow(1).getLastCellNum();//column size from particular row(1)
		
		System.out.println("rows :"+rows);
		System.out.println("cols :"+cols+"\n");
		
		for(int r=0;r<=rows;r++) //this for row
		{
			XSSFRow row=sht.getRow(r);//reading row 0....so on
			
		    for(int c=0;c<cols;c++) //this for col
		    {
		    	XSSFCell cell=row.getCell(c); //reading cells of row(0)...so on
		    	
		    	//due to hybrid data..datatype will be hybrid..so capture cell datatype
		    	
		    	switch(cell.getCellType())
		    	{
		    	case STRING:System.out.print(cell.getStringCellValue());break;
		    	case NUMERIC:System.out.print(cell.getNumericCellValue());break;
		    	case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
		    	}
		    	
		    	System.out.print(" | ");
		    }
		    System.out.println();
		}
	
		
	}

}
