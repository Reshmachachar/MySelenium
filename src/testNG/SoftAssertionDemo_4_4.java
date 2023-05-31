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
 * **Soft Assertion**
 *   1.Soft validation : if test assertion is getting failed, remaining part of test case will be executed and
 *                        and test case will not be marked as failed.
 *   2.To resolve this problem,assertAll() method used at the end of all soft assertion then,
 *     if any soft assertion getting failed,the rest part of test case will be executed 
 *     but test case will be marked as failed. 
 *   3.if there are multiple test cases and they are using common(one) softAssert object then
 *     if particular test case failed then even following tase cases do not any problem,
 *     they marked as failed.
 */





import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SoftAssertionDemo_4_4 {
	
	SoftAssert softAssert=new SoftAssert();
	@Test
    void test1()
    {
		softAssert.assertEquals(true ,true);	
		System.out.println("test1");	
		softAssert.assertAll();
    }
	@Test
	void test2()
	{
		softAssert.assertEquals(true, false);
		System.out.println("test2");
		softAssert.assertAll();
		
	}
	@Test
	void test3()
	{
		softAssert.assertEquals(true, true);
		System.out.println("test3");
		softAssert.assertAll();
		
	}
	
	@Test
	void test4()
	{
		softAssert.assertEquals(true, true);
		System.out.println("test4");
		softAssert.assertAll();
		
	}

}
