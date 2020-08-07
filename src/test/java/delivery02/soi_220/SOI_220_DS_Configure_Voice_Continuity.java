package delivery02.soi_220;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecDriverClass;
import execStructure.ExecStructure;
import execStructure.TestData;
import execStructure.TestStructure;
import functionalSteps.CS.StpsCSEditProductConfiguration;
import functionalSteps.CS.StpsCSProductBasket;
import functionalSteps.SFDS.StpsSalesCompany;
import functionalSteps.SFDS.StpsSalesHomePage;
import functionalSteps.SFDS.StpsSalesOpportunity;

public class SOI_220_DS_Configure_Voice_Continuity extends ExecDriverClass {

	String testName = this.getClass().getSimpleName();

	String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	long startTime=System.nanoTime();

	List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();

	List<TestReportTestData> testData = new ArrayList<TestReportTestData>();

	int stepsExecuted;

	private String userProfile="regularUser";


	@BeforeTest
	public void beforeTest() 
	{
		TestStructure.startTest(testName);
	}

	@Test
	public void step01() throws Exception 
	{
		stepsExecuted++;

		//String userProfile="regularUser";

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

			testData.add(new TestReportTestData("Quick Sale Opportunity", TestData.getOPTYName(testName), "URL", driver.getCurrentUrl()));


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

	@Test(dependsOnMethods = "step03")
	public void step04() throws Exception 
	{	

		stepsExecuted++;
		

		try
		{
			TestStepReportStructure step04 = StpsSalesOpportunity.createNewProductBasketEmpty(driver, stepsExecuted, testName);
			testExecStructure.add(step04);

			


			if (step04.getStepStatus().toLowerCase().contains("failed")) 
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

	@Test(dependsOnMethods = "step04")
	public void step05() throws Exception 
	{	
		stepsExecuted++;

		try
		{
			TestStepReportStructure step05 = StpsCSProductBasket.chineseWallsDuringQuoting(driver, stepsExecuted, testName, userProfile);
			testExecStructure.add(step05);


			if (step05.getStepStatus().toLowerCase().contains("failed")) 
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

	@Test(dependsOnMethods = "step05")
	public void step06() throws Exception 
	{
		stepsExecuted++;

		try
		{
			TestStepReportStructure step06 = StpsCSProductBasket.addProductToProductBasketByTestName(stepsExecuted, driver, testName);
			testExecStructure.add(step06);


			if (step06.getStepStatus().toLowerCase().contains("failed")) 
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

	@Test(dependsOnMethods = "step06")
	public void step07() throws Exception 
	{
		stepsExecuted++;

		try
		{
			TestStepReportStructure step07 = StpsCSProductBasket.goToEditProductConfigurationScreen(stepsExecuted, driver, testName);
			testExecStructure.add(step07);


			if (step07.getStepStatus().toLowerCase().contains("failed")) 
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

	@Test(dependsOnMethods = "step07")
	public void step08() throws Exception 
	{
		stepsExecuted++;

		try
		{
			TestStepReportStructure step08 = StpsCSEditProductConfiguration.configureVoiceContinuityByDefault(driver, stepsExecuted, testName);
			testExecStructure.add(step08);


			if (step08.getStepStatus().toLowerCase().contains("failed")) 
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
	
	@Test(dependsOnMethods = "step08")
	public void step09() throws Exception 
	{
		stepsExecuted++;

		try
		{
			TestStepReportStructure step09 = StpsCSEditProductConfiguration.finsihConfiguration(driver, stepsExecuted, testName);
			testExecStructure.add(step09);


			if (step09.getStepStatus().toLowerCase().contains("failed")) 
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
