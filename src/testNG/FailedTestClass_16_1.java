package testNG;

/*1.Test case failed then to take screenshot of it,we use two methods
 *   1.By using Listener              -   for this we use ITestListener interface
 *   2.By using dependency injection
 *   
 *1.2 what is exactly dependency injection?
 *     =>1.We do not send/pass any values,TestNG directly inject the value at the runtime.
 *       2.value means Internally created ITestResult result object passed by TestNG at the runtime
 *       3.We can use it directly in our test method.
 *       4.for this,you should add @After annotation for failed test method.
 *       
 * 1.Whenever your test case failed,
 *    your test name should be your screenshot's name .@Test(name="test name")
 *     
 *2.when the testNG triggering execution , internally creating the ITestResult object.
 *   1.ItestResult object proved the name of test or test method name
 *   
 *3.We can get test name or test method name by using ITestResult object
 *
 *4.How to avoid screenshot overriding?
 *   ->By using date and time format we can achieve this.   
   
 * */


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FailedTestClass_16_1 extends WebDriverSetupForTestClass_16_2 {
	
	@Test(testName="GoogleSearch")
	void  testGoogleSearch() throws InterruptedException
	{
		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		//System.out.println("Titel OF Page : "+driver.getTitle());

		String expectedTitle= "selenium - Google Search";
		String actualTitle=driver.getTitle();		 
		Assert.assertEquals(actualTitle, expectedTitle);

	}


	@Test(testName="FacebookLogin")
	void  testFacebookLogin() throws InterruptedException
	{
		
		driver.get("https://www.facebook.com/login/");
		driver.findElement(By.name("email")).sendKeys("ansh",Keys.ENTER);
		//System.out.println("Titel OF Page : "+driver.getTitle());

		SoftAssert sft=new SoftAssert();

		//Titel Assertion
		String expectedTitle= "Log in to Facebook";
		String actualTitle=driver.getTitle();
		sft.assertEquals(actualTitle, expectedTitle,"Title Is Mismatched");

		//Url assertion
		String expectedUrl= "https://www.facebook.com/login/";
		String actualUrl=driver.getCurrentUrl();
		sft.assertEquals(actualUrl, expectedUrl, "Url Is Mismatched");
		
		//Text assertion
		String expectedText= "";
		String actualText=driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
		sft.assertEquals(actualText, expectedText,"Text is Mismatched");

		sft.assertAll();

	}

	@Test(testName="OrangeHRMLogin")
	public void testOrangeHRMLogin()
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1235");
		driver.findElement(By.id("btnLogin")).click(); 
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());

	}

}
