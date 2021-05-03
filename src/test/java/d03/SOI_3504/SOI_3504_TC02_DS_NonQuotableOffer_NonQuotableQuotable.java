package d03.SOI_3504;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import delivery03.SOI_3504;
import executionDriver.ExecDriverClass;
import executionTools.BrowserActions;
import executionTools.ExecStructure;
import executionTools.TestStructure;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;

public class SOI_3504_TC02_DS_NonQuotableOffer_NonQuotableQuotable {
	
	String testName = "SOI_3504_TC02_DS_NonQuotableOffer_NonQuotableQuotable";

	String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	long startTime=System.nanoTime();

	List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();

	List<TestReportTestData> testData = new ArrayList<TestReportTestData>();

	List<TestLog> logStream = new ArrayList<TestLog>();

	int stepsExecuted; 
	
	WebDriver driver;
	

	@BeforeClass
	public void beforeClass() 
	{
				
		driver = ExecDriverClass.setupDriver();
		
		TestStructure.startTest(logStream,testName);
		
	}
	@Test
	public void SOI_3504_TC02_DS_NonQuotableOffer_NonQuotableQuotable() throws Exception
	{
		try
		{
			SOI_3504.SOI_3504_TC02_DS_NonQuotableOffer_NonQuotableQuotable(testExecStructure, logStream, driver, stepsExecuted, testName);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Execution Failed", e.toString());
			throw new Exception (testName+" - Execution Failed",e);
		}
	}

		@AfterClass
	public void afterClass() 
	{
		TestStructure.finishTest(testName, initialTestDate, startTime, testExecStructure, testData, driver, logStream);
	}

}
