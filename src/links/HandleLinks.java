package links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleLinks {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		
		 //Link and partial link
		 //driver.findElement(By.linkText("Today's Deals")).click();
		 //driver.findElement(By.partialLinkText("Deals")).click();
		 
		 //list of all links present on active window
		 List<WebElement> linklist=driver.findElements(By.tagName("a"));
		 System.out.println("Link Size : "+linklist.size());
		 
		 for(WebElement ele : linklist)
		 {
			 System.out.println("Link Text : "+ele.getText());
			 System.out.println("Link href : "+ele.getAttribute("href"));//return the value of attribute href
		 }

	}

}
