package cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1.cookies are temporary files which are created by browser to optimize time of searching 
 * 2.Browser creates cookies at client side.
 */

public class Cookies {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://demo.nopcommerce.com/");
		 
		 //how to capture cookies from the browser		 
		 Set<Cookie> ck_set=setOfCookies(driver);
		 
		 //how to print cookies from browser
		 printCookies(ck_set);
		 
		//how to add cookie to the browser
		 addCookie("MyCookies123","1234",driver);		 
		 printCookies(setOfCookies(driver));
		 
		 
		//how to DELETE cookie to the browser
		 deleteCookie("MyCookie123",driver);
		printCookies(setOfCookies(driver));
		
		//how to DELETE all cookie to the browser
		deleteAllCookie(driver);
		printCookies(setOfCookies(driver));

	}

	public static Set<Cookie> setOfCookies(WebDriver driver) 
	{
		Set<Cookie> ck_set=driver.manage().getCookies();
		 System.out.println("Size of Cookies : "+ck_set.size());
		 return ck_set;
	}
	
	public static void printCookies(Set<Cookie> ck_set) 
	{
		for(Cookie ck:ck_set) 
		 {
			 System.out.println(ck.getName()+" "+ck.getValue());
		 }
	}
	
	public static void addCookie(String cookie,String ck_val,WebDriver driver) 
	{
		Cookie ck=new Cookie(cookie,ck_val);
		 driver.manage().addCookie(ck);
	}
	
	public static void deleteCookie(String cookie_name,WebDriver driver) 
	{
		//Cookie ck=new Cookie(cookie,ck_val);
		 driver.manage().deleteCookieNamed(cookie_name);
	}
	
	public static void deleteAllCookie(WebDriver driver) 
	{
		
		 driver.manage().deleteAllCookies();
	}
	
}
