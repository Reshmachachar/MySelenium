package testNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annatation_RealTimeExample_5_3 {

	WebDriver driver;


	@BeforeTest
	public void InitializeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();

	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}

	@Test
	public void LaunchApp()
	{
		driver.get("http://automationpractice.com/");		 
	}

	@Test
	public void Login()
	{
		WebElement SignIn=driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		assertTrue(SignIn.isDisplayed());
		SignIn.click();

		WebElement username=driver.findElement(By.id("email"));
		assertTrue(username.isDisplayed());

		WebElement password=driver.findElement(By.id("passwd"));
		assertTrue(password.isDisplayed());

		WebElement loginButton=driver.findElement(By.id("SubmitLogin"));
		assertTrue(loginButton.isDisplayed());

		username.sendKeys("asss@gmail.com");
		password.sendKeys("saniket");
		loginButton.click();

	}

	@Test
	public void verifyMyLogin()
	{
		String txt=driver.findElement(By.xpath("//a[@title='View my customer account']//span")).getText();
		if(txt.equalsIgnoreCase("Ani shirke"))
			System.out.println("Login Verification is Done!!");
		else
			System.out.println("Login Verification is not Done!!");

	}
	@Test
	public void nevigateToOrderHistoryAndDetails()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Order history and details']")).click();

	}
	@Test
	public void verifyOrderHistory()
	{
		driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']")).isDisplayed();
		System.out.println("Order History Verification is  Done!!");

	}

}
