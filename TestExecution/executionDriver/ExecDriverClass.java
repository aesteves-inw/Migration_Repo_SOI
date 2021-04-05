package executionDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import browserManagement.BrowserData;
import executionTools.ExecStructure;
import testDataFiles.TestDataFiles;


public class ExecDriverClass {

	//protected static WebDriver driver;

	//@BeforeMethod
	public static WebDriver setupDriver()
	{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", ExecStructure.workingDir+"\\lib\\chromedriver.exe");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		prefs.put("download.default_directory", TestDataFiles.externalFilesRepository);

		ChromeOptions chromeProfile = new ChromeOptions(); 
		
		//chromeProfile.addArguments("--start-maximized");
	
		chromeProfile.addArguments("--headless", "--window-size=1920,1080");

		chromeProfile.addArguments("chrome.switches","--disable-extensions");

		chromeProfile.addArguments("user-data-dir=" + BrowserData.ChromeProfilePath);

		chromeProfile.addArguments("disable-infobars");

		chromeProfile.addArguments("profile.default_content_settings.popups", "0"); 

		chromeProfile.addArguments("download.prompt_for_download", "false");

		chromeProfile.addArguments("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

		chromeProfile.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		chromeProfile.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(chromeProfile); 

		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 
			driver.manage().addCookie(cookie); 
		}
		return driver;
		
		
	}
	
	

}
