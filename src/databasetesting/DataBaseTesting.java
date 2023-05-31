package databasetesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * How to perform database testing
 *Selenium webdriver can not automate any database related stuff..it can not connect to database
 * and can not connect to any validation on database
 * Still there are some certain cases in the project which we need to validate on db on db_side.  
 * 
 * By using JDBC we fetch the data and validate the data..(field level and data level validation we performed)
 * 
 */

public class DataBaseTesting {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		String firstname="Devsena";
		String lastname="Reddy";
		String email="dr@gmail.com";
		String telephone="9955995599";
		String password="admin";
		String confirm_pasw="admin";
		
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 
		driver.get("https://localhost/opencart/upload/");
		driver.manage().window().maximize();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		//Reg_Form
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephone);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(confirm_pasw);
        
        
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 
		String new_acc=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		
		if(new_acc.equals("Your Account Has Been Created!"))
		{
			System.out.println("Account created successfully");
		}
		else
			System.out.println("Account not created successfully");
			
		 
		
		//database testing
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop?useSSL=false&allowPublicKeyRetrieval=true", "root", "");
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String query="select firstname,lastname,email,telephone from oc_customer";
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) 
		{
			String fstname=rs.getString("firstname");
			String lstname=rs.getString("lastname");
			String eml=rs.getString("email");
			String tphone=rs.getString("telephone");
			
			System.out.println(fstname+" "+lstname+" "+eml+" "+tphone);
			
			if(firstname.equals(fstname) && lastname.equals(lstname) 
					&& email.equals(eml) && telephone.equals(tphone))
				System.out.println("Record found in table || test Passed");
	
		}
		

	}

}
