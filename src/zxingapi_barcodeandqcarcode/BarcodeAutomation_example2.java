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

public class BarcodeAutomation_example2 {

	public static void main(String[] args) throws IOException, NotFoundException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_108//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://testautomationpractice.blogspot.com/");
		 
		String src_val= driver.findElement(By.xpath("//*[@id=\"HTML12\"]/div[1]/img[2]")).getAttribute("src");
		
		URL url=new URL(src_val);
		BufferedImage bimg=ImageIO.read(url);
		
		BufferedImageLuminanceSource bimgls=new BufferedImageLuminanceSource(bimg);
		LuminanceSource ls=bimgls;
		
		HybridBinarizer hbb=new HybridBinarizer(ls);
		BinaryBitmap bmap=new BinaryBitmap(hbb);
		
	  //to read binarybitmap image use MultiFormatReader class
		
		MultiFormatReader  mfr=new MultiFormatReader();
		
		Result rs=mfr.decode(bmap);
		
		System.out.println("Barcode decode text : "+rs.getText());
		
		
		
		
		
		
		
		
		


	}

}
