
//Explicit wait is Element specific means we can wait for that particular wait...
//additionally we need to specify the condition so till the condition is matched , we can wait for that time.    
//ExplicitWait is nothing but user defined wait class..you create for your own reason.
package methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		/*//------------------------------
		//Explicit Wait
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
			
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		//this is for one element..
	   mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='WebDriver']"))).click();
	   
	   //---------------------------------------------------------*/
	   
		//2.Generic Code...
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		By loc=By.xpath("//a[normalize-space()='WebDriver']");
		WebElement spelement=explicitWaitForElementspecific(driver,loc,10);
		spelement.click();
		 
		loc=By.xpath("//a[@id='m-documentationwebdrivercapabilities']");
		spelement=explicitWaitForElementspecific(driver,loc,10);
		spelement.click();
	     
	}

	public static WebElement explicitWaitForElementspecific(WebDriver driver,By loc,int timedur)
	{
		 WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(timedur));
		 
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		 
		return driver.findElement(loc); 

	}

}
