package testNG;

/*A1.What is DataProvider?
 *   1.DataProvider is help us for parameterize.
 *   2.DataProvider is container which can pass the data to test method 
 *     so that,test method can execute with different sets of data.
 *A2.Why we need to use dataProvider?
 *    1.Main reason is to parameterize the data to test method.(avoiding hard coded value)      
 * 
 * A3.How to use the dataProvider?
 *   1.First we need to create one method and 
 *     then add @DataProvider annotation to that test method in which we create the data
 *   2.call that DataProvider inside the @Test annotation of test method as parameter like @Test(dataProvider="LoginDataProvider")/@Test(dataProvider="loginData")  
 *   3.add the related parameter to the test method
 * 
 * A4.What happens if we don't provide a name to the dataProvider?
 *    1.if we provide unnamed DataProvider then testNG generates the runtime exception 
 *    but we can overcome this exception by providing 
 *    test method name as name of DataProvider to the @Test annotation's dataProvider parameter.  
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderBasics_10_1 {
	WebDriver driver;

	//1//@Test(dataProvider="LoginDataProvider") //dataProvider work as parameter
	@Test(dataProvider="loginData") //loginData is name of the test method
	public void testLogin(String userName,String password) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys(userName);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        
        Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
        Thread.sleep(3000);
        
        driver.close();
       
	}
	
	//1//@DataProvider(name="LoginDataProvider") //DataProvider work as annotation and assign the name to dataProvider
	@DataProvider()        //if we don't give name to DataProvider the it throws Runtime Exception(testNGException)                   
	@Test                  //so we can use the name of test method as DataProvider annotation.
	public Object[][] loginData()
	{
		return new Object[][]{ 
			                   {"Admin", "admin123"},
                               {"Admin","test123"}
                             };
	}
	

}
