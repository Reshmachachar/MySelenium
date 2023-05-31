package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterOperationalPage {
  @Test
  public void verifyFlightReg() {
	    System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		
		//POM_IdentifacationRegisterPage1 rPage=new POM_IdentifacationRegisterPage1(driver);
		POM_IdentifacationRegisterPage2 rPage=new POM_IdentifacationRegisterPage2(driver);
		 rPage.clickRegLink();
		 rPage.firstName("Anikett");
		 rPage.lastName("shirkee");
		 rPage.phone("123455");
		 rPage.email("anshh@gmail.com");
		 rPage.address1("1011,Manik road");
		 rPage.city("Baramatii");
		 rPage.state("Maharastra");
		 rPage.postalCode("412123");
		 rPage.country("India");
		 rPage.userName("anshh@gmail.com");
		 rPage.password("12345");
		 rPage.confirmPassword("12345");
		 rPage.submit();
		 
		 //validation
		
		 if(driver.getPageSource().contains("Thank you for registering."))
			 System.out.println("You are succefully registerd");
		 else
			 System.out.println("You are not succefully registerd");
		 
		 
		 driver.close();
		
  }
}
