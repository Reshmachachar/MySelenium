package zxingapi_barcodeandqcarcode;
/*BarCode-->
 * a machine-readable code in the form of numbers and a pattern of parallel lines of varying widths, 
 * printed on a commodity and used especially for stock control.
 * it is used for any item,place person, location.
 * 
 * Steps-->
 * 1.find barcodeimage element and get url by getAttribute("src")
 * 2.convert it into proper URL
 * 3.get Buffered-image by URl by using ImageIO.read(url)
 * 4.get Luminance source by BufferedimageLuminanceSource class 
 * and Luminance interface initiate by that BufferedimageLuminanceSource obj.
 * 5.get hybrid binarizer text by luminanace source
 * 6.get Binary bitmap by HybridBinarizer 
 * 7.read binary bitmap by multifimatreader
 * 8.store it into result and by using resultobj getText()
 */


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

//Read The Text from Barcode
public class BarCodeAutomation_ZXingApi {

	public static void main(String[] args) throws IOException, NotFoundException {
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://testautomationpractice.blogspot.com/");
		 
		String barcodeurl= driver.findElement(By.xpath("//*[@id=\"HTML12\"]/div[1]/img[1]")).getAttribute("src");
		
		URL url=new URL(barcodeurl);
	
		BufferedImage bimg=ImageIO.read(url);
		
		//buffls-ls
		BufferedImageLuminanceSource bimag_ls=new BufferedImageLuminanceSource(bimg);
		LuminanceSource ls=bimag_ls;  //LuminanceSource is interface we initiate it by
		
		//hbdbn-bn
		HybridBinarizer hd_bn=new  HybridBinarizer(ls); 
		BinaryBitmap bbtm=new BinaryBitmap(hd_bn);
		
		//read binary code	
		MultiFormatReader mfr=new MultiFormatReader();
		Result rs=mfr.decodeWithState(bbtm);
		
		String text=rs.getText();
		System.out.println("Barcode decoded text :"+text);
	     
		
		
		
		
		

	}

}
