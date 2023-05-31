package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumGetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		System.out.println("Title of Page : "+driver.getTitle());
		System.out.println("CurrtenUrl of Page : "+driver.getCurrentUrl());
		//System.out.println("Source of Page : "+driver.getPageSource());
		
		//Getting WebElement's attribute(WebElement.getAttribute("attribute_name"))...first we need to get webelement
		WebElement ele=driver.findElement(By.id("email"));
		
		System.out.println("Value Of attribute placeholder : "+ele.getAttribute("placeholder"));
		
		//Getting WebElement's text(WebElement.getText())..its inner text..first we need to get webelement
		WebElement text_ele=driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
		System.out.println("Text of create new Acc button : "+text_ele.getText());
		
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
