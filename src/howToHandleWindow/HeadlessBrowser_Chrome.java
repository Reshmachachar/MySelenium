package howToHandleWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser_Chrome {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		 
		ChromeOptions option=new ChromeOptions();
		//option.setHeadless(true);
		//or
		option.addArguments("--headless");
		
		 WebDriver driver=new ChromeDriver(option);
		 driver.manage().window().maximize();
		 driver.get("http://demo.nopcommerce.com");
		 
		 System.out.println("Titel Of Page : "+driver.getTitle());
		 

	}

}
