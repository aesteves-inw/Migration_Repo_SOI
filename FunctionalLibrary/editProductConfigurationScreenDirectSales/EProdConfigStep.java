package editProductConfigurationScreenDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.TestExecutionReport;
import productConfigurationCloudSense.VoiceContinuity;
import testExecutionData.ProductConfigurationD02;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class EProdConfigStep 
{

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
	
}
