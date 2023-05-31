package cogniwizewebsite;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.python.modules.thread.thread;
import org.testng.Assert;



public class ResourcesWebpage {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		
		//driver.get("https://cogniwize.com");
		
	/*	Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-item-3959\"]"))).perform();
		String newEvent="News and Events";
		String expectedString=driver.findElement(By.xpath("//*[@id=\"menu-item-3960\"]/a/span")).getText();
		Assert.assertEquals(newEvent, expectedString);
		
		Thread.sleep(3000);
		driver.close();
		*/
		
		driver.get("https://www.google.com");
		
	    driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("site:cogniwize.com");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
       // driver.findElement(By.xpath("//span[@class='z1asCe MZy1Rb']")).click();
      Thread.sleep(5000);
      
     
      //career.CareersLink().click();
      WebElement next=driver.findElement(By.xpath("//*[@id=\"pnnext\"]/span[2]"));
      while(next!=null)
      {
        
          System.out.println("Welcome");
          /*
             List<WebElement>links=driver.findElements(By.tagName("a"));// a is anchor tag
            System.out.println(links.size());
            //for(int i=0;i<links.size();i++)
            //{
            for(WebElement link:links)
            {
                String url = link.getAttribute("href");
                URL Link=new URL(url);
                HttpURLConnection httpcon=(HttpURLConnection) Link.openConnection();
                Thread.sleep(2000);
                httpcon.connect();
                int response = httpcon.getResponseCode();//broken links 
                if(response>=400)
                {
                    System.out.println(url+" "  + "link is broken");
                }
                */
           ///
          List<WebElement> links = driver.findElements(By.tagName("cite"));
          System.out.println(links.size());
          
          for(int i=0;i<links.size();i++) {
              
              System.out.println(links.get(i).getText());
            
              
          }
          next.click();
          try {
        	  next=driver.findElement(By.xpath("//*[@id=\"pnnext\"]/span[2]"));  
          }catch(Exception e)
          {
        	  System.out.println("Done");
        	  break;
          }
          
      }
	}

}
