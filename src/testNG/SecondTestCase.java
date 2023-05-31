package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SecondTestCase {

	@Test
	void  testGoogle() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.google.co.in/");
		 driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		 System.out.println("Titel OF Page : "+driver.getTitle());
		 Thread.sleep(5000);
		 driver.close();
		 
	}
	
	
	@Test
	void  testFacebook() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.facebook.com/login/");
		 driver.findElement(By.name("email")).sendKeys("ansh",Keys.ENTER);
		 System.out.println("Titel OF Page : "+driver.getTitle());
		
		 driver.close();
		 
	}
    	
}
