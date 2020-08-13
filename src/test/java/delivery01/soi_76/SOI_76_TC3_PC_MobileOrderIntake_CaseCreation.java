package delivery01.soi_76;

import org.testng.annotations.Test;

import actions.BrowserActions;
import actions.FunctionalActionsSFPC;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesforceNewMACDFlow;
import sfPartnersCommunity.SFPC_Case;
import sfPartnersCommunity.SFPC_Company;
import sfPartnersCommunity.SFPC_HomePage;
import sfPartnersCommunity.SFPC_LoginPage;
import sfPartnersCommunity.SFPC_NewMACDFlow;
import sfPartnersCommunity.SFPC_Opportunity;
import sfPartnersCommunity.SFPC_Orders;
import sfPartnersCommunity.SFPC_Products;
import sfPartnersCommunity.SFPC_Services;

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

public class SOI_76_TC3_PC_MobileOrderIntake_CaseCreation {
	
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

	String companyContactPerson="Simple Ordering SeventySix";
	
	String oppiename, generatedAgreement, productsLinkView, orderURL;

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
		
		oppiename="OPTY_"+testExecutionString;
		
		String optyStage=TestData.searchDT(2, "optyStage");
		
		String optyForecastCategory=TestData.searchDT(2, "optyForecastCategory");
	
