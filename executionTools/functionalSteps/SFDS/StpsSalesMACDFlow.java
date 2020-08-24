package functionalSteps.SFDS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import functionalActions.SFDS.ActsSalesMACDFlow;

public class StpsSalesMACDFlow {
	
	
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
			ActsSalesMACDFlow.goToNewMACDOrderScreen(driver, stepID);
			
			boolean validation = ActsSalesMACDFlow.initialFirstMACDOrderScreen(driver, stepID);
			
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
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try
		{
			ActsSalesMACDFlow.firstMACDOrderScreen(driver, wait, stepID);
			
			boolean validation = ActsSalesMACDFlow.firstMACDOrderScreenValidation(driver, stepID);
			
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
			ActsSalesMACDFlow.goToSecondMACDScreen(driver, stepID);
			
			boolean validation=ActsSalesMACDFlow.initialSecondMACDOrderScreen(driver, stepID);
			
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
	
	public static TestStepReportStructure secondMACDOrderScreen(WebDriver driver, String testName, int stepID, String companyContactPerson) throws Exception
	{
		TestStepReportStructure step;


		String stepName="MACD Order: Second Screen";

		String stepNameMin="secondMACDOrderScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try
		{
			ActsSalesMACDFlow.secondMACDOrderScreen(driver, wait, testName, stepID, companyContactPerson);
			
			boolean validation=ActsSalesMACDFlow.secondMACDOrderScreenValidation(driver, testName, stepID, companyContactPerson);
			
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


	
	public static TestStepReportStructure submittingMACDOrder(WebDriver driver, String testName, int stepID, String companyContactPerson) throws Exception
	{
		TestStepReportStructure step;


		String stepName="New MACD Order: Submitting MACD Order";

		String stepNameMin="submittingMACDOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		try
		{
			ActsSalesMACDFlow.submittingMACDOrder(driver, wait, testName, stepID, companyContactPerson);
			
			boolean validation=ActsSalesMACDFlow.submittingMACDOrder(driver, stepID);
			
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
			
			ActsSalesMACDFlow.goToNewMACDOrderScreen(driver, stepID);
			
			if(ActsSalesMACDFlow.initialFirstMACDOrderScreen(driver, stepID) == false)
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
			ActsSalesMACDFlow.firstMACDOrderScreen(driver, wait, stepID);
			
			if(ActsSalesMACDFlow.firstMACDOrderScreenValidation(driver, stepID) == false)
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
			
			ActsSalesMACDFlow.goToSecondMACDScreen(driver, stepID);
			
			if(ActsSalesMACDFlow.initialSecondMACDOrderScreen(driver, stepID)== false)
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
			ActsSalesMACDFlow.secondMACDOrderScreen(driver, wait, testName, stepID, companyContactPerson);
			
			if(ActsSalesMACDFlow.secondMACDOrderScreenValidation(driver, testName, stepID, companyContactPerson)== false)
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
			
			ActsSalesMACDFlow.submittingMACDOrder(driver, wait, testName, stepID, companyContactPerson);
					
					
			boolean validation=ActsSalesMACDFlow.submittingMACDOrder(driver, stepID)== false;
			
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