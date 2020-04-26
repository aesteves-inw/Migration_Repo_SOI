package delivery01.soi_68;

import java.time.Duration;
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
import functionalSteps.SFPC.StpsPartsCompany;
import functionalSteps.SFPC.StpsPartsHomePage;
import functionalSteps.SFPC.StpsPartsOpportunity;


public class SOI_68_TC8_PC_OrderCreationForNewContract_NegativeValidation_ManualCreation {
 
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
	
	String optyName;
	
	String linkAgreementName;
	
 
  
  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("Test Case: "+testName+" initiation");
	  
	  ExecStructure.createReportStructure(testName);
	  
	  System.setProperty("webdriver.chrome.driver", TestData.ChromeDriverPath);
	  
	  ChromeOptions ChromeProfile = new ChromeOptions(); 

	  ChromeProfile.addArguments("--start-maximized"); 

	  ChromeProfile.addArguments("chrome.switches","--disable-extensions");

	  ChromeProfile.addArguments("user-data-dir=" + TestData.ChromeProfilePath);

	  ChromeProfile.addArguments("disable-infobars");

	  ChromeProfile.addArguments("profile.default_content_settings.popups", "0"); 

	  ChromeProfile.addArguments("download.prompt_for_download", "false");

	  ChromeProfile.addArguments("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		
	  ChromeProfile.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		driver = new ChromeDriver(ChromeProfile); 
		
		wait = new WebDriverWait(driver, 15);

		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 

			driver.manage().addCookie(cookie); 

		}
		
		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC1_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));
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
			TestStepReportStructure step05 = StpsPartsOpportunity.optyProductConfigurationNonMobile(driver, wait, stepsExecuted, testName, testExecutionString);
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
	public void step06() throws Exception {
		
		stepsExecuted++;
		
		try 
		{
			TestStepReportStructure step06 = StpsPartsOpportunity.closeWonOPTY(driver, wait, stepsExecuted, testName);
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
	
	
	@Test(dependsOnMethods = "step06")
	public void step07() throws Exception {
		
		stepsExecuted++;
		
		try
		{
			TestStepReportStructure step07 = StpsPartsOpportunity.negativeSOI68Validation(driver, stepsExecuted, testName, testExecutionString);
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
