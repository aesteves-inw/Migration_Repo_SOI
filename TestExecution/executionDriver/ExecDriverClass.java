package executionDriver;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import browserManagement.BrowserData;


public class ExecDriverClass {

	//protected static WebDriver driver;

	//@BeforeMethod
	public static WebDriver setupDriver()
	{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", BrowserData.ChromeDriverPath);

		ChromeOptions chromeProfile = new ChromeOptions(); 

		chromeProfile.addArguments("--start-maximized"); 

		chromeProfile.addArguments("chrome.switches","--disable-extensions");

		chromeProfile.addArguments("user-data-dir=" + BrowserData.ChromeProfilePath);

		chromeProfile.addArguments("disable-infobars");

		chromeProfile.addArguments("profile.default_content_settings.popups", "0"); 

		chromeProfile.addArguments("download.prompt_for_download", "false");

		chromeProfile.addArguments("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

		chromeProfile.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		driver = new ChromeDriver(chromeProfile); 

		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 
			driver.manage().addCookie(cookie); 
		}
		return driver;
		
		
	}
	
	

}
