package action_mouse;
/*
 * Action class contains methods,
 * And with help of these methods,we are performing mouse related operations like right,double,drag and drop,mouse hover
 * Double Click action -->DoubleClick() method of action class.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClickAction {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		 
		 
	
		 //build().perform()-->build() fun creates the action and perform() fun execute that action.
         //but perform() fun internally contains build().perform() statement.
		 //so need to use it..instead of it use only perform().
		 
		 driver.switchTo().frame("iframeResult");
		 WebElement field1=driver.findElement(By.id("field1"));
		 field1.clear();
		 field1.sendKeys("Hello Aniket...How are you?");
		 WebElement d_button=driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
	     
		 Actions act=new Actions(driver);
		 act.doubleClick(d_button).perform();//internally perform() as build().perform().
		 
		 
		 
		 
		 Thread.sleep(3000);
		 
		 driver.close();
		 
	}

}
