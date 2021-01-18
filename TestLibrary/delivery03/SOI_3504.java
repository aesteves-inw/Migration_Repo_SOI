package delivery03;

import java.util.List;

import org.openqa.selenium.WebDriver;

import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3504 {
	
	public static void SOI_3504_TC01_DS_NonQuotableOffer_Standalone(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int stepsExecuted, String testName) throws Exception 
	{
		String configurationIndex="productPABX";
		
		String productName ="PABX";
		
		try
		{
			D02Models.ConfigureStandAloneProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
	}
	
	public static void SOI_3504_TC02_DS_NonQuotableOffer_NonQuotableQuotable(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int stepsExecuted, String testName) throws Exception 
	{
		String configurationIndex="productPABX";
		
		String productName ="PABX";
		
		String configurationIndex2="configurationByDefault";
		
		String productName2 ="Voice Continuity";
		
		try
		{
			D02Models.ConfigureStandAloneProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
	}

}
