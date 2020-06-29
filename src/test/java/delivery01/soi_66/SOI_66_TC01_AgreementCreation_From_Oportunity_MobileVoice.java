package delivery01.soi_66;

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
import functionalSteps.SFDS.StpsSalesCompany;
import functionalSteps.SFDS.StpsSalesHomePage;
import functionalSteps.SFDS.StpsSalesOpportunity;


public class SOI_66_TC01_AgreementCreation_From_Oportunity_MobileVoice {

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
	
	String optyName,linkAgreementName;
	
	String optyURL, agreementURL, orderURL;
	
	String companyContactPerson="Simple Ordering SixtyNine";

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

		wait=new WebDriverWait(driver, 15);

		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 

			driver.manage().addCookie(cookie); 

		}

		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC1_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));
		
		optyName="OPTY_"+testExecutionString;
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
			TestStepReportStructure step03 = StpsSalesCompany.createStandardOppie(driver, stepsExecuted, testName, testExecutionString);
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
			TestStepReportStructure step04 = StpsSalesCompany.configNewMobileOpportunity(driver, wait, testName, testExecutionString, stepsExecuted);
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
			TestStepReportStructure step05 = StpsSalesOpportunity.soi66Validation(driver, testName, stepsExecuted, optyName);
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
			TestStepReportStructure step06 = StpsSalesOpportunity.navigate2Agreement(driver, testName, stepsExecuted, optyName);
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
