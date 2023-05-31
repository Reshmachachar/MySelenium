package DropDown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckDropDownSorted {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		
        WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.twoplugs.com/");
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
		WebElement sel=driver.findElement(By.name("category_id"));
		
		Select sect=new Select(sel);
		List<WebElement> optionslist=sect.getOptions();
	    
		addingAndComparingElement(optionslist);


	}
	public static void addingAndComparingElement(List<WebElement> optionslist)
	{
		ArrayList originoptionalist = new ArrayList();
		ArrayList tempoptionlist = new ArrayList();
		for(WebElement ele : optionslist)
		{
			originoptionalist.add(ele.getText());
			tempoptionlist.add(ele.getText());
		}
		
		System.out.println("originoptionalist : " + originoptionalist);
		System.out.println("tempoptionlist : " + tempoptionlist);
		
		Collections.sort(tempoptionlist);
		
		System.out.println("After originoptionalist : " + originoptionalist);
		System.out.println("After tempoptionlist : " + tempoptionlist);
		
		if(originoptionalist.equals(tempoptionlist))
			System.out.println("DropDownOPtion Are Sorted");
		else
			System.out.println("DropDownOPtion Are UnSorted");
		
	}

}
