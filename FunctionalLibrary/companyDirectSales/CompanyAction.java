package companyDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesMACDFlow;
import objectMap.sfDirectSales.DirSalesOpportunity;
import testDataFiles.TestDataFiles;
import testExecutionData.CompaniesTestData;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CompanyAction {

	String companyID;

	String logInfo="Executed with success";
	String logError="Executed with errors";

	//Quick Sale

	public void createQuickSaleOpty(List<TestLog> logStream, WebDriver driver, String testName) throws Exception
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

	private void fillQSOpportunityFields(List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
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
			TestLogger.logError(logStream, "fillQSOpportunityFields", logError, e.toString());
			throw new Exception("fillQSOpportunityFields - "+logError, e);
		}

	}

	private void saveOpportunity(List<TestLog> logStream, WebDriver driver) throws Exception {

		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.saveButton)).click();

			TestLogger.logTrace(logStream, "saveOpportunity", logInfo);
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, "saveOpportunity", logError, e.toString());
			throw new Exception("saveOpportunity - "+logError, e);
		}

	}

	private void openQuickSaleOPTYScreen(List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		String quickSaleURL;

		companyID=CompaniesTestData.tdCompanyID(testName);


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

}
