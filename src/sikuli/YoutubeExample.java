package sikuli;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class YoutubeExample {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_108//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.get("https://www.youtube.com/watch?v=CHSnz0bCaUk&t=2s");
		 Thread.sleep(2000);
		 
		 String patternimapge_commonpath="G:\\Software\\Sikuli\\sikuli_screenshot\\";
		 
		 
		 Pattern skipadd=new Pattern(patternimapge_commonpath+"youtybeskipadd.jpg");
		 Pattern youtubeplay=new Pattern(patternimapge_commonpath+"youtubeplay.png");
		 Pattern youtubepause=new Pattern(patternimapge_commonpath+"youtubepause.png");
		 Pattern youtubesetting=new Pattern(patternimapge_commonpath+"youtubesetting.png");
		 Pattern youtubequality=new Pattern(patternimapge_commonpath+"youtubequality.png");
		 Pattern youtube260p=new Pattern(patternimapge_commonpath+"youtube260p.jpg");
		 
		 Screen s=new Screen();
		 
		// s.wait(skipadd, 6);
		// s.click(skipadd);
		 s.click(youtubeplay);
		 s.click(youtubepause);
		 s.click(youtubeplay);
		 
		 s.click(youtubesetting);
		 s.click(youtubequality);
		 s.wait(youtube260p,5);
		 s.click(youtube260p);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		

	}

}
