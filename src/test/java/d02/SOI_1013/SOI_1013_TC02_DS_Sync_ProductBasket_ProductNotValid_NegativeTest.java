package d02.SOI_1013;

import org.testng.annotations.Test;

import delivery02.SOI_1013;
import executionDriver.ExecDriverClass;
import executionTools.BrowserActions;
import executionTools.ExecStructure;
import executionTools.TestStructure;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class SOI_1013_TC02_DS_Sync_ProductBasket_ProductNotValid_NegativeTest {
 
	String testName = "SOI_1013_TC02_DS_Sync_ProductBasket_ProductNotValid_NegativeTest";

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
	public void SOI_1013_TC02_DS_Sync_ProductBasket_ProductNotValid_NegativeTest() throws Exception
	{
		try
		{
			SOI_1013.SOI_1013_TC02_DS_Sync_ProductBasket_ProductNotValid_NegativeTest(testExecStructure, logStream, driver, stepsExecuted, testName);
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
