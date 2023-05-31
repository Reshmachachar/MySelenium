package javascripexecutor_pkg;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtil {
	
	public static void drawBoarder(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static String getTitleByJs(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		return js.executeScript("return document.title;").toString();
	}
	
	public static void clickElementByJs(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void generateAlert(WebDriver driver,String msg)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("alert('" + msg + "')"); //syntax imp
	}
	
	public static void refreshBrowser(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("history.go[0]"); 
		System.out.println("Successfully refershed..");
	}
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");//take whole height
		//js.executeScript("window.scrollBy(0,350)");//go down for 350 pixel
		
	}
	
	public static void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");//scroll up for whole height pixel
		//js.executeScript("window.scrollBy(0,-350)");//go up for 350 pixel
		
	}
	
	public static void zoomPageByJs(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;//already page is 100%
		js.executeScript("document.body.style.zoom='50%'");//zoom_in page by 50%
		//js.executeScript("document.body.style.zoom='150%'");//zoom_out page by 150%
		
		
	}
	
	public static void flash(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String color=element.getCssValue("backgroundColor");
		for(int i=0;i<100;i++)
		{
			changeColor("#000000",element,driver);
			changeColor(color,element,driver);
		}
		
	}
	
	public static void changeColor(String color,WebElement element,WebDriver driver)
	{
	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].style.backgroundColor = 'lightblue';", element);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"';", element);
		
	}
	
	
	/*
	 public static void flash(WebElement element, WebDriver driver) {
	        
	        JavascriptExecutor js = ((JavascriptExecutor)driver);
	        String bgcolor = element.getCssValue("backgroundColor");
	        for (int i = 0; i < 100; i++) {
	            changeColor("#000000", element, driver); 
	            changeColor(bgcolor, element, driver); 
	            
	        }
	    }
	        public static void changeColor(String color, WebElement element, WebDriver driver) {
	            JavascriptExecutor js = ((JavascriptExecutor)driver);
	            js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
	            try {
	                Thread.sleep(20);
	          
	            }catch (InterruptedException e) {
	              
	        }
	    
	}
	
	*/
}
