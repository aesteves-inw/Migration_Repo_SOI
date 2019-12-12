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
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceOpportunity;

public class AgreementCreation_From_Oportunity_MobileVoice_EditAgreement {
 
private String testName = this.getClass().getName();
	
	private String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");
	
	private long startTime=System.nanoTime();

	public static WebDriver driver = null;
	
	private WebDriverWait wait;

	private List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();
	
	private String finalTestDate=null;
	
	private long finishTime;
	
	private int stepsExecuted;
	
	private String testExecutionString;
	
	private String optyName;
	
	private String linkAgreementName;
	
 
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
		
		testExecutionString = ExecStructure.formattedDate("yyyyMMdd")+"_TC3_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testName));
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
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceCompany.companyDetailsHeader)));
			
			driver.findElement(By.linkText(optyName)).click();
			
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
		try
		{
			driver.findElement(By.xpath(linkAgreementName)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceAgreement.detailsAgreement)));
					
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
		String editAgreementName="EDIT_"+testExecutionString;
		
		String valAgreement=driver.findElement(By.xpath(SalesForceAgreement.detailsAgreement)).getText().toString();
		
		try
		{
			driver.findElement(By.xpath(SalesForceAgreement.editButton)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceAgreement.agreementFields)));
			
			driver.findElement(By.xpath(SalesForceAgreement.inputAgreementName)).clear();
			
			driver.findElement(By.xpath(SalesForceAgreement.inputAgreementName)).sendKeys(editAgreementName);
			
			driver.findElement(By.xpath(SalesForceAgreement.selectStatus)).click();
			
			driver.findElement(By.linkText("New")).click();
			
			driver.findElement(By.xpath(SalesForceAgreement.saveButton)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceAgreement.detailsAgreement)));
			
			if(valAgreement.contains(editAgreementName) && valAgreement.contains("New"))
			{
				ExecStructure.screenShotTaking(driver, testName, "7_EditAgreementScreenValidation");
				TestStepReportStructure step07 = new TestStepReportStructure(7, "Agreement Edition validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "7_EditAgreementScreenValidation");
				testExecStructure.add(step07);
			}
			else
			{
				throw new Exception ("Not possible to validate Agreement Edition");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "7_EditAgreementScreenValidation");
			TestStepReportStructure step07 = new TestStepReportStructure(7, "Agreement Edition validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "7_EditAgreementScreenValidation");
			testExecStructure.add(step07);
			throw new Exception("Test Failed on Step 7",e);
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
