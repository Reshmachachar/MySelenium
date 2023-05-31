package datadriventest_apachepoi;
/*
 * XSSFCreationHelper Class
 * 1.Extends to java.lang.Object class
 * 2.Some Uses :
 *    2.1 :Creates a new DataFormat instance
 *    2.2 :Creates a XSSF-style Color object, 
 *         used for extended sheet formattings and conditional formattings
 *    2.3 :Create a new XSSFHyperlink.     
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithDateCell_10 {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wrk=new XSSFWorkbook();
		XSSFSheet sht=wrk.createSheet("DateFormat");
		
		//Number Date Format
		XSSFCell cell=sht.createRow(0).createCell(0);
		cell.setCellValue(new Date());
		
		//Converting Number Date Format into proper date format with help of below class and methods :
		//date Format(dd-mm-yyyy) By using XSSFCreationHelper class(wrk.getCreationHelper() method) and XSSFCellstyle class
		
		XSSFCreationHelper creationhelper=wrk.getCreationHelper();
		
		//format1:dd-mm-yyyy
		CellStyle style1=wrk.createCellStyle(); //apache.poi.ss.usermodel.CellStyle;
		style1.setDataFormat(creationhelper.createDataFormat().getFormat("dd:mm:yyyy"));
		cell=sht.createRow(1).createCell(0);
		cell.setCellValue(new Date());//we convert number format date into expected date format by using style on it.
		cell.setCellStyle(style1);
		
		//format2 : dd-mm-yyyy
		CellStyle style2=wrk.createCellStyle();
		style2.setDataFormat(creationhelper.createDataFormat().getFormat("dd-mm-yyyy"));
		
		cell=sht.createRow(2).createCell(0);
		cell.setCellValue(new Date());
		cell.setCellStyle(style2);
		
		
		//format2 : dd/mm/yyyy
		CellStyle style3=wrk.createCellStyle();
		
		style3.setDataFormat(creationhelper.createDataFormat().getFormat("dd.mm.yyyy"));
		cell=sht.createRow(3).createCell(0);
		cell.setCellValue(new Date());
		cell.setCellStyle(style3);
		
		
	
		FileOutputStream out=new FileOutputStream(".//datafiles//dateformat.xlsx");
		wrk.write(out);
		out.close();
		System.out.println("Done!!");

	}

}
