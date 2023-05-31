package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorDemo5_1_XPathAxesPrac {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe");

		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		driver.manage().window().maximize();
    
		
		//case1 : find the SignUp button From the reg Form in FB appl(Child)
		String sgn=driver.findElement(By.xpath("//div[@id='reg_form_box']/child::div[10]/button")).getText();
        System.out.println("SignUp Txt : " + sgn);
	
        //Case 2: Locate First name field from Signup Button in FB(Parent)
        ////button[@id='u_1_s_FW']/parent::*/parent::*/child::div[1]/div/div[1]
        
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("aniket");
        
        //case 3 : identified the password from Mob Number field in fb(dynamic page its not worked by id)
       //input[@id='u_0_o_+d']/following::input
        driver.findElement(By.xpath("//input[@id='u_0_o_+d']/following::input")).sendKeys("aniket");
        
      // case 4 :  identified the mob number from password field in fb[dynamic page its not worked by id]
        ////input[@id='password_step_input']/preceding::input[2]
        driver.findElement(By.xpath("//input[@id='u_0_o_+d']/following::input")).sendKeys("9284839999");
        
	}

}
