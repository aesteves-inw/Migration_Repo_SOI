package functionalSteps.SFDS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.FunctionalActionsSFDS;
import executionTools.BrowserActions;
import executionTools.ExecStructure;
import functionalActions.CS.ActsCSProductBasket;
import functionalActions.SFDS.ActsSalesOpportunity;
import sfDirectSales.SalesForceOrders;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;

public class StpsSalesOpportunity {
	
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
	
	
	

	//Navigation Steps
	public static TestStepReportStructure navigate2Order(WebDriver driver, String testName, int stepID, String optyName) throws Exception
	{
		TestStepReportStructure navigate2Order;


		String stepName="Opportunity: Navigate to Order Screen";

		String stepNameMin="navigate2Order";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		try
		{
			FunctionalActionsSFDS.navigate2Order(driver, stepID, optyName);
			
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.addServiceButton) && BrowserActions.isElementPresent(driver, SalesForceOrders.submitOrderButton) && BrowserActions.isElementPresent(driver, SalesForceOrders.servicesContainer) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderDetails) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderHeader))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigate2Order=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return navigate2Order;
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
			navigate2Order=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return navigate2Order;
		}
		
	}
	
	public static TestStepReportStructure navigate2Agreement(WebDriver driver, String testName, int stepID,
			String optyName) throws Exception 
	{
		TestStepReportStructure step;


		String stepName="step";

		String stepNameMin="step";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			
			
			
			
			

			//validation = 

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
	
	
	// Operational Steps
	
	
	
	
	public static TestStepReportStructure soi66Validation(WebDriver driver, String testName, int stepID, String linkAgreementName) throws Exception
	{
		TestStepReportStructure soi66Validation;


		String stepName="Opportunity: SOI-66 Validation";

		String stepNameMin="soi66Validation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		boolean validation;
		
		try
		{
			ActsSalesOpportunity.findAgreementOnOPTY(driver, stepID);
			
			validation=ActsSalesOpportunity.soi66opportunityValidation(driver, stepID, evidenceName);
			
			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				soi66Validation=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return soi66Validation;
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
			soi66Validation=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return soi66Validation;
		}
	}

	public static TestStepReportStructure negativeSoi66Validation(WebDriver driver, String testName, int stepID, String linkAgreementName) throws Exception
	{
		TestStepReportStructure negativeSoi66Validation;


		String stepName="Opportunity: SOI-66 Validation (Negative)";

		String stepNameMin="negativeSoi66Validation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		boolean validation;
		
		try
		{
			ActsSalesOpportunity.findAgreementOnOPTY(driver, stepID);
			
			validation=ActsSalesOpportunity.soi66opportunityValidation(driver, stepID, evidenceName);
			
			if(validation==false)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				negativeSoi66Validation=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return negativeSoi66Validation;
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
			negativeSoi66Validation=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return negativeSoi66Validation;
		}
	}
	///*
	public static TestStepReportStructure closingWonOPTY(WebDriver driver, int stepID, String testName, String optyName) throws Exception
	{
		TestStepReportStructure closingWonOPTY;


		String stepName="Opportunity: Closing Won Opportunity";

		String stepNameMin="closingWonOPTY";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsSalesOpportunity.closeWonOppie(driver, stepID);
			
			//BrowserActions.refreshPage(driver);

			validation = ActsSalesOpportunity.validationClosedWonOpty(driver, stepID, optyName);

			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				closingWonOPTY=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return closingWonOPTY;
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
			closingWonOPTY=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return closingWonOPTY;
		}

	}
	
	public static TestStepReportStructure noClosingWonOPTY(WebDriver driver, int stepID, String testName, String optyName) throws Exception
	{
		TestStepReportStructure noClosingWonOPTY;


		String stepName="Opportunity: No Closing Won Opportunity";

		String stepNameMin="noClosingWonOPTY";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsSalesOpportunity.closeWonOppie(driver, stepID);
			
			//BrowserActions.refreshPage(driver);

			validation = ActsSalesOpportunity.negativeValidationClosedWonOpty(driver, stepID, optyName);

			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				noClosingWonOPTY=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return noClosingWonOPTY;
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
			noClosingWonOPTY=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return noClosingWonOPTY;
		}

	}

	public static TestStepReportStructure soi68Validation(WebDriver driver, int stepID, String testName, String optyName) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Opportunity: SOI-68 Validation";

		String stepNameMin="soi68Validation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsSalesOpportunity.orderVisibleOnOpportunityScreen(driver, stepID, optyName);

			validation = ActsSalesOpportunity.soi68opportunityValidation(driver, stepID, optyName);

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
	
	public static TestStepReportStructure negativeSoi68Validation(WebDriver driver, int stepID, String testName, String optyName) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Opportunity: SOI-68 Negative Validation";

		String stepNameMin="negativeSoi68Validation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	


		boolean validation;

		try
		{
			
			ActsSalesOpportunity.orderVisibleOnOpportunityScreen(driver, stepID, optyName);
			
			validation = ActsSalesOpportunity.soi68opportunityValidation(driver, stepID, optyName);
			
			System.out.println("negativeSoi68Validation - validation: "+validation);

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
	
	
	public static TestStepReportStructure createNewProductBasketEmpty(WebDriver driver, int stepID, String testName) throws Exception
	{
		TestStepReportStructure createNewProductBasketEmpty;


		String stepName="Opportunity: Create a New Product Basket (Empty)";

		String stepNameMin="createNewProductBasketEmpty";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		boolean validation;

		try
		{
			
			ActsSalesOpportunity.createNewProductBasket(driver, wait, stepID);
						
			validation = ActsCSProductBasket.productBasketScreenValidation(driver, wait, stepID);

			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				createNewProductBasketEmpty=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return createNewProductBasketEmpty;
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
			createNewProductBasketEmpty=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return createNewProductBasketEmpty;
		}

	}





	
	
}

/*
TestStepReportStructure <stepNameMin>;


String stepName="Login in Partners Community";

String stepNameMin="loginSFPC";

String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);


throw new Exception (stepName+" - Failed in Step: "+stepID);
 */