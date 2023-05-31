package action_keyboard;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyoardActions {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("https://the-internet.herokuapp.com/key_presses");
		 
		 Actions act=new Actions(driver);
		 
		 act.sendKeys(Keys.ENTER).perform();//Keys predefined static class in selenium webdriver 
		 Thread.sleep(3000);
		 
		 act.sendKeys(Keys.ESCAPE).perform();
		 Thread.sleep(3000);
		 
		 act.sendKeys(Keys.BACK_SPACE).perform();
		 Thread.sleep(3000);
		 
		 act.sendKeys(Keys.SPACE).perform();
		 
		 


	}

}
