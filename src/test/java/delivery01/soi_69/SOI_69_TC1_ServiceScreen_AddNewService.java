package delivery01.soi_69;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import functionalSteps.SFDS.StpsSalesHomePage;
import functionalSteps.SFDS.StpsSalesNewContractFlow;
import functionalSteps.SFDS.StpsSalesOpportunity;
import functionalSteps.SFDS.StpsSalesOrder;

public class SOI_69_TC1_ServiceScreen_AddNewService {

	String testName = this.getClass().getSimpleName();

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

	String optyName,linkAgreementName;

	String optyURL, agreementURL, orderURL;

	String companyContactPerson="Simple Ordering SixtyNine";

	@BeforeTest
	public void beforeTest() {

		System.out.println("Test Case: "+testName+" initiation");

		ExecStructure.createReportStructure(testName);

		System.setProperty("webdriver.chrome.driver", TestData.ChromeDriverPath);

		ChromeOptions chromeProfile = new ChromeOptions(); 

		chromeProfile.addArguments("--start-maximized"); 

		chromeProfile.addArguments("chrome.switches","--disable-extensions");

		chromeProfile.addArguments("user-data-dir=" + TestData.ChromeProfilePath);

		chromeProfile.addArguments("disable-infobars");

		chromeProfile.addArguments("profile.default_content_settings.popups", "0"); 

		chromeProfile.addArguments("download.prompt_for_download", "false");

		chromeProfile.addArguments("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

		chromeProfile.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		driver = new ChromeDriver(chromeProfile); 

		wait=new WebDriverWait(driver, 15);

		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 

			driver.manage().addCookie(cookie); 

		}

		
		testExecutionString = ExecStructure.getTestExecutionString(testName);
		

	}

	@Test
	public void step01() throws Exception {

		stepsExecuted++;

		String userProfile="regularUser";

		try 
		{

			TestStepReportStructure step01 = StpsSalesHomePage.loginSFDS(driver, testName, stepsExecuted, userProfile);
			testExecStructure.add(step01);

			if (step01.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step 1",e);
		}

	}

	@Test(dependsOnMethods = "step01")
	public void step02() throws Exception {	

		stepsExecuted++;

		try
		{

			TestStepReportStructure step02 = StpsSalesHomePage.navigate2CompanyDetails(driver, stepsExecuted, testName);
			testExecStructure.add(step02);

			if (step02.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}

	}

	@Test(dependsOnMethods = "step02")
	public void step03() throws Exception {	

		stepsExecuted++;

		try
		{
			TestStepReportStructure step03 = FunctionalSteps.createAndCloseMobileOpportunity(driver, wait, testName, stepsExecuted, testExecutionString);
			testExecStructure.add(step03);

			if (step03.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}

	}


	@Test(dependsOnMethods = "step03")
	public void step04() throws Exception 
	{	
		stepsExecuted++;

		try
		{
			TestStepReportStructure step04 = StpsSalesOpportunity.navigate2Order(driver, testName, stepsExecuted, optyName);
			testExecStructure.add(step04);

			if (step04.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}

	}


	@Test(dependsOnMethods = "step04")
	public void step05() throws Exception 
	{	
		stepsExecuted++;

		try
		{
			TestStepReportStructure step05 = StpsSalesNewContractFlow.addServiceToOrder(driver,wait,stepsExecuted,testName);
			testExecStructure.add(step05);

			if (step05.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}

	@Test(dependsOnMethods = "step05")
	public void step06() throws Exception 
	{
		stepsExecuted++;
		try
		{
			TestStepReportStructure step06 = StpsSalesOrder.nav2Service(driver, testName, stepsExecuted);
			testExecStructure.add(step06);

			if (step06.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}



	@AfterTest
	public void afterTest() {

		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader, testData);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);
	}

}
