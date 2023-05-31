package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorDemo6_1_XPathShadowDom {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe");
	      
		WebDriver driver=new FirefoxDriver();
		driver.get("https://books-pwakit.appspot.com/");

		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@id='input']")).sendKeys("testing");//NoSuchElementException
		//driver.findElement(By.cssSelector("input#input")).sendKeys("Testing");//NoSuchElementException
		
		WebElement root=driver.findElement(By.tagName("book-app"));//showdow host/root Element which can hold all the shadow dom
		
		System.out.println(root);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		String script="returns argumnets[0].shadowRoot";
		
		WebElement host=(WebElement)js.executeScript(script, root);
		
		
		
		System.out.println(host);
		
        WebElement apph=host.findElement(By.tagName("app-header")) ;
        
        WebElement apptool=apph.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
        
        WebElement bid=apptool.findElement(By.tagName("book-input-decorator"));
        
        bid.findElement(By.cssSelector("#input")).sendKeys("Yayati");
        
        

	}

}
