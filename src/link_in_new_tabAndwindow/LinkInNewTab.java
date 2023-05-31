package link_in_new_tabAndwindow;
/*
 * tooltip is attached to any element. when you hover the element with your mouse,
 *  the little attribute is displayed in a little box next to the element.just like native tooltip.
 * 
 * when we move the cursor on the webelement then that time we can see the massage window.
 * this window which shows that the purpose of that element.
 * state that what are you doing and what we want from you and what is effect of that action. 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkInNewTab {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("https://demo.nopcommerce.com/");
		 
		 WebElement reg_ele=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		 
		String tab=Keys.chord(Keys.CONTROL,Keys.ENTER);//return action in string format
		
		Thread.sleep(3000);
		reg_ele.sendKeys(tab);
		 
		 
		 
		 
		 
		
		

	}

}
