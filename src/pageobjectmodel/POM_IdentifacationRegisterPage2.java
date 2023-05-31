package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



/*What is Page Object Model
 * 1.Maintaining and Managing all the  page object models in proper way and in different
 *  file is concept of Page Object model.
 * 2.In this,we are creating the java class for page to maintain and organize 
 *   the element of that page.
 * 3. For Operational method, there is main java class. 
 *  
 *What is need of POM?
 * 1. If You write both identification and operational statement then it becomes huge 
 *    in size or
 * 2. If same web element repeated multiple times in complex project,the we need to
 *    go everywhere for changes.
 * 3. Solution is that,we maintain the operational methods in one class
 *    and page objects models (web elements of page) in another class.
 *   
 * 4.Additional:
 *   1.@FindBy(how=How.NAME,using = "firstName")
	   WebElement firstName;
 *   2.@FindBy(name = "lastName") WebElement lastName;
 *   3. PageFactory.initElements(d, this);     
 *        
 */

public class POM_IdentifacationRegisterPage2 {

	WebDriver driver;
	
	//locating and identification web-element
	
	//syntax1(how is variable and How is class)
	@FindBy(how = How.LINK_TEXT,using = "REGISTER") WebElement regLink;
	
	//(how is variable and How is class)
	@FindBy(how=How.NAME,using = "firstName")
	WebElement firstName;
	
	//syntax2
	@FindBy(name = "lastName") WebElement lastName;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="userName")
	WebElement email;
	
	@FindBy(name="address1")
	WebElement address1;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="postalCode")
	WebElement postalCode;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name="submit")
	WebElement submit;
	
	
	

	POM_IdentifacationRegisterPage2(WebDriver d)
	{
		driver=d;
		//this statement used to initiate the driver object
		//because by using this,@findBy locate and identify the element
		PageFactory.initElements(d, this);
		
	}
	
	public void clickRegLink()
	{
		//identification of web-element
		regLink.click();
	}
	
	public void firstName(String Fname)
	{
		firstName.sendKeys(Fname);
	}
	public void lastName(String Lname)
	{
		lastName.sendKeys(Lname);
	}
	
	public void phone(String Pnumber)
	{
		phone.sendKeys(Pnumber);
	}
	public void email(String userEmail)
	{
		email.sendKeys(userEmail);
	}
	
	public void address1(String uAddress1)
	{
		address1.sendKeys(uAddress1);
	}
	public void city(String uCity)
	{
		city.sendKeys(uCity);
	}
	public void state(String uState)
	{
		state.sendKeys(uState);
	}
	public void postalCode(String uPostalCode)
	{
		postalCode.sendKeys(uPostalCode);
	}
	public void country(String uCountry)
	{
		country.sendKeys(uCountry);
	}
	public void userName(String uEmail)
	{
		userName.sendKeys(uEmail);
	}
	public void password(String uPassword)
	{
		password.sendKeys(uPassword);
	}
	public void confirmPassword(String uConfirmPassword)
	{
		confirmPassword.sendKeys(uConfirmPassword);
	}
	public void submit()
	{
		submit.click();
	}
	
}
