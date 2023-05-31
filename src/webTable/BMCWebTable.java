package webTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BMCWebTable {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_108//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		////tbody/tr/th[3]
		////tbody/tr  ==total number of rows
		//data=//tbody/tr[2]/td[3]

		List<WebElement> tableRowsElement=driver.findElements(By.xpath("//tbody/tr"));

		int rows=tableRowsElement.size();

		System.out.println("**********************BMC WEB Table Data************************");
		for(int i=1;i<=rows;i++)
		{
			if(i==1)
			{
				
				WebElement authorH=driver.findElement(By.xpath("//tbody/tr/th[1]"));
				WebElement courseH=driver.findElement(By.xpath("//tbody/tr/th[2]"));
				WebElement priceH=driver.findElement(By.xpath("//tbody/tr/th[3]"));
			

				System.out.println(authorH.getText()+"                           "+courseH.getText()+"                            "+priceH.getText());	
			}
			else
			{
				WebElement author=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]"));
				WebElement course=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]"));
				WebElement price=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[3]"));	

				System.out.println(author.getText()+"             "+course.getText()+"                   "+price.getText());
			}
		}
		
		System.out.println("**************************-END-****************************");






	}

}
