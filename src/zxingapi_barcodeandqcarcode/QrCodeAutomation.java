package zxingapi_barcodeandqcarcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QrCodeAutomation {

	public static void main(String[] args) throws IOException, NotFoundException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_108//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://testautomationpractice.blogspot.com/");
		 
		String qr_url= driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/img")).getAttribute("src");
		URL url=new URL(qr_url);
		BufferedImage bimg=ImageIO.read(url);//now read image by url
		
		BufferedImageLuminanceSource bimg_ls=new BufferedImageLuminanceSource(bimg);
		LuminanceSource ls=bimg_ls;
		
		
		HybridBinarizer hbb=new HybridBinarizer(ls);
		BinaryBitmap bmp=new BinaryBitmap(hbb);
		
		//read binary image by MultiFormatReader class
		
		MultiFormatReader mfr=new MultiFormatReader();
		Result rs=mfr.decode(bmp);
		
		System.out.println("ORCode decoded Text : "+rs.getText());
		
		
		
		
		
		
		
		

	}

}
