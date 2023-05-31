package action_mouse;
/*
 *
 *  1.Actions()-->1.It is a predefined class which available in selenium webdriver
 * 	             2.Mouse related oprations performed by using Actions()class.
 * 
 * 2.Action()-->1.it is an interface.
 * 
 * Action class contains methods,
 * And with help of these methods,we are performing mouse related operations like right,double,drag and drop,mouse hover
 * 
 * //build().perform()-->build() method creates the action and perform() method execute that action.
         //but perform() method internally contains build().perform() statement.
		 //so no need to use it..instead of it use only perform().
		  
  * //->Build() method return the action which we are storing into the Action interface.
		 //build() method used when we just want to store the action but we do not want to perform action.
		 //to perform it..perform() method	used
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsVsAction {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("http://automationpractice.com/index.php");
		 
		WebElement wm= driver.findElement(By.xpath("//a[@title='Women']"));
		
		WebElement wm_tshirt= driver.findElement(By.xpath("//ul[@style='display: none;']//a[@title='T-shirts']"));
		
		Actions act=new Actions(driver);
		
		//act.moveToElement(wm).moveToElement(wm_tshirt).click().perform();
		
		Action action_interfaceref=act.moveToElement(wm).moveToElement(wm_tshirt).click().build();//create and return the action..
		action_interfaceref.perform();//perform() complete or execute the action
		
		
		
		
		
		
		 
		 
		


	}

}
