package Extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class A_WebDriverSetupForTestClass_1_2 {

	public static WebDriver driver;	
	public static ExtentReports eReports;
	public static ExtentTest extentTest;
	String screenShotPath=null;
	
	/*1.creating extent report in html format
	  2.attach it
	  3.logging system info.
	*/
	@BeforeSuite
	public void intialiseExtentReport() {
	try {
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("AllTest.html");
		eReports=new ExtentReports();
		eReports.attachReporter(extentSparkReporter);
		
		eReports.setSystemInfo("os", System.getProperty("os.name"));
		eReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	 	
	}
	
	@AfterSuite
	public void generateExtentReport() throws IOException, Exception {
	
		//generation extent report
		eReports.flush();
	
		Desktop.getDesktop().browse(new URI("AllTest.html"));
		//Desktop.getDesktop().browse(new File(".//Extent_Reports//AllTest.html").toURI());
		
	}

	
	@Parameters("browserName")
	@BeforeTest
	public void setUpWebDriver(String browserName,ITestContext testContext)
	{
		System.out.println("browserName"+browserName);
		/*System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();*/
		
		switch(browserName.toLowerCase())
		{
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
			driver=new ChromeDriver();

			break;
		case "firefox" :
			System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe"); 
			driver=new FirefoxDriver();

			break;
		case "edge" :
			System.setProperty("webdriver.edge.driver", "G://Selenium_Driver//edgedriver_win64_latest//msedgedriver.exe"); 
			driver=new EdgeDriver();		
			break;	
		default:
			System.out.println("Invalid Browser Name");	
			break;
		}
		//logging browser and its version,author of test method information
		Capabilities capabilities= ((RemoteWebDriver)driver).getCapabilities();
		String browserDevice=capabilities.getBrowserName()+" "+capabilities.getBrowserVersion().substring(0, capabilities.getBrowserVersion().indexOf('.'));
		String author=testContext.getCurrentXmlTest().getParameter("TestWriter");
		
       extentTest=eReports.createTest(testContext.getName());
       extentTest.assignAuthor(author);
       extentTest.assignDevice(browserDevice);
       


	}
	
	@AfterTest
	public void tearDown()
	{
	    driver.quit();	
	}
	
	@Test
	public String captureScreenshot(String fileName) throws IOException
	{
		try {
			LocalDateTime myLocalDateTimeObj=LocalDateTime.now();
			DateTimeFormatter dateTimeFormatterObj=DateTimeFormatter.ofPattern("ddMMyyyHHmmss");
			String cuDateAndTime= myLocalDateTimeObj.format(dateTimeFormatterObj);

			 screenShotPath=".//Screenshot//"+fileName+cuDateAndTime+".png";

			TakesScreenshot tkS = (TakesScreenshot) driver;
			File srcFile=tkS.getScreenshotAs(OutputType.FILE); //screenshot unnamed file
			//File destFile=new File(".//Screenshot//"+"_"+cuDateAndTime+fileName);//assign name to unnamed screenshot with path...this is also file
			File destFile=new File(screenShotPath);
			FileUtils.copyFile(srcFile, destFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved Successfully..!!");
      
		
		return screenShotPath;
		
	}
	
	@AfterMethod //Method m-java.lang.reflact
	public void checkStatus(Method m,ITestResult result) throws IOException
	{
		if(result.getStatus()==result.FAILURE)
		{
			//String screenshotpath_r=null;
			String screenshotpath_r=captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
			extentTest.addScreenCaptureFromPath(screenshotpath_r);
			extentTest.fail(result.getThrowable());//internally created exception		
		}else if(result.getStatus()==result.SUCCESS) {
			
			System.out.println(m.getName()+"  is Passed");
		}
	
		//logging method annotation
		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}

	
	


}
