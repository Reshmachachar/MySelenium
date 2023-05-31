package link_in_new_tabAndwindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenDiff_Url_In2Windows {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("https://demo.nopcommerce.com/");
		 
		
		 
		 driver.switchTo().newWindow(WindowType.WINDOW);
		 driver.get("https://www.opencart.com/");
		 
		 

	}

}
