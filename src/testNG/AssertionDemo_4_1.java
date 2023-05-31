package testNG;
/*Assertion:
 * 1.It is an expression which will verify actual test outcome(by the selenium script) with 
 * expected test outcome(by the FRS)
 * 2.Selenium WebDriver does not provide any facilities for validation part.
 * So getting proper validation we use external libraries like testNG to get confirmation about test, is it passed or failed?   
 */



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AssertionDemo_4_1 {
	
	@Test
	void  testGoogle() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.google.co.in/");
		 driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		 String expected_outcome="selenium - Google Searchhh";
		 String actual_outcome=driver.getTitle();
		 //Assert.assertEquals(actual_outcome, expected_outcome);
		 Assert.assertEquals(actual_outcome, expected_outcome, "Title is Mismatched");
		 //Thread.sleep(5000);
		 driver.close();
		 
	}

}
