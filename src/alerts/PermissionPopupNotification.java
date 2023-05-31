package alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PermissionPopupNotification {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		 
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");//this is disable all the permission popup notifications
		
		WebDriver driver=new ChromeDriver(option);//parameter constructor called--by passing option obj.
		 
		 driver.get("https://www.hdfcbank.com/");
		 

	}

}
