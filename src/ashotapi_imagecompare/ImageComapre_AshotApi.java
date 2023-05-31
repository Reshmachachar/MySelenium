package ashotapi_imagecompare;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

/*
 *1.You should have required image(expected) to compare with actual image
 *2.Take this by file and raed it by ImageIO class stored into buffered image.
 *3.Take screenshot by AShotApi 
 */


public class ImageComapre_AshotApi {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		
		 //expected file
		 File f=new File("G://Software//Ashotapi//captured_image//Orangehrmlogo.png"); 
		BufferedImage expected_logo=ImageIO.read(f);
		
		//actual image--screenshot and conver it into image
		
		WebElement logo_ele=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		
		AShot at=new AShot();
	    Screenshot logoscreenshot=at.takeScreenshot(driver, logo_ele);
	    BufferedImage actual_logo=logoscreenshot.getImage();
	    
	    //To Compare image we need two class
	    //1/ImageDiffer
	    //2.ImageDiff
	    
	    ImageDiffer differ=new ImageDiffer();
	    ImageDiff dff=differ.makeDiff(expected_logo, actual_logo);//also compare screenshot
	    
	    if(dff.hasDiff())
	    	System.out.println("Images are not Same");
	    else
	    	System.out.println("Images are Same");
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
		
		
		
		
		
		
		

	}

}