		try
		{
			driver.findElement(By.xpath(SFPC_Company.newOppieButton)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Opportunity.newOpportunityHeader)));
			
			driver.findElement(By.xpath(SFPC_Opportunity.inputOpportunityName)).clear();
			driver.findElement(By.xpath(SFPC_Opportunity.inputOpportunityName)).sendKeys(oppiename);
			
			driver.findElement(By.xpath(SFPC_Opportunity.inputCloseDate)).clear();
			driver.findElement(By.xpath(SFPC_Opportunity.inputCloseDate)).sendKeys(ExecStructure.formattedDate("dd/MM/yyyy"));
			
			driver.findElement(By.xpath(SFPC_Opportunity.selectStage)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyStage+"']"))).click();
			
			driver.findElement(By.xpath(SFPC_Opportunity.selectForecastCategory)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyForecastCategory+"']"))).click();
						
			driver.findElement(By.xpath(SFPC_Opportunity.saveButton)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			WebElement oppieLink=driver.findElement(By.linkText(oppiename));
			
			if(oppieLink.isDisplayed())
			{
				ExecStructure.screenShotTaking(driver, testName, 3+"_CreateNewOppie");
				TestStepReportStructure step03 = new TestStepReportStructure(3, "Create new Opportunity", "Opportunity created with success", "Created with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 3+"_CreateNewOppie");
				testExecStructure.add(step03);
			}
			else
			{
				throw new Exception ("Not possible to create Opportunity");
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, 3+"_CreateNewOppie");
			TestStepReportStructure step03 = new TestStepReportStructure(3, "Create new Opportunity", "Opportunity created with success", "Not possible to create Opportunity", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), 3+"_CreateNewOppie");
			testExecStructure.add(step03);
			throw new Exception("Test Failed on Step 3",e);
		}
	}
	
	@Test(dependsOnMethods = "step03")
	public void step04() throws Exception {
		
		stepsExecuted++;
		
		try
		{
			driver.findElement(By.linkText(oppiename)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Products"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Products.addProductsBtn))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Products.addProductsHeader)));
			
			if(BrowserActions.isElementPresent(driver,SFPC_Products.addProductsHeader) && BrowserActions.isElementPresent(driver,SFPC_Products.inputSearchProducts) && BrowserActions.isElementPresent(driver,SFPC_Products.nextButton) && BrowserActions.isElementPresent(driver,SFPC_Products.cancelButton) && BrowserActions.isElementPresent(driver,SFPC_Products.productTable))
			{
				ExecStructure.screenShotTaking(driver, testName, "4_AddProductScreenValidation");
				TestStepReportStructure step04 = new TestStepReportStructure(4, "Add Product Screen validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "4_AddProductScreenValidation");
				testExecStructure.add(step04);
				stepsExecuted=4;
			}
			else
			{
				throw new Exception ("Not possible to validate add product screen");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "4_AddProductScreenValidation");
			TestStepReportStructure step04 = new TestStepReportStructure(4, "Add Product Screen validation", "Validation with success", "Not possible to validate.", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "4_AddProductScreenValidation");
			testExecStructure.add(step04);
			throw new Exception("Test Failed on Step 4",e);
		}
	}
	
	@Test(dependsOnMethods = "step04")
	public void step05() throws Exception {
		
		stepsExecuted++;
		
		String mobileVoice=TestData.searchDT(3, "mobileVoice");
		
		String mobileVoiceProduct="//div[@title='"+mobileVoice+"']";
		
		try
		{
			driver.findElement(By.xpath(SFPC_Products.inputSearchProducts)).sendKeys(mobileVoice);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mobileVoiceProduct))).click();
			
			driver.findElement(By.xpath(SFPC_Products.nextButton)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver,SFPC_Products.headerEditSelectedProducts) && BrowserActions.isElementPresent(driver,SFPC_Products.backButton) && BrowserActions.isElementPresent(driver,SFPC_Products.totalContractValue) && BrowserActions.isElementPresent(driver,SFPC_Products.contractDuration) && BrowserActions.isElementPresent(driver,SFPC_Products.revenueType) && BrowserActions.isElementPresent(driver,SFPC_Products.productRegime))
			{
				ExecStructure.screenShotTaking(driver, testName, "5_MobileVoiceAddedtoOppie");
				TestStepReportStructure step05 = new TestStepReportStructure(5, "Mobile Voice product adiction validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "5_MobileVoiceAddedtoOppie");
				testExecStructure.add(step05);
			}
			else
			{
				throw new Exception ("Not possible to add Mobile Voice Product");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "5_MobileVoiceAddedtoOppie");
			TestStepReportStructure step05 = new TestStepReportStructure(5, "Mobile Voice product adiction validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "5_MobileVoiceAddedtoOppie");
			testExecStructure.add(step05);
			throw new Exception("Test Failed on Step 5",e);
		}
	}
	
	@Test(dependsOnMethods = "step05")
	public void step06() throws Exception {
		
		stepsExecuted++;
		
		String[] config2Apply=TestData.prodConfiguration(1);
		
		String mobileVoice=TestData.searchDT(3, "mobileVoice");
		
		String lineItemOppie=(SFPC_Opportunity.productsArea).concat("//a[contains(.,'"+mobileVoice+"')]");
		
		generatedAgreement=(SFPC_Opportunity.agreementsArea).concat("//a[contains(.,'"+oppiename+"')]");
		
		try
		{

			driver.findElement(By.xpath(SFPC_Products.totalContractValue)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Products.inputContractValue))).sendKeys(config2Apply[0]);
			
			driver.findElement(By.xpath(SFPC_Products.contractDuration)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Products.inputContratDuration))).sendKeys(config2Apply[1]);
			
			driver.findElement(By.xpath(SFPC_Products.revenueType)).click();
			driver.findElement(By.xpath(SFPC_Products.revenueType2)).click();
			driver.findElement(By.linkText(config2Apply[2])).click();
			
			BrowserActions.ScrollByPixs(driver, 100, 0);
			
			driver.findElement(By.xpath(SFPC_Products.productRegime)).click();
			driver.findElement(By.xpath(SFPC_Products.productRegime2)).click();
			driver.findElement(By.linkText(config2Apply[3])).click();
			
			driver.findElement(By.xpath(SFPC_Products.saveButton)).click();
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SFPC_Products.headerEditSelectedProducts)));
			
			BrowserActions.refreshPage(driver);
			
			if(BrowserActions.isElementPresent(driver, lineItemOppie) && BrowserActions.isElementPresent(driver, generatedAgreement))
			{
				ExecStructure.screenShotTaking(driver, testName, "6_MobileVoiceEditedtoOppie");
				TestStepReportStructure step06 = new TestStepReportStructure(6, "Mobile Voice product edition validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "6_MobileVoiceEditedtoOppie");
				testExecStructure.add(step06);
			}
			else
			{
				throw new Exception ("Not possible to edit Mobile Voice Product");
			}
						
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "6_MobileVoiceEditedtoOppie");
			TestStepReportStructure step06 = new TestStepReportStructure(6, "Mobile Voice product edition validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "6_MobileVoiceEditedtoOppie");
			testExecStructure.add(step06);
			throw new Exception("Test Failed on Step 6",e);
		}
		
	}
	
	@Test(dependsOnMethods = "step06")
	public void step07() throws Exception {
		
		stepsExecuted++;
		
		try
		{
			FunctionalActionsSFPC.navigate2Agreement(driver, stepsExecuted, generatedAgreement);
			
			FunctionalActionsSFPC.addFile2Agreement(driver, stepsExecuted);
			
			driver.findElement(By.linkText(oppiename)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Opportunity.optyDetails)));
			
			FunctionalActionsSFPC.closeWonOPTY(driver, stepsExecuted);
			
			
			if (BrowserActions.isElementPresent(driver, SalesForceOpportunity.stageClosedWonDetails))
			{
				ExecStructure.screenShotTaking(driver, testName, "7_ClosedWonOppieValidation");
				TestStepReportStructure step07 = new TestStepReportStructure(7, "Close Won Opportunity Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "7_ClosedWonOppieValidation");
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
			ExecStructure.screenShotTaking(driver, testName, "7_ClosedWonOppieValidation");
			TestStepReportStructure step07 = new TestStepReportStructure(7, "Close Won Opportunity Validation", "Validation with success", "Validated with success", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "7_ClosedWonOppieValidation");
			testExecStructure.add(step07);
			throw new Exception("Test Failed on Step 7",e);
		}
		
	}
	
	@Test(dependsOnMethods = "step07")
	public void step08() throws Exception {
		
		stepsExecuted++;
		
		try
		{
			
			BrowserActions.ScrollByPixs(driver, 0, 100);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.ordersContainer.concat("//a[contains(.,'"+oppiename+"')]"))));
			
			String orderValidation=driver.findElement(By.xpath(SalesForceOpportunity.ordersContainer)).getText().toString();
			
			
			if (orderValidation.contains(oppiename))
			{
				ExecStructure.screenShotTaking(driver, testName, "8_OrderValidation");
				TestStepReportStructure step08 = new TestStepReportStructure(8, "Order Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "8_OrderValidation");
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
			ExecStructure.screenShotTaking(driver, testName, "8_OrderValidation");
			TestStepReportStructure step08 = new TestStepReportStructure(8, "Order Validation", "Validation with success", "Validated with success", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "8_OrderValidation");
			testExecStructure.add(step08);
			throw new Exception("Test Failed on Step 8",e);
		}
		
		
	}
	
	@Test(dependsOnMethods = "step08")
	public void step09() throws Exception {
		
		stepsExecuted++;
		
		try
		{
			driver.findElement(By.xpath(SalesForceOpportunity.ordersContainer.concat("//a[contains(.,'"+oppiename+"')]"))).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if (BrowserActions.isElementPresent(driver, SFPC_Orders.addServiceBtn) && BrowserActions.isElementPresent(driver, SFPC_Orders.submitOrderBtn) && BrowserActions.isElementPresent(driver, SalesForceOrders.servicesContainer) && BrowserActions.isElementPresent(driver, SFPC_Orders.orderDetails) && BrowserActions.isElementPresent(driver, SFPC_Orders.headerOrderDetail))
			{
				ExecStructure.screenShotTaking(driver, testName, "9_OrderScreenValidation");
				TestStepReportStructure step09 = new TestStepReportStructure(9, "Order Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "9_OrderScreenValidation");
				testExecStructure.add(step09);
			}
			else
			{
				throw new Exception("Validation Failed on Step 09");
			}
			
			orderURL=driver.getCurrentUrl();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "9_OrderScreenValidation");
			TestStepReportStructure step09 = new TestStepReportStructure(9, "Order Screen Validation", "Validation with success", "N", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "9_OrderScreenValidation");
			testExecStructure.add(step09);
			throw new Exception("Test Failed on Step 9",e);
		}
		
	}
	
	@Test(dependsOnMethods = "step09")
	public void step10() throws Exception {
		
		stepsExecuted++;
		
		try 
		{
			//FunctionalActionsSFPC.addService2Order(driver, stepsExecuted, testName, companyContactPerson);
			
			BrowserActions.refreshPage(driver);
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Orders.addServiceBtn))).click();
			driver.findElement(By.xpath(SFPC_Orders.addServiceBtn)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Orders.firstScreenFlow)));
			
			if (BrowserActions.isElementPresent(driver, SFPC_Orders.firstScreenFlow) && BrowserActions.isElementPresent(driver, SFPC_Orders.nextBtn))
			{
				
				//First Screen of the Flow
				
				driver.findElement(By.xpath(SFPC_Orders.inputDetail)).click();
				
				driver.findElement(By.xpath(SFPC_Orders.inputDetailWinback)).click();
				
				driver.findElement(By.xpath(SFPC_Orders.nextBtn)).click();
				
				
				//Second Screen of the Flow		
			
				driver.findElement(By.xpath(SFPC_NewMACDFlow.inputCompanyContactPerson)).click();
				
				driver.findElement(By.xpath(SFPC_NewMACDFlow.inputCompanyContactPerson)).sendKeys(companyContactPerson);
				
				BrowserActions.updateInnerHTMLSelenium(driver);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='slds-listbox__item cPRX_SOI_CustomLookupResult']"))).click();				
								
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate))).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.todayCalendarButton))).click();					
			
				driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testName);
				
				driver.findElement(By.xpath(SFPC_NewMACDFlow.saveButton)).click();
				
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SFPC_NewMACDFlow.saveButton)));
				
			}
						
			
			FunctionalActionsSFPC.navigate2ServiceScreen(driver, stepsExecuted);
			
			if (BrowserActions.isElementPresent(driver, SFPC_Services.detailsServicePage) && BrowserActions.isElementPresent(driver, SFPC_Services.fieldServiceName) && BrowserActions.isElementPresent(driver, SFPC_Services.fieldCase) && BrowserActions.isElementPresent(driver, SFPC_Services.fieldDomain) && BrowserActions.isElementPresent(driver, SFPC_Services.fieldType) && BrowserActions.isElementPresent(driver, SFPC_Services.fieldDetail) && BrowserActions.isElementPresent(driver, SFPC_Services.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SFPC_Services.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SFPC_Services.fieldStatus))
			{
				ExecStructure.screenShotTaking(driver, testName, "10_ServiceScreenValidation");
				TestStepReportStructure step010 = new TestStepReportStructure(10, "Service Screen Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "10_ServiceScreenValidation");
				testExecStructure.add(step010);
			}
			else
			{
				throw new Exception("Validation Failed on Step 010");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, "10_ServiceScreenValidation");
			TestStepReportStructure step010 = new TestStepReportStructure(10, "Service Screen Validation", "Validation with success", "Not possible to validate.", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), "10_ServiceScreenValidation");
			testExecStructure.add(step010);
			throw new Exception("Test Failed on Step 10",e);
		}
	}
	
	@Test(dependsOnMethods = "step10")
	public void step11() throws Exception 
	{
		try
		{
			driver.get(orderURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Orders.submitOrderBtn))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Orders.successMessage)));
			
			FunctionalActionsSFPC.navigate2ServiceScreen(driver, stepsExecuted);
			
			FunctionalActionsSFPC.navigate2CaseScreen(driver, stepsExecuted);
			
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
	public void afterTest() {

		finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader, testData);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);

	}

}
