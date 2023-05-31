package testNG;
/*Assertion:
 * 1.It is an expression which will verify actual test outcome(by the selenium script) with 
 * expected test outcome(by the FRS)
 * 2.Selenium WebDriver does not provide any facilities for validation part.
 * So getting proper validation we use external libraries like testNG to get confirmation about test, is it passed or failed?
 * 
 ***In Selenium, Asserts are validations or checkpoints for an application. 
 *Assertions state confidently that application behavior is working as expected.
 * One can say that Asserts in Selenium are used to validate the test cases. 
 * They help testers understand if tests have passed or failed.    
 * 
 * **Hard Assertion**
 *   1.hard validation : if test assertion is getting failed, immediately test case will be marked as failed
 *                        and test case will be terminated.
 *   2.if the hard assert getting failed then the rest of the test case statement will not be executed
 *   3.due to assertion,if testcase1 failed then there is no impact of testcase1 execution on testcase2 till testcase2 assertion is passed 
 * 
 */



import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HardAssertionDemo_4_2 {
	
	@Test
	void  testLogin() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("http://automationpractice.com/");		 
		 
		 WebElement SignIn=driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		 assertTrue(SignIn.isDisplayed());
		 SignIn.click();
		 
		 WebElement username=driver.findElement(By.id("email"));
		 assertTrue(username.isDisplayed());
		 
		 WebElement password=driver.findElement(By.id("passwd"));
		 assertTrue(password.isDisplayed());
		  
		 WebElement loginButton=driver.findElement(By.id("SubmitLogin"));
		 assertTrue(loginButton.isDisplayed());
		 
		 username.sendKeys("asss@gmail.com");
		 password.sendKeys("saniket");
		 loginButton.click();
		
		 driver.close();
		 
	}

}
