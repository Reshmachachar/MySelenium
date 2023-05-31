package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*1.What is Invocation count?
 *   1.it is parameter or attribute which tell us 
 *     how many time same test method is invoked or executed.
 *2.What is the need of Invocation count?    
 *   1.If we want to invoke same method same time then we can use looping logic but
 *     the problem with looping is if there is exception occurred then other iterations
 *     are not performed,control come out from the loop.
 *   2.Thats why we are using invocation count.
 * 3.without the invocationCount,the invocationTimeOut is useless
 * 4.invocationTimeOut stated that within allocated time,the invocation must be 
 *    complete otherwise test case marked as failed.
 * 5.if invocationCount=4 and threadPoolsize=2 that means test method invoked 
 *   four times but due to threadPoolsize is 2,
 *   At single point of time, 2 invocations happened.     
 * 
 *  6.1.If invocationCount=3 then there are 3 times same test method is invoked,
 *      So 3 test cases are passed  but,
 *    2.with looping there is only one Test case is passed even you invoked test method
 *      many times.  
 *      
 *                   
 *    
 * 
 * 
 */

import org.testng.annotations.Test;

public class InvocationAndThreadPoolSize_14 {
	
	@Test(invocationCount = 2,invocationTimeOut = 7000)
   //@Test(invocationCount = 4,threadPoolSize = 2)
  public void testMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe");
	  
	  WebDriver	driver=new ChromeDriver();		
		driver.manage().window().maximize();
		
		//Thread.sleep(2000);
		driver.get("https://randomuser.me/");
		
	   driver.close();
	  
  }
}
