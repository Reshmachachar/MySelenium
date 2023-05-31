package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionCommands {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
  
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		
		if(driver.findElement(By.name("firstname")).isDisplayed() && driver.findElement(By.name("firstname")).isEnabled())
			driver.findElement(By.name("firstname")).sendKeys("aniket");
		 if(driver.findElement(By.name("lastname")).isDisplayed() && driver.findElement(By.name("lastname")).isEnabled())
			driver.findElement(By.name("lastname")).sendKeys("shirke");
		 
		 
		 if(driver.findElement(By.xpath("//label[contains(text(),'Female')]/following-sibling::input")).isSelected())
			 driver.findElement(By.xpath("//label[contains(text(),'Female')]/following-sibling::input")).clear();
		 else
			 driver.findElement(By.xpath("//label[contains(text(),'Female')]/following-sibling::input")).click();
		 
		 // //label[contains(text(),'Male')]/following-sibling::input --xpath for male radio button
		 
		 
		 
			 
		 Thread.sleep(3000);
			
		driver.close();
		
	}

}
