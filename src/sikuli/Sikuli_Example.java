package sikuli;
/*
 * webdriver does not support to windows based application it is support to web-based application
 * 1.window based application means if you want to upload file from local machine, 
 *   for that local window open which webdriver can not handle.
 * 2.web based means online application which can handled by wedriver.   
 * 3.to handle this scenario we have tools-->
 * 3.1 AutoIt
 * 3.2 Sikuli
 *     these are window based automation tool which is not for web based appl. 
 *     and it is integrated with selenium wd.
 * 3.1 AutoIT-->
 *       there are lot of disadvantages with this tool and there is lot of steps to follow.
 *       mainly it is not platform independent ,its only for ms-window based application.
 * 3.2 Sikuli-->
 *      1.it is simple and there is only need of its jar file to work with sikuli..
 *      2.More popular than AutoIT.
 *      3.we can work with any kind of environment with sikuli.
 *      4.it is used to automate anything but mainly used for automate non-html elment.
 *      5.selenium wd works on source of element.
 *      6.sikuli works on visibility of element on screen.
 *      7.Definition: Sikuli is a powerful and open source tool for test automation. 
 *      It can automate anything which is displayed on the screen. 
 *      It identifies the objects by using image recognition and control GUI (Graphical User Interface) components. 
 *      Python scripting is supported by the Sikuli-IDE.
 *      8.SIKULI is an open-source GUI based test automation tool. 
 *      It is mainly used for interacting with elements of web pages and handling windows based popups. 
 *      Sikuli uses the technique of “Image Recognition” and “Control GUI” to interact with elements of web pages and windows popups.            
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

//How to upload files using Webdriver+sikuli

public class Sikuli_Example {

	public static void main(String[] args) throws FindFailed {
		
		System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe"); 
		 WebDriver driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get("http://demo.automationtesting.in/Register.html");
		 
	    WebElement ele= driver.findElement(By.xpath("//*[@id='imagesrc']"));
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click()", ele);
	    
	    /*steps-->
	     * 1.Capture the pop-up window's screen of required element(like text-box and open button)
	     * 2.create pattern of those elements (each one has separate pattern)
	     * 3.create screen object
	     * 4.with help of screen object use your logic
	     */
	   	    
	    //pattern1->filetextbox
	    Pattern filetextbox=new Pattern("G:\\Software\\Sikuli\\sikuli_screenshot\\filename_textbox.png");
	  //pattern1->openutton
	    Pattern openbutton=new Pattern("G:\\Software\\Sikuli\\sikuli_screenshot\\openbutton");
	    
	    Screen s=new Screen();
	    s.wait(filetextbox, 10);
	    s.type(filetextbox,"G:\\Software\\Sikuli\\sikuli_input\\pineApple.jpg" );
        s.click(openbutton);	   
	   

	}

}
