package functionalActions.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import actions.BrowserActions;
import actions.FunctionalActionsSFDS;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesforceNewMACDFlow;
import sfSikuli.SalesForceSikuli;

public class ActsSalesMACDFlow {

	// Regular Actions
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
	 *String actionName="";


			try
			{
				<JAVA CODE>

				System.out.println(actionName+" - Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}

	 */

	public static void goToNewMACDOrderScreen(WebDriver driver, int stepID) throws Exception
	{
		String actionName ="New MACD Order: New MACD Order Screen";

		try
		{
			driver.findElement(By.xpath(SalesForceCompany.newMACDOrderButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void firstMACDOrderScreen(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName ="New MACD Order: 1st MACD Order Screen - Filling Fields";		

		try
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputType)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.adminValueType))).click();

			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputDetail)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.changeAddressDetailValue))).click();

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void goToSecondMACDScreen(WebDriver driver, int stepID) throws Exception
	{
		String actionName="";

		try
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.nextButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void secondMACDOrderScreen(WebDriver driver, WebDriverWait wait, String testName, int stepID, String companyContactPerson) throws Exception
	{
		String actionName="New MACD Order: 2nd MACD Order Screen - Filling Fields";

		try
		{
			lookupCompanyContactPerson(driver, wait, stepID, companyContactPerson);
			
			lookupOrderOwner(driver, wait, stepID);
			
			lookupSalesforceID(driver, wait, stepID);
			
			inputServiceRequestDate(driver, wait, stepID);
			
			inputQuoteID(driver, stepID);
			
			inputComments(driver, stepID,testName);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}



	private static void lookupCompanyContactPerson(WebDriver driver, WebDriverWait wait, int stepID, String companyContactPerson) throws Exception 
	{
		String actionName="New MACD Order - 2ndScreen - Company Contact Person name Field";


		try
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).sendKeys(companyContactPerson);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.liCompanyContactPerson))).click();
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}
	
	
	private static void lookupOrderOwner(WebDriver driver, WebDriverWait wait, int stepID) throws Exception 
	{
		String actionName="New MACD Order - 2ndScreen - Order Owner Field";
		
		String usernameSalesforce=TestData.searchDT(0, "envUsernameNameITTQA");
		
		String orderOwnerPersonElement="//input[@placeholder='"+usernameSalesforce+"']";
		
		boolean orderOwnerPersonValidation;


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(orderOwnerPersonElement)));	
			
			orderOwnerPersonValidation=BrowserActions.isElementPresent(driver, orderOwnerPersonElement);
					
			if(orderOwnerPersonValidation == false)
			{
				driver.findElement(By.xpath(SalesforceNewMACDFlow.orderOwnerClearSelection)).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='"+usernameSalesforce+"']"))).click();
			}

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}
	

	private static void lookupSalesforceID(WebDriver driver, WebDriverWait wait, int stepID) throws Exception 
	{
		String actionName="New MACD Order - 2ndScreen - Salesforce ID Field";
		
		String usernameSalesforce=TestData.searchDT(0, "envUsernameNameITTQA");
		
		String salesforceIDElement="//input[@placeholder='"+usernameSalesforce+"']";
		
		boolean salesforceIDPreValidation;


		try
		{
			salesforceIDPreValidation=BrowserActions.isElementPresent(driver, salesforceIDElement);
			
			if(salesforceIDPreValidation==false)
			{
				driver.findElement(By.xpath(SalesforceNewMACDFlow.salesforceIDClearSelection)).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='"+usernameSalesforce+"']"))).click();
			}

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void inputServiceRequestDate(WebDriver driver, WebDriverWait wait, int stepID) throws Exception 
	{
		String actionName="New MACD Order - 2ndScreen - Service Request Date Field";


		try
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate)).sendKeys(ExecStructure.formattedDate("dd/MM/yyyy"));

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void inputQuoteID(WebDriver driver, int stepID) throws Exception 
	{
		String actionName="New MACD Order - 2ndScreen - Quote ID Field";


		try
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputQuoteID)).sendKeys("862181");

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void inputComments(WebDriver driver, int stepID, String testName) throws Exception 
	{
		String actionName="New MACD Order - 2ndScreen - Comments Field";
		
		String testExecutionString=ExecStructure.getTestExecutionString(testName);


		try
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testExecutionString);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	public static void submittingMACDOrder(WebDriver driver, WebDriverWait wait, String testName, int stepID, String companyContactPerson) throws Exception
	{
		String actionName="New MACD Order: Submitting MACD Order";


		try
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.submitOrderButton)).click();

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.submitOrderButton)));

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void addFile2MACDOrder(WebDriver driver, int stepID, String file2Upload) throws Exception
	{
		String actionName="New MACD Order: Add file to MACD Order";
		
		Screen screen = new Screen();	

		String agreementFileTestData=ExecStructure.workingDir+"\\testData\\"+file2Upload+".pdf";

		try
		{
			//driver.findElement(By.xpath("(//span[contains(.,'Upload Files')])")).click();

			screen.click(SalesForceSikuli.uploadFilesButton);

			screen.wait(SalesForceSikuli.uploadBarFilePathOpenCancel, 20);

			screen.find(SalesForceSikuli.filePath);

			screen.paste(agreementFileTestData);

			screen.click(SalesForceSikuli.openButton);

			screen.wait(SalesForceSikuli.uploadFilesDoneSalesforce, 20);

			screen.wait(SalesForceSikuli.doneButton, 20);

			screen.click(SalesForceSikuli.doneButton);
		
			Thread.sleep(10000);
			
			
			
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);
			
			
			

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}


	}

	// Validation Actions
	/*02-03-2020:LMA
	 * sketch for every validation functions
	 *=====================================
	 *String actionName="";
	 * 	try
			{
				if()
				{
					System.out.println(actionName+" - Succeeded in Step: "+stepID);
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
				throw new Exception (actionName+" - Failed in Step: "+stepID,e);
			}

	 */

	public static boolean initialFirstMACDOrderScreen(WebDriver driver, int stepID) throws Exception
	{
		String actionName="New MACD Order: Initial First MACD Order Screen Validation";

		try
		{
			if(BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.headerNewMACDOrder) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.nextButton) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.newMACDOrderScreen) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputDomain) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputType) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputDetail))
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}

	}

	public static boolean firstMACDOrderScreenValidation(WebDriver driver, int stepID) throws Exception
	{
		String actionName="New MACD Order: First Screen Validation";

		try
		{
			String vfirstScreenType=driver.findElement(By.xpath(SalesforceNewMACDFlow.inputType)).getAttribute("value");

			String vfirstScreenDetail=driver.findElement(By.xpath(SalesforceNewMACDFlow.inputDetail)).getAttribute("value");

			if(vfirstScreenType.contains("Administration") && vfirstScreenDetail.contains("Change address"))
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean initialSecondMACDOrderScreen(WebDriver driver, int stepID) throws Exception
	{
		String actionName="New MACD Order: Initial Second Screen Validation";

		try
		{
			if(BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputCompanyContactPerson) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputComments) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.uploadFilesButton))
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean secondMACDOrderScreenValidation(WebDriver driver, String testName, int stepID, String companyContactPerson) throws Exception
	{
		String actionName="New MACD Order: Second Screen Validation";
		
		String testExecutionString=ExecStructure.getTestExecutionString(testName);
		
		try
		{
			String vSecMACDCompCont=driver.findElement(By.xpath(SalesforceNewMACDFlow.secondScreen)).getText().toString();

			String vSecMACDComment=driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).getAttribute("value");

			if(vSecMACDCompCont.contains(companyContactPerson) && vSecMACDComment.contains(testExecutionString))
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean submittingMACDOrder(WebDriver driver, int stepID) throws Exception
	{
		String actionName="New MACD Order: Order Submission";

		try
		{
			if(BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.secondScreen)==false)
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}
}