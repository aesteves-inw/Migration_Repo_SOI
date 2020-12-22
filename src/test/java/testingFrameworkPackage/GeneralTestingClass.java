package testingFrameworkPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import executionDriver.ExecDriverClass;
import executionTools.ExecStructure;
import executionTools.TestStructure;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;

public class GeneralTestingClass extends ExecDriverClass
{
	
	String testName = "GeneralTestingClass_D02_TC01_ToHaveAProductBasket";

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
	public void ToHaveAProductBasket() throws Exception
	{		
		D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
	}
	
	
	@AfterClass
	public void afterClass() 
	{
		TestStructure.finishTest(testName, initialTestDate, startTime, testExecStructure, testData, driver, logStream);
	}

}
