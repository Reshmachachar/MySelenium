package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorDemo1 {

	public static void main(String[] args) {
		  System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe");
           
		  WebDriver driver=new FirefoxDriver();
		 driver.get("http://automationpractice.com/index.php");
		 
		 driver.manage().window().maximize();
		 
		 //id and name loc
		 driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
		 driver.findElement(By.name("submit_search")).click();
		 
		
         //linktext and partialinktext 
		 
		 driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();   
     
		// driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		 
		 //driver.findElement(By.partialLinkText("Printed Chiffon")).click();
		 //driver.findElement(By.partialLinkText("Chiffon Dress")).click();
		// driver.findElement(By.partialLinkText("Chiffon")).click();
		  
		 
		 
		 driver.close();
		 
		 
		 
		 
		 
	}

}
