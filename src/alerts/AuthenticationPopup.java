package alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		 
		 WebDriver driver=new ChromeDriver();

		 //https://admin:admin@the-internet.herokuapp.com/basic_auth
		 //https://username:password@the-internet.herokuapp.com/basic_auth
		 
		 driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		// driver.get("https://www.redbus.in/");

	}

}
