package delivery01.soi_721;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
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

public class SOI_721_TC02_OrderTypeValidation_InOrdersListView {

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
			
			TestReportTestData testData01= new TestReportTestData("User",TestData.searchDT(0, "envUsernameNameITTQA"),"Profile",TestData.searchDT(0, "envUserProfileITTQA"));
			testData.add(testData01);

			if (step01.getStepStatus().toLowerCase().contains("failed")) 
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
	
	@Test(dependsOnMethods = "step01")
	public void step02() throws Exception 
	{
		stepsExecuted++;
		
		try
		{
		TestStepReportStructure step02 = FunctionalSteps.go2OrderListView(driver, wait, testName, stepsExecuted);
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
	public void step03() throws Exception 
	{
		stepsExecuted++;
		
		try
		{
			TestStepReportStructure step03 = FunctionalSteps.search4MACDOrders(driver, wait, testName, stepsExecuted);
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
			TestStepReportStructure step04 = FunctionalSteps.navigateToFirstMACDOrder(driver, wait, testName, stepsExecuted);
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
			TestStepReportStructure step05 = FunctionalSteps.orderValidationSOI721(driver, wait, testName, stepsExecuted);
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
	
	@AfterTest
	public void afterTest()
	{

		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader, testData);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);

	}
}
