package testNG;

/* 1.A Test method is run for all data set provided by a DataProvider method 
 *    which is by default one after another. 
 * 2.Note here that test method is run on data in same sequence in which DataProvider pass it. 
 * 3.The reason behind this is that a DataProvider annotated method 
 *    has an attribute named “parallel” whose default value is set to “false”.
 * 4.We can run it parallel as well by setting attribute “parallel” value as true. 
     It will save a lot of time.
 * 5.Parallel data providers running from an XML file share 
     the same pool of threads,which has a size of 10 by default. 
 * 6.You can modify this value in the tag of your XML file: 
     <suite name="Suite1" data-provider-thread-count="20" > 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelDataProviderExecution_12 {
	 
		@Test(dataProvider="loginData") 
		public void testLogin(String userName,String password) throws Exception
		{
			
			System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			Thread.sleep(3000);
	        driver.findElement(By.id("txtUsername")).sendKeys(userName);
	        driver.findElement(By.id("txtPassword")).sendKeys(password);
	        driver.findElement(By.id("btnLogin")).click();
	        Thread.sleep(3000);
	        Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
	       
	        driver.close();
	       
		}
		
		
		@DataProvider(parallel=true)                           
		@Test                  
		public Object[][] loginData()
		{
		 Object[][] data= new Object[4][2];
		 
          data[0][0]= "Admin";
          data[0][1]= "admin123";
          
          data[1][0]= "Admin";
          data[1][1]= "admin123";
          
          data[2][0]= "Admin22";
          data[2][1]= "admin1233";
          
          data[3][0]= "Admin";
          data[3][1]= "admin1233";
          
       
	       return data;	                             
  }
}
