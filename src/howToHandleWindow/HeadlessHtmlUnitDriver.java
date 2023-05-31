package howToHandleWindow;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessHtmlUnitDriver {

	public static void main(String[] args) {
		
		HtmlUnitDriver driver=new HtmlUnitDriver();
		
		 driver.get("http://demo.nopcommerce.com");
		 System.out.println("CurrentUrl Of Page : "+driver.getCurrentUrl());
		 System.out.println("Titel Of Page : "+driver.getTitle());
		

	}

}
