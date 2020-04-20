package delivery01.soi_68;

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
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import functionalSteps.SFDS.AgreementSFDS;
import functionalSteps.SFDS.CompanySFDS;
import functionalSteps.SFDS.HomePageSFDS;
import functionalSteps.SFDS.OpportunitySFDS;

public class SOI_68_TC01_OrderCreation_From_OPTYClosure_Won_MobileVoice {

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

		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC1_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));
		
		optyName="OPTY_"+testExecutionString;
	}
  
  @Test
	public void step01() throws Exception {

		stepsExecuted++;

		String userProfile="regularUser";

		try 
		{

			TestStepReportStructure step01 = HomePageSFDS.loginSFDS(driver, testName, stepsExecuted, userProfile);
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

			TestStepReportStructure step02 = HomePageSFDS.navigate2CompanyDetails(driver, stepsExecuted, testName);
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
			TestStepReportStructure step03 = CompanySFDS.createStandardOppie(driver, stepsExecuted, testName, testExecutionString);
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
			TestStepReportStructure step04 = CompanySFDS.configNewMobileOpportunity(driver, wait, testName, testExecutionString, stepsExecuted);
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
			TestStepReportStructure step05 = OpportunitySFDS.soi66Validation(driver, testName, stepsExecuted, optyName);
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
			TestStepReportStructure step06 = OpportunitySFDS.navigate2Agreement(driver, testName, stepsExecuted, optyName);
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
	public void step07() throws Exception 
	{	
		stepsExecuted++;

		try
		{
			String file2Upload="SimpleOrdering_Dummy_File";

			TestStepReportStructure step07 = AgreementSFDS.add1stFileToAgreement(driver, testName, stepsExecuted, file2Upload);
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
	
	@Test(dependsOnMethods = "step07")
	public void step08() throws Exception 
	{	
		stepsExecuted++;
		
		try
		{
			TestStepReportStructure step08 = AgreementSFDS.navigate2Opportunity(driver, testName, stepsExecuted, optyName);
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
			TestStepReportStructure step09 = OpportunitySFDS.closingWonOPTY(driver, stepsExecuted, testName, optyName);
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
			TestStepReportStructure step10 = OpportunitySFDS.soi68Validation(driver, stepsExecuted, testName, optyName);
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
			TestStepReportStructure step11 = OpportunitySFDS.navigate2Order(driver, testName, stepsExecuted, optyName);
			
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
