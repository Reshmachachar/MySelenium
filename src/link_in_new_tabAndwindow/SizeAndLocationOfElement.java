package link_in_new_tabAndwindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SizeAndLocationOfElement {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		 
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		 
		 //location :method1
		 System.out.println("Loaction(x,y) :"+logo.getLocation());
		 System.out.println("Loaction(x) :"+logo.getLocation().getX());
		 System.out.println("Loaction(y) :"+logo.getLocation().getY());
		 
		 //method2
		 System.out.println("Loaction(x) :"+logo.getRect().getX());
		 System.out.println("Loaction(Y) :"+logo.getRect().getY());
		 
		 //size:method1
		 System.out.println("Size(W,H) :"+logo.getSize());
		 System.out.println("Size(H) :"+logo.getSize().getHeight());
		 System.out.println("Size(W) :"+logo.getSize().getWidth());
		 
		 //method1:
		 System.out.println("Size(H) :"+logo.getRect().getHeight());
		 System.out.println("Size(W) :"+logo.getRect().getWidth());
		 
		 
		 
		 
		 
		 

	}

}
