package links;
/*
 * Broken Link is link which is does not have any target page.
 * when you click on link,it will not go on target page.
 */

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_106//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://www.deadlinkcity.com/");
		 
		 List<WebElement> linklist= driver.findElements(By.tagName("a"));
		 
		 System.out.println("Linklist size : "+linklist.size());
		 
		 checklinkBrokenOrNormal( linklist);
		 driver.close();
		 

	}

	public static void checklinkBrokenOrNormal(List<WebElement> linklist) throws IOException
	{
		String href_value;
		for(WebElement ele : linklist)
		{
			href_value=ele.getAttribute("href");
			if((href_value==null) || href_value.isEmpty())
			{
				System.out.println("Link is Empty : ");
				continue;
			}
		
		URL url_link=new URL(href_value);	//converting string into proper URL format.
		
		HttpURLConnection conn=(HttpURLConnection) url_link.openConnection();//here we are hitting the url..trying to open the url's page
		
	
		
		 if(conn.getResponseCode()>=400)
			 System.out.println(href_value + " is broken Link ");
		 else
			 System.out.println(href_value+" : "+ conn.getResponseCode() + " is Normal Link ");
			 
			
		}
		
	}
	
}
