package opportunityDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import objectMap.sfDirectSales.DirSalesOpportunity;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OpportunityAction {

	//Operational Actions
	public static void createProductBasket(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="createProductBasket";


		try
		{
			goToProductBasketRelatedMenu(logStream, driver, stepID);

			clickNewProductBasketLink(logStream, driver, stepID);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	private static void clickNewProductBasketLink(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="clickNewProductBasketLink";


		try
		{
			driver.findElement(By.linkText("New Product Basket")).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void goToProductBasketRelatedMenu(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="goToProductBasketRelatedMenu";


		try
		{
			String optyRecordID=BrowserActions.getRecordIDByURL(driver);

			String productBasketRelatedMenuURL="https://proximus--prxitt.lightning.force.com/lightning/r/cscfga__Product_Basket__c/"+optyRecordID+"/related/cscfga__Product_Baskets__r/view";

			BrowserActions.goToByURL(driver, productBasketRelatedMenuURL);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}	
	}

	public static void changeOPTYName(List<TestLog> logStream, WebDriver driver, int stepsExecuted, String valueToInput) throws Exception 
	{
		String actionName="changeOPTYName";

		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.optyNameinput)).clear();

			driver.findElement(By.xpath(DirSalesOpportunity.optyNameinput)).sendKeys(valueToInput);

			driver.findElement(By.xpath(DirSalesOpportunity.nosSaveButton)).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}

	}

	public static void closeWonOpportunity(List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception 
	{
		String actionName="closeWonOpportunity";

		String status="Closed Won";


		try
		{
			openEditOpportunityMenu(logStream, driver, stepID);

			changeStatusOfOpportunity(logStream, driver, stepID, status);

			saveChangesOnEditOpportunityScreen(logStream, driver, stepID);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	private static void openEditOpportunityMenu(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="openEditOpportunityMenu";


		try
		{
			String optyURL=driver.getCurrentUrl();

			String editOpportunityMenuURL=ExcelDataFetch.searchDT(0, "DirectSalesEditOptyMenu");

			String optyEditMenuURL=optyURL.replaceAll("view", editOpportunityMenuURL);

			BrowserActions.goToByURL(driver, optyEditMenuURL);
			
			new WebDriverWait (driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOpportunity.editHeader)));


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void changeStatusOfOpportunity(List<TestLog> logStream, WebDriver driver, int stepID, String status) throws Exception 
	{
		String actionName="changeStatusOfOpportunity";
		
		

		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.editInputSelectStage)).click();
			
			//WebElement statusElement = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-base-combobox-item[@data-value='"+status+"']/span[@class='slds-media__figure slds-listbox__option-icon']")));

			//statusElement.click();
			
			WebElement statusClosedWon = BrowserActions.getElementByJSQuery(driver, "return document.querySelector('records-lwc-detail-panel').shadowRoot.querySelector('records-base-record-form').shadowRoot.querySelector('records-lwc-record-layout').shadowRoot.querySelector('forcegenerated-detailpanel_opportunity___012000000000000aaa___full___edit___recordlayout2').shadowRoot.querySelector('sfa-input-stage-name').shadowRoot.querySelector('force-record-picklist').shadowRoot.querySelector('force-form-picklist').shadowRoot.querySelector('lightning-picklist').shadowRoot.querySelector('lightning-combobox').shadowRoot.querySelector('lightning-base-combobox').shadowRoot.querySelectorAll('lightning-base-combobox-item')[7].shadowRoot.querySelector('span.slds-media__figure.slds-listbox__option-icon')");
			
			BrowserActions.jsClick(driver, statusClosedWon);
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void saveChangesOnEditOpportunityScreen(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="saveChangesOnEditOpportunityScreen";


		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.saveEditButton)).click();

			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOpportunity.editConfirmationMessage)));



			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	
	
	//Validation Actions
	public static boolean opportunityScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Opportunity: Opportunity Page validation";

		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesOpportunity.optyHeader) && BrowserActions.isElementPresent(driver, DirSalesOpportunity.optyDetails))
			{
				new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOpportunity.optyDetails)));
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean validateMoreThanOneRelatedProductBasket(List<TestLog> logStream, WebDriver driver,
			int newStepCounter) throws Exception 
	{
		String actionName="validateMoreThanOneRelatedProductBasket";


		try
		{
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));

			List<WebElement> tableLines=driver.findElements(By.tagName("tr"));

			if(tableLines.size() > 1)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+newStepCounter);
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
			TestLogger.logError(logStream, actionName, "Failed in Step "+newStepCounter, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+newStepCounter,e);
		}

	}

	public static boolean validateEditOpportunityScreen(List<TestLog> logStream, WebDriver driver, int stepsExecuted) throws Exception 
	{
		String actionName="validateEditOpportunityScreen";
		try
		{
			if(
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.editHeader) &&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.optyNameinput) &&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.nosCancelButton) &&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.nosSaveButton) &&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.selectStage) &&
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.selectForecastCategory)
					)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepsExecuted);
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
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepsExecuted,e);
		}
	}

	public static boolean editOPTYNegativeValidation(List<TestLog> logStream, WebDriver driver, int stepsExecuted) throws Exception
	{
		String actionName="editOPTYNegativeValidation";

		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesOpportunity.editOpportunityErrors))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepsExecuted);
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
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepsExecuted,e);
		}
	}

	public static boolean closeWonOpportunityValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String testName) throws Exception 
	{
		String actionName="closeWonOpportunityValidation";

		String status="Closed Won";

		try
		{

			String optyEditValidation =driver.findElement(By.xpath(DirSalesOpportunity.optyDetails)).getText().toString();
			
			Thread.sleep(2000);

			if(BrowserActions.isElementPresent(driver, DirSalesOpportunity.editConfirmationMessage) || optyEditValidation.contains(status))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}





}
