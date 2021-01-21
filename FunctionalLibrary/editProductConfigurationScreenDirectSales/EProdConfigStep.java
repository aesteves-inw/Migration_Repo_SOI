package editProductConfigurationScreenDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;
import executionTools.TestExecutionReport;
import productBasketDirectSales.ProductBasketAction;
import productBasketPartCom.ProductBasketPCAction;
import productConfigurationCloudSense.NonQuotableProducts;
import productConfigurationCloudSense.PhoneLine;
import productConfigurationCloudSense.ProfessionalInternet;
import productConfigurationCloudSense.VoiceContinuity;
import testExecutionData.ProductConfigurationD02;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class EProdConfigStep 
{
	// D02 Products
	public static void configureVoiceContinuity(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configureVoiceContinuity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{
			VoiceContinuity.configurationOfVoiceContinuity(logStream, driver, stepID, configuration, testName);

			validation = VoiceContinuity.validationOfVCConfiguration(logStream, driver, stepID, configuration);

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

	public static void finsihConfiguration(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);		
		
		String stepName="Edit Product Configuration 'Screen': Finish Configuration";

		String stepNameMin="finsihConfiguration";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			EProdConfigAction.finishConfiguration(logStream, driver, stepID);

			validation = ProductBasketAction.productBasketScreenValidation(logStream, driver, stepID);

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
	
	public static void finsihConfigurationInPC(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);		
		
		String stepName="Edit Product Configuration 'Screen': Finish Configuration";

		String stepNameMin="finsihConfiguration";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			EProdConfigAction.finishConfiguration(logStream, driver, stepID);

			validation = ProductBasketPCAction.validateProductBasketScreen(logStream, stepID, driver);

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

	public static void configurePhoneLine(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configurePhoneLine";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{
			PhoneLine.configurationOfPhoneLine(logStream, driver, stepID, configuration, testName);

			validation = PhoneLine.validationOfPLConfiguration(logStream, driver, stepID, configuration);

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

	public static void configureProfessionalInternet(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configureProfessionalInternet";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{
			ProfessionalInternet.configurationOfProfessionalInternet(logStream, driver, stepID, configuration, testName);

			validation = ProfessionalInternet.validationOfPIConfiguration(logStream, driver, stepID, configuration);

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

	// D03 Products
	public static void configureNonQuotableProduct(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String configurationProduct) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Configure Non Quotable Product: "+configurationProduct;

		String stepNameMin="configureNonQuotableProductStep";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			NonQuotableProducts.configurationOfNonQuotableProduct(logStream, driver, stepID, configurationProduct);

			validation = NonQuotableProducts.validationOfNQPConfiguration(logStream, driver, stepID, configurationProduct);

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

	
	public static void validateD03ProductConfiguration(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		
		String stepName="Product Configuration: D03 Product Validation";

		String stepNameMin="validateD03ProductConfiguration";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			
			validation = NonQuotableProducts.validationOfNQPConfiguration(logStream, driver, stepID, productName);

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

	
}
