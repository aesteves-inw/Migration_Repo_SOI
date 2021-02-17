package opportunityPartCom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfPartnersCommunity.PartComOpportunity;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OpportunityPCAction {

	//Operational Actions

	public static void createProductBasket(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
		String actionName="createProductBasket";


		try
		{
			clickNewBasketButtonOnOPTY(logStream, stepID, driver);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void clickNewBasketButtonOnOPTY(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
		String actionName="clickNewBasketButtonOnOPTY";


		try
		{
			driver.findElement(By.xpath(PartComOpportunity.buttonNewBasketButton)).click();

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

	public static void closeWinOPTY(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="closeWinOPTY";

		String status="Closed Won";

		try
		{
			goToEditOPTYScreen(logStream, driver, stepID);

			changeStageField(logStream, driver, stepID, status);

			saveChangesOnEditOPTY(logStream, driver, stepID);



			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);			


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}



	private static void goToEditOPTYScreen(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="goToEditOPTYScreen";


		try
		{
			driver.findElement(By.xpath(PartComOpportunity.editButton)).click();

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PartComOpportunity.headerEditOPTY)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}


	}

	private static void changeStageField(List<TestLog> logStream, WebDriver driver, int stepID, String status) throws Exception 
	{
		String actionName="changeStageField";


		try
		{
			WebElement comboBoxStage=driver.findElement(By.xpath(PartComOpportunity.comboStage));

			Thread.sleep(1000);

			BrowserActions.jsClick(driver, comboBoxStage);

			Thread.sleep(1000);

			WebElement stageToClick=driver.findElement(By.xpath("//*[text()='status']"));

			Thread.sleep(1000);

			BrowserActions.jsClick(driver, stageToClick);

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

	private static void saveChangesOnEditOPTY(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="saveChangesOnEditOPTY";


		try
		{
			driver.findElement(By.xpath(PartComOpportunity.buttonSaveEdit)).click();

			new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PartComOpportunity.headerEditOPTY)));

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

	public static boolean opportunityPageValidation(List<TestLog> logStream, String testName, int stepID,
			WebDriver driver) throws Exception 
	{
		String actionName="opportunityPageValidation";


		try
		{
			if(BrowserActions.isElementPresent(driver, PartComOpportunity.optyDetails))
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


	public static boolean closeWinOPTYValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="closeWinOPTYValidation";

		try
		{
			WebElement stageToValidate=driver.findElement(By.xpath("//article/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/span/span"));

			if(stageToValidate.getText().toString().contains("Closed Won"))
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
