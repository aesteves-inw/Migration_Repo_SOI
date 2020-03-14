package functionalSteps.SFDS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import functionalActions.SFDS.MACDFlow;

public class MACDFlowSDFS {
	
	
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
	
	
	
	//MACD Order by Steps
	public static TestStepReportStructure createMACDOrder(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure step;


		String stepName="MACD Order: Create MACD Order";

		String stepNameMin="createMACDOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		try
		{
			MACDFlow.goToNewMACDOrderScreen(driver, stepID);
			
			boolean validation = MACDFlow.initialFirstMACDOrderScreen(driver, stepID);
			
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

	public static TestStepReportStructure firstMACDOrderScreen(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure step;


		String stepName="MACD Order: First Screen";

		String stepNameMin="firstMACDOrderScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		try
		{
			MACDFlow.firstMACDOrderScreenValidation(driver, stepID);
			
			boolean validation = MACDFlow.firstMACDOrderScreenValidation(driver, stepID);
			
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
	
	public static TestStepReportStructure goToSecondMACDOrderScreen(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure step;


		String stepName="MACD Order: Go to second screen of MACD Order";

		String stepNameMin="goToSecondMACDOrderScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		try
		{
			MACDFlow.goToSecondMACDScreen(driver, stepID);
			
			boolean validation=MACDFlow.initialSecondMACDOrderScreen(driver, stepID);
			
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
	
	public static TestStepReportStructure secondMACDOrderScreen(WebDriver driver, WebDriverWait wait, String testName, int stepID, String companyContactPerson) throws Exception
	{
		TestStepReportStructure step;


		String stepName="MACD Order: Second Screen";

		String stepNameMin="secondMACDOrderScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		try
		{
			MACDFlow.secondMACDOrderScreen(driver, wait, testName, stepID, companyContactPerson);
			
			boolean validation=MACDFlow.secondMACDOrderScreenValidation(driver, testName, stepID, companyContactPerson);
			
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

	public static TestStepReportStructure submittingMACDOrder(WebDriver driver, WebDriverWait wait, String testName, int stepID, String companyContactPerson) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Agreement: Navigate to Opportunity";

		String stepNameMin="submittingMACDOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		try
		{
			MACDFlow.submittingMACDOrder(driver, wait, testName, stepID, companyContactPerson);
			
			boolean validation=MACDFlow.submittingMACDOrder(driver, stepID);
			
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

	
	//MACD Order: Full Flow
	public static TestStepReportStructure completeMACDOrder(WebDriver driver, WebDriverWait wait, String testName, int stepID, String companyContactPerson) throws Exception
	{
		TestStepReportStructure step;


		String stepName="MACD Order: Complete MACD Order Flow";

		String stepNameMin="completeMACDOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		try
		{
			
			MACDFlow.goToNewMACDOrderScreen(driver, stepID);
			
			if(MACDFlow.initialFirstMACDOrderScreen(driver, stepID) == false)
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
			MACDFlow.firstMACDOrderScreen(driver, wait, stepID);
			
			if(MACDFlow.firstMACDOrderScreenValidation(driver, stepID) == false)
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
			
			MACDFlow.goToSecondMACDScreen(driver, stepID);
			
			if(MACDFlow.initialSecondMACDOrderScreen(driver, stepID)== false)
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
			MACDFlow.secondMACDOrderScreen(driver, wait, testName, stepID, companyContactPerson);
			
			if(MACDFlow.secondMACDOrderScreenValidation(driver, testName, stepID, companyContactPerson)== false)
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
			
			MACDFlow.submittingMACDOrder(driver, wait, testName, stepID, companyContactPerson);
					
					
			boolean validation=MACDFlow.submittingMACDOrder(driver, stepID)== false;
			
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

/*
TestStepReportStructure step;


String stepName="Agreement: Navigate to Opportunity";

String stepNameMin="navigate2Opportunity";

String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

try
{
	boolean validation
	
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
*/