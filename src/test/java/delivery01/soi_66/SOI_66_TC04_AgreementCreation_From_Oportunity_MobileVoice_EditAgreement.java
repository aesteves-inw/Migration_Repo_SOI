package delivery01.soi_66;

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
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceOpportunity;

public class SOI_66_TC04_AgreementCreation_From_Oportunity_MobileVoice_EditAgreement {

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
		
		String url="https://proximusitqa--prxittqa.lightning.force.com/lightning/r/csclm__Agreement__c/a2A3E000001QZFTUA4/view";
		
		String editAgreementName="Edit Agreement Testing";
		
		try
		{
			driver.get(url);
			
			driver.findElement(By.xpath("//button[@name='Edit'][contains(.,'Edit')]")).click();
			
			driver.findElement(By.xpath("//input[@class=' input']")).clear();
			
			driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(editAgreementName);
			
			driver.findElement(By.xpath("//button[@title='Save']/span[contains(.,'Save')]")).click();
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@title='Save']/span[contains(.,'Save')]")));
			
			String editVal=driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field']")).getAttribute("value");
				
			if(editVal.contains(editAgreementName))
			{
				ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_EditAgreement");
				TestStepReportStructure step07 = new TestStepReportStructure(stepsExecuted, "Edit Agreement", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_EditAgreement");
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
			ExecStructure.screenShotTaking(driver, testName, stepsExecuted+"_EditAgreement");
			TestStepReportStructure step07 = new TestStepReportStructure(stepsExecuted, "Edit Agreement", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepsExecuted+"_EditAgreement");
			testExecStructure.add(step07);
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
