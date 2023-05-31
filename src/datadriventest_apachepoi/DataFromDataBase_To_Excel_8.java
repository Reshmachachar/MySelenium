package datadriventest_apachepoi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.google.zxing.Result;

public class DataFromDataBase_To_Excel_8 {

	public static void main(String[] args) throws SQLException, IOException {
		
		
		XSSFWorkbook wrk=new XSSFWorkbook();
		XSSFSheet sht=wrk.createSheet("Database_data");
		
		
		HtmlUnitDriver driver=new HtmlUnitDriver();
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop","root","");
		Statement stm=conn.createStatement();
		String query="select customer_id,firstname,lastname,email,telephone,password,date_added from oc_customer";
		ResultSet set=stm.executeQuery(query);
		
		int rowcount=0;
		XSSFRow row=sht.createRow(rowcount++);
		 row.createCell(0).setCellValue("Customer_id");
		 row.createCell(1).setCellValue("firstname");
		 row.createCell(2).setCellValue("lastname");
		 row.createCell(3).setCellValue("email");
		 row.createCell(4).setCellValue("telephone");
		 row.createCell(5).setCellValue("password");
		 row.createCell(6).setCellValue("date_added");
		 
		while(set.next())
		{		
			String id=set.getString("customer_id");
			String firstname=set.getString("firstname");
			String lastname=set.getString("lastname");
			String email=set.getString("email");
			String telephone=set.getString("telephone");
			String  password=set.getString("password");
			String  date_added=set.getString("date_added");
			
			//Excel sheet row
			  row=sht.createRow(rowcount++);
			 row.createCell(0).setCellValue(id);
			 row.createCell(1).setCellValue(firstname);
			 row.createCell(2).setCellValue(lastname);
			 row.createCell(3).setCellValue(email);
			 row.createCell(4).setCellValue(telephone);
			 row.createCell(5).setCellValue(password);
			 row.createCell(6).setCellValue(date_added);
			
		}
		
		conn.close();
		FileOutputStream fout=new FileOutputStream(".//datafiles//database_to_excel.xlsx");
		wrk.write(fout);
		fout.close();
		
	}

}
