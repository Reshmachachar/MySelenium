package robotapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Robot Class is predefined class in java
 * 
 * why robot class?
 * 1.In certain  Selenium automation test,
 *   there is a need to control keyboard or mouse to interact with OS windows like,
 *   windows pop-ups,Alerts,Print Pop-ups etc.
 * 2.Selenium WebDriver can not handle these OS pop-ups
 * 
 *Benefits?
 * 1.Can simulate Keyboard and mouse event.
 * 2.Help in Upload and download file
 * 3.Can easily be integrated with current automation framework(Keyword,data-driven or hybrid)
 * 
 * keyPress is method in Robot class(KeyEvent-static class)
 */


public class RobotApiDemo {

	public static void main(String[] args) {
	 
		//Download this template for free
		 System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe"); 
		 WebDriver driver=new FirefoxDriver();
		 
		 driver.get("https://spreadsheetpage.com/calendar/yearly/");
		//a[normalize-space()='Download this template for free']
		 driver.findElement(By.xpath("//a[text()='Download this template for free']")).click();

		 //refer uploadfile class of file package...
		 
	}

}
