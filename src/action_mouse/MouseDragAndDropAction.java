package action_mouse;
/*
 * Action class contains methods,
 * And with help of these methods,we are performing mouse related operations like right,double,drag and drop,mouse hover
 * DragAndDrop action -->dragAndDrop(WebElement source, WebElement target) method of action class.
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class MouseDragAndDropAction {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
	
		 WebElement frm=driver.findElement(By.xpath("//iframe[@data-src='../../demoSite/practice/droppable/photo-manager.html']"));
		 driver.switchTo().frame(frm);
		 
		// WebElement source_ele=driver.findElement(By.xpath("//img[@alt='On top of Kozi kopka']"));
		 
		 List<WebElement> sourcelist=driver.findElements(By.xpath("//ul[@id='gallery']//li//img"));
		 WebElement dest_ele=driver.findElement(By.id("trash"));
		 
		Actions act=new Actions(driver);
		
		for(WebElement ele : sourcelist)
		{
			act.dragAndDrop(ele, dest_ele).perform();
			
		}
		
		
		 
		 
		 
		 Thread.sleep(3000);
		 
		// driver.close();
		 
	}

}

