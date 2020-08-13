package delivery01.soi_880;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
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
import functionalSteps.SFDS.HomePageSFDS;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceService;
import sfDirectSales.SalesforceCase;
import sfDirectSales.SalesforceNewMACDFlow;

public class SOI_880_TC03_CaseRouting_MACD {

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

			TestStepReportStructure step02 = HomePageSFDS.navigate2CompanyDetails(driver, stepsExecuted, testName);
			testExecStructure.add(step02);
			
			testData.add(new TestReportTestData("Company", TestData.tdCompanyName(testName), "URL", driver.getCurrentUrl()));
			

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

		try {

			driver.findElement(By.xpath(SalesForceCompany.newMACDOrderButton)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.newMACDOrderScreen)));

			if (BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.headerNewMACDOrder) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.nextButton) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.newMACDOrderScreen) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputDomain) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputType) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputDetail))
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
			
			if(BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputCompanyContactPerson) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputComments) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.uploadFilesButton))
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
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).click();
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).sendKeys(companyContactPerson);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'"+companyContactPerson+"')]"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.calendarTable)));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.todayCalendarButton))).click();
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate))).sendKeys(ExecStructure.todaysformattedDateddMMMyyyy());
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testName);
			
			FunctionalActionsSFDS.addFile2MACDOrder(driver, stepsExecuted, "SimpleOrdering_Dummy_File");
			
			testData.add(new TestReportTestData("File","SimpleOrdering_Dummy_File.pdf","File Name","Not Applicable"));
			
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
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.submitOrderButton)));
			
			if (BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.secondScreen))
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
			//Rebuild Step 8
			
			BrowserActions.verticalScrollByPixs(driver, 250);
			
			String orderlink=driver.findElement(By.xpath(SalesForceCompany.firstOrderLink)).getAttribute("href");
			
			driver.get(orderlink);
			
			//End of Rebuild
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if (BrowserActions.isElementPresent(driver, SalesForceOrders.servicesContainer) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderDetails) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderHeader))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_OrderScreenValidation");
				TestStepReportStructure step08 = new TestStepReportStructure(stepsExecuted, "Order Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_OrderScreenValidation");
				testExecStructure.add(step08);
				testData.add(new TestReportTestData("Order",driver.findElement(By.xpath("//h1//lightning-formatted-text")).getAttribute("value"),"URL",orderlink));
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
			String serviceLink=driver.findElement(By.xpath(SalesForceOrders.firstServiceLink)).getAttribute("href");
			
			driver.get(serviceLink);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);		
			
			if(BrowserActions.isElementPresent(driver, SalesForceService.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceService.headerServicesPage) && BrowserActions.isElementPresent(driver, SalesForceService.detailsServicePage)  &&  BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceName)  && BrowserActions.isElementPresent(driver, SalesForceService.fieldCase) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDomain) && BrowserActions.isElementPresent(driver, SalesForceService.fieldType) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDetail) && BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesForceService.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SalesForceService.fieldStatus))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_ServiceScreenValidation");
				TestStepReportStructure step09 = new TestStepReportStructure(stepsExecuted, "Service Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_ServiceScreenValidation");
				testExecStructure.add(step09);
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
			
			String caseLink=driver.findElement(By.xpath(SalesForceService.caseLink)).getAttribute("href");
			
			driver.get(caseLink);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if (BrowserActions.isElementPresent(driver, SalesforceCase.keyDetailsArticle) && BrowserActions.isElementPresent(driver, SalesforceCase.filesContainer))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_CaseScreenValidation");
				TestStepReportStructure step10 = new TestStepReportStructure(stepsExecuted, "Case Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_CaseScreenValidation");
				testExecStructure.add(step10);
				testData.add(new TestReportTestData("Case",driver.findElement(By.xpath("//h1//lightning-formatted-text")).getAttribute("value"),"URL",caseLink));
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
	
	@Test(dependsOnMethods = "step10")
	public void step11() throws Exception 
	{	
		stepsExecuted++;
		
		try
		{
			TestStepReportStructure step11 = CaseSFDS.caseValidationBySOI880(driver, testName, stepsExecuted);
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
	public void afterTest(){

		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader, testData);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);

	}
	
}
