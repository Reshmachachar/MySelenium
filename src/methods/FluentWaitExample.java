//also Similar With Explicit with more flexibility in polling time and ignoring exceptions
//polling time means in total wait timeout(20) ,after how much time(after every 5sec(polling time)) page verified..  
// 4 times in 20sec your page is hit and checked..
//ignoring exception means inbuilt managed 
package methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitExample {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	   
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		By loc=By.xpath("//a[normalize-space()='WebDriver']");
		fluentWaitForElement(driver,loc,30,5).click();
		
		loc=By.xpath("//a[@id='m-documentationwebdrivercapabilities']");
		fluentWaitForElement(driver,loc,30,5).click();
		 
	}
	
	public static WebElement fluentWaitForElement(WebDriver driver,By loc, int timedur,int pollingtime)
	{
		//declaration
		Wait<WebDriver> mywait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(NoSuchElementException.class);
		
		//use of fluentwait
		WebElement ele= mywait.until( new Function<WebDriver,WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(loc);
			}
		
		});
		
				
    	return ele;				
		
	}
	

}
