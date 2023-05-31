package testNG;
/*
 * 1.Parameters are info or values send to methods for program execution.
 * 2.To pass multiple data to the application at runtime.
 * 3.With help of parameterization,we can validate our application with the different values.
 * Facts with testNG xml Files : 
 *    1.You can declare <Paramaeter name="" value="">
 *    2.You can declare parameter in xml file at suite level or test level
 *    3.If you declare same parameter with same name but different value in both
 *      suite and test level then test level parameter has highest priority.
 *    4.@Parameters("parameter name declare in xml file")
 *      by declaring @Paramertes annotation above method you can access the value of it which
 *      is declare in xml file.
 *    5.To the @Parameters annotation's parameters you can mention the type of value directly,
 *      no need to use type casting     
 */

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameters_CrossBrowsing_RealTimeExample_6_1 {

	
	WebDriver driver;

	@Parameters("browserName") 
	@BeforeTest
	public void InitializeBrowser(String browserName)
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
  
	@Parameters("url")
	@Test
	public void LaunchApp(String url)
	{
		driver.get(url);
	}

	@Parameters({"userName","password"})
	@Test
	public void Login(String userName,String password)
	{
        driver.findElement(By.id("txtUsername")).sendKeys(userName);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
     
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
