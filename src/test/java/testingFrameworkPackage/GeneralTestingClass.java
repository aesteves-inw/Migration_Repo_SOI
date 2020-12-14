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
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import testLogBuilder.TestLog;
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
	
	WebDriver driver;
	
	
	
	@BeforeClass
	public void beforeClass() 
	{
		driver = ExecDriverClass.setupDriver();
		
		TestStructure.startTest(logStream,testName);
	}
	
	@Test
	public void S01LoginSFDSForTestingFramework() throws Exception
	{
		stepsExecuted++;
		LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, stepsExecuted, "salesUser");
		
		stepsExecuted++;
		HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName, stepsExecuted);
		
		
	}
	
	
	@AfterClass
	public void afterClass() 
	{
		TestStructure.finishTest(testName, initialTestDate, startTime, testExecStructure, testData, driver, logStream);
	}

}
