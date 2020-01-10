package delivery01.soi_69;

import org.testng.annotations.Test;

import actions.BrowserActions;
import actions.FunctionalActionsSFDS;
import actions.FunctionalSteps;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceService;

import org.testng.annotations.BeforeTest;

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

public class ServiceScreen_AddNewService_CreateMoreThenOneSerivice {


	String testName = this.getClass().getName();

	String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	long startTime=System.nanoTime();

	WebDriver driver = null;

	WebDriverWait wait;

	List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();

	String finalTestDate=null;

	long finishTime;

	int stepsExecuted;

	String testExecutionString;

	String optyName;

	public String linkAgreementName;

	public String optyURL;

	public String orderURL;
	
	public String ordersLinkXpath;


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

		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC16_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));
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

			TestStepReportStructure step02 = FunctionalSteps.navigate2CompanyDetails(driver, 2, testName);
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
			TestStepReportStructure step03 = FunctionalSteps.createStandardOppie(driver, 3, testName, testExecutionString);
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

		optyName="OPTY_"+testExecutionString;

		try
		{
			FunctionalActionsSFDS.addProductToOppie(driver, "mobileVoice");

			FunctionalActionsSFDS.editProductConfiguration(driver, 1);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(optyName))).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesForceOpportunity.optyHeader) && BrowserActions.isElementPresent(driver, SalesForceOpportunity.productContainer))
			{
				ExecStructure.screenShotTaking(driver, testName, "4_OppieValidation");
				TestStepReportStructure step04 = new TestStepReportStructure(4, "Opportunity Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "4_OppieValidation");
				testExecStructure.add(step04);
			}
			else
			{
				throw new Exception("Validation Failed on Step 04");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "4_OppieValidation");
			TestStepReportStructure step04 = new TestStepReportStructure(4, "Opportunity Screen Validation", "Validation with success", "Validated with success", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "4_OppieValidation");
			testExecStructure.add(step04);
			throw new Exception("Test Failed on Step 4",e);
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
			BrowserActions.verticalscrollByVisibleElement(driver, SalesForceOpportunity.agreementsContainer);

			if (BrowserActions.isElementPresent(driver, linkAgreementName))
			{
				ExecStructure.screenShotTaking(driver, testName, "5_OpportunityValdiation");
				TestStepReportStructure step05 = new TestStepReportStructure(5, "Generated Opportunity validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "5_OpportunityValdiation");
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
			TestStepReportStructure step05 = new TestStepReportStructure(5, "Generated Opportunity validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "5_OpportunityValdiation");
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
			driver.findElement(By.xpath(linkAgreementName)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);		


			if(BrowserActions.isElementPresent(driver, SalesForceAgreement.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceAgreement.editButton) && BrowserActions.isElementPresent(driver, SalesForceAgreement.headerAgreementPage) && BrowserActions.isElementPresent(driver, SalesForceAgreement.detailsAgreement) && BrowserActions.isElementPresent(driver, SalesForceAgreement.nameAgreement))
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
			TestStepReportStructure step08 = new TestStepReportStructure(8, "Order Screen Validation", "Validation with success", "N", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "8_OrderScreenValidation");
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
			FunctionalActionsSFDS.addService2Order(driver, stepsExecuted);

			if(BrowserActions.isElementPresent(driver, SalesForceService.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceService.headerServicesPage) && BrowserActions.isElementPresent(driver, SalesForceService.detailsServicePage)  &&  BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceName)  && BrowserActions.isElementPresent(driver, SalesForceService.fieldQuote) && BrowserActions.isElementPresent(driver, SalesForceService.fieldCase) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDomain) && BrowserActions.isElementPresent(driver, SalesForceService.fieldType) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDetail) && BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesForceService.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SalesForceService.fieldStatus))
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

		ordersLinkXpath=SalesForceOrders.serviceContainer.concat("//a[contains(.,'Mobile')]");

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
			FunctionalActionsSFDS.addService2Order(driver, stepsExecuted);
			
			if(BrowserActions.isElementPresent(driver, SalesForceService.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceService.headerServicesPage) && BrowserActions.isElementPresent(driver, SalesForceService.detailsServicePage)  &&  BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceName)  && BrowserActions.isElementPresent(driver, SalesForceService.fieldQuote) && BrowserActions.isElementPresent(driver, SalesForceService.fieldCase) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDomain) && BrowserActions.isElementPresent(driver, SalesForceService.fieldType) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDetail) && BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesForceService.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SalesForceService.fieldStatus))
			{
				ExecStructure.screenShotTaking(driver, testName, "11_ServiceScreenValidation");
				TestStepReportStructure step011 = new TestStepReportStructure(11, "Service Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "11_ServiceScreenValidation");
				testExecStructure.add(step011);
			}
			else
			{
				throw new Exception("Validation Failed on Step 011");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "11_ServiceScreenValidation");
			TestStepReportStructure step011 = new TestStepReportStructure(11, "Service Screen Validation", "Validation with success", "Not possible to validate.", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "11_ServiceScreenValidation");
			testExecStructure.add(step011);
			throw new Exception("Test Failed on Step 11",e);
		}
	}
	
	@Test(dependsOnMethods = "step11")
	public void step12() throws Exception
	{
		stepsExecuted++;
		
		
		
		try
		{
			driver.get(orderURL);

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
			
			List<WebElement> servicesList = driver.findElements(By.xpath(ordersLinkXpath));
			
			if (servicesList.size() > 1)
			{
				ExecStructure.screenShotTaking(driver, testName, "12_ServiceinOrderScreenValidation");
				TestStepReportStructure step12 = new TestStepReportStructure(12, "Services in Order Screen Validation", "Validation with success", "Validated with success. Counted Services: "+servicesList, "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "12_ServiceinOrderScreenValidation");
				testExecStructure.add(step12);
			}
			else
			{
				throw new Exception("Validation Failed on Step 012");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "12_ServiceinOrderScreenValidation");
			TestStepReportStructure step12 = new TestStepReportStructure(12, "Services in Order Screen Validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "12_ServiceinOrderScreenValidation");
			testExecStructure.add(step12);
			throw new Exception("Test Failed on Step 12",e);
		}
	}

	@AfterTest
	public void afterTest() {

		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);

	}

}
