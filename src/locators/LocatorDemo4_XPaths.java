package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorDemo4_XPaths {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe");
      
		WebDriver driver=new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		
		//Absolute Xpath
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/input[4]")).sendKeys("T-shirt");
		
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
		
		//RElative Xpath
		//driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirt");
		//driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		
		// or (atleast one must be true)
	    //driver.findElement(By.xpath("//input[@id='search_query_top' or @name='search_query']")).sendKeys("T-shirt");
	    //driver.findElement(By.xpath("//button[@class='btn btn-default button-search' or @name='submit_search']")).click();
	    
	    //and (both condition must be true)
	   // driver.findElement(By.xpath("//input[@id='search_query_top' and @name='search_query']")).sendKeys("T-shirt");
	   // driver.findElement(By.xpath("//button[@class='btn btn-default button-search' and @name='submit_search']")).click();
	    
		
		//contains  (value of attribute should contain some part of actual value--dynamic approach)
		// driver.findElement(By.xpath("//input[contains(@id,'search')]")).sendKeys("T-shirt");
		 //driver.findElement(By.xpath("//button[contains(@name,'submit')]")).click();
		
		//starts-with(in toggle approach...dynamic scenario and value of attribute always satrt with actual value starting word)
	   //	driver.findElement(By.xpath("//input[starts-with(@id,'se')]")).sendKeys("T-shirt");
	   //	driver.findElement(By.xpath("//button[starts-with(@name,'sub')]")).click();
		
		//text(danymic scenario)
		driver.findElement(By.xpath("//a[text()='Women']")).click();
		
		//chained xpath(xpath followed by xpath)
		//  //form[@id='searchbox']//input[4]
		//  //form[@id='searchbox']//input[@id='search_query_top']
		
		//  //form[@id='searchbox']//button
		//  //form[@id='searchbox']//button[@name='submit_search']
		
		//driver.findElement(By.xpath("//form[@id='searchbox']//input[4]")).sendKeys("T-shirt");
		//driver.findElement(By.xpath("//form[@id='searchbox']//button")).click();
		
		driver.findElement(By.xpath("//form[@id='searchbox']//input[@id='search_query_top']")).sendKeys("T-shirt");
		driver.findElement(By.xpath("//form[@id='searchbox']//button[@name='submit_search']")).click();
		
		
	}

}
