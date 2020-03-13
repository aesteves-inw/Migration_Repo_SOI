package delivery01.soi_880;

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
import functionalSteps.SFDS.CaseSFDS;
import functionalSteps.SFDS.CompanySFDS;
import functionalSteps.SFDS.HomePageSFDS;
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceService;
import sfDirectSales.SalesforceCase;

public class SOI_880_TC01_CaseRouting_NewContractFlow {

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
	
	String optyURL; 
	
	String agreementURL; 
	
	String orderURL; 
	
	String caseURL;
	
	String companyContactPerson="Simple Ordering EightEighty";

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

		wait=new WebDriverWait(driver, 20);

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
				ExecStructure.screenShotTaking(driver, testName, "5_OpportunityValdiation");
				TestStepReportStructure step05 = new TestStepReportStructure(5, "Generated Agreement on Opportunity validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "5_OpportunityValdiation");
				testExecStructure.add(step05);
			}
			else
			{
				throw new Exception("Validation Failed on Step 05");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "5_OpportunityValdiation");
			TestStepReportStructure step05 = new TestStepReportStructure(5, "Generated Agreement on Opportunity validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "5_OpportunityValdiation");
			testExecStructure.add(step05);
			throw new Exception("Test Failed on Step 5",e);
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
				ExecStructure.screenShotTaking(driver, testName, "6_AgreementValdiation");
				TestStepReportStructure step06 = new TestStepReportStructure(6, "Generated Agreement validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "6_AgreementValdiation");
				testExecStructure.add(step06);
			}
			else
			{
				throw new Exception("Validation Failed on Step 06");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "6_AgreementValdiation");
			TestStepReportStructure step06 = new TestStepReportStructure(6, "Generated Agreement validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "6_AgreementValdiation");
			testExecStructure.add(step06);
			throw new Exception("Test Failed on Step 6",e);
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
				ExecStructure.screenShotTaking(driver, testName, "7_FileUpload");
				TestStepReportStructure step07 = new TestStepReportStructure(7, "File Upload on Agreements Page validation", "Validation with success", "File Updated with success: "+file2Upload, "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "7_FileUpload");
				testExecStructure.add(step07);
			}
			else
			{
				throw new Exception("Validation Failed on Step 07");
			}

			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "7_FileUpload");
			TestStepReportStructure step07 = new TestStepReportStructure(7, "File Upload on Agreements Page validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "7_FileUpload");
			testExecStructure.add(step07);
			throw new Exception("Test Failed on Step 7",e);
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
				ExecStructure.screenShotTaking(driver, testName, "8_OrderScreenValidation");
				TestStepReportStructure step08 = new TestStepReportStructure(8, "Order Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "8_OrderScreenValidation");
				testExecStructure.add(step08);
			}
			else
			{
				throw new Exception("Validation Failed on Step 08");
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "8_OrderScreenValidation");
			TestStepReportStructure step08 = new TestStepReportStructure(8, "Order Screen Validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "8_OrderScreenValidation");
			testExecStructure.add(step08);
			throw new Exception("Test Failed on Step 8",e);
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
			
			if(BrowserActions.isElementPresent(driver, SalesForceService.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceService.headerServicesPage) && BrowserActions.isElementPresent(driver, SalesForceService.detailsServicePage)  &&  BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceName)  && BrowserActions.isElementPresent(driver, SalesForceService.fieldCase) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDomain) && BrowserActions.isElementPresent(driver, SalesForceService.fieldType) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDetail) && BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesForceService.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SalesForceService.fieldStatus))
			{
				ExecStructure.screenShotTaking(driver, testName, "9_ServiceScreenValidation");
				TestStepReportStructure step09 = new TestStepReportStructure(9, "Service Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "9_ServiceScreenValidation");
				testExecStructure.add(step09);
			}
			else
			{
				throw new Exception("Validation Failed on Step 09");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "9_ServiceScreenValidation");
			TestStepReportStructure step09 = new TestStepReportStructure(9, "Service Screen Validation", "Validation with success", "Not possible to validate.", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "9_ServiceScreenValidation");
			testExecStructure.add(step09);
			throw new Exception("Test Failed on Step 9",e);
		}
		
	}
	
	@Test(dependsOnMethods = "step09")
	public void step10() throws Exception
	{
		stepsExecuted++;
		
		String ordersLinkXpath=SalesForceOrders.serviceContainer.concat("//a[contains(.,'Mobile')]");
		
		try
		{
			driver.get(orderURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
			
			if(BrowserActions.isElementPresent(driver, ordersLinkXpath))
			{
				ExecStructure.screenShotTaking(driver, testName, "10_ServiceinOrderScreenValidation");
				TestStepReportStructure step10 = new TestStepReportStructure(10, "Service in Order Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "10_ServiceinOrderScreenValidation");
				testExecStructure.add(step10);
			}
			else
			{
				throw new Exception("Validation Failed on Step 10");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "10_ServiceinOrderScreenValidation");
			TestStepReportStructure step10 = new TestStepReportStructure(10, "Service in Order Screen Validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "10_ServiceinOrderScreenValidation");
			testExecStructure.add(step10);
			throw new Exception("Test Failed on Step 10",e);
		}
	}
	
	@Test(dependsOnMethods = "step10")
	public void step11() throws Exception
	{
		stepsExecuted++;
		
		try
		{
			driver.findElement(By.xpath(SalesForceOrders.submitOrderButton)).click();
			
			if (BrowserActions.isElementPresent(driver, SalesForceOrders.orderSubmittedSuccess))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_OrderSubmission");
				TestStepReportStructure step11 = new TestStepReportStructure(stepsExecuted, "Order Submission", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OrderSubmission");
				testExecStructure.add(step11);
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_OrderSubmission");
			TestStepReportStructure step11 = new TestStepReportStructure(stepsExecuted, "Order Submission", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OrderSubmission");
			testExecStructure.add(step11);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
		
	}
	
	@Test(dependsOnMethods = "step11")
	public void step12() throws Exception
	{
		stepsExecuted++;
		
		
		try
		{
			
			String serviceLink=driver.findElement(By.xpath(SalesForceOrders.firstServiceLink)).getAttribute("href");
			
			driver.get(serviceLink);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);		

			if(BrowserActions.isElementPresent(driver, SalesForceService.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceService.headerServicesPage) && BrowserActions.isElementPresent(driver, SalesForceService.detailsServicePage)  &&  BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceName)  && BrowserActions.isElementPresent(driver, SalesForceService.fieldCase) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDomain) && BrowserActions.isElementPresent(driver, SalesForceService.fieldType) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDetail) && BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesForceService.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SalesForceService.fieldStatus))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_ServiceScreenValidation");
				TestStepReportStructure step12 = new TestStepReportStructure(stepsExecuted, "Service Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_ServiceScreenValidation");
				testExecStructure.add(step12);
				testData.add(new TestReportTestData("Service",driver.findElement(By.xpath("//h1//lightning-formatted-text")).getAttribute("value"),"URL",serviceLink));
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_ServiceAfterSubmission");
			TestStepReportStructure step12 = new TestStepReportStructure(stepsExecuted, "Service after Submission", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_ServiceAfterSubmission");
			testExecStructure.add(step12);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	@Test(dependsOnMethods = "step12")
	public void step13() throws Exception
	{
		stepsExecuted++;
		
		try
		{
			WebElement caseLink= driver.findElement(By.xpath(SalesForceService.caseLink));
			
			caseLink.click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			
			
			if (BrowserActions.isElementPresent(driver, SalesforceCase.keyDetailsArticle) && BrowserActions.isElementPresent(driver, SalesforceCase.filesContainer))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_CaseScreenValidation");
				TestStepReportStructure step13 = new TestStepReportStructure(stepsExecuted, "Case Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_CaseScreenValidation");
				testExecStructure.add(step13);
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_CaseScreenValidation");
			TestStepReportStructure step13 = new TestStepReportStructure(stepsExecuted, "Case Screen Validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_CaseScreenValidation");
			testExecStructure.add(step13);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}		
	}
	
	@Test(dependsOnMethods = "step13")
	public void step14() throws Exception
	{
		stepsExecuted++;
		
		try
		{
			TestStepReportStructure step14 = CaseSFDS.caseValidationBySOI880(driver, testName, stepsExecuted);
			testExecStructure.add(step14);
			

			if (step14.getStepStatus().toLowerCase().contains("failed")) 
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
  public void afterTest(){
	  
		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader, testData);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);
  }
	
}
