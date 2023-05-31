package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



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
 * 2. If same web element repeated multiple times in complex project,so we need to
 *    go everywhere for changes.
 * 3. Solution is that,we maintain the operational methods in one class
 *    and page objects models (web elements of page) in another class.
 *        
 */

public class POM_IdentifacationRegisterPage1 {

	WebDriver driver;
	
	//Only locating web-element
	By regLink=By.xpath("//a[normalize-space()='REGISTER']");
	By firstName=By.name("firstName");
	By lastName=By.name("lastName");
	By phone=By.name("phone");
	By email=By.name("userName");
	
	By address1=By.name("address1");
	By city=By.name("city");
	By state=By.name("state"); 
	By postalCode=By.name("postalCode");
	By country=By.name("country");
	
	By userName=By.name("email");
	By password=By.name("password");
	By confirmPassword=By.name("confirmPassword");
	By submit=By.name("submit");
	

	POM_IdentifacationRegisterPage1(WebDriver d)
	{
		driver=d;
	}
	
	public void clickRegLink()
	{
		//identification of web-element
		driver.findElement(regLink).click();
	}
	
	public void firstName(String Fname)
	{
		driver.findElement(firstName).sendKeys(Fname);
	}
	public void lastName(String Lname)
	{
		driver.findElement(lastName).sendKeys(Lname);
	}
	
	public void phone(String Pnumber)
	{
		driver.findElement(phone).sendKeys(Pnumber);
	}
	public void email(String userEmail)
	{
		driver.findElement(email).sendKeys(userEmail);
	}
	
	public void address1(String uAddress1)
	{
		driver.findElement(address1).sendKeys(uAddress1);
	}
	public void city(String uCity)
	{
		driver.findElement(city).sendKeys(uCity);
	}
	public void state(String uState)
	{
		driver.findElement(state).sendKeys(uState);
	}
	public void postalCode(String uPostalCode)
	{
		driver.findElement(postalCode).sendKeys(uPostalCode);
	}
	public void country(String uCountry)
	{
		driver.findElement(country).sendKeys(uCountry);
	}
	public void userName(String uEmail)
	{
		driver.findElement(userName).sendKeys(uEmail);
	}
	public void password(String uPassword)
	{
		driver.findElement(password).sendKeys(uPassword);
	}
	public void confirmPassword(String uConfirmPassword)
	{
		driver.findElement(confirmPassword).sendKeys(uConfirmPassword);
	}
	public void submit()
	{
		driver.findElement(submit).click();
	}
	
}
