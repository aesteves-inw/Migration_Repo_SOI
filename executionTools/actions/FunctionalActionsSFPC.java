package actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceNewMACDOrderScreen;
import sfPartnersCommunity.SFPC_Company;
import sfPartnersCommunity.SFPC_HomePage;
import sfPartnersCommunity.SFPC_LoginPage;
import sfPartnersCommunity.SFPC_NewMACDOrderScreen;
import sfPartnersCommunity.SFPC_Opportunity;
import sfPartnersCommunity.SFPC_Products;

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

	public static TestStepReportStructure navigate2CompDetailsPC(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure nav2comp;

		String companyURL=(TestData.searchDT(1, "environmentITTQA")).concat(TestData.searchDT(1, "CompanyDetails")).concat(TestData.tdCompanyID(testName));

		try
		{
			driver.get(companyURL);

			if(BrowserActions.isElementPresent(driver, SFPC_Company.buttonFollow) && BrowserActions.isElementPresent(driver, SFPC_Company.buttonNewMACDOrder) && BrowserActions.isElementPresent(driver, SFPC_Company.buttonEdit) && BrowserActions.isElementPresent(driver, SFPC_Company.relListNewOPTYButton) && BrowserActions.isElementPresent(driver, SFPC_Company.relListAgreementsLink) && BrowserActions.isElementPresent(driver, SFPC_Company.companyDetails) && BrowserActions.isElementPresent(driver, SFPC_Company.headerCompany))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2CompDetails");
				nav2comp = new TestStepReportStructure(stepID, "Navigation to Company Details", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2CompDetails");
				return nav2comp;
			}
			else
			{
				throw new Exception("Not possible to validate Company Details Page on Partners Community");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2CompDetails");
			nav2comp = new TestStepReportStructure(stepID, "Navigation to Company Details", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2CompDetails");
			return nav2comp;
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


	public static TestStepReportStructure createNewMACDOrder(WebDriver driver, WebDriverWait wait, String testName, int stepID, String testExecutionString) throws Exception
	{
		TestStepReportStructure newMACDOrder;
		
		String orderName="Order_"+testExecutionString;

		String newOrderCreated="//*[contains(.,'"+orderName+"')]";

		try 
		{
			driver.findElement(By.xpath(SFPC_Company.buttonNewMACDOrder)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceNewMACDOrderScreen.headerNewMACDOrder)));

			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).clear();

			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).sendKeys(orderName);

			driver.findElement(By.xpath(SFPC_NewMACDOrderScreen.nmoSaveButton)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(orderName)));

			if(BrowserActions.isElementPresent(driver, newOrderCreated))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_NewMACDOrder");
				newMACDOrder = new TestStepReportStructure(stepID, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_NewMACDOrder");
				return newMACDOrder;
			}
			else
			{
				throw new Exception("Not possible to validate New MACD Order on Partners Community");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_NewMACDOrder");
			newMACDOrder = new TestStepReportStructure(stepID, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_NewMACDOrder");
			return newMACDOrder;
		}
	}
}
