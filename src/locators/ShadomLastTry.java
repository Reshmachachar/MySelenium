package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadomLastTry {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");

		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@id='input']")).sendKeys("testing");//NoSuchElementException
		//driver.findElement(By.cssSelector("input#input")).sendKeys("Testing");//NoSuchElementException
		
		WebElement root=driver.findElement(By.tagName("book-app"));//showdow host/root Element which can hold all the shadow dom
		
		System.out.println(root);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		//String script="return arguments[0].shadowRoot";
		
		WebElement host=(WebElement) js.executeScript("return arguments[0].shadowRoot",root);
	
		System.out.println(host);
		
		
		
        WebElement apph=host.findElement(By.tagName("app-header")) ;
        
        WebElement apptool=apph.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
        
        WebElement bid=apptool.findElement(By.tagName("book-input-decorator"));
        
        bid.findElement(By.cssSelector("#input")).sendKeys("Yayati");
        

	}	
}
