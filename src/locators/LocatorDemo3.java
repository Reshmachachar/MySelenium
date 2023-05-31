package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class LocatorDemo3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe");

		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		//Tag and id (Tag is optional for all the combinations) 
		//driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
	
		driver.findElement(By.cssSelector("#email")).sendKeys("sd@gmail.com");
		
		//Tag and Class (findElement always return 1st element from the multiple element)
		
		//List<WebElement> cdf = driver.findElements(By.cssSelector("input.inputtext"));
		//List<WebElement> cdf = driver.findElements(By.cssSelector(".inputtext"));
		//WebElement ele=cdf.get(1);
		//ele.sendKeys("1234");
		
		//----tag and Attribute
		
		//driver.findElement(By.cssSelector("input[name=pass]")).sendKeys("777");
		//driver.findElement(By.cssSelector("[name=pass]")).sendKeys("777");
		
		
		//==Tag and class and attribute==
		
		//driver.findElement(By.cssSelector("input.inputtext[name=pass]")).sendKeys("555");
		 //driver.findElement(By.cssSelector(".inputtext[name=pass]")).sendKeys("1");
		 driver.findElement(By.cssSelector(".inputtext[data-testid=royal_pass]")).sendKeys("333");
		 
		
		
		 //---/html/body/div[1]/div/div[3]/div[1]/img--Absolute xpath
		
		
	}

}
