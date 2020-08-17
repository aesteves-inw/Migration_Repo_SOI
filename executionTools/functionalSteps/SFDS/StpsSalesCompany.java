package functionalSteps.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import actions.FunctionalActionsSFDS;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import functionalActions.SFDS.ActsSalesCompany;
import functionalActions.SFDS.ActsSalesOpportunity;
import functionalActions.SFDS.ActsSalesOrder;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesforceCase;
import sfDirectSales.SalesforceNewMACDFlow;

public class StpsSalesCompany {
	
	// 14-03-2020: Example/Template for steps
				/*
				public static TestStepReportStructure step(WebDriver driver, int stepID, String testName) throws Exception
				{
					TestStepReportStructure step;


					String stepName="step";

					String stepNameMin="step";

					String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


					boolean validation;

					try
					{
						<FUNCTIONAL STEPS>
						
						<FUNCTIONAL STEPS>
						
						<FUNCTIONAL STEPS>

						validation = <FUNCTIONAL STEP FOR VALIDATION>

						if(validation==true)
						{
							ExecStructure.screenShotTaking(driver, testName, evidenceName);
							step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
							return step;
						}
						else
						{
							throw new Exception (stepName+" - Failed in Step: "+stepID);
						}


					}
					catch(Exception e)
					{
						System.out.println(e);
						ExecStructure.screenShotTaking(driver, testName, evidenceName);
						step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
						return step;
					}

				}

			*/
	
	
	
