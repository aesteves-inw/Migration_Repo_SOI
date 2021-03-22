package d03.SOI_3610;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import delivery03.SOI_3610;
import executionDriver.ExecDriverClass;
import executionTools.ExecStructure;
import executionTools.TestStructure;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;

public class SOI_3610_TC00_PC_SingleOrder_Quotable_NonQuotable 
{
	String testName = "SOI_3610_TC00_PC_SingleOrder_Quotable_NonQuotable";

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
	@Parameters("productD03")
	public void SOI_3610_TC00_DS_SingleOrder_Quotable_NonQuotable(String productD03) throws Exception
	{
		String finalTestName = testName+productD03;
		
		try
		{
			SOI_3610.SOI_3610_TC00_PC_SingleOrder_Quotable_NonQuotable(testExecStructure, logStream, driver, finalTestName, productD03);
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
