package functionalActions.SFDS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesforceNewMACDFlow;

public class ActsSalesNewContractFlow {
	// Regular Actions
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
	 *public static void ()
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
	
	

	public static void creatingSerivceFromOrder(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName="Order: New Service Screen";


		try
		{
			driver.findElement(By.xpath(SalesForceOrders.addServiceButton)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.detailsASSC)));


			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void firstScreenNewContactFlow(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName="New Contact Flow: First Screen";


		try
		{
			driver.findElement(By.xpath(SalesForceOrders.inputDomain)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.domainMobile))).click();

			driver.findElement(By.xpath(SalesForceOrders.inputType)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.typeNewContract))).click();

			driver.findElement(By.xpath(SalesForceOrders.inputDetail)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.domainWinback))).click();

			driver.findElement(By.xpath(SalesForceOrders.nextButton)).click();

			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.secondScreen)));


			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void secondScreenNewContactFlow(WebDriver driver, WebDriverWait wait, String testName, int stepID, String companyContactPerson) throws Exception
	{
		String actionName="New Contact Flow: Second Screen";


		try
		{
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).click();

			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).sendKeys(companyContactPerson);

			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).sendKeys(Keys.ENTER);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'"+companyContactPerson+"')]"))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.calendarTable)));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.todayCalendarButton))).click();

			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testName);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void savingService(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName="New Contact Flow: Save Service";


		try
		{
			WebElement nextButton = driver.findElement(By.xpath(SalesForceOrders.nextButton));
			
			nextButton.click();
			
			
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.secondScreen)));


			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void addService2Order(WebDriver driver, WebDriverWait wait, int stepID, String testName, String companyContactPerson) throws Exception
	{
		String actionName="New Contract Flow: Full Flow";

		try
		{
			creatingSerivceFromOrder(driver, wait, stepID);

			//First Screen for Add Service

			driver.findElement(By.xpath(SalesForceOrders.inputDomain)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.domainMobile))).click();

			driver.findElement(By.xpath(SalesForceOrders.inputType)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.typeNewContract))).click();

			driver.findElement(By.xpath(SalesForceOrders.inputDetail)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.domainWinback))).click();

			driver.findElement(By.xpath(SalesForceOrders.nextButton)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.secondScreen)));

			//Second Screen for Add Service



			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).click();

			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).sendKeys(companyContactPerson);

			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).sendKeys(Keys.ENTER);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'"+companyContactPerson+"')]"))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.calendarTable)));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.todayCalendarButton))).click();

			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testName);

			driver.findElement(By.xpath(SalesForceOrders.nextButton)).click();

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.secondScreen)));


			System.out.println(actionName+" - Succeeded in Step: "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}




	// Validation Actions
	/*02-03-2020:LMA
	 * sketch for every validation functions
	 *=====================================
	 *public static boolean ()
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
					throw new Exception (actionName+" - Failed in Step: "+stepID,e);
				}

	 */

	public static boolean initialContractFlowScreenValidation(WebDriver driver, int stepID) throws Exception
	{
		String actionName="New Contact Flow: initial Screen validation";

		try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.inputDomain) && BrowserActions.isElementPresent(driver, SalesForceOrders.inputType) && BrowserActions.isElementPresent(driver, SalesForceOrders.inputDetail) && BrowserActions.isElementPresent(driver, SalesForceOrders.nextButton))
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

	}

	public static boolean secondScreenContactFlow(WebDriver driver, int stepID) throws Exception
	{
		String actionName="New Contact Flow: Second Screen validation";

		try
		{
			if(BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputCompanyContactPerson) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.inputComments))
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
	}
}

