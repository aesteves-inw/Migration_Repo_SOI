package sq.J1835004000_14;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import executionDriver.ExecDriverClass;
import executionTools.ExecStructure;
import executionTools.TestStructure;
import simpleQuoting.J1835004000_14;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;

public class J1835004000_14_TC02_QuickSaleOpportunity_CreateMoreThanOneProdBasket {

	String testName = "J1835004000_14_TC02_QuickSaleOpportunity_CreateMoreThanOneProdBasket";

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
	public void testCase() throws Exception
	{
		try
		{
			J1835004000_14.J1835004000_14_TC02_QuickSaleOpportunity_CreateMoreThanOneProdBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
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
