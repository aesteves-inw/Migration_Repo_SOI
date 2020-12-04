package testingFrameworkPackage;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import executionDriver.ExecDriverClass;
import executionTools.ExecStructure;
import executionTools.TestStructure;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;

public class GeneralTestingClass extends ExecDriverClass 
{
	
	String testName = this.getClass().getName();

	String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	long startTime=System.nanoTime();

	List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();
	
	List<TestReportTestData> testData = new ArrayList<TestReportTestData>();
	
	List<TestLog> logStream = new ArrayList<TestLog>();
	
	int stepsExecuted; 
	
	@BeforeTest
	public void beforeTest() 
	{
		TestStructure.startTest(logStream,testName);
	}
	
	@Test
	public void test()
	{
		//TestLogger.logInfo(logStream, "test", "Just Testing this MothaphukkinG");
		D01NewFlowModel(TestReportStream, TestLogStrem, TestData, CompanyName, MobileVoice);
		
	}
	
	@AfterTest
	public void afterTest() 
	{
		TestStructure.finishTest(testName, initialTestDate, startTime, stepsExecuted, testExecStructure, testData, driver, logStream);
	}

}
