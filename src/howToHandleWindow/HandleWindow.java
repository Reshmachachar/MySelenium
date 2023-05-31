package howToHandleWindow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
  * 1.How to Handle browser windows in selenium webdriver
  * 2.Diff Bet getWindowHandle() and getWindowHandles() method
  * 3.How to switch bet multiple Browser windows
  * 4.how to close all browser windows
  * 5.how to close specific browser window by choice?  
 */
public class HandleWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_108//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
		 /*
		 //1.single window
		  String windowid=driver.getWindowHandle();//Return the id of Single Window browser(id is produced dynamically hence everytime its different)
		  System.out.println("Window_id : "+windowid);
		  //Window_id : CDwindow-80D4D5632B6A13E2D72D3340D16DBD33
		  //Window_id : CDwindow-029A31B570825DE7A1BB8D8F5907FCE2
		  
		   */
		  
		  
		  //2.Multiple window
	  
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();
		//driver.navigate().to("https://nxtgenaiacademy.com/multiplewindows/");
		 Set<String> windowid_set=driver.getWindowHandles();//set collection doest not allow duplicate value.
	     //windowIterator(windowid_set,driver);
	    windowList(windowid_set,driver);
	    
	    //driver.close();//closing only single browser active window(pointing by driver)
	    //driver.quit();//closing all the browser windows(active+opened)
		 
	}
	
/*	
	public static void windowIterator(Set<String> windowid_set,WebDriver driver)
	{
		Iterator<String> windowid_it=windowid_set.iterator();
	   String parentid,childid;
	  
	   parentid=windowid_it.next();
	   System.out.println("Id Of ParentWindow by the setC : "+parentid);
	   childid=windowid_it.next();
	   System.out.println("Id Of childWindow by the setC : "+childid);

	/*   
	 * Iterator are not reusable and can not reset to 1st element.
	 * so you need to use another one by abandoning old iterator.
	  while(windowid_it.hasNext())
	  {
		  String title=driver.switchTo().window(windowid_it.next()).getTitle();
		  System.out.println("By setIteratot Title : "+title);
	  }
			
	}
*/
	
	public static void  windowList(Set<String> windowid_set,WebDriver driver)
	{
		List<String> windowid_list=new ArrayList(windowid_set);//list allows duplicate values
		                                                        //here we are converting set into list collection
	   String parentid,childid;
	   
	   parentid=windowid_list.get(0);
	   System.out.println("Id Of ParentWindow by the listC : "+parentid);
	   childid=windowid_list.get(1);
	   System.out.println("Id Of childWindow by the listC : "+childid);
		
	   //we are switching from one window to another and getting its title.
	   //1.parent window title and then child window title.
	   for(String lst: windowid_list)
		  {
			  String title=driver.switchTo().window(lst).getTitle();
			  System.out.println("By list_Title : "+title);
			  //to close specific window then you should know title or specific element of window
			  if(title.equalsIgnoreCase("OrangeHRM") || title.equalsIgnoreCase("Give here another title"))
				  driver.close();
		  }
	}

}
