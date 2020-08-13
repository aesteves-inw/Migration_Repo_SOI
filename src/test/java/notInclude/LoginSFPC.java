package notInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actions.BrowserActions;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfPartnersCommunity.SFPC_HomePage;
import sfPartnersCommunity.SFPC_LoginPage;

public class LoginSFPC {

	private String testName = this.getClass().getName();

	private String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	private long startTime=System.nanoTime();

	public static WebDriver driver = null;

	private List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();
	
	private List<TestReportTestData> testDataReport= new ArrayList<TestReportTestData>();

	private String finalTestDate=null;

	private long finishTime;

	private int stepsExecuted;

	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Test Case: "+testName+" initiation");

		ExecStructure.createReportStructure(testName);

		System.setProperty("webdriver.chrome.driver", TestData.ChromeDriverPath);

		ChromeOptions Chrome_Profile = new ChromeOptions(); 

		Chrome_Profile.addArguments("--start-maximized"); 

		Chrome_Profile.addArguments("chrome.switches","--disable-extensions");

		Chrome_Profile.addArguments("user-data-dir=" + TestData.ChromeProfilePath);

		Chrome_Profile.addArguments("disable-infobars");

		Chrome_Profile.addArguments("profile.default_content_settings.popups", "0"); 

		Chrome_Profile.addArguments("download.prompt_for_download", "false");

		Chrome_Profile.addArguments("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

		driver = new ChromeDriver(Chrome_Profile); 
		
		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 

			driver.manage().addCookie(cookie); 

		}

	}

	@Test
	public void step01() throws Exception {
		
		stepsExecuted++;

		String envURL=TestData.searchDT(1, "environmentITTQA");

		String username=TestData.searchDT(1, "envUserNameITTQA");

		String password=TestData.searchDT(1, "envPasswordITTQA");

		try
		{
			driver.get(envURL);

			driver.findElement(By.xpath(SFPC_LoginPage.inputUserame)).sendKeys(username);

			driver.findElement(By.xpath(SFPC_LoginPage.inputPassword)).sendKeys(password);

			driver.findElement(By.xpath(SFPC_LoginPage.loginButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SFPC_HomePage.headerNavigationBar) && BrowserActions.isElementPresent(driver, SFPC_HomePage.quickCreateButton) && BrowserActions.isElementPresent(driver, SFPC_HomePage.inputSearchBar) && BrowserActions.isElementPresent(driver, SFPC_HomePage.dashboard))
			{
				ExecStructure.screenShotTaking(driver, testName, 1+"_LoginScreen");
				TestStepReportStructure step01 = new TestStepReportStructure(1, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 1+"_LoginScreen");
				testExecStructure.add(step01);
			}
			else
			{
				throw new Exception("Not possible to perform login on Partners Community");
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, 1+"_LoginScreen");
			TestStepReportStructure step01 = new TestStepReportStructure(1, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 1+"_LoginScreen");
			testExecStructure.add(step01);
			stepsExecuted++;
			throw new Exception("Test Failed on Step 1",e);

		}
	}


	@AfterTest
	public void afterTest() {
		
		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader, testDataReport);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);
	}
	
}
