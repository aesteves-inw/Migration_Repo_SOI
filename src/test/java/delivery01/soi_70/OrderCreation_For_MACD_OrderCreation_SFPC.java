package delivery01.soi_70;

import org.testng.annotations.Test;

import actions.BrowserActions;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceNewMACDOrderScreen;
import sfPartnersCommunity.SFPC_Company;
import sfPartnersCommunity.SFPC_HomePage;
import sfPartnersCommunity.SFPC_LoginPage;
import sfPartnersCommunity.SFPC_NewMACDOrderScreen;
import sfPartnersCommunity.SFPC_Orders;

import org.testng.annotations.BeforeTest;

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

public class OrderCreation_For_MACD_OrderCreation_SFPC {

	private String testName = this.getClass().getName();

	private String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	private long startTime=System.nanoTime();

	public static WebDriver driver = null;

	private List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();

	private String finalTestDate=null;

	private long finishTime;

	private int stepsExecuted;

	private String testExecutionString;

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

		Set<Cookie> allCookies = driver.manage().getCookies(); 

		for(Cookie cookie : allCookies) 

		{ 

			driver.manage().addCookie(cookie); 

		}

		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC14_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));

	}

	@Test
	public void step01() throws Exception {

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
		
		String companyURL=(TestData.searchDT(1, "environmentITTQA")).concat(TestData.searchDT(1, "CompanyDetails")).concat(TestData.searchDT(2,"idTestingCompanySOI70"));
		
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
		
		WebDriverWait waitNewMACDOrder = new WebDriverWait(driver, 15);
		
		String orderName="Order_"+testExecutionString;
		
		String newOrderCreated="//*[contains(.,'"+orderName+"')]";
		
		try 
		{
			driver.findElement(By.xpath(SFPC_Company.buttonNewMACDOrder)).click();
			
			waitNewMACDOrder.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceNewMACDOrderScreen.headerNewMACDOrder)));
			
			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).clear();
			
			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).sendKeys(orderName);
			
			driver.findElement(By.xpath(SFPC_NewMACDOrderScreen.nmoSaveButton)).click();
					
			waitNewMACDOrder.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(orderName)));
			
			if(BrowserActions.isElementPresent(driver, newOrderCreated))
			{
				ExecStructure.screenShotTaking(driver, testName, 3+"_NewMACDOrder");
				TestStepReportStructure step03 = new TestStepReportStructure(3, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 3+"_NewMACDOrder");
				testExecStructure.add(step03);
			}
			else
			{
				throw new Exception("Not possible to validate New MACD Order on Partners Community");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, 3+"_NewMACDOrder");
			TestStepReportStructure step03 = new TestStepReportStructure(3, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 3+"_NewMACDOrder");
			testExecStructure.add(step03);
			stepsExecuted=3;
			throw new Exception("Test Failed on Step 3",e);
		}
	}
	
	@Test(dependsOnMethods = "step03")
	public void step04() throws Exception {	
		
		String orderName="Order_"+testExecutionString;
		
		try
		{
			driver.findElement(By.linkText(orderName)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SFPC_Orders.filesContainer) && BrowserActions.isElementPresent(driver, SFPC_Orders.changeRecordTypeButton) && BrowserActions.isElementPresent(driver, SFPC_Orders.changeOwnerButton) && BrowserActions.isElementPresent(driver, SFPC_Orders.headerOrder) && BrowserActions.isElementPresent(driver, SFPC_Orders.headerOrderDetail) && BrowserActions.isElementPresent(driver, SFPC_Orders.orderDetails) && BrowserActions.isElementPresent(driver, SFPC_Orders.servicesContainer))
			{
				ExecStructure.screenShotTaking(driver, testName, "4_OrderScreenValidation");
				TestStepReportStructure step04 = new TestStepReportStructure(4, "Order Screen validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "4_OrderScreenValidation");
				testExecStructure.add(step04);
			}
			else
			{
				throw new Exception("Validation Failed on Step 4");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "4_OrderScreenValidation");
			TestStepReportStructure step04 = new TestStepReportStructure(4, "Order Screen validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "4_OrderScreenValidation");
			testExecStructure.add(step04);
			stepsExecuted=4;
			throw new Exception("Test Failed on Step 4",e);
		}
	}

	@AfterTest
	public void afterTest() {

		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		stepsExecuted=4;

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);
	}

}
