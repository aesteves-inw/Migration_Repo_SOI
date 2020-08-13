package delivery01.soi_68;

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
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import functionalSteps.SFPC.StpsPartsAgreement;
import functionalSteps.SFPC.StpsPartsCompany;
import functionalSteps.SFPC.StpsPartsHomePage;
import functionalSteps.SFPC.StpsPartsOpportunity;

public class SOI_68_TC5_PC_OrderCreation_From_OPTYClosure_Won_MobileVoice {

	private String testName = this.getClass().getName();

	private String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	private long startTime=System.nanoTime();

	public static WebDriver driver = null;

	private List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();

	List<TestReportTestData> testData = new ArrayList<TestReportTestData>();

	private String finalTestDate=null;

	private long finishTime;

	private int stepsExecuted;

	private String testExecutionString;

	private WebDriverWait wait;


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

		wait = new WebDriverWait(driver, 15);

		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 

			driver.manage().addCookie(cookie); 

		}

		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC4PC_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));
	}

	@Test
	public void step01() throws Exception {

		stepsExecuted++;

		try 
		{
			TestStepReportStructure step01 = StpsPartsHomePage.loginSFPC(driver, stepsExecuted, testName);
			testExecStructure.add(step01);

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
	public void step02() throws Exception {

		stepsExecuted++;

		try 
		{
			TestStepReportStructure step02 = StpsPartsHomePage.navigate2CompDetailsPC(driver, testName, stepsExecuted, testExecutionString);
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
			TestStepReportStructure step03 = StpsPartsCompany.createNewOpportunity(driver, wait, stepsExecuted, testName, testExecutionString);
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
	public void step04() throws Exception {

		stepsExecuted++;

		try 
		{
			TestStepReportStructure step04 = StpsPartsOpportunity.opportunityAddProductScreen(driver, wait, stepsExecuted, testName, testExecutionString);
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
	public void step05() throws Exception {

		stepsExecuted++;

		try 
		{
			TestStepReportStructure step06 = StpsPartsOpportunity.optyProductConfiguration(driver, wait, stepsExecuted, testName, testExecutionString);
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

	@Test(dependsOnMethods = "step05")
	public void step06() throws Exception {

		stepsExecuted++;

		try 
		{
			TestStepReportStructure step07 = StpsPartsOpportunity.soi66validation(driver, wait, testName, stepsExecuted, testExecutionString);
			testExecStructure.add(step07);

			if (step07.getStepStatus().toLowerCase().contains("failed")) 
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

	@Test(dependsOnMethods = "step06")
	public void step07() throws Exception {

		stepsExecuted++;

		try 
		{
			TestStepReportStructure step08 = StpsPartsAgreement.agreementValidation(driver, stepsExecuted, testName, testExecutionString);
			testExecStructure.add(step08);

			if (step08.getStepStatus().toLowerCase().contains("failed")) 
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

	@Test(dependsOnMethods = "step07")
	public void step08() throws Exception 
	{
		stepsExecuted++;

		try 
		{
			TestStepReportStructure step08 = StpsPartsAgreement.addFile2Agreement(driver, stepsExecuted, testName);
			testExecStructure.add(step08);

			if (step08.getStepStatus().toLowerCase().contains("failed")) 
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


	@Test(dependsOnMethods = "step08")
	public void step09() throws Exception 
	{
		stepsExecuted++;
		
		try
		{	
			TestStepReportStructure step09 = StpsPartsAgreement.goToOpportunityScreen(driver, stepsExecuted, testName, testExecutionString);
			testExecStructure.add(step09);
			
			if (step09.getStepStatus().toLowerCase().contains("failed")) 
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
	
	
	@Test(dependsOnMethods = "step09")
	public void step10() throws Exception 
	{
		stepsExecuted++;
		
		try
		{
			TestStepReportStructure step10 = StpsPartsOpportunity.closeWonOPTY(driver, wait, stepsExecuted, testName);
			testExecStructure.add(step10);
			
			if (step10.getStepStatus().toLowerCase().contains("failed")) 
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
	
	@Test(dependsOnMethods = "step10")
	public void step11() throws Exception
	{
		stepsExecuted++;
		
		try
		{
			TestStepReportStructure step11 = StpsPartsOpportunity.soi68validation(driver, stepsExecuted, testName, testExecutionString);
			testExecStructure.add(step11);
			
			if (step11.getStepStatus().toLowerCase().contains("failed")) 
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
