package howToHandleWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessBrowser_Firefox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe");
		 
		FirefoxOptions option=new FirefoxOptions();
		option.setHeadless(true);
		
		
		
		 WebDriver driver=new FirefoxDriver(option);
		 driver.manage().window().maximize();
		 driver.get("http://demo.nopcommerce.com");
		 
		 System.out.println("Titel Of Page : "+driver.getTitle());
		 

	}

}
