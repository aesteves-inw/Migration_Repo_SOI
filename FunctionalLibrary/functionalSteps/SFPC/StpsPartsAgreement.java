package functionalSteps.SFPC;

import org.openqa.selenium.WebDriver;

import executionTools.ExecStructure;
import functionalActions.SFPC.ActsPartsAgreement;
import functionalActions.SFPC.ActsPartsOpportunity;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;

public class StpsPartsAgreement {

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
	
	public static TestStepReportStructure agreementValidation(WebDriver driver, int stepID, String testName, String testExecutionString) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Agreement: Agreement screen validation";

		String stepNameMin="agreementValidation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsPartsOpportunity.goToAgreementScreen(driver, stepID, testExecutionString);
			
			validation = ActsPartsAgreement.validateAgreementScreen(driver, stepID);

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

	public static TestStepReportStructure addFile2Agreement(WebDriver driver, int stepID, String testName) throws Exception
	{
		TestStepReportStructure addFile2Agreement;


		String stepName="Agreement: Add File to Agreement";

		String stepNameMin="addFile2Agreement";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsPartsAgreement.addFile2Agreement(driver, stepID);

			validation = ActsPartsAgreement.singleFileValidation(driver, stepID);

			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				addFile2Agreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return addFile2Agreement;
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
			addFile2Agreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return addFile2Agreement;
		}

	}
	
	public static TestStepReportStructure goToOpportunityScreen(WebDriver driver, int stepID, String testName, String testExecutionString) throws Exception
	{
		TestStepReportStructure step;


		String stepName="step";

		String stepNameMin="goToOpportunityScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsPartsAgreement.goToOpportunityScreen(driver, stepID, testExecutionString);

			validation = ActsPartsOpportunity.opportunityScreenValidation(driver, stepID);

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
