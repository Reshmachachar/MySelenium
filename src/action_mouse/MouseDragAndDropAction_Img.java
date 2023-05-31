package action_mouse;
/*
 * Action class contains methods,
 * And with help of these methods,we are performing mouse related operations like right,double,drag and drop,mouse hover
 * DragAndDrop action -->dragAndDrop(WebElement source, WebElement target) method of action class.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDropAction_Img {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		 WebElement source_ele= driver.findElement(By.id("box3"));//washington
		WebElement destination_ele= driver.findElement(By.id("box103"));//usa
		
		
		Actions act=new Actions(driver);
		act.dragAndDrop(source_ele, destination_ele).perform();
		
		
		 
		 
		 
		 Thread.sleep(3000);
		 
		 driver.close();
		 
	}

}
