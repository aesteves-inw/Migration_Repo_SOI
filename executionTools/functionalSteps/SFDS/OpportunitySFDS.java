package functionalSteps.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.BrowserActions;
import actions.FunctionalActionsSFDS;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import functionalActions.SFDS.Opportunity;
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;

public class OpportunitySFDS {
	
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
	public static TestStepReportStructure navigate2Agreement(WebDriver driver, String testName, int stepID, String optyName) throws Exception
	{
		TestStepReportStructure navigate2Agreement;


		String stepName="Opportunity: Navigate to Agreement Page";

		String stepNameMin="navigate2Agreement";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		
		try
		{
			String linkAgreementName=SalesForceOpportunity.agreementsContainer.concat("//a[contains(.,'"+optyName+"')]");
			
			driver.get(driver.findElement(By.xpath(linkAgreementName)).getAttribute("href"));
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
			if(BrowserActions.isElementPresent(driver, SalesForceAgreement.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceAgreement.headerAgreementPage) && BrowserActions.isElementPresent(driver, SalesForceAgreement.detailsAgreement) && BrowserActions.isElementPresent(driver, SalesForceAgreement.nameAgreement))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigate2Agreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return navigate2Agreement;
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
			navigate2Agreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return navigate2Agreement;
		}
	}
	
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
			Opportunity.findAgreementOnOPTY(driver, stepID);
			
			validation=Opportunity.soi66opportunityValidation(driver, stepID, evidenceName);
			
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
			Opportunity.findAgreementOnOPTY(driver, stepID);
			
			validation=Opportunity.soi66opportunityValidation(driver, stepID, evidenceName);
			
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

	
}

/*
TestStepReportStructure <stepNameMin>;


String stepName="Login in Partners Community";

String stepNameMin="loginSFPC";

String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);


throw new Exception (stepName+" - Failed in Step: "+stepID);
 */