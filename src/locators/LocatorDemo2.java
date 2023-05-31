package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorDemo2 {

	public static void main(String[] args) {
   
		System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php");
		//classname(used for multiple elements which having common attribute is class(homeslidercontainer))
 
		int c=driver.findElements(By.className("homeslider-container")).size();
		
		System.out.println("No Of Images : "+c);
		
		//TagName(No Attributes Are Common But we want count total  link ,list,images... of active window)
		
	  int links=driver.findElements(By.tagName("a")).size();
	  
	  System.out.println("Total Links Of Active Window : "+links);
	  
		
	}

}
