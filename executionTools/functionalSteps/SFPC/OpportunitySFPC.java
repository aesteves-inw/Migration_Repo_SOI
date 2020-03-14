package functionalSteps.SFPC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import functionalActions.SFPC.Company;
import functionalActions.SFPC.Opportunity;

public class OpportunitySFPC {
	
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

	
	public static TestStepReportStructure opportunityAddProductScreen(WebDriver driver, WebDriverWait wait, int stepID, String testName, String testExecutionString) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Opportunity: Add Products Screen";

		String stepNameMin="opportunityAddProductScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			Company.goToOpportunityScreen(driver, stepID, testExecutionString);
			
			Opportunity.goToAddProductScreen(driver, wait, stepID, testExecutionString);

			validation = Opportunity.addProductsScreenValidation(driver, testName, stepID, testExecutionString);

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
	
	public static TestStepReportStructure optyProductConfiguration(WebDriver driver, WebDriverWait wait, int stepID, String testName, String testExecutionString) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Opportunity: Product Configuration";

		String stepNameMin="optyProductConfiguration";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		

		

		boolean validation;

		try
		{
			Opportunity.configNewMobileOpportunity(driver, wait, stepID, testExecutionString);
			
			Opportunity.configProductConfiguration(driver, wait, stepID, testExecutionString);
			

			validation = Opportunity.opportunityScreenValidation(driver, stepID);

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

	public static TestStepReportStructure soi66validation(WebDriver driver, WebDriverWait wait, String testName, int stepID, String testExecutionString) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Opportunity: SOI-66 Validation";

		String stepNameMin="soi66validation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			BrowserActions.refreshPage(driver);
			
			validation = Opportunity.soi66validation(driver, wait, testName, stepID, testExecutionString);

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
	
	
	
	
	
	}
	

