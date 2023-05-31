package action_slider;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement min_slider= driver.findElement(By.xpath("//span[1]"));
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		
		//location(x,y) and size(height,width)
		
		System.out.println("Min_slider Location(x,y) : "+min_slider.getLocation());//return point
		System.out.println("Min_slider Size(h,w) : "+min_slider.getSize());//return dimension
		System.out.println("Max_slider Location(x,y) : "+max_slider.getLocation());//return point
		
   
		Actions act=new Actions(driver);
		
		//Actions()-->It is a predefined class which available in selenium webdriver
		//mouse related oprations performed by using Actions()class.
		
		
		
		 act.dragAndDropBy(min_slider, 67, 250).perform();
		 System.out.println("Min_slider Location(x,y) : "+min_slider.getLocation());//return point
		 
		  act.dragAndDropBy(max_slider, -100, 250).perform();
		  //perform()->imp to execute the action
		  System.out.println("Max_slider Location(x,y) : "+max_slider.getLocation());//return point
		  
		 Thread.sleep(3000);
		driver.close();
		
	}

}
