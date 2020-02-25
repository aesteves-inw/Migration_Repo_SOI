package delivery01.soi_80;

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

public class SOI_80_TC4_MobileOrderIntake_OrderListView_ConfigureListView_AllOrders_ColumnsConfig {

	private String testName = this.getClass().getName();

	private String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	private long startTime=System.nanoTime();

	public static WebDriver driver = null;

	private WebDriverWait wait;

	private List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();
	
	private List<TestReportTestData> testDataReport=new ArrayList<TestReportTestData>();

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

			TestStepReportStructure step01 = FunctionalSteps.loginSalesForce(driver, 1, "DS", testName);
			testExecStructure.add(step01);

			if (step01.getStepStatus().toLowerCase().contains("failed")) 
			{

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

		stepsExecuted++;

		try
		{

			TestStepReportStructure step02 = FunctionalSteps.navigate2OrdersList(driver, 2, testName);
			testExecStructure.add(step02);

			if (step02.getStepStatus().toLowerCase().contains("failed")) 
			{

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

		stepsExecuted++;

		try
		{

			TestStepReportStructure step03 = FunctionalSteps.navigate2AllOrders(driver, 3, testName);
			testExecStructure.add(step03);

			if (step03.getStepStatus().toLowerCase().contains("failed")) 
			{

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

		stepsExecuted++;

		try
		{

			TestStepReportStructure step04 = FunctionalSteps.navigate2SelectFields(driver, 4, testName);
			testExecStructure.add(step04);

			if (step04.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step 4");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step 4",e);
		}
	}

	@Test(dependsOnMethods = "step04")
	public void step05() throws Exception {		

		stepsExecuted++;

		try
		{

			TestStepReportStructure step05 = FunctionalSteps.add3fields(driver, 5, testName, wait);
			testExecStructure.add(step05);

			if (step05.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step 5");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step 5",e);
		}
	}
	
	@Test(dependsOnMethods = "step05")
	public void step06() throws Exception {		

		stepsExecuted++;

		try
		{

			TestStepReportStructure step06 = FunctionalSteps.navigate2SelectFields(driver, 6, testName);
			testExecStructure.add(step06);

			if (step06.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step 6");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step 6",e);
		}
	}
	
	@Test(dependsOnMethods = "step06")
	public void step07() throws Exception {		

		stepsExecuted++;

		try
		{

			TestStepReportStructure step07 = FunctionalSteps.remove3fields(driver, 7, testName, wait);
			testExecStructure.add(step07);

			if (step07.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step 7");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step 7",e);
		}
	}
	
	@Test(dependsOnMethods = "step07")
	public void step08() throws Exception {		

		stepsExecuted++;

		try
		{

			TestStepReportStructure step08 = FunctionalSteps.navigate2SelectFields(driver, 8, testName);
			testExecStructure.add(step08);

			if (step08.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step 8");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step 8",e);
		}
	}

	@Test(dependsOnMethods = "step08")
	public void step09() throws Exception {		

		stepsExecuted++;

		try
		{

			TestStepReportStructure step09 = FunctionalSteps.moveField(driver, 9, testName);
			testExecStructure.add(step09);

			if (step09.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step 9");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step 9",e);
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
