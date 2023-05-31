package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethods {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/login/");
		
		Thread.sleep(2000);
		
		//navigate().to() //at the first time and if page is not in buffor stack then we call this method
		driver.navigate().to("https://www.facebook.com/r.php?locale=en_GB&display=page");
		
		driver.navigate().back(); //loginpage (Still in buffor)
		
		driver.navigate().forward(); //signUp page--forword() used becoz signup page remain in buffor. 
		
		driver.navigate().refresh();//refresh the page
		
		driver.close(); //close the active window and all other opened window
           
		
		
	}

}
