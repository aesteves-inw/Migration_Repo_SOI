package productBasketDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;
import addOfferToBasketDirectSales.AddOfferToBasketAction;
import agreementDirectSales.AgreementAction;
import agreementPartCom.AgreementPCAction;
import editProductConfigurationScreenDirectSales.EProdConfigAction;
import executionTools.TestExecutionReport;
import navigation.NavigationAction;
import opportunityDirectSales.OpportunityAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class ProductBasketStep 
{
	public static void goToAddOferToBasketScreen(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID;
		
		stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Go To Add Offer to Basket Screen";

		String stepNameMin="goToAddOferToBasketScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.openAddProductMenu(logStream, driver, stepID);

			validation = AddOfferToBasketAction.addProductMenuValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
	
	public static void syncProductBasket(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Sync Product Basket (Positive Validation)";

		String stepNameMin="syncProductBasketPosVal";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.syncProductBasket(logStream, driver, stepID);

			validation = ProductBasketAction.syncProductBasketPosVal(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}
	
	public static void syncProductBasketNegVal(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, int newStepCounter, String testName) throws Exception 
	{
		String stepName="Sync Product Basket (Negative Validation)";

		String stepNameMin="syncProductBasketNegVal";

		String evidenceName=ReportStructure.evidenceName(newStepCounter, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.syncProductBasket(logStream, driver, newStepCounter);

			validation = ProductBasketAction.syncProductBasketNegVal(logStream, driver, newStepCounter);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
		}

		
	}

	public static void deletePBLineItem(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, int newStepCounter, String productName) throws Exception 
	{
		String stepName="Delete Product Basket Line Item";

		String stepNameMin="deletePBLineItem";

		String evidenceName=ReportStructure.evidenceName(newStepCounter, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.selectLineItem(logStream, driver, newStepCounter, productName);
			
			ProductBasketAction.deleteLineItem(logStream, driver, newStepCounter);
			
			validation = ProductBasketAction.productOnProductBasketNegativeValidation(logStream, driver, newStepCounter, productName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
		}
		
	}

	public static void expandECSPackage(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception
	{
		int stepID;
		
		stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Expanding ECS Package on Product Basket";

		String stepNameMin="expandECSPackage";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.expandingECS(logStream, driver, stepID, productName);
			
			validation = ProductBasketAction.expandedECSPackValidation(logStream, driver, stepID, productName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}

	public static void goToEditProductConfigurationScreen(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Go To Edit Product Configuration Screen - "+productName;

		String stepNameMin="goToEditProductConfigurationScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.goToEditProductConfiguration(logStream, driver, stepID, productName);
			
			EProdConfigAction.changeToEditProductConfigurationiFrame(logStream, driver, stepID);

			validation = EProdConfigAction.editProductConfiguration(logStream, driver, stepID, productName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
		
	}
	
	public static void goToEditProductConfigurationScreenForD03(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Go To Edit Product Configuration Screen For D03 Product - "+productName;

		String stepNameMin="goToEditProductConfigurationScreenForD03";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.goToEditProductConfiguration(logStream, driver, stepID, productName);
			
			EProdConfigAction.changeToEditProductConfigurationiFrame(logStream, driver, stepID);

			validation = EProdConfigAction.editProductConfigurationForD03(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
		
	}
	
	
	public static void goToAgreementScreen(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Product Basket: Go To Agreement Screen (After Sync)";

		String stepNameMin="goToAgreementScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketNavigation.goToAgreement(logStream, driver, stepID);

			validation = AgreementAction.agreementScreenValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}

	public static void goToAgreementScreenInPC(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Product Basket: Go To Agreement Screen (After Sync) in PartCom";

		String stepNameMin="goToAgreementScreenInPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketNavigation.goToAgreement(logStream, driver, stepID);

			validation = AgreementPCAction.agreementScreenValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}
	
	public static void goToOpportunityScreenByURL(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String optyURL) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		
		String stepName="Product Basket: Go To Opportunity Screen By URL";

		String stepNameMin="goToOpportunityScreenByURL";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, stepID);
			
			NavigationAction.goToOPTYByURL(logStream, driver, stepID, optyURL);

			validation = OpportunityAction.opportunityScreenValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


}
}
	



