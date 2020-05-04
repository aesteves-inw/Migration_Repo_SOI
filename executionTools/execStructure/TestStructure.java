package execStructure;

import java.util.List;

import org.openqa.selenium.WebDriver;

import actions.BrowserActions;
import execReport.CreateTestReport;
import execReport.TestReportHeaderStructure;
import execReport.TestReportTestData;
import execReport.TestStepReportStructure;

public class TestStructure {
	
	public static void startTest(String testName)
	{
		System.out.println("Test Case: "+testName+" initiation");

		ExecStructure.createReportStructure(testName);
	}
	
	
	public static void finishTest(String testName, String initialTestDate, long startTime, int stepsExecuted, List<TestStepReportStructure> testExecStructure, List<TestReportTestData> testData, WebDriver driver)
	{
		String finalTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		long finishTime=System.nanoTime();

		TestReportHeaderStructure testHeader = new TestReportHeaderStructure(testName, initialTestDate, finalTestDate, startTime, finishTime, stepsExecuted);

		new CreateTestReport(testExecStructure, testHeader, testData);

		System.out.println("Test Case: "+testName+" completion");

		BrowserActions.endSession(driver);
		
		//System.exit(1);
	}

}
