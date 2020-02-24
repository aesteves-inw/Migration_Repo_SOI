package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import execStructure.ExecStructure;
import execStructure.TestData;
import io.github.sukgu.Shadow;
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceProducts;
import sfDirectSales.SalesForceService;
import sfDirectSales.SalesforceNewMACDFlow;
import sfSikuli.SalesForceSikuli;

public class FunctionalActionsSFDS {



	public static void createNewStandardOpportunity(WebDriver driver) throws Exception
	{
		WebDriverWait waitNSOS = new WebDriverWait(driver, 10);

		try
		{	
			
			String rmOpportunitiesListViewlink = driver.findElement(By.xpath(SalesForceCompany.rmOpportunitieslink)).getAttribute("href");
			
			driver.get(rmOpportunitiesListViewlink);
			
			driver.findElement(By.xpath(SalesForceOpportunity.newButton)).click();
			
			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.newOpportunityHeader)));
			
		}
		catch(Exception e)
		{
			throw new Exception ("Navigation failed to New Opportunity Screen",e);
		}
	}

	public static void inputOpportunityValues(WebDriver driver, String testExecutionString, String testName) throws Exception
	{
		WebDriverWait waitNSOS = new WebDriverWait(driver, 10);

		String optyName="OPTY_"+testExecutionString;

		String optyStage=TestData.searchDT(2, "optyStage");

		String optyForecastCategory=TestData.searchDT(2, "optyForecastCategory");
		

		try
		{
			
			driver.findElement(By.xpath(SalesForceOpportunity.inputOpportunityName)).clear();

			driver.findElement(By.xpath(SalesForceOpportunity.inputOpportunityName)).sendKeys(optyName);

			driver.findElement(By.xpath(SalesForceOpportunity.inputCloseDate)).clear();

			driver.findElement(By.xpath(SalesForceOpportunity.inputCloseDate)).sendKeys(ExecStructure.formattedDate("dd/MM/yyyy"));

			driver.findElement(By.xpath(SalesForceOpportunity.selectStage)).click();

			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyStage+"']"))).click();

			driver.findElement(By.xpath(SalesForceOpportunity.selectForecastCategory)).click();

			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyForecastCategory+"']"))).click();
			

			//14-02-2020 - Adding Terms&Conditions value to the oppie

			BrowserActions.verticalscrollByVisibleElement(driver, SalesForceOpportunity.additionalInformationTab);

			driver.findElement(By.xpath(SalesForceOpportunity.termsAndConditionsComboBox)).click();

			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.termAndConditionsOption))).click();

			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		}
		catch(Exception e)
		{
			throw new Exception ("Input on Opportunity Screen Failed",e);
		}
	}

	public static void addProductToOppie(WebDriver driver, String product) throws Exception
	{
		WebDriverWait waitAp2o = new WebDriverWait(driver, 10);

		String product2Add = TestData.searchDT(2,product);

		try
		{
			driver.findElement(By.xpath(SalesForceProducts.inputSearchProducts)).clear();

			driver.findElement(By.xpath(SalesForceProducts.inputSearchProducts)).sendKeys(product2Add);
			
			driver.findElement(By.xpath(SalesForceProducts.inputSearchProducts)).sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[2]/span/span/label/span[1]")).click();
			
			driver.findElement(By.xpath(SalesForceProducts.nextButtonScreen)).click();

			waitAp2o.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceProducts.editProductHeader)));

		}
		catch(Exception e)
		{
			throw new Exception ("Add Product To Opportunity Failed",e);
		}
	}

	public static void editProductConfiguration(WebDriver driver, int tcNumber) throws Exception
	{
		String[] config2Apply=TestData.prodConfiguration(tcNumber);

		WebDriverWait wait = new WebDriverWait(driver,10);

		try
		{

			driver.findElement(By.xpath(SalesForceProducts.totalContractValue)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceProducts.inputContractValue))).sendKeys(config2Apply[0]);

			driver.findElement(By.xpath(SalesForceProducts.contractDuration)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceProducts.inputContratDuration))).sendKeys(config2Apply[1]);

			driver.findElement(By.xpath(SalesForceProducts.revenueType)).click();
			driver.findElement(By.xpath(SalesForceProducts.revenueType)).click();
			driver.findElement(By.linkText(config2Apply[2])).click();

			BrowserActions.ScrollByPixs(driver, 100, 0);

			driver.findElement(By.xpath(SalesForceProducts.productRegimeType)).click();
			driver.findElement(By.xpath(SalesForceProducts.productRegimeType2)).click();
			driver.findElement(By.linkText(config2Apply[3])).click();

			driver.findElement(By.xpath(SalesForceProducts.saveButtonEdit)).click();

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceProducts.editProductHeader)));

		}
		catch(Exception e)
		{
			throw new Exception ("Edit Product Configuration Failed",e);
		}
	}

	public static void closeWonOppie(WebDriver driver) throws Exception
	{
		WebDriverWait waitCWO = new WebDriverWait(driver, 10);
		
		Screen screen = new Screen();

		try
		{
			screen.wait(SalesForceSikuli.closeOPTYBtn, 20);
			
			screen.click(SalesForceSikuli.closeOPTYBtn);
			
			screen.wait(SalesForceSikuli.selectClosedStageBtn, 20);
			
			screen.click(SalesForceSikuli.selectClosedStageBtn);
			
			waitCWO.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.ctomHeader)));

			Select closedStage = new Select(driver.findElement(By.xpath("//select")));

			closedStage.selectByVisibleText("Closed Won");

			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();

			waitCWO.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceOpportunity.ctomHeader)));

			driver.navigate().refresh();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		}
		catch(Exception e)
		{
			throw new Exception ("Closing Won Opportunity - Failed",e);
		}
	}

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

	public static void findAgreementOnOPTY(WebDriver driver, int stepID, String linkAgreementName) throws Exception
	{

		WebDriverWait waitFAO = new WebDriverWait(driver, 10);

		try
		{

			for(int i=0;i<2;i++)
			{
				waitFAO.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.agreementsContainer)));

				BrowserActions.verticalScrollByPixs(driver, BrowserActions.getYOfElement(driver, SalesForceOpportunity.agreementsContainer));

				Thread.sleep(3000);
			}


			waitFAO.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkAgreementName)));

			BrowserActions.verticalScrollByPixs(driver, BrowserActions.getYOfElement(driver, linkAgreementName));

		}
		catch(Exception e)
		{
			throw new Exception("Test Procedure to find Agreement on Opportunity's Related Menu. Failed on StepID: "+stepID,e);
		}
	}

	public static void findOrderOnCompany(WebDriver driver, int stepID) throws Exception
	{
		WebDriverWait waitFOC = new WebDriverWait(driver, 10);

		try
		{

			for(int i=0;i<2;i++)
			{
				waitFOC.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceCompany.articleOrders)));

				BrowserActions.verticalScrollByPixs(driver, BrowserActions.getYOfElement(driver, SalesForceCompany.articleOrders));

				Thread.sleep(3000);
			}


			waitFOC.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceCompany.firstOrderLink)));

			BrowserActions.verticalScrollByPixs(driver, BrowserActions.getYOfElement(driver, SalesForceCompany.firstOrderLink));

		}
		catch(Exception e)
		{
			throw new Exception("Test Procedure to find Agreement on Opportunity's Related Menu. Failed on StepID: "+stepID,e);
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



