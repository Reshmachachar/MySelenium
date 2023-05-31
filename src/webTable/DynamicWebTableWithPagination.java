package webTable;

//web scraping


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableWithPagination {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 //Login
		 driver.get("https://demo.opencart.com/admin");
		 WebElement username=driver.findElement(By.id("input-username"));
		 username.clear();
		 username.sendKeys("demo");
		 WebElement password=driver.findElement(By.id("input-password"));
		 password.clear();
		 password.sendKeys("demo");		 
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 //Sales-->Orders 
		 driver.findElement(By.xpath("//a[contains(text(),' Sales')]")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		 
		 //Table-->Showing 1 to 20 of 12546 (628 Pages)
		  int pagecount= totalPageCount(driver);
		 
		 //make your active page
		  ////Bydefault avtive page is 1..We make it 624 or (pagecount-4) page as active
		 // makeYourActivePage(pagecount,driver);
		  
		  //Total rows and all data of page(s)..
		  totalRowsAndDataPerPage(pagecount,driver);
				 
		 
	}
	public static int totalPageCount( WebDriver driver)
	{
		 String pagecounttext=driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		 int pagecount=Integer.valueOf(pagecounttext.substring(pagecounttext.indexOf("(")+1,pagecounttext.indexOf("Pages")-1));
		 System.out.println("Total Number of Pages : "+pagecount);
		
		 return pagecount;
	}
	
	public static void makeYourActivePage(int pagecount,WebDriver driver)
	{
		
		 int lastfifthpageno=pagecount-1;//how many pages you want ...
		 driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='>|']")).click();
		 driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+lastfifthpageno+"']")).click();
		 //last(627 to 628)
		
	}
	
	
	public static void totalRowsAndDataPerPage(int pagecount,WebDriver driver)
	{
		//due to 628 pages we giving here hardcore value 2 instead of pagecount
		for(int p=1;p<=2;p++)
		 {
			 WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			 System.out.println("Active Page : "+active_page.getText());
			 
			 int row_perpage=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			 System.out.println("Rows Per Page : "+row_perpage);
			 
			 //row Data of uesre selected pages... 
			 rowData(row_perpage,driver);
		
			 //String next_pagenumber= Integer.toString(Integer.valueOf(active_page.getText())+1);
			 int next_pagenumber=Integer.valueOf(active_page.getText())+1;
			// String next_pagenumber=Integer.toString(p+1);
			 
			 if(next_pagenumber<(pagecount+1))
            driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+next_pagenumber+"']")).click();
		 
		 }

	}
	public static void rowData(int row_perpage,WebDriver driver) 
	{
		
		 String customer,status,total;
		 System.out.println("Customer     "+"        "+"Status     "+"       "+"Total");
		 for(int row=1;row<=row_perpage;row++)
		 {
			 //table[@class='table table-bordered table-hover']//tbody//tr[6]//td[5]
			 customer=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+row+"]//td[3]")).getText();
			 status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+row+"]//td[4]")).getText();
			 total=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+row+"]//td[5]")).getText();
			 
			if(status.equalsIgnoreCase("Pending")) 
			 System.out.println(customer+"               "+status+"               " +total);
			 
			 
		 }
	
		
	}
	

}
