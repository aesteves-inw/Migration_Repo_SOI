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

		try
		{
			WebElement editBtn=driver.findElement(By.xpath("//div/div[2]/div[2]/div/div[2]/button"));
			
			BrowserActions.jsClick(driver, editBtn);
			
			Thread.sleep(1000);
			
			WebElement menu = driver.findElement(By.xpath("//article/div[3]/div/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a"));
			
			BrowserActions.jsClick(driver, menu);
			
			Thread.sleep(1000);
			
			WebElement status=driver.findElement(By.xpath("//a[@title='Closed Won']"));
			
			BrowserActions.jsClick(driver, status);
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//article/div[3]/div/div[2]/div/div/div[2]/button[2]")).click();
			
			//new WebDriverWait(driver,15).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//article/div[3]/div/div[2]/div/div/div[2]/button[2]")));
			
			Thread.sleep(10000);

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
