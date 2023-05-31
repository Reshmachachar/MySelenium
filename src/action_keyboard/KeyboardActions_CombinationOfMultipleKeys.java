package action_keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions_CombinationOfMultipleKeys {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("https://text-compare.com/");
		 
		 WebElement textarea2=driver.findElement(By.name("text2"));
		 textarea2.clear();
		 
		 WebElement textarea1=driver.findElement(By.name("text1"));
		 textarea1.clear();
		 textarea1.sendKeys("Welcome Aniket..");

		 //action sequence and focus on element is most imp so its copied to above becoz
		 //those statement shift the focus on textarea2 
		 //WebElement textarea2=driver.findElement(By.name("text2"));
		 // textarea2.clear();

		 
		 
		 Actions act=new Actions(driver);
		 
		 //CTRL + A(Select text of first text area)
		 act.keyDown(Keys.CONTROL);
		 act.sendKeys("a");
		 act.keyUp(Keys.CONTROL);
		 act.perform();
		 
		 //CTRL+C (Copy text of first text area)
		 act.keyDown(Keys.CONTROL);
		 act.sendKeys("c");
		 act.keyUp(Keys.CONTROL);
		 act.perform();
		 
		 //TAB key--> move to 2nd textarea
		 
		 act.sendKeys(Keys.TAB).perform();
		 
		//CTRL+V (Paste the text of 1st textarea to 2nd textarea.)
		 
		 act.keyDown(Keys.CONTROL);
		 act.sendKeys("v");
		 act.keyUp(Keys.CONTROL);
		 act.perform();
		 
		 
		 if(textarea1.getAttribute("value").equals(textarea2.getAttribute("value")))
			 System.out.println("Successfully Copied...");
		 else
			 System.out.println("Successfully not Copied...");
		 
		 
		 
		 
		 
		 

	}

}
