package webTable;

import org.openqa.selenium.By;

/*
 * How many rows and columns in the table
 * Retrieve the specific row/column from the table
 * retrieve all the data from the table
 * print name and author
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.sun.tools.javac.util.List;



public class HandleWebTable {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.selenium.dev/ecosystem/");
		 
		 //1.how many rows in the webtable
		 int rowcount=driver.findElements(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']/tbody/tr")).size();
		 System.out.println("Total Number of Rows in The WebTable : "+rowcount);
		 
		 //2.how many columns in the webtable
		 int colcount=driver.findElements(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']/thead/tr/th")).size();
		 System.out.println("Total Number of Columns in The WebTable : "+colcount);
		 
		 //3.data of  Specific row-col
		 int i=2;
		String authorname = driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tr[5]//td["+i+"]")).getText();
		System.out.println("Specific Authorname in The WebTable : "+authorname);
		
		//4.Retrieve all the data of webtable : 
		//table_data(colcount,rowcount,driver);
		
		
		//5.Retrive 2 or more values of row (print name and author)
		specific_data(rowcount, driver);
	
		driver.close();
		
	}
	public static void specific_data(int rowcount,WebDriver driver)
	{
		for(int row=1;row<=rowcount;row++)
		{
			////div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tbody//tr[4]/th
			String tt=driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tbody//tr["+row+"]/th")).getText();
			if(tt.equalsIgnoreCase("Helium"))
			{
				String lang=driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tbody//tr["+row+"]/td[1]")).getText();
				System.out.println(tt+" : "+lang);
				String author=driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tbody//tr["+row+"]/td[2]")).getText();
				System.out.println(tt+" : "+author);
			}
		}
		
	}
	
	public static void table_data(int colcount, int rowcount,WebDriver driver)
	{		
				//colhead-//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//thead//tr//th[1]
				//name(a)-//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tbody//tr[1]//th//a
				//row[1]data-//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tbody//tr[1]//td[1]
				
				
				String cloheading ,row_a_text,rowdata;
				
				System.out.print("Table Data....... "+"\n");
				
				for(int col=1;col<=colcount;col++)
				{
					cloheading=driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//thead//tr//th["+col+"]")).getText();
				    System.out.print(cloheading + ":   ");
					
					for(int row=1;row<=rowcount;row++)
					{
					
						switch(col) 
						{
						case 1 :
							row_a_text=driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tbody//tr["+row+"]//th//a")).getText();
							System.out.print(row_a_text + "      ");
						   break; 
						case 2 :
							rowdata=driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tbody//tr["+row+"]//td["+(col-1)+"]")).getText();
							System.out.print(rowdata+ "      ");
							break;
						case 3 :
							rowdata=driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']//table[@class='table']//tbody//tr["+row+"]//td["+(col-1)+"]")).getText();
							System.out.print(rowdata+" ");		
							break;
						 
						
						}	
						
					}
					System.out.println("");
				}
				
		
		
	}

}
