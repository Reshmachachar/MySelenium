package tooltip;
/*
 * tooltip is attached to any element. when you hover the element with your mouse,
 *  the little attribute is displayed in a little box next to the element.just like native tooltip.
 * 
 * when we move the cursor on the webelement then that time we can see the massage window.
 * this window which shows that the purpose of that element.
 * state that what are you doing and what we want from you and what is effect of that action. 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTip {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("https://jqueryui.com/tooltip/");
		 
		 driver.switchTo().frame(0);
		 
		 String toolti_text=driver.findElement(By.id("age")).getAttribute("title");
		
		 System.out.println("ToolTipText : "+toolti_text);
		

	}

}
