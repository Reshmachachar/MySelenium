package firstSeleniumPrg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySelenium {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");

	}

}
