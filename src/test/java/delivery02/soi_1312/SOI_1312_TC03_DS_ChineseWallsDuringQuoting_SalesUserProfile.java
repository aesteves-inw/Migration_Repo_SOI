package delivery02.soi_1312;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecDriverClass;
import execStructure.ExecStructure;
import execStructure.TestData;
import execStructure.TestStructure;
import functionalSteps.SFDS.StpsSalesCompany;
import functionalSteps.SFDS.StpsSalesHomePage;

public class SOI_1312_TC03_DS_ChineseWallsDuringQuoting_SalesUserProfile extends ExecDriverClass {

		String testName = this.getClass().getSimpleName();

		String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

		long startTime=System.nanoTime();

		WebDriverWait wait;

		List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();
		
		List<TestReportTestData> testData = new ArrayList<TestReportTestData>();

		String finalTestDate=null;

		long finishTime;

		int stepsExecuted;

		String testExecutionString;

		String companyContactPerson="Simple Ordering OneFifty";

		@BeforeTest
		public void beforeTest() 
		{
			TestStructure.startTest(testName);
		}

		@Test
		public void step01() throws Exception 
		{
			stepsExecuted++;

			String userProfile="regularUser";

			try 
			{

				TestStepReportStructure step01 = StpsSalesHomePage.loginSFDS(driver, testName, stepsExecuted, userProfile);
				testExecStructure.add(step01);
				
				if (step01.getStepStatus().toLowerCase().contains("failed")) 
				{

					throw new Exception("Validation Failed on Step "+stepsExecuted);
				}

			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception("Test Failed on Step "+stepsExecuted,e);
			}

		}
		
		@Test(dependsOnMethods = "step01")
		public void step02() throws Exception {		

			stepsExecuted++;

			try
			{

				TestStepReportStructure step02 = StpsSalesHomePage.navigate2CompanyDetails(driver, stepsExecuted, testName);
				testExecStructure.add(step02);
				
				testData.add(new TestReportTestData("Company", TestData.tdCompanyName(testName), "URL", driver.getCurrentUrl()));
				

				if (step02.getStepStatus().toLowerCase().contains("failed")) 
				{

					throw new Exception("Validation Failed on Step "+stepsExecuted);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception("Test Failed on Step "+stepsExecuted,e);
			}
		}
		
		@Test(dependsOnMethods = "step02")
		public void step03() throws Exception {		

			stepsExecuted++;

			try
			{

				TestStepReportStructure step03 = StpsSalesCompany.createNewQuickSaleOpportunity(driver, stepsExecuted, testName);
				testExecStructure.add(step03);
						

				if (step03.getStepStatus().toLowerCase().contains("failed")) 
				{

					throw new Exception("Validation Failed on Step "+stepsExecuted);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception("Test Failed on Step "+stepsExecuted,e);
			}
		}
		
		@AfterClass
		public void afterClass() 
		{
			TestStructure.finishTest(testName, initialTestDate, startTime, stepsExecuted, testExecStructure, testData, driver);
		}
}
