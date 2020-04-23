package functionalSteps.SFPC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import functionalActions.SFPC.ActsPartsCompany;
import functionalActions.SFPC.ActsPartsOpportunity;

public class StpsPartsCompany {
	
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
	
	public static TestStepReportStructure createNewOpportunity(WebDriver driver, WebDriverWait wait, int stepID, String testName, String testExecutionString) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Company: Create New Opportunity";

		String stepNameMin="createNewOpportunity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsPartsCompany.createNewOpportunity(driver, stepID);
			
			ActsPartsOpportunity.opportunityNewOpportunityScreen(driver, wait, stepID, testExecutionString);

			validation = ActsPartsOpportunity.newOpportunityDetailsPage(driver, testName, stepID, testExecutionString);

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
