package datadriventest_apachepoi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*Write Excel Sheet
 * 1.create new Workbook
 * 2.Create sheet of that Workbook
 * 3.Create data by using any collection type like object ArraylList,ArrayList,ForEach
 * 4.Store it into row and column by using XSSFRow and XSSFCell
 * 5.add Workbook to FileOuputStream(FilePath)-->Give name to created new file with location path 
 */


public class WriteExcelDemo_ObjectArrayAndForEach_2_1 {

	public static void main(String[] args) throws IOException {
		
		String filePath=".//datafiles//IMP_PEOPLE.xlsx";
	
		XSSFWorkbook workbook=new XSSFWorkbook();//Create empty Workbook
		XSSFSheet sht=workbook.createSheet("IMP_PEOPLE_INFO");//create sheet with name
		
		Object emp[][]=DataToStoreIntoExcelFile();
		//writeDataByObjectArrayType(sht,emp);
		 writeDataByForEachType(sht,emp);
			
		FileOutputStream outputstream=new FileOutputStream(filePath);//give file path 
		workbook.write(outputstream);
		outputstream.close();

	}
	public static Object[][] DataToStoreIntoExcelFile()
	{
		//create data which we want to store in excel sheet
				//Object type help us to create heterogeneous data 
				Object emp[][]= { {"ID","Name","Job"},
				                  {101,"Aniket","Engineer"},
				                  {102,"Amruta","Architecture"},
				                  {103,"Shravani","Trainee"},
				                  {104,"Shubha","MakeupArtist"},
				                  {105,"ShirkeSir","Teacher"},
				                  {106,"Laxmi","HouseMaker"},
				                };
				return emp;
	}
	
	public static void writeDataByForEachType(XSSFSheet sht,Object emp[][])
	{
		int row_index=0;
		for(Object ep[]:emp) // we need rows so we get single dimension array..outer array
		{
			XSSFRow row=sht.createRow(row_index++);  //creating one row
			int col_index=0;
			for(Object emp_val:ep) //we read values of row..
			{
				XSSFCell cell=row.createCell(col_index++); ////creating one cell
				if(emp_val instanceof String)
					cell.setCellValue((String)(emp_val)); //type cast-->due to heterogeneous data 
				                                          //we do not know which type it is so type cast explicitly
				if(emp_val instanceof Integer)
					cell.setCellValue((Integer)emp_val);
				if(emp_val instanceof Boolean)
					cell.setCellValue((Boolean)emp_val);
			}
		}
	}
	public static void writeDataByObjectArrayType(XSSFSheet sht,Object emp[][])
	{
		//Get Rows and Columns size of data for for loop
				int rows=emp.length;
				int cols=emp[0].length;
				System.out.println("Rows"+rows);
				System.out.println("Cols"+cols);
				
				for(int r=0;r<rows;r++) 
				{
					XSSFRow row=sht.createRow(r); //creating 1 row
				   for(int c=0;c<cols;c++)
				   {
					   XSSFCell cell=row.createCell(c);//creating one cell
					   if(emp[r][c] instanceof String)
						   cell.setCellValue((String)emp[r][c]); //to set value to cell convert it into proper type(Type casting)
					   if(emp[r][c] instanceof Integer)           //from Object to Particular Type  
						   cell.setCellValue((Integer)emp[r][c]);
					   if(emp[r][c] instanceof Boolean)
						   cell.setCellValue((Boolean)emp[r][c]);
				   }
				}

	}

}
