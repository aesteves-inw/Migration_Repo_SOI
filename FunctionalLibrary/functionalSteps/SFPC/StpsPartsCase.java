package functionalSteps.SFPC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import executionTools.ExecStructure;
import sfPartnersCommunity.SFPC_Case;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;

public class StpsPartsCase {
	
	
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
	
	
	
	public static TestStepReportStructure caseValidationBySOI880(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure caseValidationBySOI880;


		String stepName="Case's Page Validation according with SOI-880";

		String stepNameMin="caseValidationBySOI880";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		try
		{
			String caseStatus=driver.findElement(By.xpath(SFPC_Case.caseStatusLabel)).getText();
			String caseOwner=driver.findElement(By.xpath(SFPC_Case.caseOwnerFieldLabel)).getText();
			
			if(caseStatus.toLowerCase()=="open" && caseOwner.isEmpty()==false)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				caseValidationBySOI880=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return caseValidationBySOI880;
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
			caseValidationBySOI880=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return caseValidationBySOI880;
		}
	}

}
