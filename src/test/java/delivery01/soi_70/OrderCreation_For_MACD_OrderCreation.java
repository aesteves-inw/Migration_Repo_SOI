package delivery01.soi_70;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actions.BrowserActions;
import actions.FunctionalSteps;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceOrders;

public class OrderCreation_For_MACD_OrderCreation {
	
	private String testName = this.getClass().getName();

	private String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	private long startTime=System.nanoTime();

	public static WebDriver driver = null;

	private List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();

	private String finalTestDate=null;

	private long finishTime;

	private int stepsExecuted;

	private String testExecutionString;


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

		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC13_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));
	}

	@Test
	public void step01() throws Exception {

		String envURL=TestData.searchDT(0, "environmentITTQA");

		try 
		{

			driver.get(envURL);

			TestStepReportStructure step01 = FunctionalSteps.loginSalesForce(driver, 1, "DS", testName);
			testExecStructure.add(step01);

			if (step01.getStepStatus().toLowerCase().contains("failed")) 
			{
				stepsExecuted=1;
				throw new Exception("Validation Failed on Step 1");
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

		try
		{

			TestStepReportStructure step02 = FunctionalSteps.navigate2CompanyDetails(driver, 2, testName);
			testExecStructure.add(step02);

			if (step02.getStepStatus().toLowerCase().contains("failed")) 
			{
				stepsExecuted=2;
				throw new Exception("Validation Failed on Step 2");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step 2",e);
		}
	}

	@Test(dependsOnMethods = "step02")
	public void step03() throws Exception {	

		try
		{
			TestStepReportStructure step03 = FunctionalSteps.createNewMACDOrder(driver, 3, testName, testExecutionString);
			testExecStructure.add(step03);

			if (step03.getStepStatus().toLowerCase().contains("failed")) 
			{
				stepsExecuted=3;
				throw new Exception("Validation Failed on Step 3");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step 3",e);
		}

	}

	@Test(dependsOnMethods = "step03")
	public void step04() throws Exception {	

		//String orderName="Order_"+testExecutionString;

		try
		{
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);


			if(BrowserActions.isElementPresent(driver, SalesForceOrders.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderDetails))
			{
				ExecStructure.screenShotTaking(driver, testName, "4_OrderScreenValidation");
				TestStepReportStructure step04 = new TestStepReportStructure(4, "Order Screen validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "4_OrderScreenValidation");
				testExecStructure.add(step04);
			}
			else
			{
				throw new Exception("Validation Failed on Step 4");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "4_OrderScreenValidation");
			TestStepReportStructure step04 = new TestStepReportStructure(4, "Order Screen validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "4_OrderScreenValidation");
			testExecStructure.add(step04);
			stepsExecuted=4;
			throw new Exception("Test Failed on Step 4",e);

		}
	}

	@AfterTest
	public void afterTest() {

		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		stepsExecuted=4;

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);

	}
}
