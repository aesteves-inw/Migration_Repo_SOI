package notInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actions.BrowserActions;
import actions.FunctionalSteps;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;

public class TestingMACDJSQuery {

	String testName = this.getClass().getName();

	String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	long startTime=System.nanoTime();

	WebDriver driver = null;

	WebDriverWait wait;

	List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();
	
	List<TestReportTestData> testData = new ArrayList<TestReportTestData>();

	String finalTestDate=null;

	long finishTime;

	int stepsExecuted;

	String testExecutionString;

	String companyContactPerson="Simple Ordering SeventySix";
	
	String oppiename, generatedAgreement, productsLinkView;
	
	
	
	
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
		
		wait=new WebDriverWait(driver, 15);

		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 

			driver.manage().addCookie(cookie); 

		}

		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC14_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));

	}
	
	

	@Test
	public void step01() throws Exception {
		
		stepsExecuted++;

		String envURL=TestData.searchDT(0, "environmentITTQA");
		

		try 
		{

			driver.get(envURL);

			TestStepReportStructure step01 = FunctionalSteps.loginSalesForce(driver, stepsExecuted, "DS", testName);
			testExecStructure.add(step01);
			

			if (step01.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, 1+"_LoginScreen");
			TestStepReportStructure step01 = new TestStepReportStructure(1, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 1+"_LoginScreen");
			testExecStructure.add(step01);
			stepsExecuted=1;
			throw new Exception("Test Failed on Step "+stepsExecuted,e);

		}

	}
	
	@Test(dependsOnMethods = "step01")
	public void step02() throws Exception
	{
		try 
		{
			
			driver.get("https://proximusitqa--prxittqa.lightning.force.com/lightning/r/Opportunity/0063E000007A4EeQAK/view");

			Thread.sleep(5000);
			
			//String queryString = "return document.querySelector('one-record-home-flexipage2').shadowRoot.querySelector('forcegenerated-flexipage_company_record_page_account__view_js').shadowRoot.querySelector('records-lwc-highlights-panel').shadowRoot.querySelector('records-lwc-record-layout').shadowRoot.querySelector('forcegenerated-highlightspanel_account___012000000000000aaa___compact___view___recordlayout2').shadowRoot.querySelector('force-highlights2').shadowRoot.querySelectorAll('li.slds-button.slds-button--neutral.slds-truncate')[1]";
			
			//String queryString = "return document.querySelector('one-record-home-flexipage2').shadowRoot.querySelector('forcegenerated-flexipage_opportunity_record_page3_opportunity__view_js').shadowRoot.querySelectorAll('flexipage-aura-wrapper')[0].shadowRoot.querySelectorAll('a.tabHeader.slds-path__link')[6]";
			
			String queryString = "return document.querySelector('one-record-home-flexipage2').shadowRoot.querySelector('forcegenerated-flexipage_opportunity_record_page3_opportunity__view_js').shadowRoot.querySelectorAll('flexipage-aura-wrapper')[0].shadowRoot.querySelectorAll('span.title.slds-path__title')[6]";
					
			wait.until(ExpectedConditions.visibilityOf((WebElement) ((JavascriptExecutor)driver).executeScript(queryString)));
			
			WebElement element = (WebElement) ((JavascriptExecutor)driver).executeScript(queryString);
			
			//Thread.sleep(1000);
			
			element.click();
			
			System.out.println("PASSA CONAÇA!");
			
		}
		catch(Exception e)
		{
			System.out.println("PENALTY CARALHO!");
			System.out.println(e);
		}
	}
	
	@AfterTest
	public void afterTest() {

		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader, testData);

		System.out.println("Test Case: "+testName+" completion");

		//BrowserActions.endSession(driver);

	}
}
