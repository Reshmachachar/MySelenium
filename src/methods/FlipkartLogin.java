package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.python.modules.thread.thread;

public class FlipkartLogin {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_108//chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		 driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		 Actions act=new Actions(driver);
		
		WebElement login=driver.findElement(By.xpath("//a[@class='_1_3w1N']"));
		WebElement profile=driver.findElement(By.xpath("(//div[@class='_3vhnxf'])[1]"));
		act.moveToElement(login).perform();
	    Thread.sleep(2000);
		act.moveToElement(profile).click().perform();
		
		

        WebElement form= driver.findElement(By.xpath("//form[@autocomplete='on']//input[@autocomplete='off']"));
       driver.switchTo().frame(form);
		driver.findElement(By.xpath("//form[@autocomplete='on']//input[@autocomplete='off']")).sendKeys("8767551651");
		//driver.findElement(By.xpath("//div[@class='_1k3JO2']")).click();


	}

}
