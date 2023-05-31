package datadriventest_apachepoi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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


public class WriteExcelDemo_ArrayList_2_2 {

	public static void main(String[] args) throws IOException {
		
		String filePath=".//datafiles//IMP_PEOPLE.xlsx";
	
		XSSFWorkbook workbook=new XSSFWorkbook();//Create empty Workbook
		XSSFSheet sht=workbook.createSheet("IMP_PEOPLE_INFO");//create sheet with name
		
		ArrayList<Object[]> emp=DataToStoreIntoExcelFile();
		//writeDataByObjectArrayType(sht,emp);
		 writeDataByForEachType(sht,emp);
			
		FileOutputStream outputstream=new FileOutputStream(filePath);//give file path 
		workbook.write(outputstream);
		outputstream.close();

	}
	public static ArrayList<Object[]> DataToStoreIntoExcelFile()
	{
		ArrayList<Object[]> emp=new ArrayList<Object[]>(); //Object type data because heterogeneous type data  
		emp.add(new Object[]{"ID","Name","Job"});
		emp.add(new Object[]{101,"Aniket","Engineer"});
		emp.add(new Object[]{102,"Amruta","Architecture"});
		emp.add(new Object[]{103,"Shravani","Trainee"});
		emp.add(new Object[]{104,"Shubha","MakeupArtist"});
		emp.add(new Object[]{105,"ShirkeSir","Teacher"});
		emp.add(new Object[]{106,"Laxmi","HouseMaker"});
				
				return emp;
	}
	
	public static void writeDataByForEachType(XSSFSheet sht,ArrayList<Object[]> emp)
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
				                                          //it is Object type & we do not know which type it is so type cast explicitly
				if(emp_val instanceof Integer)
					cell.setCellValue((Integer)emp_val);
				if(emp_val instanceof Boolean)
					cell.setCellValue((Boolean)emp_val);
			}
		}
	}

}
