package delivery01.soi_150;

import org.testng.annotations.Test;

import actions.BrowserActions;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceService;
import sfDirectSales.SalesforceNewMACDFlow;
import sfPartnersCommunity.SFPC_Case;
import sfPartnersCommunity.SFPC_Company;
import sfPartnersCommunity.SFPC_HomePage;
import sfPartnersCommunity.SFPC_LoginPage;
import sfPartnersCommunity.SFPC_NewMACDFlow;
import sfPartnersCommunity.SFPC_Orders;
import sfPartnersCommunity.SFPC_Services;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class SOI_150_TC4_PC_MobileOrderIntake_MACD_Flow {
  
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

	String companyContactPerson="Simple Ordering OneFifty";

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

		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 

			driver.manage().addCookie(cookie); 

		}

		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC14_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));

	}

	@Test
	public void step01() throws Exception {
		
		stepsExecuted++;

		String envURL=TestData.searchDT(1, "environmentITTQA");

		String username=TestData.searchDT(1, "envUserNameITTQA");

		String password=TestData.searchDT(1, "envPasswordITTQA");

		try
		{
			driver.get(envURL);

			driver.findElement(By.xpath(SFPC_LoginPage.inputUserame)).sendKeys(username);

			driver.findElement(By.xpath(SFPC_LoginPage.inputPassword)).sendKeys(password);

			driver.findElement(By.xpath(SFPC_LoginPage.loginButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SFPC_HomePage.headerNavigationBar) && BrowserActions.isElementPresent(driver, SFPC_HomePage.quickCreateButton) && BrowserActions.isElementPresent(driver, SFPC_HomePage.inputSearchBar) && BrowserActions.isElementPresent(driver, SFPC_HomePage.dashboard))
			{
				ExecStructure.screenShotTaking(driver, testName, 1+"_LoginScreen");
				TestStepReportStructure step01 = new TestStepReportStructure(1, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 1+"_LoginScreen");
				testExecStructure.add(step01);
				
			}
			else
			{
				throw new Exception("Not possible to perform login on Partners Community");
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, 1+"_LoginScreen");
			TestStepReportStructure step01 = new TestStepReportStructure(1, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 1+"_LoginScreen");
			testExecStructure.add(step01);
			stepsExecuted=1;
			throw new Exception("Test Failed on Step 1",e);

		}

	}
	
	@Test(dependsOnMethods = "step01")
	public void step02() throws Exception {	
		
		stepsExecuted++;
		
		String companyURL=(TestData.searchDT(1, "environmentITTQA")).concat(TestData.searchDT(1, "CompanyDetails")).concat(TestData.tdCompanyID(testName));
		
		try
		{
			driver.get(companyURL);
			
			if(BrowserActions.isElementPresent(driver, SFPC_Company.buttonFollow) && BrowserActions.isElementPresent(driver, SFPC_Company.buttonNewMACDOrder) && BrowserActions.isElementPresent(driver, SFPC_Company.buttonEdit) && BrowserActions.isElementPresent(driver, SFPC_Company.relListNewOPTYButton) && BrowserActions.isElementPresent(driver, SFPC_Company.relListAgreementsLink) && BrowserActions.isElementPresent(driver, SFPC_Company.companyDetails) && BrowserActions.isElementPresent(driver, SFPC_Company.headerCompany))
			{
				ExecStructure.screenShotTaking(driver, testName, 2+"_Navigate2CompDetails");
				TestStepReportStructure step02 = new TestStepReportStructure(2, "Navigation to Company Details", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 2+"_Navigate2CompDetails");
				testExecStructure.add(step02);
			}
			else
			{
				throw new Exception("Not possible to validate Company Details Page on Partners Community");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, 2+"_Navigate2CompDetails");
			TestStepReportStructure step02 = new TestStepReportStructure(2, "Navigation to Company Details", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 2+"_Navigate2CompDetails");
			testExecStructure.add(step02);
			stepsExecuted=2;
			throw new Exception("Test Failed on Step 2",e);
		}
	}
	
	@Test(dependsOnMethods = "step02")
	public void step03() throws Exception {		

		stepsExecuted++;

		try {

			driver.findElement(By.xpath(SalesForceCompany.newMACDOrderButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	

			if (BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.headerNewMACDOrder) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.nextButton) && BrowserActions.isElementPresent(driver, SFPC_NewMACDFlow.newMACDOrderScreen) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputDomain) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputType) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputDetail))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreen");
				TestStepReportStructure step03 = new TestStepReportStructure(stepsExecuted, "New MACD Order Screen", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreen");
				testExecStructure.add(step03);
			}
			else
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreen");
			TestStepReportStructure step03 = new TestStepReportStructure(stepsExecuted, "New MACD Order - First Screen", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreen");
			testExecStructure.add(step03);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}

	}
	
	@Test(dependsOnMethods = "step03")
	public void step04() throws Exception {	
		
		stepsExecuted++;
		
		try 
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputType)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.adminValueType))).click();
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputDetail)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.changeAddressDetailValue))).click();
			
			String vfirstScreenType=driver.findElement(By.xpath(SalesforceNewMACDFlow.inputType)).getAttribute("value");
			
			String vfirstScreenDetail=driver.findElement(By.xpath(SalesforceNewMACDFlow.inputDetail)).getAttribute("value");
			
			if(vfirstScreenType.contains("Administration") && vfirstScreenDetail.contains("Change address"))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreenFS");
				TestStepReportStructure step04 = new TestStepReportStructure(stepsExecuted, "New MACD Order - First Screen", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreenFS");
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
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreenFS");
			TestStepReportStructure step04 = new TestStepReportStructure(stepsExecuted, "New MACD Order - First Screen", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreenFS");
			testExecStructure.add(step04);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	@Test(dependsOnMethods = "step04")
	public void step05() throws Exception {	
		
		stepsExecuted++;
		
		try
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.nextButton)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.secondScreen)));
			
			if(BrowserActions.isElementPresent(driver, SFPC_NewMACDFlow.inputCompanyContactPerson) && BrowserActions.isElementPresent(driver, SFPC_NewMACDFlow.inputServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputComments))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreenSecS");
				TestStepReportStructure step05 = new TestStepReportStructure(stepsExecuted, "New MACD Order - Second Screen", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreenSecS");
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
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreenSecS");
			TestStepReportStructure step05 = new TestStepReportStructure(stepsExecuted, "New MACD Order - Second Screen", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreenSecS");
			testExecStructure.add(step05);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
		
		
	}
	
	@Test(dependsOnMethods = "step05")
	public void step06() throws Exception {	
		
		stepsExecuted++;		
		
		try
		{
			driver.findElement(By.xpath(SFPC_NewMACDFlow.inputCompanyContactPerson)).click();
			
			driver.findElement(By.xpath(SFPC_NewMACDFlow.inputCompanyContactPerson)).sendKeys(companyContactPerson);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'"+companyContactPerson+"')]"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_NewMACDFlow.inputServiceRequestDate))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.calendarTable)));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.todayCalendarButton))).click();
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testName);
			
			//Do Not Remove the following Line
			//FunctionalActionsSFPC.addFile2MACDOrder(driver, stepsExecuted);
			
			String vSecMACDCompCont=driver.findElement(By.xpath(SalesforceNewMACDFlow.secondScreen)).getText().toString();
			String vSecMACDComment=driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).getAttribute("value");
			
			if (vSecMACDCompCont.contains(companyContactPerson) && vSecMACDComment.contains(testName))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreenR4S");
				TestStepReportStructure step06 = new TestStepReportStructure(stepsExecuted, "New MACD Order - Ready for Submission", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreenR4S");
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
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreenR4S");
			TestStepReportStructure step06 = new TestStepReportStructure(stepsExecuted, "New MACD Order - Ready for Submission", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreenR4S");
			testExecStructure.add(step06);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
		
	}
	
	@Test(dependsOnMethods = "step06")
	public void step07() throws Exception {	
		
		stepsExecuted++;
		
		try 
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.submitOrderButton)).click();
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.secondScreen)));
			
			if (BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.headerNewMACDOrder))
			{
				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}
			else
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreenSubmitted");
				TestStepReportStructure step07 = new TestStepReportStructure(stepsExecuted, "New MACD Order - Order Submitted", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreenSubmitted");
				testExecStructure.add(step07);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_NewMACDScreenSubmitted");
			TestStepReportStructure step07 = new TestStepReportStructure(stepsExecuted, "New MACD Order - Order Submitted", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_NewMACDScreenSubmitted");
			testExecStructure.add(step07);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	@Test(dependsOnMethods = "step07")
	public void step08() throws Exception {	
		
		stepsExecuted++;
		
		try
		{
			WebElement ordersContainer = driver.findElement(By.xpath(SalesForceCompany.articleOrders));
			
			if (ordersContainer.isDisplayed() == false)
			{
				BrowserActions.verticalscrollByVisibleElement(driver, SalesForceCompany.articleOrders);
			}
			
			driver.findElement(By.xpath(SFPC_Company.firstOrderLink)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
			
			if (BrowserActions.isElementPresent(driver, SalesForceOrders.servicesContainer) && BrowserActions.isElementPresent(driver, SFPC_Orders.orderDetails) && BrowserActions.isElementPresent(driver, SFPC_Orders.headerOrderDetail))
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
			TestStepReportStructure step08 = new TestStepReportStructure(stepsExecuted, "Order Screen Validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OrderScreenValidation");
			testExecStructure.add(step08);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	@Test(dependsOnMethods = "step08")
	public void step09() throws Exception {	
		
		stepsExecuted++;
		
		try
		{
			driver.findElement(By.xpath(SFPC_Orders.firstServiceLink)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);		
			
			if(BrowserActions.isElementPresent(driver, SalesForceService.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceService.headerServicesPage) && BrowserActions.isElementPresent(driver, SalesForceService.detailsServicePage)  &&  BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceName) && BrowserActions.isElementPresent(driver, SalesForceService.fieldCase) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDomain) && BrowserActions.isElementPresent(driver, SalesForceService.fieldType) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDetail) && BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesForceService.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SalesForceService.fieldStatus))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_ServiceScreenValidation");
				TestStepReportStructure step09 = new TestStepReportStructure(stepsExecuted, "Service Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_ServiceScreenValidation");
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
			TestStepReportStructure step09 = new TestStepReportStructure(stepsExecuted, "Service Screen Validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_ServiceScreenValidation");
			testExecStructure.add(step09);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
		
	}
	
	@Test(dependsOnMethods = "step09")
	public void step10() throws Exception {	
		
		stepsExecuted++;
		
		try
		{
			driver.findElement(By.xpath(SFPC_Services.caseLink)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if (BrowserActions.isElementPresent(driver, SFPC_Case.caseInformation) && BrowserActions.isElementPresent(driver, SFPC_Case.caseCategorization) && BrowserActions.isElementPresent(driver, SFPC_Case.additionalInformation) && BrowserActions.isElementPresent(driver, SFPC_Case.linkRelated))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_CaseScreenValidation");
				TestStepReportStructure step10 = new TestStepReportStructure(stepsExecuted, "Case Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_CaseScreenValidation");
				testExecStructure.add(step10);
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
			TestStepReportStructure step10 = new TestStepReportStructure(stepsExecuted, "Case Screen Validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_CaseScreenValidation");
			testExecStructure.add(step10);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
		
	}
	
	@AfterTest
	public void afterTest() throws Exception {

		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader,testData);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);
	}

}
