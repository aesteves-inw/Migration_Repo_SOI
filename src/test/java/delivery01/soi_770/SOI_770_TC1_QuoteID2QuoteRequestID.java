package delivery01.soi_770;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
import actions.FunctionalActionsSFDS;
import actions.FunctionalSteps;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceService;

public class SOI_770_TC1_QuoteID2QuoteRequestID {

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
	
	String companyContactPerson="Simple Ordering SevenSeventy";

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
			throw new Exception("Test Failed on Step 1",e);
		}

	}
  
  @Test(dependsOnMethods = "step01")
	public void step02() throws Exception {	
		
		stepsExecuted++;
		
		try
		{
			
			TestStepReportStructure step02 = FunctionalSteps.navigate2CompanyDetails(driver, stepsExecuted, testName);
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
			TestStepReportStructure step03 = FunctionalSteps.createStandardOppie(driver, stepsExecuted, testName, testExecutionString);
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
			
		optyName="OPTY_"+testExecutionString;
		
		String optyElement="//a[@title='"+optyName+"']";
		
		try
		{
			FunctionalActionsSFDS.addProductToOppie(driver, "mobileVoice");
			
			FunctionalActionsSFDS.editProductConfiguration(driver, 1);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.optyTablePool)));
			
			driver.get(driver.findElement(By.xpath(optyElement)).getAttribute("href"));
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	

			if(BrowserActions.isElementPresent(driver, SalesForceOpportunity.optyHeader) && BrowserActions.isElementPresent(driver, SalesForceOpportunity.productContainer))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_OppieValidation");
				TestStepReportStructure step04 = new TestStepReportStructure(stepsExecuted, "Opportunity Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OppieValidation");
				testExecStructure.add(step04);
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_OppieValidation");
			TestStepReportStructure step04 = new TestStepReportStructure(stepsExecuted, "Opportunity Screen Validation", "Validation with success", "Validated with success", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OppieValidation");
			testExecStructure.add(step04);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	@Test(dependsOnMethods = "step04")
	public void step05() throws Exception 
	{	
		stepsExecuted++;
		
		optyURL=driver.getCurrentUrl();
		
		linkAgreementName=SalesForceOpportunity.agreementsContainer.concat("//a[contains(.,'"+optyName+"')]");
		
		try
		{
			FunctionalActionsSFDS.findAgreementOnOPTY(driver, stepsExecuted, linkAgreementName);
			
			if (BrowserActions.isElementPresent(driver, linkAgreementName))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_OpportunityValdiation");
				TestStepReportStructure step05 = new TestStepReportStructure(stepsExecuted, "Generated Agreement on Opportunity validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OpportunityValdiation");
				testExecStructure.add(step05);
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_OpportunityValdiation");
			TestStepReportStructure step05 = new TestStepReportStructure(stepsExecuted, "Generated Agreement on Opportunity validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OpportunityValdiation");
			testExecStructure.add(step05);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	@Test(dependsOnMethods = "step05")
	public void step06() throws Exception 
	{	
		stepsExecuted++;
		
		try
		{
			
			driver.get(driver.findElement(By.xpath(linkAgreementName)).getAttribute("href"));
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
			if(BrowserActions.isElementPresent(driver, SalesForceAgreement.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceAgreement.headerAgreementPage) && BrowserActions.isElementPresent(driver, SalesForceAgreement.detailsAgreement) && BrowserActions.isElementPresent(driver, SalesForceAgreement.nameAgreement))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_AgreementValdiation");
				TestStepReportStructure step06 = new TestStepReportStructure(stepsExecuted, "Generated Agreement validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_AgreementValdiation");
				testExecStructure.add(step06);
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_AgreementValdiation");
			TestStepReportStructure step06 = new TestStepReportStructure(stepsExecuted, "Generated Agreement validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_AgreementValdiation");
			testExecStructure.add(step06);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	@Test(dependsOnMethods = "step06")
	public void step07() throws Exception
	{
		stepsExecuted++;
		
		String file2Upload="SimpleOrdering_Dummy_File";
		
		
		try
		{
		
			FunctionalActionsSFDS.addFile2Agreement(driver, stepsExecuted, file2Upload);
			
			WebElement file = driver.findElement(By.xpath(SalesForceAgreement.filesContainer.concat("//a[contains(.,'"+file2Upload+"')]")));
			
			if (file.isDisplayed())
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_FileUpload");
				TestStepReportStructure step07 = new TestStepReportStructure(stepsExecuted, "File Upload on Agreements Page validation", "Validation with success", "File Updated with success: "+file2Upload, "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_FileUpload");
				testExecStructure.add(step07);
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}

			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_FileUpload");
			TestStepReportStructure step07 = new TestStepReportStructure(stepsExecuted, "File Upload on Agreements Page validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_FileUpload");
			testExecStructure.add(step07);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	
	@Test(dependsOnMethods = "step07")
	public void step08() throws Exception
	{
		stepsExecuted++;
		
		try
		{
			driver.get(optyURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			FunctionalActionsSFDS.closeWonOppie(driver);
			
			FunctionalActionsSFDS.navigate2Order(driver, stepsExecuted, optyName);
			
			if (BrowserActions.isElementPresent(driver, SalesForceOrders.addServiceButton) && BrowserActions.isElementPresent(driver, SalesForceOrders.submitOrderButton) && BrowserActions.isElementPresent(driver, SalesForceOrders.servicesContainer) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderDetails) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderHeader))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_OrderScreenValidation");
				TestStepReportStructure step08 = new TestStepReportStructure(stepsExecuted, "Order Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OrderScreenValidation");
				testExecStructure.add(step08);
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_OrderScreenValidation");
			TestStepReportStructure step08 = new TestStepReportStructure(stepsExecuted, "Order Screen Validation", "Validation with success", "N", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OrderScreenValidation");
			testExecStructure.add(step08);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	@Test(dependsOnMethods = "step08")
	public void step09() throws Exception
	{
		stepsExecuted++;
		
		orderURL=driver.getCurrentUrl();
		
		try
		{
			FunctionalActionsSFDS.addService2Order(driver, stepsExecuted, testName, companyContactPerson);
			
			FunctionalActionsSFDS.navigate2Service(driver, stepsExecuted);
			
			if(BrowserActions.isElementPresent(driver, SalesForceService.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceService.headerServicesPage) && BrowserActions.isElementPresent(driver, SalesForceService.detailsServicePage)  &&  BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceName)  && BrowserActions.isElementPresent(driver, SalesForceService.fieldCase) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDomain) && BrowserActions.isElementPresent(driver, SalesForceService.fieldType) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDetail) && BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesForceService.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SalesForceService.fieldStatus) && BrowserActions.isElementPresent(driver, SalesForceService.fieldQuoteRequestId))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_ServiceScreenValidation");
				TestStepReportStructure step09 = new TestStepReportStructure(stepsExecuted, "Service Screen Validation (SOI-770)", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_ServiceScreenValidation");
				testExecStructure.add(step09);
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_ServiceScreenValidation");
			TestStepReportStructure step09 = new TestStepReportStructure(stepsExecuted, "Service Screen Validation (SOI-770)", "Validation with success", "Not possible to validate.", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_ServiceScreenValidation");
			testExecStructure.add(step09);
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
