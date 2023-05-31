package action_mouse;
/*
 *  1.Actions()-->1.It is a predefined class which available in selenium webdriver
 * 	             2.Mouse related oprations performed by using Actions()class.
 * 
 * 2.Action()-->1.it is an interface.
 * 
 * Action class contains methods,
 * And with help of these methods,we are performing mouse related operations like right,double,drag and drop,mouse hover
 * Right Click action -->contextClick() method of action class.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseRightClickAction {

	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		 driver.manage().window().maximize();
		 
		 ///span[@class='context-menu-one btn btn-neutral']
		 Actions act=new Actions(driver);
		 
		 //act.contextClick().build().perform();
		 
		 //build().perform()-->build() method creates the action and perform() method execute that action.
         //but perform() method internally contains build().perform() statement.
		 //so no need to use it..instead of it use only perform().
		 
		
		 
		 WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		 //act.contextClick(button).perform();
		 //contextClick(button)->this method used for right click and button is parameter arg on which we perform the right click.
		
		 
		 Action action_interfaceref=act.contextClick(button).build();//Action is interface.
		        action_interfaceref.perform();
		 //->Build() method return the action which we are storing into Action interface.
		 //build() method used when we just want to store the action but we do not want to perform action.
		 //to perform it..perform() method
		
		 
		 
		 
		 
		 Thread.sleep(3000);
		 
		 driver.close();
		 
	}

}
