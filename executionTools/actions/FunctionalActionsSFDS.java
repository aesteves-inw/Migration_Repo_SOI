package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import execStructure.ExecStructure;
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceService;
import sfDirectSales.SalesforceNewMACDFlow;
import sfSikuli.SalesForceSikuli;

public class FunctionalActionsSFDS {

	
	// GENERAL FUNCTIONAL ACTIONS
	
	public static void goToByURL(WebDriver driver, int stepID, String object, String objectURL) throws Exception
	{
		 String actionName="General: Go to "+object;

			try
			{
				driver.get(objectURL);
				
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
				

				System.out.println(actionName+" - Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}
	}
	
	

	
	
	// LEGACY

	public static void navigate2Agreement(WebDriver driver, int stepID, String linkAgreementName) throws Exception
	{
		try
		{
			BrowserActions.verticalscrollByVisibleElement(driver, SalesForceOpportunity.agreementsContainer);

			if (BrowserActions.isElementPresent(driver, linkAgreementName))
			{
				driver.findElement(By.xpath(linkAgreementName)).click();

				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			}
			else
			{
				throw new Exception("Not possible to navigate into Agreement's Page on Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);

			throw new Exception("Test Procedure to Navigate to Agreement's page. Failed on StepID: "+stepID,e);
		}
	}
	
	public static void addFile2Agreement(WebDriver driver, int stepID, String file2Upload) throws Exception
	{
		Screen screen = new Screen();	

		String agreementFileTestData=ExecStructure.workingDir+"\\testData\\"+file2Upload+".pdf";


		try
		{
			//driver.findElement(By.xpath(SalesForceAgreement.uploadFilesBtn)).click();
			
			screen.click(SalesForceSikuli.uploadFilesButton);

			screen.wait(SalesForceSikuli.uploadBarFilePathOpenCancel, 20);

			screen.find(SalesForceSikuli.filePath);

			screen.paste(agreementFileTestData);

			screen.click(SalesForceSikuli.openButton);

			screen.wait(SalesForceSikuli.uploadFilesDoneSalesforce, 20);

			screen.wait(SalesForceSikuli.doneButton, 20);

			screen.click(SalesForceSikuli.doneButton);


			Thread.sleep(10000);


			WebElement file = driver.findElement(By.xpath(SalesForceAgreement.filesContainer.concat("//a[contains(.,'"+file2Upload+"')]")));

			if (file.isDisplayed() == false)
			{
				throw new Exception("Not possible to Add File on Agreement on Step ID: "+stepID);
			}


		}
		catch(Exception e)
		{
			throw new Exception("Test Procedure to Add File to Agreement. Failed on StepID: "+stepID,e);
		}
	}
/*
	public static void addFile2MACDOrder(WebDriver driver, int stepID, String file2Upload) throws Exception
	{
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

		}
		catch(Exception e)
		{
			throw new Exception("Test Procedure to Add File to MACD Order. Failed on StepID: "+stepID,e);
		}


	}
*/
	
	public static void addFile2MACDOrder(WebDriver driver, int stepID, String file2Upload) throws Exception
	{
		

		String agreementFileTestData=ExecStructure.workingDir+"\\testData\\"+file2Upload+".pdf";

		try
		{
			WebElement inputUpLoadFile=driver.findElement(By.xpath(SalesforceNewMACDFlow.inputUploadFiles));
			
			inputUpLoadFile.click();
			
			inputUpLoadFile.sendKeys(agreementFileTestData);
			
			inputUpLoadFile.sendKeys(Keys.ENTER);
			

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Procedure to Add File to MACD Order. Failed on StepID: "+stepID,e);
		}


	}
	
	
	
	
	
	
	public static void navigate2Order(WebDriver driver, int stepID, String optyName) throws Exception
	{
		String orderLinkXpath=SalesForceOpportunity.ordersContainer.concat("//a[contains(.,'"+optyName+"')]");

		try
		{
			BrowserActions.verticalscrollByVisibleElement(driver, SalesForceOpportunity.ordersContainer);

			if (BrowserActions.isElementPresent(driver, orderLinkXpath))
			{
				driver.get(driver.findElement(By.xpath(orderLinkXpath)).getAttribute("href"));

				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			}
			else
			{
				throw new Exception("Not possible to navigate into Order's Page on Step: "+stepID);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Procedure to Navigate to Order's page. Failed on StepID: "+stepID,e);
		}
	}

	public static void navigate2Service(WebDriver driver, int stepID) throws Exception
	{
		String serviceXpath=SalesForceOrders.serviceContainer.concat("//h3/div/a");

		try
		{
			driver.get(driver.findElement(By.xpath(serviceXpath)).getAttribute("href"));
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Procedure to Navigate to Order's page. Failed on StepID: "+stepID,e);
		}
	}
	
	public static void addService2Order(WebDriver driver, int stepID, String testName, String companyContactPerson) throws Exception
	{
		WebDriverWait waitAS2O = new WebDriverWait(driver, 10);

		try
		{
			driver.findElement(By.xpath(SalesForceOrders.addServiceButton)).click();

			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.detailsASSC)));
			
			//First Screen for Add Service

			driver.findElement(By.xpath(SalesForceOrders.inputDomain)).click();
			
			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.domainMobile))).click();
			
			driver.findElement(By.xpath(SalesForceOrders.inputType)).click();
			
			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.typeNewContract))).click();
			
			driver.findElement(By.xpath(SalesForceOrders.inputDetail)).click();
			
			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.domainWinback))).click();
			
			driver.findElement(By.xpath(SalesForceOrders.nextButton)).click();
			
			//Second Screen for Add Service
			
			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.secondScreen)));
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).click();
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).sendKeys(companyContactPerson);
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).sendKeys(Keys.ENTER);
			
			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'"+companyContactPerson+"')]"))).click();
			
			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate))).click();
			
			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.calendarTable)));
			
			waitAS2O.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.todayCalendarButton))).click();
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testName);
			
			driver.findElement(By.xpath(SalesForceOrders.nextButton)).click();
			
			waitAS2O.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.secondScreen)));

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Procedure to Add Service to Order. Failed on StepID: "+stepID,e);
		}
	}

	public static void enrichService(WebDriver driver, int stepID, String optyName, String testName) throws Exception 
	{
		WebDriverWait waitES = new WebDriverWait(driver, 10);

		try
		{
			//Edit Company Contact Person
			
			driver.findElement(By.xpath(SalesForceService.editCompanyContactPersonBtn)).click();
			
			waitES.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceService.inputCompanyContactPerson))).sendKeys("Simple Ordering");
					
			waitES.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceService.companyContactPersonList))).click();
			
			//Save and Validation
			driver.findElement(By.xpath(SalesForceService.saveBtn)).click();

			waitES.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceService.saveBtn)));


		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Procedure to Enrich Service Failed on StepID: "+stepID,e);
		}
	}


}



