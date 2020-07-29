package delivery01.soi_273;

import org.testng.annotations.Test;

import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecDriverClass;
import execStructure.ExecStructure;
import execStructure.TestData;
import execStructure.TestStructure;
import functionalSteps.CS.StpsCSProductBasket;
import functionalSteps.SFDS.StpsSalesCompany;
import functionalSteps.SFDS.StpsSalesHomePage;
import functionalSteps.SFDS.StpsSalesOpportunity;
import functionalSteps.SFPC.StpsPartsHomePage;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class SOI_273_TC01_NoContactPerson_SalesUser extends ExecDriverClass {
	
	String testName = this.getClass().getSimpleName();

	String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	long startTime=System.nanoTime();

	List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();

	List<TestReportTestData> testData = new ArrayList<TestReportTestData>();

	int stepsExecuted;
	
	private String userProfile="SysAdmin";


	@BeforeTest
	public void beforeTest() 
	{
		TestStructure.startTest(testName);
	}

	@Test
	public void step01() throws Exception 
	{
		stepsExecuted++;

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


	@AfterClass
	public void afterClass() 
	{
		TestStructure.finishTest(testName, initialTestDate, startTime, stepsExecuted, testExecStructure, testData, driver);
	}

}
