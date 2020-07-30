package functionalSteps.CS;

import org.openqa.selenium.WebDriver;

import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import functionalActions.CS.ActsCSVoiceContinuity;

public class StpsCSEditProductConfiguration {
	
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
	
	public static TestStepReportStructure configureVoiceContinuityByDefault(WebDriver driver, int stepID, String testName) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Configure Voice Continuity (By Default)";

		String stepNameMin="configureVoiceContinuityByDefault";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsCSVoiceContinuity.configureVCByDefault(driver, stepID, testName);
			
			validation = ActsCSVoiceContinuity.validateVCByDefault(driver, stepID, testName);

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
