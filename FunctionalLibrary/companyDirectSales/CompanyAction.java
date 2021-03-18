package companyDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import executionTools.ExecStructure;
import fetchDataFromExcelFiles.ExcelDataFetch;
import objectMap.sfDirectSales.DirSalesMACDFlow;
import objectMap.sfDirectSales.DirSalesOpportunity;
import objectMap.sfDirectSales.DirSalesProducts;
import testDataFiles.TestDataFiles;
import testExecutionData.CompaniesTestData;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CompanyAction {

	static String companyID;

	static String logInfo="Executed with success";
	static String logError="Executed with errors";
	
	// Operational Actions

	//Quick Sale

	public static void createQuickSaleOpty(List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		try
		{
			openQuickSaleOPTYScreen(logStream, driver, testName);

			fillQSOpportunityFields(logStream, driver, testName);

			saveOpportunity(logStream, driver);
			
			

			TestLogger.logInfo(logStream, "createQuickSaleOpty", logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, "createQuickSaleOpty", logError, e.toString());
			throw new Exception("createQuickSaleOpty - "+logError, e);
		}
	}

	public static void fillQSOpportunityFields(List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		//07-12-2020 - Only to fill Opportunity Name.
		//Later and if applicable new functions should be added for other fields

		String optyName;

		optyName=TestCasesData.getOPTYName(testName);

		try
		{			
			driver.findElement(By.xpath(DirSalesOpportunity.optyNameinput)).sendKeys(optyName);

			TestLogger.logTrace(logStream, "createQuickSaleOpty", logInfo);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, "fillQSOpportunityFields", logError, e.toString());
			throw new Exception("fillQSOpportunityFields - "+logError, e);
		}

	}

	public static void saveOpportunity(List<TestLog> logStream, WebDriver driver) throws Exception {

		try
		{
			WebElement saveOPTYButton=driver.findElement(By.xpath(DirSalesOpportunity.saveButton));

			saveOPTYButton.click();

			new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOf(saveOPTYButton));

			TestLogger.logTrace(logStream, "saveOpportunity", logInfo);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, "saveOpportunity", logError, e.toString());
			throw new Exception("saveOpportunity - "+logError, e);
		}

	}

	public static void openQuickSaleOPTYScreen(List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		String quickSaleURL;

		//companyID=CompaniesTestData.tdCompanyID(testName);

		companyID="0013M000004hDSQQA2";


		try
		{
			quickSaleURL="https://proximus--prxitt.lightning.force.com/lightning/action/quick/Account.PB_Opportunity?objectApiName=Opportunity&recordId="+companyID+"&backgroundContext=%2Flightning%2Fr%2FAccount%2F"+companyID+"%2Fview";

			BrowserActions.goToByURL(driver, quickSaleURL);



			TestLogger.logTrace(logStream, "openQuickSaleOPTYScreen", logInfo);
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, "openQuickSaleOPTYScreen", logError, e.toString());
			throw new Exception("openQuickSaleOPTYScreen - "+logError, e);
		}
	}

	public static boolean quickSaleFormValidation(List<TestLog> logStream, WebDriver driver, int stepsExecuted) throws Exception
	{
		String actionName="quickSaleFormValidation";
		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesOpportunity.quickSaleHeader)&&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.optyNameinput)&&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.companyName) &&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.forecastCategoryMenu)&&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.closeDateInput)&&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.stageMenu)&&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.totalContractValueInput))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepsExecuted);
				System.out.println(actionName+" - Succeeded in Step: "+stepsExecuted);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, "openQuickSaleOPTYScreen", logError, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepsExecuted,e);
		}
	}

	public static boolean validateQuickSaleFilledFields(List<TestLog> logStream, WebDriver driver, int stepsExecuted) throws Exception 
	{
		String actionName="validateQuickSaleFilledFields";

		String closeDateValidation, stageValidation;

		try
		{
			
			stageValidation=driver.findElement(By.xpath(DirSalesOpportunity.stageText)).getText().toString();

			closeDateValidation=driver.findElement(By.xpath(DirSalesOpportunity.closeDateInput)).getAttribute("value");
			
			if(stageValidation.contains("Prospecting") && ExecStructure.formattedDate("dd/MM/YYYY").contains(closeDateValidation))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepsExecuted);
				System.out.println(actionName+" - Succeeded in Step: "+stepsExecuted);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepsExecuted,e);
		}
	}

	
	//Standard Opportunity

	public static void createStandardOpportunity(List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception
	{
		String actionName="createStandardOpportunity";

		try
		{
			CompanyNavigation.goToOpportunityRelatedMenuOnCompany(logStream, driver, testName);

			WebElement newButton = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("New"))));

			newButton.click();

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(DirSalesOpportunity.newOpportunityHeader))));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}
	}

	public static void fillStandardOpportunityFields(List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception
	{
		String actionName="fillStandardOpportunityFields";

		try
		{
			fillOpportunityName(logStream, driver, stepsExecuted, testName);
			fillCloseDate(logStream, driver, stepsExecuted);
			fillStage(logStream, driver, stepsExecuted);
			fillForecastCategory(logStream, driver, stepsExecuted);
			fillTermsAndConditions(logStream, driver, stepsExecuted);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}

	}

	public static void saveStandardOpportunity(List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception
	{	

		String actionName="saveStandardOpportunity";


		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.nosSaveButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}
	}

	public static void fillOpportunityName(List<TestLog> logStream, WebDriver driver, int stepsExecuted,
			String testName) throws Exception 
	{
		String actionName="fillOpportunityName";

		String optyName=TestCasesData.getOPTYName(testName);


		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.optyNameinput)).clear();

			driver.findElement(By.xpath(DirSalesOpportunity.optyNameinput)).sendKeys(optyName);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}

	}

	private static void fillCloseDate(List<TestLog> logStream, WebDriver driver, int stepsExecuted) throws Exception 
	{
		String actionName="fillCloseDate";

		try
		{

			driver.findElement(By.xpath(DirSalesOpportunity.inputCloseDate)).clear();

			driver.findElement(By.xpath(DirSalesOpportunity.inputCloseDate)).sendKeys(ExecStructure.formattedDate("dd/MM/yyyy"));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}		
	}

	private static void fillStage(List<TestLog> logStream, WebDriver driver, int stepsExecuted) throws Exception 
	{
		String actionName="fillStage";

		String optyStage=ExcelDataFetch.searchDT(3, "optyStage");

		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.selectStage)).click();

			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyStage+"']"))).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}

	}

	private static void fillForecastCategory(List<TestLog> logStream, WebDriver driver, int stepsExecuted) throws Exception 
	{
		String actionName="fillForecastCategory";

		String optyForecastCategory=ExcelDataFetch.searchDT(3, "optyForecastCategory");

		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.selectForecastCategory)).click();

			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyForecastCategory+"']"))).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}	
	}

	private static void fillTermsAndConditions(List<TestLog> logStream, WebDriver driver, int stepsExecuted) throws Exception 
	{
		String actionName="fillTermsAndConditions";


		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.termsAndConditionsComboBox)).click();

			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOpportunity.termAndConditionsOption))).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}		

	}

	public static void standardOpportunityForD02(List<TestLog> logStream, WebDriver driver, String testName, int stepID) throws Exception 
	{
		String actionName="Standard Opportunity for SQ/D02";

		try
		{
			if (BrowserActions.isElementPresent(driver, DirSalesProducts.inputSearchProducts))
			{
				driver.findElement(By.xpath(DirSalesOpportunity.nosCancelButton)).click();
			}

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	
	
	//MACD Order

	public void createMACDOrder(List<TestLog> logStream, WebDriver driver, String testName, String companyContactPerson) throws Exception
	{

		try
		{
			goToFirstMACDScreen(logStream, driver, testName);

			fillFieldsFromFirstMACDScreen(logStream, driver);

			goToSecondMACDScreen(logStream, driver);

			fillFieldsFromSecondMACDScreen(logStream, driver, testName, companyContactPerson);

			submitMACDOrder(logStream, driver);

			TestLogger.logInfo(logStream, "createMACDOrder", logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, "createMACDOrder", logError, e.toString());
			throw new Exception("createMACDOrder - "+logError, e);
		}
	}

	private void goToFirstMACDScreen(List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		String componentName="goToFirstMACDScreen";

		String macdURL;


		try
		{
			companyID=CompaniesTestData.tdCompanyID(testName);

			macdURL = "https://proximus--prxitt.lightning.force.com/lightning/action/quick/Account.NewOrder?objectApiName&recordId="+companyID+"&backgroundContext=%2Flightning%2Fr%2FAccount%2F"+companyID+"%2Fview";

			BrowserActions.goToByURL(driver, macdURL);


			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}

	private void fillFieldsFromFirstMACDScreen(List<TestLog> logStream, WebDriver driver) throws Exception 
	{
		String componentName="fillFieldsFromFirstMACDScreen";

		try
		{
			fillTypeMACD(logStream, driver);

			fillDetailMACD(logStream, driver);

			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}

	private void fillTypeMACD(List<TestLog> logStream, WebDriver driver) throws Exception {
		String componentName="fillTypeMACD";

		try
		{
			driver.findElement(By.xpath(DirSalesMACDFlow.inputType)).click();

			//07-12-2020 - To implement parameters on this instruction
			driver.findElement(By.xpath(DirSalesMACDFlow.adminValueType)).click();

			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}

	private void fillDetailMACD(List<TestLog> logStream, WebDriver driver) throws Exception {
		String componentName="fillDetailMACD";

		try
		{
			driver.findElement(By.xpath(DirSalesMACDFlow.inputDetail)).click();

			//07-12-2020 - To implement parameters on this instruction
			driver.findElement(By.xpath(DirSalesMACDFlow.changeAddressDetailValue)).click();

			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}

	private void goToSecondMACDScreen(List<TestLog> logStream, WebDriver driver) throws Exception {
		String componentName="goToSecondMACDScreen";

		try
		{
			driver.findElement(By.xpath(DirSalesMACDFlow.nextButton)).click();

			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}

	private void fillFieldsFromSecondMACDScreen(List<TestLog> logStream, WebDriver driver, String testName, String companyContactPerson) throws Exception 
	{

		String componentName="fillFieldsFromSecondMACDScreen";

		try
		{
			fillCompanyContactPersonName(logStream, driver, companyContactPerson);

			//07-12-2020 - Fields Not Mandatory for MACD
			//To be taken later
			/*
			fillOrderOwner(logStream, driver);

			fillSalesforceId(logStream, driver);

			fillServiceRequestDate(logStream, driver);

			fillQuoteID(logStream, driver);
			 */
			fillComments(logStream, driver, testName);

			uploadfileMACD(logStream, driver);


			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}

	private void fillCompanyContactPersonName(List<TestLog> logStream, WebDriver driver, String companyContactPerson) throws Exception {

		String componentName="fillCompanyContactPersonName";

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try
		{
			driver.findElement(By.xpath(DirSalesMACDFlow.inputCompanyContactPerson)).sendKeys(companyContactPerson);

			WebElement companyCPerson = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-aura-class = 'cPRX_SOI_CustomLookupResult'][text()='"+companyContactPerson+"']")));

			companyCPerson.click();


			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}
	/*
	private void fillOrderOwner(List<TestLog> logStream, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	private void fillSalesforceId(List<TestLog> logStream, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	private void fillServiceRequestDate(List<TestLog> logStream, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	private void fillQuoteID(List<TestLog> logStream, WebDriver driver) {
		// TODO Auto-generated method stub

	}
	 */
	private void fillComments(List<TestLog> logStream, WebDriver driver, String testName) throws Exception {

		String componentName="fillComments";

		try
		{
			driver.findElement(By.xpath(DirSalesMACDFlow.inputComments)).sendKeys(testName);

			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}

	private void uploadfileMACD(List<TestLog> logStream, WebDriver driver) throws Exception 
	{
		String componentName="uploadfileMACD";

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try
		{
			WebElement uploadFileInput=driver.findElement(By.xpath(DirSalesMACDFlow.inputUploadFiles));

			uploadFileInput.sendKeys(TestDataFiles.fileNameD01);

			WebElement buttonDoneUploadFiles = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesMACDFlow.buttonDoneUploadFiles)));

			buttonDoneUploadFiles.click();


			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}

	private void submitMACDOrder(List<TestLog> logStream, WebDriver driver) throws Exception 
	{
		String componentName="submitMACDOrder";

		try
		{
			driver.findElement(By.xpath(DirSalesMACDFlow.submitOrderButton)).click();

			TestLogger.logTrace(logStream, componentName, logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, logError, e.toString());
			throw new Exception(componentName+" - "+logError, e);
		}

	}

	
	
	// 02-03-2020 - Create the New Opportunity - Create a Quick Opportunity
	public static void createNewQuickOpportunity(List<TestLog> logStream, WebDriver driver, String testName, int stepID, String productFamily) throws Exception
    {
        String actionName="createNewQuickOpportunity";


				try
				{
					WebElement newButton = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("New"))));

					newButton.click();
					
					fillNewOpportunityName(logStream, driver, testName, stepID);
					
					fillNewCloseDate(logStream, driver, stepID);
					
					fillDescription(logStream, driver, testName, stepID);
					
					fillProductFamily(logStream, driver, stepID, productFamily);
					
					clickCreateButton(logStream, driver, stepID);
					
					driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
					

					TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

				}
				catch(Exception e)
				{
					System.out.println(e);
					TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}

    }
	
	private static void fillNewOpportunityName(List<TestLog> logStream, WebDriver driver, String testName, int stepID) throws Exception 
	{
		String actionName="fillNewOpportunityName";
		
		String optyName=TestCasesData.getOPTYName(testName);
		
		try
		{
			WebElement inputOpportunityName = driver.findElement(By.xpath("//input[@name='Name']"));
			
			inputOpportunityName.click();
			
			inputOpportunityName.clear();
			
			inputOpportunityName.sendKeys(optyName);
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void fillNewCloseDate(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="fillNewCloseDate";
		
		String closeDate=ExecStructure.tomorrowFormattedDate("dd-MMM-yyyy");
		
		try
		{
			WebElement inputCloseDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
			
			inputCloseDate.click();
			
			inputCloseDate.clear();
			
			inputCloseDate.sendKeys(closeDate);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void fillDescription(List<TestLog> logStream, WebDriver driver, String testName, int stepID) throws Exception
	{
		String actionName="fillDescription";
		
		try
		{
			WebElement inputDescription = driver.findElement(By.xpath("//textarea[@name='Description']"));
			
			inputDescription.click();
			
			inputDescription.clear();
			
			inputDescription.sendKeys(testName);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void fillProductFamily(List<TestLog> logStream, WebDriver driver, int stepID, String productFamily) throws Exception
	{
		String actionName="fillProductFamily";
		
		try
		{
			
			driver.findElement(By.xpath("//input[@name='PRX_Product_family__c']")).click();
			
					
			BrowserActions.jsClickByXpath(driver, "//span[@title='"+productFamily+"']");
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}
	
	private static void clickCreateButton(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		 String actionName="clickCreateButton";


			try
			{
				BrowserActions.jsClickByXpath(driver, "//button[@name='Create']");

				TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}

		
	}

	
	
	
	// Validation Actions
	
	//Validation of Company Page

	public static boolean companyPageValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String componentName="companyPageValidation";

		boolean validation;

		String companyURLvalidation, companyTitleValidation;

		String companyName=ExcelDataFetch.searchDT(2, "testingCompanyD02Functional");

		companyID=ExcelDataFetch.searchDT(2, "idCompanyD02Functional");


		try
		{			
			companyURLvalidation=driver.getCurrentUrl();
			companyTitleValidation=driver.getTitle();

			if(companyURLvalidation.contains(companyID) && companyTitleValidation.contains(companyName))
			{
				TestLogger.logTrace(logStream, componentName, TestLogger.logInfo);
				validation=true;
			}
			else
			{
				validation=false;
				TestLogger.logTrace(logStream, componentName, "Validation Failed on Step "+stepID);
				throw new Exception("Validation Failed on Step "+stepID);
			}

			return validation;
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, componentName, TestLogger.logError, e.toString());
			throw new Exception(componentName+" - "+TestLogger.logError, e);
		}
	}


	
	
	
	



	}






