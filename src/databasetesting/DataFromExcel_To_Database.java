package databasetesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class DataFromExcel_To_Database {

	public static void main(String[] args) throws SQLException, IOException {
	
		HtmlUnitDriver driver=new HtmlUnitDriver();
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop","root","");
		Statement stm=conn.createStatement();
		
		
		//Excel sheet into fileinputstream
		FileInputStream fis=new FileInputStream(".//datafiles//excel_to_database.xlsx");
		XSSFWorkbook wrk=new XSSFWorkbook(fis);
		XSSFSheet sht=wrk.getSheetAt(0);
		
		int rows=sht.getLastRowNum();
		int cols=sht.getRow(1).getLastCellNum();
		
		//insert into oc_customer(customer_id,firstname,lastname,email,telephone,password,date_added) values(6,'xx','yy','xxyy@gmail.com','9933000033','xyy65xx','2022-04-24 20:03:30');
		String query="";
		for(int r=1;r<=rows;r++)
		{
			XSSFRow row=sht.getRow(r);
			
				Double id=row.getCell(0).getNumericCellValue();
				String customer_id=String.valueOf(id);
				
				String firstname=row.getCell(1).getStringCellValue();
				String lastname=row.getCell(2).getStringCellValue();
				String email=row.getCell(3).getStringCellValue();
				
				String telephone=String.valueOf(row.getCell(4).getNumericCellValue());
				
				String  password=row.getCell(5).getStringCellValue();
				String  date_added=row.getCell(6).getStringCellValue();
				
				
				String customer_group_id="0";
				String language_id="1";
				String fax="aaa";
				String safe="0";
				String status="1";
				String address_id="0";
				String newsletter="0";
				
				//
				//
				
				query="insert into oc_customer(customer_id,code,token,safe,status,ip,custom_field,address_id,newsletter,wishlist,cart,salt,fax,language_id,customer_group_id,firstname,lastname,email,telephone,password,date_added) "
						+ "values('"+customer_id+"','"+null+"','"+null+"','"+safe+"','"+status+"','"+null+"','"+null+"','"+address_id+"','"+newsletter+"','"+null+"','"+null+"','"+null+"','"+fax+"','"+language_id+"','"+customer_group_id+"','"+firstname+"','"+lastname+"','"+email+"','"+telephone+"','"+password+"','"+date_added+"')";
				stm.execute(query);
			
		}
		
		
		conn.close();
		fis.close();
		System.out.println("Done!");
		
		

	}

}
