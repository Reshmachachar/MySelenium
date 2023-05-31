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
 *   2.if the hard assert getting failed then the rest of the coding statement will not be executed
 * 
 */





import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HardAssertionDemo_4_3 {
	
	@Test
    void test1()
    {
		System.out.println("Launch Browser");
		
		Assert.assertEquals(true ,false);
		
		System.out.println("Login");
		System.out.println("Logout");
    }
	@Test
	void test2()
	{
		System.out.println("test2");
		
	}

}
