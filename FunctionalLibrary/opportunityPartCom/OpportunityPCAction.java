package opportunityPartCom;

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

	public static void closeWinOPTY(List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception 
	{
		String actionName="closeWinOPTY";

		String status="Closed Won";

		try
		{
			goToEditOPTYScreenInOptyDetailPageInPC(logStream, driver, stepID);

			fillOtherMandatoryFieldsOfOpportunityInPC(logStream, driver, stepID, testName);

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



	private static void fillOtherMandatoryFieldsOfOpportunityInPC(List<TestLog> logStream, WebDriver driver, int stepID,
			String testName) throws Exception
	{
		String actionName="fillOtherMandatoryFieldsOfOpportunityInPC";


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


		try
		{
			WebElement selectLevelOfConfidence=driver.findElement(By.xpath("(//a[@class='select'])[3]"));
			
			BrowserActions.jsClick(driver, selectLevelOfConfidence);
			
			Thread.sleep(1000);
			
			WebElement confidenceLevel=driver.findElement(By.xpath("//a[@title='High (100%)']"));
			
			BrowserActions.jsClick(driver, confidenceLevel);
			
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
			WebElement inputNextStep = driver.findElement(By.xpath("(//input[@maxlength='255'])[1]"));

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
			WebElement inputNextStepDueDate = driver.findElement(By.xpath("//article/div[3]/div/div[1]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div/input"));

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
		

		String productFamily="Fix Data";

		try
		{
			WebElement selectProductFamily=driver.findElement(By.xpath("(//a[@class='select'])[4]"));
			
			BrowserActions.jsClick(driver, selectProductFamily);
			
			Thread.sleep(1000);
			
			WebElement productFamilyOption=driver.findElement(By.xpath("//a[@title='"+productFamily+"']"));
			
			BrowserActions.jsClick(driver, productFamilyOption);
			
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

		String competitorName="No competitor";

		try
		{
			
			WebElement competitorNameOption=driver.findElement(By.xpath("//span[@title='"+competitorName+"']"));
			
			BrowserActions.jsClick(driver, competitorNameOption);
			
			Thread.sleep(1000);
			
			
			WebElement moveSelectionToChosen=driver.findElement(By.xpath("//button[@title='Move selection to Chosen']"));
			
			BrowserActions.jsClick(driver, moveSelectionToChosen);
			
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

	private static void goToEditOPTYScreenInOptyDetailPageInPC(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="goToEditOPTYScreenInOptyDetailPage";


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

	private static void changeStageField(List<TestLog> logStream, WebDriver driver, int stepID, String status) throws Exception 
	{
		String actionName="changeStageField";


		try
		{
			WebElement comboBoxStage=driver.findElement(By.xpath(PartComOpportunity.comboStage));

			Thread.sleep(1000);

			BrowserActions.jsClick(driver, comboBoxStage);

			Thread.sleep(1000);

			WebElement stageToClick=driver.findElement(By.xpath("//*[text()='"+status+"']"));

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
			
			Thread.sleep(5000);

			new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PartComOpportunity.headerEditOPTY)));

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
