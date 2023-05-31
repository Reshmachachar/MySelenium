package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/*Default Report=>
 * what is Report?
 * ==>.Report is just like file in which we stored the last execution details and 
 *     this file is stored on your os/machine.
 * 1.Java console shows the report regarding test cases..passes,failed,skipped.etc
 *   but do not show execution time(required).So it is not providing clear report.  
 * 2.TestNG shows the all the information about test case.
 * 
 * 3.But then why we need of Report?
 * Answer> 1.TestNG console just showing report but not saving this execution information,
 *           for further use.
 *         2.if you need last execution details report after 2-3 days,that time you do not have it.
 *           because of data loss,machine shut down,or due to any issue.
 *         3.thats why we need of generating report.    
 *         4.Report is just like file in which we stored the last execution details and 
 *           this file is stored on your os/machine.
 *                      
 * 4.TestNG by default generate the report which is stored into the project test-output folder.
 * 5.If execute the testNG class by TestNG test, 
 *   then TestNG by default create the testng-customsuite.xml file. 
 *   
 * 6.emailable report is the high level report. 
 * 7.we do not use this reports,we use alternative options like Extent report. 
 */

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DefaultReport {
	
	 WebDriver driver;
	
	@Test(testName="GoogleSearch")
	void  testGoogleSearch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		//System.out.println("Titel OF Page : "+driver.getTitle());

		String expectedTitle= "selenium - Google Search";
		String actualTitle=driver.getTitle();		 
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();

	}


	@Test(testName="FacebookLogin")
	void  testFacebookLogin() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
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
		driver.close();

	}

	@Test(testName="OrangeHRMLogin")
	public void testOrangeHRMLogin()
	{
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1235");
		driver.findElement(By.id("btnLogin")).click(); 
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());

		driver.close();
	}
}
