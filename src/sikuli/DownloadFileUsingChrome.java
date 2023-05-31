package sikuli;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadFileUsingChrome {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://demo.automationtesting.in/FileDownload.html");
		 
		 //txt file
		 WebElement ele_txt=driver.findElement(By.xpath("//textarea[@id='textbox']"));
		 ele_txt.clear();
		 ele_txt.sendKeys("aniket shrike....txt");
		 driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		 driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
		 Thread.sleep(2000);
	
		 boolean filetxtexist= isFileExist("C://Users//Aniket//Downloads//info.txt");
		 if(filetxtexist)
			 System.out.println("file txt exist");
		 else
			 System.out.println("file txt not exist");
		 
		 //pdf file
		 WebElement ele_pdf=driver.findElement(By.xpath("//textarea[@id='pdfbox']"));
		 ele_pdf.clear();
		 ele_pdf.sendKeys("Ar shrike....pdf");
		 driver.findElement(By.xpath("//button[@id='createPdf']")).click();
		 driver.findElement(By.xpath("//a[@id='pdf-link-to-download']")).click();
		 Thread.sleep(2000);
		 
		 boolean filepdfexist= isFileExist("C://Users//Aniket//Downloads//info.pdf");
		 if(filepdfexist)
			 System.out.println("file pdf exist");
		 else
			 System.out.println("file pdf not exist");
		 

	}
	
	public static boolean isFileExist(String path)
	{
		File f=new File(path);
		if(f.exists())
		    return true;
		else
			return false;
	}

}
