package datadriventest_apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*Steps-->Read and Write Existing file
 * 
 * 1.Read File By FileInputStream into Workbook..
 * 2.Then by Workbook take Sheet and do your work 
 * 3.Then Close the Only FileInputStream and not close the Workbook 
 * 4.Then Write Workbook to File create FileOutputStream
 * 5.write Workbook and close the both.. 
 */

public class WriteFormulaCellIn_ExistingExcelFile_4 {

	public static void main(String[] args) throws IOException {
	
		String filePath=".\\datafiles\\booksprice.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		//get file into workbook
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sht=workbook.getSheet("Sheet1");
		//sht.getRow(7).getCell(2).setCellValue(0);
		//if(sht.getRow(7).getCell(2).getBooleanCellValue()==false)
		sht.getRow(7).createCell(2).setCellFormula("SUM(C2:C6)");
		sht.getRow(7).getCell(2).setCellFormula("SUM(C2:C6)");
		fis.close();//only FileInputStream closed which is we read into the workbook
		            //So whatever changes happened is in the only workbook..
		            //like that there is no effect on file..
		            //so we want to write that changes into the file
		            //for that we need FileOutputstream to write that workbook into the file
		            //So first we need to close existing opened FileInputStream
		
		FileOutputStream fos=new FileOutputStream(filePath);
		
		workbook.write(fos);
		workbook.close();
		fos.close();
		
		System.out.println("Done!");
		
		
		
		
		
		               
		
		
		
		
		
		
		

	}

}
