package delivery03;

import java.util.List;

import org.openqa.selenium.WebDriver;

import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3610 {

	public static void SOI_3610_TC01_DS_SingleOrder_Quotable_NonQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String finalTestName, String productD03) throws Exception 
	{
		try
		{
            
           D03Models.E2EFlowToOrderNoAgreement(testExecStructure, logStream, driver, finalTestName, productD03);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, finalTestName, "Test Failed", e.toString());
			throw new Exception(finalTestName+" - Test Case Failed");
		}
		
	}

	public static void SOI_3610_TC02_PC_SingleOrder_Quotable_NonQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String finalTestName, String productD03) throws Exception 
	{
		try
		{
            
			D03Models.E2EFlowToOrderNoAgreementInPC(testExecStructure, logStream, driver, finalTestName, productD03);

			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, finalTestName, "Test Failed", e.toString());
			throw new Exception(finalTestName+" - Test Case Failed");
		}
		
	}

}