	// Navigation Steps
	public static TestStepReportStructure navigate2CompanyCasesListView(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure navigate2CompanyCasesListView;


		String stepName="Company: Navigate to Company Case's List View";

		String stepNameMin="navigate2CompanyCasesListView";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		try
		{
			WebElement caseLinkElement=driver.findElement(By.xpath(SalesForceCompany.caseHeader));
			
			String casesListViewURL=caseLinkElement.getAttribute("href");
			
			driver.get(casesListViewURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesforceCase.newBtn) && BrowserActions.isElementPresent(driver, SalesforceCase.changeOwner) && BrowserActions.isElementPresent(driver, SalesforceCase.showQuickFilters) && BrowserActions.isElementPresent(driver, SalesforceCase.refreshBtn) && BrowserActions.isElementPresent(driver, SalesforceCase.listViewControlsBtn) && BrowserActions.isElementPresent(driver, SalesforceCase.casesTable))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigate2CompanyCasesListView=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return navigate2CompanyCasesListView;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			navigate2CompanyCasesListView=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return navigate2CompanyCasesListView;
		}
	}
	
	public static TestStepReportStructure navigate2FirstOrder(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure navigate2FirstOrder;


		String stepName="Company: Navigate to the First Order of Related Menu";

		String stepNameMin="navigate2FirstOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		try
		{
			Actions actions=new Actions(driver);
			
			WebElement firstOrderLink=driver.findElement(By.xpath(SalesForceCompany.firstOrderLink));
			
			actions.moveToElement(firstOrderLink).build().perform();
			
			String orderlink=firstOrderLink.getAttribute("href");
			
			driver.get(orderlink);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.servicesContainer) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderDetails) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderHeader))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigate2FirstOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return navigate2FirstOrder;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			navigate2FirstOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return navigate2FirstOrder;
		}
	}
	
	
	
	
	
	// Operational Steps
	public static TestStepReportStructure createStandardOppie(WebDriver driver, int stepID, String testName, String testExecutionString) throws Exception
	{
		
		TestStepReportStructure createStandardOppie;


		String stepName="Create Standard Opportunity";

		String stepNameMin="createStandardOppie";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		boolean validation;
		
		try
		{
			ActsSalesCompany.createNewStandardOpportunity(driver, stepID);

			ActsSalesOpportunity.inputOpportunityValues(driver, testExecutionString, testName);

			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			validation=ActsSalesOpportunity.productScreenValidation(driver, stepID);

			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				createStandardOppie=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return createStandardOppie;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Create New Opportunity");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			createStandardOppie=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return createStandardOppie;
		}
	}
	
	public static TestStepReportStructure createMACDOrder(WebDriver driver, String testName, int stepID, String companyContactPerson) throws Exception
	{
		TestStepReportStructure createMACDOrder;


		String stepName="Create New MACD Order";

		String stepNameMin="createMACDOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		try
		{
			
			//Pressing 'New MACD Order' Button
			driver.findElement(By.xpath(SalesForceCompany.newMACDOrderButton)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			
			//MACD Order: First Screen
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputType)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.adminValueType))).click();
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputDetail)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.changeAddressDetailValue))).click();
			
			
			//MACD Order: Navigate to the Second Screen
			driver.findElement(By.xpath(SalesforceNewMACDFlow.nextButton)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.secondScreen)));
			
			
			
			//MACD Order: Second Screen
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).click();
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputCompanyContactPerson)).sendKeys(companyContactPerson);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'"+companyContactPerson+"')]"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.inputServiceRequestDate))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.calendarTable)));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceNewMACDFlow.todayCalendarButton))).click();
			
			driver.findElement(By.xpath(SalesforceNewMACDFlow.inputComments)).sendKeys(testName);
			
			FunctionalActionsSFDS.addFile2MACDOrder(driver, stepID, "SimpleOrdering_Dummy_File");
			
			
			//MACD Order: Second Screen - Submitting the Order
			driver.findElement(By.xpath(SalesforceNewMACDFlow.submitOrderButton)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesforceNewMACDFlow.secondScreen)==false)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				createMACDOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return createMACDOrder;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			createMACDOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return createMACDOrder;
		}
	}
	
	public static TestStepReportStructure configNewMobileOpportunity(WebDriver driver, WebDriverWait wait, String testName, String testExecutionString, int stepID) throws Exception
	{
		TestStepReportStructure configNewMobileOpportunity;


		String stepName="Company: Configure new Mobile Voice Opportunity";

		String stepNameMin="createNewMobileOpportunity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		boolean validation;
		
		
		String optyName="OPTY_"+testExecutionString;
		
		String optyElement="//a[@title='"+optyName+"']";
		
		try
		{
			ActsSalesOpportunity.addProductToOppie(driver, stepID, "mobileVoice");
			
			ActsSalesOpportunity.editProductConfiguration(driver, 1, stepID);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.optyTablePool)));
			
			driver.get(driver.findElement(By.xpath(optyElement)).getAttribute("href"));
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
			
			validation=ActsSalesOpportunity.opportunityScreenValidation(driver, stepID);
			
			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				configNewMobileOpportunity=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return configNewMobileOpportunity;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			configNewMobileOpportunity=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return configNewMobileOpportunity;
		}
		
	}
	
	public static TestStepReportStructure configNewNonMobileOpportunity(WebDriver driver, WebDriverWait wait, String testName, String testExecutionString, int stepID) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Company: Configure new Opportunity - Not Mobile Voice";

		String stepNameMin="configNewNonMobileOpportunity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		boolean validation;
		
		
		String optyName="OPTY_"+testExecutionString;
		
		String optyElement="//a[@title='"+optyName+"']";
		
		
		try
		{
			ActsSalesOpportunity.addProductToOppie(driver, stepID, "nonMobileVoice");
			
			ActsSalesOpportunity.editProductConfiguration(driver, 1, stepID);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.optyTablePool)));
			
			driver.get(driver.findElement(By.xpath(optyElement)).getAttribute("href"));
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
			
			
			validation=ActsSalesOpportunity.opportunityScreenValidation(driver, stepID);
			
			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return step;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return step;
		}
	}
	
	/*
	public static TestStepReportStructure createCloseStandardMobileVoiceOppie(WebDriver driver, int stepID, String testName, String testExecutionString) throws Exception
	{
		TestStepReportStructure createCloseStandardMobileVoiceOppie;


		String stepName="Create and Close Mobile Voice Opportunity";

		String stepNameMin="createCloseStandardMobileVoiceOppie";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		try
		{
			ActsSalesCompany.createNewStandardOpportunity(driver, stepID);

			ActsSalesOpportunity.inputOpportunityValues(driver, testExecutionString, testName);

			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			ActsSalesOpportunity.addProductToOppie(driver, stepID, "mobileVoice");

			ActsSalesOpportunity.editProductConfiguration(driver, 1, stepID);

			ActsSalesOpportunity.closeWonOppie(driver, stepID);

			if (BrowserActions.isElementPresent(driver, SalesForceOpportunity.stageClosedWonDetails))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				createCloseStandardMobileVoiceOppie=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return createCloseStandardMobileVoiceOppie;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			createCloseStandardMobileVoiceOppie=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return createCloseStandardMobileVoiceOppie;
		}
	}
*/
	public static TestStepReportStructure ordersActionsCompanyRelatedMenu(WebDriver driver, int stepID, String testName) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Company: Orders Area validation on Related Menu";

		String stepNameMin="ordersActionsCompanyRelatedMenu";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsSalesCompany.ordersShowMoreMenu(driver, stepID);

			validation = ActsSalesCompany.orderActionsMenuValidation(driver, stepID);

			if(validation==false)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return step;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return step;
		}
	}
	
	public static TestStepReportStructure companyOrdersListViewPageValidation(WebDriver driver, WebDriverWait wait, int stepID, String testName) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Company: Go to Orders List View from Company's Related Menu";

		String stepNameMin="companyOrdersPageValidation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsSalesCompany.goToOrdersListViewPageFromCompany(driver, stepID);

			validation = ActsSalesOrder.orderListViewPageValidation(driver, wait, stepID);

			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return step;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return step;
		}

	}

	// Delivery 02
	
	public static TestStepReportStructure createNewQuickSaleOpportunity(WebDriver driver, int stepID, String testName) throws Exception
	{
		TestStepReportStructure createNewQuickSaleOpportunity;


		String stepName="Company: Create New Quick Sale Opportunity";

		String stepNameMin="createNewQuickSaleOpportunity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		
		
		
		boolean validation, validationQuickSaleOpty;

		try
		{
			ActsSalesCompany.createNewQuickSaleOPTY(driver, stepID, testName);
			
			validationQuickSaleOpty = ActsSalesCompany.validateNewQuickSaleOPTY(driver, stepID, testName);
			
			if (validationQuickSaleOpty == true)
			{
				ActsSalesCompany.goToOpportunityOnRelatedMenu(driver, stepID, testName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
			validation=ActsSalesOpportunity.opportunityScreenValidation(driver, stepID);

			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				createNewQuickSaleOpportunity=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return createNewQuickSaleOpportunity;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			createNewQuickSaleOpportunity=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return createNewQuickSaleOpportunity;
		}

	}
	

}




/*
TestStepReportStructure <stepNameMin>;


String stepName="Login in Partners Community";

String stepNameMin="loginSFPC";

String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);


public static TestStepReportStructure
*/