package actions;

//import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesforceNewMACDFlow;
import sfPartnersCommunity.SFPC_Company;
import sfPartnersCommunity.SFPC_HomePage;
import sfPartnersCommunity.SFPC_LoginPage;
import sfPartnersCommunity.SFPC_NewMACDFlow;
import sfPartnersCommunity.SFPC_Opportunity;
import sfPartnersCommunity.SFPC_Orders;
import sfPartnersCommunity.SFPC_Products;
import sfPartnersCommunity.SFPC_Services;
import sfSikuli.SalesForceSikuli;

public class FunctionalActionsSFPC {

	public static WebDriverWait wait;

	public static TestStepReportStructure loginPartnersCommunity(WebDriver driver, String testName, int stepID, String envURL, String userName, String passWord) throws Exception
	{
		TestStepReportStructure loginSFPC;

		try
		{
			driver.get(envURL);

			driver.findElement(By.xpath(SFPC_LoginPage.inputUserame)).sendKeys(userName);

			driver.findElement(By.xpath(SFPC_LoginPage.inputPassword)).sendKeys(passWord);

			driver.findElement(By.xpath(SFPC_LoginPage.loginButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SFPC_HomePage.headerNavigationBar) && BrowserActions.isElementPresent(driver, SFPC_HomePage.quickCreateButton) && BrowserActions.isElementPresent(driver, SFPC_HomePage.inputSearchBar) && BrowserActions.isElementPresent(driver, SFPC_HomePage.dashboard))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_LoginScreen");
				loginSFPC = new TestStepReportStructure(stepID, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_LoginScreen");
				return loginSFPC;
			}
			else
			{
				throw new Exception("Not possible to perform login on Partners Community");
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_LoginScreen");
			loginSFPC = new TestStepReportStructure(stepID, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_LoginScreen");
			return loginSFPC;
		}
	}

	public static TestStepReportStructure createNewOppie(WebDriver driver, WebDriverWait wait, String testName, int stepID, String testExecutionString, String optyStage, String optyForecastCategory) throws Exception 
	{
		String oppiename = "OPTY_"+testExecutionString;

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
				ExecStructure.screenShotTaking(driver, testName, stepID+"_CreateNewOppie");
				TestStepReportStructure createOppie = new TestStepReportStructure(stepID, "Create new Opportunity", "Opportunity created with success", "Created with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_CreateNewOppie");
				return createOppie;
			}
			else
			{
				throw new Exception ("Not possible to create Opportunity");
			}



		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_CreateNewOppie");
			TestStepReportStructure createOppie = new TestStepReportStructure(stepID, "Create new Opportunity", "Opportunity created with success", "Not possible to create Opportunity", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_CreateNewOppie");
			return createOppie;
		}
	}

	public static TestStepReportStructure addProduct2Oppie(WebDriver driver, WebDriverWait wait, String testName, int stepID, String testExecutionString) throws Exception {

		String oppiename = "OPTY_"+testExecutionString;

		try
		{
			driver.findElement(By.linkText(oppiename)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Opportunity.optyDetails)));

			driver.findElement(By.xpath(SFPC_Opportunity.addProductsButton)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Opportunity.optyDetails)));

			if(BrowserActions.isElementPresent(driver,SFPC_Products.addProductsHeader) && BrowserActions.isElementPresent(driver,SFPC_Products.inputSearchProducts) && BrowserActions.isElementPresent(driver,SFPC_Products.nextButton) && BrowserActions.isElementPresent(driver,SFPC_Products.cancelButton) && BrowserActions.isElementPresent(driver,SFPC_Products.productTable))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_AddProductScreenValidation");
				TestStepReportStructure addProduct = new TestStepReportStructure(stepID, "Add Product Screen validation", "Validation with success", "Validated with success.", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_AddProductScreenValidation");
				return addProduct;
			}
			else
			{
				throw new Exception ("Not possible to validate add product screen");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_AddProductScreenValidation");
			TestStepReportStructure addProduct = new TestStepReportStructure(stepID, "Add Product Screen validation", "Validation with success", "Not possible to validate.", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_AddProductScreenValidation");
			return addProduct;
		}

	}


	public static void navigate2Agreement(WebDriver driver, int stepID, String generatedAgreement) throws Exception
	{
				
		try
		{
			String agreementURL = driver.findElement(By.xpath(generatedAgreement)).getAttribute("href");
			
			driver.get(agreementURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
			throw new Exception("Test Procedure to Navigate to Agreement's page. Failed on StepID: "+stepID,e);
		}
	}
	
	public static void addFile2Agreement(WebDriver driver, int stepID) throws Exception
	{
			
	}
		
	public static void addFile2MACDOrder(WebDriver driver, int stepID) throws Exception
	{
			Screen screen = new Screen();	
		
			String file2Upload="SimpleOrdering_Dummy_File";
			
			String agreementFileTestData=ExecStructure.workingDir+"\\testData\\"+file2Upload+".pdf";
		
		try
		{
			driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
			
			screen.wait(SalesForceSikuli.uploadBarFilePathOpenCancel, 20);
			
			screen.find(SalesForceSikuli.filePath);
			
			screen.paste(agreementFileTestData);
			
			screen.click(SalesForceSikuli.openButton);
			
			screen.wait(SalesForceSikuli.uploadFilesDoneSalesforce, 20);
			
			screen.wait(SalesForceSikuli.doneButton, 20);
			
			screen.click(SalesForceSikuli.doneButton);
			
			
			Thread.sleep(10000);
			
		

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Procedure to Add File to MACD Order. Failed on StepID: "+stepID,e);
		}
	}
	
	public static void addService2Order(WebDriver driver, int stepID, String testName, String companyContactPerson) throws Exception
	{
		//WebDriverWait waitAS2O= new WebDriverWait(driver, 15);
		
	
		
		try
		{
			/*
			driver.findElement(By.xpath(SFPC_Orders.addServiceBtn)).click();
			
			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Orders.firstScreenFlow)));
			
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
				
				waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='slds-listbox__item cPRX_SOI_CustomLookupResult']"))).click();				
								
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate))).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.todayCalendarButton))).click();					
			
				driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testName);
				
				driver.findElement(By.xpath(SFPC_NewMACDFlow.saveButton)).click();
				
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SFPC_NewMACDFlow.inputCompanyContactPerson)));
				
				
			} */
			
			BrowserActions.refreshPage(driver);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Orders.addServiceBtn))).click();
			//driver.findElement(By.xpath(SFPC_Orders.addServiceBtn)).click();
			
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
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='slds-listbox__item cPRX_SOI_CustomLookupResult']"))).click();				
								
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate))).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.todayCalendarButton))).click();					
			
				driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testName);
				
				driver.findElement(By.xpath(SFPC_NewMACDFlow.saveButton)).click();
				
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SFPC_NewMACDFlow.saveButton)));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Procedure to Add Service to Order. Failed on StepID: "+stepID,e);
		}
	}

	public static void navigate2ServiceScreen(WebDriver driver, int stepID) throws Exception
	{
		
		String serviceLink = SFPC_Orders.servicesContainer.concat("//a[contains(.,'Mobile')]");
		
		WebDriverWait waitN2SS = new WebDriverWait(driver, 15);
		
		try
		{
			driver.findElement(By.xpath(serviceLink)).click();
			
			waitN2SS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Services.detailsServicePage)));
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Procedure to Navigate to Service Screen. Failed on StepID: "+stepID,e);
		}
	}
	
	public static void navigate2CaseScreen(WebDriver driver, int stepID) throws Exception
	{
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		try
		{
			
			String caseURL=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Services.caseLink))).getAttribute("href");
			
			driver.get(caseURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Procedure to Navigate to Case Screen. Failed on StepID: "+stepID,e);
		}
	}
	
	
	
	}