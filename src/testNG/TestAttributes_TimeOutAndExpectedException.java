package testNG;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*1.What is timeout
 *  -->1.If you want to complete any certain method in particular time
 *       then you can set timeout attribute of @Test annotation.
 *     2.If that test method will not execute within that timeout then
 *        it marked as Failed.      
 *     3.From this we can get performance information of test method
 *        1.How much time required to execute that test method?     
 */

import org.testng.annotations.Test;

public class TestAttributes_TimeOutAndExpectedException {
	
	WebDriver driver;

/*	
	//TimeOut
  @Test(timeOut=6000) //if test method will not complete within time out
                      //then driver will not closed.
  public void testMethod() {
	  System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.close();
  } */
	
	/*if you expecting exception  but the given test method will not thrown  
	   given exception then test method will be failed....*/
	@Test(expectedExceptions = {org.openqa.selenium.NoSuchElementException.class} )//array of Class(Class[])
	public void testMethod() {
		  System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.findElement(By.id("abcd")).click();
			driver.close();
	  }	
	
}
