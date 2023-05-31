package log4J;





import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*What is Log4J
 * 1.Whatever application you are using like web application or windows application,
 *   all the transaction or operations with that application are logged in one file.
 *   To log this information we use log4J.
 *   1.1 To maintain record of transaction we use log4J.
 *   1.2 By the Log4J,we get information regarding every transaction of automation
 *       script;what are the happening inside,how many test cases are failed,passed..etc
 *   
 * 2.1.Log4j is a logging framework written in Java that provides an easy way for logging 
 *     in Selenium. In a nutshell, the framework gives out information about everything 
 *     that goes on during the software execution. 
 *   2.Log4j also provides insight into anything that may have gone wrong 
 *     during software execution or automation
 *      
 * 3.Apache Log4j is a Java-based logging utility originally written by Ceki Gülcü.
 *   It is part of the Apache Logging Services, a project of the Apache Software Foundation. 
 *   Log4j is one of several Java logging frameworks   
 *   
 * 4.1.Log4J.jar
 *   2.Log4J.properties or Log4J.xml    
 * 
 */

public class Log4JDemo {

	public static void main(String[] args)
	{
      	
      //org.apache.log4j.Logger logger2=org.apache.log4j.Logger.getLogger("Log4JDemo");
      
      Logger logger2=Logger.getLogger("Log4JDemo");
      
      PropertyConfigurator.configure(".//PropertyFile//log4j.properties");
      
      System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		
		
		logger2.info("Browser Opened");
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		
				
		
		     logger2.info("Clicking on Register link");
			driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
			
			logger2.info("Entering First name");
			driver.findElement(By.name("firstName")).sendKeys("Ani");
		
			logger2.info("Entering Last name");
			driver.findElement(By.name("lastName")).sendKeys("Shirke");
		
			logger2.info("Entering Phone number");
			driver.findElement(By.name("phone")).sendKeys("3333");
			
			logger2.info("Entering Email ");
			driver.findElement(By.name("userName")).sendKeys("ans@gmil.com");
		
			logger2.info("Entering Address");
			driver.findElement(By.name("address1")).sendKeys("Mg road");
		
			logger2.info("Entering City");
			driver.findElement(By.name("city")).sendKeys("Pune");
		
			logger2.info("Entering State");
			driver.findElement(By.name("state")).sendKeys("Maharastra");
		
			logger2.info("Entering Postal Code");
			driver.findElement(By.name("postalCode")).sendKeys("414444");
		
			logger2.info("Entering Country");
			driver.findElement(By.name("country")).sendKeys("India");
		
			logger2.info("Entering User name");		
			driver.findElement(By.name("email")).sendKeys("ans@gmil.com");
		
			logger2.info("Entering Password");
			driver.findElement(By.name("password")).sendKeys("332211");
		
			logger2.info("Entering Confirm Password");
			driver.findElement(By.name("confirmPassword")).sendKeys("332211");
		
			logger2.info("Clicking on Submit Button");
			driver.findElement(By.name("submit")).click();
			
			 //validation
			
			 if(driver.getPageSource().contains("Thank you for registering."))
			 {
				 System.out.println("You are succefully registerd");
				 logger2.info("You are succefully registerd");
			 }
			 else
			 {
				 System.out.println("You are not succefully registerd");
				 logger2.info("You are not succefully registerd");
			 }
		
			logger2.info("Browser Closed");
			driver.close();
			
	}
}
