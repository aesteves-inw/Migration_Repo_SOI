package delivery01.soi_68;

import org.testng.annotations.Test;

import actions.BrowserActions;
import actions.FunctionalActionsSFDS;
import actions.FunctionalSteps;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceOpportunity;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class OrderCreationForNewContract_OrderCreation_From_OPTYClosure_Won_NotMobileVoice {

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

	String linkAgreementName;



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

		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC8_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));
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
			FunctionalActionsSFDS.addProductToOppie(driver, "nonMobileVoice");

			FunctionalActionsSFDS.editProductConfiguration(driver, 1);

			//driver.findElement(By.linkText(optyName)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(optyName))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.agreementsContainer)));

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
	public void step05() throws Exception {

		try
		{
			driver.findElement(By.xpath(SalesForceOpportunity.closeOPTYHeaderButton)).click();
			
			driver.findElement(By.xpath(SalesForceOpportunity.selectCloseMenu)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.ctomHeader)));
			
			Select closedStage = new Select(driver.findElement(By.xpath("//select")));
			
			closedStage.selectByVisibleText("Closed Won");
			
			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceOpportunity.ctomHeader)));
			
			driver.navigate().refresh();
			
			
			if (BrowserActions.isElementPresent(driver, SalesForceOpportunity.stageClosedWonDetails))
			{
				ExecStructure.screenShotTaking(driver, testName, "5_ClosedWonOppieValidation");
				TestStepReportStructure step05 = new TestStepReportStructure(5, "Close Won Opportunity Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "5_ClosedWonOppieValidation");
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
			ExecStructure.screenShotTaking(driver, testName, "5_ClosedWonOppieValidation");
			TestStepReportStructure step05 = new TestStepReportStructure(5, "Close Won Opportunity Validation", "Validation with success", "Validated with success", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "5_ClosedWonOppieValidation");
			testExecStructure.add(step05);
			throw new Exception("Test Failed on Step 5",e);
		}
	}
	
	@Test(dependsOnMethods = "step05")
	public void step06() throws Exception {
		
		try
		{
			
			String orderValidation=driver.findElement(By.xpath(SalesForceOpportunity.ordersContainer)).getText().toString();
			
			if (orderValidation.contains(optyName))
			{
				throw new Exception("Validation Failed on Step 06");
			}
			else
			{
				ExecStructure.screenShotTaking(driver, testName, "6_OrderValidation");
				TestStepReportStructure step06 = new TestStepReportStructure(6, "Order Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "6_OrderValidation");
				testExecStructure.add(step06);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "6_OrderValidation");
			TestStepReportStructure step06 = new TestStepReportStructure(6, "Order Validation", "Validation with success", "Validated with success", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "6_OrderValidation");
			testExecStructure.add(step06);
			throw new Exception("Test Failed on Step 6",e);
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
