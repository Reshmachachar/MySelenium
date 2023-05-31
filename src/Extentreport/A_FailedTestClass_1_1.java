package Extentreport;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class A_FailedTestClass_1_1 extends A_WebDriverSetupForTestClass_1_2  {
	
	@Test(testName="GoogleSearch", groups = {"smoke"})
	void  testGoogleSearch() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		extentTest.info("Navigate to Url");
		driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		extentTest.info("Enter text into search box");
		//System.out.println("Titel OF Page : "+driver.getTitle());

		String expectedTitle= "selenium - Google Search";
		String actualTitle=driver.getTitle();		 
		Assert.assertEquals(actualTitle, expectedTitle);
		//extentTest.pass("Assetion is passed for webpage title");
		
	}


	@Test(testName="FacebookLogin",groups = {"smoke","regression"})
	public void  testFacebookLogin() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		extentTest.info("Navigate to Url");
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
		
		/*Text assertion
		String expectedText= "";
		String actualText=driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
		sft.assertEquals(actualText, expectedText,"Text is Mismatched");*/

		sft.assertAll();

	}

	@Test(testName="OrangeHRMLogin",groups = {"sanity"})
	public void testOrangeHRMLogin()
	{
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		extentTest.info("Navigate to Url");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1235");
		driver.findElement(By.id("btnLogin")).click(); 
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());

	}
	
	

}
