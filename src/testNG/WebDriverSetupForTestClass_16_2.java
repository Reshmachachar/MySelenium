package testNG;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriverSetupForTestClass_16_2 {

	public static WebDriver driver;
	
	@BeforeTest
	public void setUpWebDriver()
	{
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void dependencyInjection_captureScreenshot(ITestResult result) throws IOException
	{
		if(result.getStatus()==result.FAILURE)
		{
			captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
		}
	    
	}
	
	@AfterTest
	public void tearDown()
	{
	    driver.quit();	
	}

	@Test
	public void captureScreenshot(String fileName) throws IOException
	{
		try {
			LocalDateTime myLocalDateTimeObj=LocalDateTime.now();
			 DateTimeFormatter dateTimeFormatterObj=DateTimeFormatter.ofPattern("ddMMyyyHHmmss");
			 String cuDateAndTime= myLocalDateTimeObj.format(dateTimeFormatterObj);
			
			 fileName=fileName+cuDateAndTime+".png";
			 
			TakesScreenshot tkS = (TakesScreenshot) driver;
			File srcFile=tkS.getScreenshotAs(OutputType.FILE); //screenshot unnamed file
			//File destFile=new File(".//Screenshot//"+"_"+cuDateAndTime+fileName);//assign name to unnamed screenshot with path...this is also file
			File destFile=new File(".//Screenshot//"+fileName);
			FileUtils.copyFile(srcFile, destFile);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved Successfully..!!");
				    
	}

}
