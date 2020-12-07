package testReporter;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import executionTools.ExecStructure;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;

public class TestReporter {
	
	 
	static String expectedOutcome;
	static String actualOutcome;
	static String stepStatus;
	static String timeStamp;
	
	public static void stepPassed(List<TestStepReportStructure> testReportStream, WebDriver driver, String testName, int stepID, String stepDescription, String screenshotName) throws Exception
	{
		
		expectedOutcome=ReportStructure.testReportFinalElement('p', 'e');
		actualOutcome=ReportStructure.testReportFinalElement('p', 'a');
		stepStatus=ReportStructure.testReportFinalElement('p', 's');
		timeStamp=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");
		
		stepReporter(testReportStream, driver, testName, stepID, stepDescription, expectedOutcome, actualOutcome, stepStatus, timeStamp, screenshotName);
		
	}

	public static void stepFailed(List<TestStepReportStructure> testReportStream, WebDriver driver, String testName, int stepID, String stepDescription, String screenshotName) throws Exception
	{
		expectedOutcome=ReportStructure.testReportFinalElement('f', 'e');
		actualOutcome=ReportStructure.testReportFinalElement('f', 'a');
		stepStatus=ReportStructure.testReportFinalElement('f', 's');
		timeStamp=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");
		
		stepReporter(testReportStream, driver, testName, stepID, stepDescription, expectedOutcome, actualOutcome, stepStatus, timeStamp, screenshotName);
	}
	
	
	private static void stepReporter(List<TestStepReportStructure> testReportStream, WebDriver driver, String testName, int stepID, String stepDescription, String expectedOutcome, String actualOutcome, String stepStatus, String timeStamp, String screenshotName) throws Exception
	{
		BrowserActions.screenShotTaking(driver, testName, screenshotName);
		
		TestStepReportStructure stepReport = new TestStepReportStructure(stepID, stepDescription, expectedOutcome, actualOutcome, stepStatus, timeStamp, screenshotName);
				
		testReportStream.add(stepReport);
	}

}
