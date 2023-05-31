package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorDemo5_XPathAxes {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://money.rediff.com/gainers");
		
		driver.manage().window().maximize();
		
		//self  (current node )
		String selfnode_xpath="//a[contains(text(),'Tata Elxsi')]";
		
		//String selftxt=driver.findElement(By.xpath("//a[contains(text(),'Tata Elxsi')]/self::a")).getText();
		String selftxt=driver.findElement(By.xpath(selfnode_xpath+"/self::a")).getText();
		System.out.println("SelfTaxt : "+ selftxt);
		
		
		//parent--(td tag is parent but in table data(td) there is only one element is self so op will be self now)
		//(in other case it should be diff (parent)
		// select parent of current node( always one)
		
		String parenttxt=driver.findElement(By.xpath(selfnode_xpath+"/parent::td")).getText();
		System.out.println("ParentTaxt : "+ parenttxt);
		
		//child Element : select all children of current node (one or many)
		
		//int anc_childsize=driver.findElements(By.xpath("//a[contains(text(),'Pranavaditya Spi')]/ancestor::tr/child::td")).size();
		//System.out.println("Anc_Childsize : "+anc_childsize);
		
		List<WebElement> childele =  driver.findElements(By.xpath(selfnode_xpath+"/ancestor::tr/child::td"));
		
		for(WebElement chld : childele)
		{  
		
			System.out.println("Anc_ChildName Of : "+chld.getLocation() + chld.getText());
			
		}
		
		//ancestor--(Giving row's all data in single string // op=Anc_Row : Pranavaditya Spi X 24.00 24.40 + 1.67)
		// select all ancestor paraent,grandparent
		
		String anctxt=driver.findElement(By.xpath(selfnode_xpath+"/ancestor::tr")).getText();
		System.out.println("Anc_Row : "+anctxt);
		
		
		//descendant (child+child's child(grandchild)) of current node
		
	List<WebElement> descendant=driver.findElements(By.xpath(selfnode_xpath+"/ancestor::tr/descendant::*"));
	System.out.println("DesdSize : "+descendant.size());
	
	//following : Select everything in the document after closing tag of current node 
	//*-select all following node
	List<WebElement> fnod=driver.findElements(By.xpath(selfnode_xpath+"/following::*"));
	System.out.println("Fnode_Size(*) : "+fnod.size());
	
	List<WebElement> fnod1=driver.findElements(By.xpath(selfnode_xpath+"/ancestor::tr/following::*"));
	System.out.println("Ance_Fnode_Size(*) : "+fnod1.size());
	
	List<WebElement> fnod2=driver.findElements(By.xpath(selfnode_xpath+"/ancestor::tr/following::tr"));
	System.out.println("Ance_Fnode_Size(tr) : "+fnod2.size());
	
	
	//following-sibling (Select all siblings after the current node) 
	
    List<WebElement> fsibling=	driver.findElements(By.xpath(selfnode_xpath+"/ancestor::tr/following-sibling::tr"));
    System.out.println("Fsibling : "+ fsibling.size());

    
    //Prceding (Select all nodes appear before the current node in the doocument)
	
    List<WebElement> precd=driver.findElements(By.xpath(selfnode_xpath+"/ancestor::tr/preceding::tr"));
    System.out.println("Preceding nodes : "+precd.size());
    
    //preceding-Sibling (Select all sibling nodes before the current node in the document)
    List<WebElement> precd_sibling=driver.findElements(By.xpath(selfnode_xpath+"/ancestor::tr/preceding-sibling::tr"));
    System.out.println("Preceding_sibling nodes : "+precd_sibling.size());
    
    
	driver.close();
	}

}
