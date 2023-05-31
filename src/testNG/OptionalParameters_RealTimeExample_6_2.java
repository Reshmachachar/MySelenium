package testNG;
/*
 * 1.Optional Parameter is like default value
 * 2.if you forget to pass value to method then optional parameter value consider 
 *   as default value so test script do not generate any error.
 * 3.if you do not want to pass value or forget to pass value and 
 *   still your test script should be run properly then use OPtional Parameter.     
 *  
 */

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OptionalParameters_RealTimeExample_6_2 {

	
	WebDriver driver;

	@Parameters("browserName") 
	@BeforeTest
	public void InitializeBrowser(@Optional("firefox") String browserName)
	{
		switch(browserName.toLowerCase())
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		    break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe"); 
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		    break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "G://Selenium_Driver//edgedriver_win64_latest//msedgedriver.exe"); 
			driver=new EdgeDriver();
			driver.manage().window().maximize();
		    break;    
		default:
			System.err.println("Invalid Browser Name : ");
	
		}
		
	}
	@Parameters("threadSleepMiliseconds")
	@AfterTest
	public void CloseBrowser(long duration) throws InterruptedException
	{
		Thread.sleep(duration);
		driver.close();
	}
  
	@Parameters({"url","threadSleepMiliseconds"})
	@Test
	public void LaunchApp(String url,long duration) throws Exception
	{
		driver.get(url);
		Thread.sleep(duration);
	}

	@Parameters({"userName","password","threadSleepMiliseconds"})
	@Test
	public void Login(String userName,String password,long duration) throws Exception
	{
        driver.findElement(By.id("txtUsername")).sendKeys(userName);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(duration);
     
	}
	   
	@Test
	public void verifyMyLogin()
	{
        driver.findElement(By.id("welcome")).isDisplayed();
        System.out.println("Login Verification is Done!!");
    
	}
	@Test
	public void nevigateToMyInfo()
	{
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}
	@Test
	public void verifyMyInfo()
	{
        driver.findElement(By.id("employee-details")).isDisplayed();
        System.out.println("My Info Verification is  Done!!");
       
      
	}

}
