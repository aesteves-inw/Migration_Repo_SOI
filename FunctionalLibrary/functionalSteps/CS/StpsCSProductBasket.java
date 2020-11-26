package functionalSteps.CS;

import org.openqa.selenium.WebDriver;

import execStructure.TestDataManagement;
import executionTools.ExecStructure;
import functionalActions.CS.ActsCSEditProductConfiguration;
import functionalActions.CS.ActsCSProductBasket;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;

public class StpsCSProductBasket {
	
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

	public static TestStepReportStructure chineseWallsDuringQuoting(WebDriver driver, int stepID, String testName, String userProfile) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Product Basket: Chinese Walls During Quoting";

		String stepNameMin="chineseWallsDuringQuoting";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			
			ActsCSProductBasket.openAddProductMenu(driver, stepID);
			
			
			validation = ActsCSProductBasket.soi1312Validation(driver, stepID, userProfile);

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

	public static TestStepReportStructure addProductToProductBasketByTestName(int stepID, WebDriver driver, String testName) throws Exception 
	{
		TestStepReportStructure addProductToProductBasketByTestName;
		

		String productToAdd=TestDataManagement.getD02ProductToAdd(testName);
		

		String stepName="Add Offer to Basket: "+productToAdd;

		String stepNameMin="addProductToProductBasketByTestName";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsCSProductBasket.pickProductOnAddOfferBasketByTestName(driver, stepID, testName);

			validation = ActsCSProductBasket.productOnProductBasketValidationByTestName(driver, stepID, testName);

			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				addProductToProductBasketByTestName=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return addProductToProductBasketByTestName;
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
			addProductToProductBasketByTestName=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return addProductToProductBasketByTestName;
		}

	}

	public static TestStepReportStructure goToEditProductConfigurationScreen(int stepID, WebDriver driver, String testName) throws Exception 
	{
		TestStepReportStructure step;


		String stepName="Product Basket: Go To Edit Product Configuration Screen";

		String stepNameMin="goToEditProductConfigurationScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ActsCSProductBasket.goToEditProductConfigurationScreen(driver, stepID);
			
			validation = ActsCSEditProductConfiguration.goToEditProductConfigurationScreenValidationByTestName(driver, stepID, testName);

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
