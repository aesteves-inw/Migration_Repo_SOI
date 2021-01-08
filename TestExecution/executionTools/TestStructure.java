package executionTools;

import java.util.List;

import org.openqa.selenium.WebDriver;

import testLogBuilder.TestLog;
import testLogGeneration.CreateLogFile;
import testReportComposition.TestReportHeaderStructure;
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;
import testReportGeneration.CreateTestReport;
import testLogger.TestLogger;

public class TestStructure {
	
	public static void startTest(List<TestLog> logstream, String testName)
	{
		
		TestLogger.logInfo(logstream, "startTest","Test Case: "+testName+" initiation");
		
		ExecStructure.createReportStructure(testName);
	}

	public static void finishTest(String testName, String initialTestDate, long startTime, List<TestStepReportStructure> testExecStructure, List<TestReportTestData> testData, WebDriver driver, List<TestLog> logstream)
	{
		String finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		long finishTime=System.nanoTime();
		
		int newStepCounterForReport=testExecStructure.size();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, newStepCounterForReport);

		new CreateTestReport(testExecStructure, testHeader, testData);
			
		TestLogger.logInfo(logstream, "finishTest","Test Case: "+testName+" completion");
		
		new CreateLogFile(logstream, testExecStructure,testHeader);

		BrowserActions.endSession(driver);
		
		
	}

	


}
