package opportunityDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import executionTools.ExecStructure;
import objectMap.sfDirectSales.DirSalesOpportunity;
import objectMap.sfPartnersCommunity.PartComOpportunity;
import testExecutionData.TestCasesData;
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
			openEditOpportunityMenuInOptyDetailsScreen(logStream, driver, stepID);

			fillOtherMandatoryFieldsOfOpportunity(logStream, driver, stepID, testName);

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

	private static void openEditOpportunityMenuInOptyDetailsScreen(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="openEditOpportunityMenu";


		try
		{
			WebElement editOppyName=driver.findElement(By.xpath("//button[@title='Edit Opportunity Name']"));
			
			BrowserActions.jsClick(driver, editOppyName);
			
			Thread.sleep(1000);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fillOtherMandatoryFieldsOfOpportunity(List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		String actionName="fillOtherMandatoryFieldsOfOpportunity";


		try
		{
			fillOptyDescription(logStream, driver, stepID, testName);
			
			fillLevelOfConfidence(logStream, driver, stepID);

			fillOptyNextStep(logStream, driver, stepID, testName);

			fillOptyNextStepDueDate(logStream, driver, stepID);

			fillOptyProductFamily(logStream, driver, stepID);

			fillOptyCompetitorName(logStream, driver, stepID);
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	

	private static void fillOptyDescription(List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		String actionName="fillOptyDescription";


		try
		{
			WebElement textareaDescription = driver.findElement(By.xpath(DirSalesOpportunity.textareaDescription));

			textareaDescription.click();

			textareaDescription.clear();

			textareaDescription.sendKeys(TestCasesData.getOPTYName(testName));

			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fillLevelOfConfidence(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="fillLevelOfConfidence";
		
		String levelOfConfidence="High (100%)";


		try
		{
			WebElement selectLevelOfConfidence = driver.findElement(By.xpath(DirSalesOpportunity.selectLevelOfConfidence));
			
			BrowserActions.jsClick(driver, selectLevelOfConfidence);
			
			Thread.sleep(1000);
			
			WebElement statusLabel=driver.findElement(By.xpath("//span[@title='"+levelOfConfidence+"']"));
			
			BrowserActions.jsClick(driver, statusLabel);
			
			Thread.sleep(1000);

			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}
	
	private static void fillOptyNextStep(List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		String actionName="fillOptyNextStep";


		try
		{
			WebElement inputNextStep = driver.findElement(By.xpath(DirSalesOpportunity.inputNextStep));

			inputNextStep.click();

			inputNextStep.clear();

			inputNextStep.sendKeys(TestCasesData.getOPTYName(testName));

			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fillOptyNextStepDueDate(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="fillOptyNextStepDueDate";


		try
		{
			WebElement inputNextStepDueDate = driver.findElement(By.xpath(DirSalesOpportunity.inputNextStepDueDate));

			inputNextStepDueDate.click();

			inputNextStepDueDate.clear();

			inputNextStepDueDate.sendKeys(ExecStructure.tomorrowFormattedDate("dd/MM/yyyy"));

			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fillOptyProductFamily(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="fillOptyProductFamily";


		try
		{
			WebElement selectProductFamily=driver.findElement(By.xpath(DirSalesOpportunity.selectProductFamily));
			
			BrowserActions.jsClick(driver, selectProductFamily);
			Thread.sleep(1000);
			
			WebElement productFamilyItem=driver.findElement(By.xpath("//*[text()='Fix Data']"));
			
			BrowserActions.jsClick(driver, productFamilyItem);
			Thread.sleep(1000);

			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fillOptyCompetitorName(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="fillOptyCompetitorName";


		try
		{
			driver.findElement(By.xpath(DirSalesOpportunity.nomeCompetitorName)).click();
			
			driver.findElement(By.xpath(DirSalesOpportunity.buttonAddToChosen)).click();
			

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
			/*
			//09-02-2021
			System.out.println("Debug of changeStatusOfOpportunity - Start");

			Thread.sleep(1000);

			WebElement buttonEditStage=driver.findElement(By.xpath("//button[@title='Edit Stage']"));

			BrowserActions.jsClick(driver, buttonEditStage);

			Thread.sleep(1000);

			WebElement selectList=driver.findElement(By.xpath("//force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[3]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[1]/input"));

			BrowserActions.jsClick(driver, selectList);

			Thread.sleep(1000);

			WebElement statusLabel=driver.findElement(By.xpath("//span[@title='"+status+"']"));

			BrowserActions.jsClick(driver, statusLabel);

			Thread.sleep(1000);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

			//09-02-2021
			System.out.println("Debug of changeStatusOfOpportunity - End");
			 */
			
			// 19-02-2021
			
			WebElement selectStageEditScreen = driver.findElement(By.xpath(DirSalesOpportunity.selectStageEditScreen));
			
			BrowserActions.jsClick(driver, selectStageEditScreen);
			
			Thread.sleep(1000);
			
			WebElement statusLabel=driver.findElement(By.xpath("//span[@title='"+status+"']"));
			
			BrowserActions.jsClick(driver, statusLabel);
			
			Thread.sleep(1000);
			

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

			new WebDriverWait(driver, 50).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DirSalesOpportunity.saveEditButton)));



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
			//if(BrowserActions.isElementPresent(driver, DirSalesOpportunity.optyHeader) && BrowserActions.isElementPresent(driver, DirSalesOpportunity.optyDetails))
				if(BrowserActions.isElementPresent(driver, DirSalesOpportunity.optyDetails))
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
					BrowserActions.isElementPresent(driver, DirSalesOpportunity.nosSaveButton) //&&
					//BrowserActions.isElementPresent(driver, DirSalesOpportunity.selectStage) &&
					//BrowserActions.isElementPresent(driver, DirSalesOpportunity.selectForecastCategory
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

			
			String optyEditValidation =driver.findElement(By.xpath("(//a[@data-tab-name='Closed Won']//span)[2]")).getText().toString();

			
			System.out.println("Debug of closeWonOpportunityValidation 01: "+optyEditValidation);
			System.out.println("Debug of closeWonOpportunityValidation 02: "+optyEditValidation.contains(status));

			if(optyEditValidation.contains(status))
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
