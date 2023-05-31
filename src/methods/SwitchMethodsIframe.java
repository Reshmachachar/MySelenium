package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchMethodsIframe {

	public static void main(String[] args) throws InterruptedException {
		
		//https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[contains(text(),'org.openqa.selenium.chrome')]/parent::li/preceding-sibling::li/child::a")).click();
		driver.switchTo().defaultContent();//return to main page
				
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
		driver.switchTo().defaultContent();
		
		//frame-3 (Help)
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Help']")).click();
		driver.switchTo().defaultContent();
		
		driver.close();
    
	}

}
