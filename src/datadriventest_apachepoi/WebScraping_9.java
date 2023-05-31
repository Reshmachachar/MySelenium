package datadriventest_apachepoi;
/*
 * Reading web table is called web scraping or web harvesting or web data extraction
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebScraping_9 {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
         
		 int tbody_rows=driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr")).size();		 
		 int tbody_col=driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr[2]/td")).size();
		 
       // FileOutputStream out=new FileOutputStream(".//datafiles//webscrap.xlsx");
        XSSFWorkbook wrk=new XSSFWorkbook();
        XSSFSheet sht=wrk.createSheet("W1");
        WebElement ele;
        //int sheetNo=1,r=0,startIndexOfRow=0;
        //int NoOfSheet=(tbody_rows/20);
        HeadingOfData(driver,sht,tbody_col);
          
		 for(int r=2;r<=tbody_rows;r++)//6
		 {	
			 XSSFRow row=sht.createRow(r);
			 for(int c=1;c<tbody_col;c++)//6
			 {
				 
				 if(c==1) 
				 {
				  ele=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr["+r+"]/th["+c+"]"));
				  row.createCell((c-1)).setCellValue(ele.getText()); 
				  ele=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr[136]/td["+c+"]/descendant::a"));
				  row.createCell((c)).setCellValue(ele.getText());
				 }
				 ele=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr["+r+"]/td["+c+"]"));
				 row.createCell((c)).setCellValue(ele.getText());//c=2
			 }
		 }
		 
       
		 FileOutputStream out=new FileOutputStream(".//datafiles//webscrap.xlsx");
		 wrk.write(out);
		 out.close();
		 System.out.println("Done!");
		 
	}
	public static void HeadingOfData(WebDriver driver,XSSFSheet sht,int tbody_col)
	{
		WebElement ele;
		XSSFRow row=sht.createRow(0);
		XSSFRow row1=sht.createRow(1);
		
		for(int c=1;c<=tbody_col;c++)
		  { 
			ele=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/thead/tr/th["+c+"]"));
			row.createCell(c-1).setCellValue(ele.getText());
			ele=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr[1]/td["+c+"]"));
			row1.createCell(c-1).setCellValue(ele.getText());
		  }
		
	}

}
