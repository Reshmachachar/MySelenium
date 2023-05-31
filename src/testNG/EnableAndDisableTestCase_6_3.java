package testNG;
/*
 * 1.By default every test case is enabled="true"
 * 2.if you want to disable it then use enable="false"
 * 3.in testNG project,there are multiple xml file which are contains multiple test cases.
 * 4.but if we want to execute the selective test case from every xml file 
 *   then use enable and disable property.
 * 5.for example,As part of the testing project,we have multiple releases like,
 *   release1,release2,..,and under each release have multiple sprints(agile)
 *   So,Each sprint,i do not want to execute all the test case.
 *   i want to execute selective few cases which are based on test coverage analysis           
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

public class EnableAndDisableTestCase_6_3 {

	
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
