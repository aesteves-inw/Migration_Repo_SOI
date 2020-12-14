package companyDirectSales;

import java.util.List;
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
import testDataFiles.TestDataFiles;
import testExecutionData.CompaniesTestData;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CompanyAction {

	static String companyID;

	static String logInfo="Executed with success";
	static String logError="Executed with errors";

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

		String forecastCategoryValidation, closeDateValidation, stageValidation;
		
		try
		{
			forecastCategoryValidation=driver.findElement(By.xpath(DirSalesOpportunity.forecastCategoryText)).getText().toString();
			
			stageValidation=driver.findElement(By.xpath(DirSalesOpportunity.stageText)).getText().toString();
			
			closeDateValidation=driver.findElement(By.xpath(DirSalesOpportunity.closeDateInput)).getAttribute("value");
			
			
			if(forecastCategoryValidation.contains("Committed") && stageValidation.contains("Prospecting") && closeDateValidation.contains(ExecStructure.formattedDate("dd/MM/YYYY")))
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
