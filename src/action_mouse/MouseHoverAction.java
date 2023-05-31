package action_mouse;
/*
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demo.opencart.com/");
		 
		 WebElement desk=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		 WebElement macop=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		 
		 Actions act=new Actions(driver);
		 
		 act.moveToElement(desk).moveToElement(macop).click().perform();
		 //perform()->must imp to execute action
		 
		 Thread.sleep(3000);
		 
		 driver.close();
		 
		 
		 
	}

}
