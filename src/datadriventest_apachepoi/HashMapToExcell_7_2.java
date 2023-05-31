package datadriventest_apachepoi;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcell_7_2 {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wrk=new XSSFWorkbook();
		XSSFSheet sht=wrk.createSheet("Student_info");
		
		Map<Integer,String> mapdata=new HashMap<Integer,String>();
		//Map is interface which is implemented by HashMap class
		//We can store data in the form of Key value pair.
		mapdata.put(101, "Aniket");
		mapdata.put(102, "Vishal");
		mapdata.put(103, "Pradeep");
		mapdata.put(104, "Prashant");
		mapdata.put(105, "Sagar");
		
		int rowcount=0;
		//start from entry and return value in set<Key,Value> format.
	   //mapdata.entrySet()-->it is type of Map.Entry
		for(Map.Entry kv:mapdata.entrySet())
		{
		     XSSFRow rows=sht.createRow(rowcount++);
		     rows.createCell(0).setCellValue((Integer)kv.getKey());
		     rows.createCell(1).setCellValue((String)kv.getValue());
	
		}
		
	  FileOutputStream out=new FileOutputStream(".//datafiles//hashmap_to_excel.xlsx");
	  wrk.write(out);
	  out.close();
	System.out.println("Excel written Successfully...");

	}

}
