package d03.SOI_3825;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import delivery03.SOI_3602;
import delivery03.SOI_3825;
import executionDriver.ExecDriverClass;
import executionTools.ExecStructure;
import executionTools.TestStructure;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;

public class SOI_3825_TC01_DS_OCK_Check_ECS_Pro_PhoneLine {
	String testName = "SOI_3825_TC01_DS_OCK_Check_ECS_Pro_PhoneLine";

	String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	long startTime=System.nanoTime();

	List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();

	List<TestReportTestData> testData = new ArrayList<TestReportTestData>();

	List<TestLog> logStream = new ArrayList<TestLog>();

	WebDriver driver;
	

	@BeforeClass
	public void beforeClass() 
	{
		driver = ExecDriverClass.setupDriver();
		
		TestStructure.startTest(logStream,testName);
		
	}

	
	@Test
	public void SOI_3825_TC01_DS_OCK_Check_ECS_Pro_PhoneLine() throws Exception
	{
		try
		{
			SOI_3825.SOI_3825_TC01_DS_OCK_Check_ECS_Pro_PhoneLine(testExecStructure, logStream, driver, testName);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Execution Failed", e.toString());
			throw new Exception (testName+" - Failed: ",e);
		}
	}

		@AfterClass
	public void afterClass() 
	{
		TestStructure.finishTest(testName, initialTestDate, startTime, testExecStructure, testData, driver, logStream);
	}
}
