package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RunThroughXml_OrangeHRM {

	WebDriver driver;

	@Test
	public void LaunchApp()
	{
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@Test
	public void Login()
	{
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
     
	}
	   
	@Test
	public void verifyMyLogin()
	{
        driver.findElement(By.id("welcome")).isDisplayed();
        System.out.println("Login Verification is Done!!");
        driver.close();
    //menu_pim_viewMyDetails   
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
        driver.close();
      
	}
	

}
