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
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;

public class J1835004000_14_TC01_QuickSaleOpportunity_CreateProdBasket {

		String testName = "J1835004000_14_TC01_Quick_Sale_Opportunity_CreateProdBasket";

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
			J1835004000_14.J1835004000_14_TC01_Quick_Sale_Opportunity_CreateProdBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
		}

		@AfterClass
		public void afterClass()
		{
			TestStructure.finishTest(testName, initialTestDate, startTime, testExecStructure, testData, driver, logStream);
		}

	}

