package delivery01.soi_150;

import org.testng.annotations.Test;

import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecDriverClass;
import execStructure.ExecStructure;
import execStructure.TestData;
import execStructure.TestStructure;
import functionalSteps.SFDS.StpsSalesCompany;
import functionalSteps.SFDS.StpsSalesHomePage;
import functionalSteps.SFDS.StpsSalesMACDFlow;
import functionalSteps.SFDS.StpsSalesOrder;
import functionalSteps.SFDS.StpsSalesService;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.AfterTest;

public class SOI_150_TC1_MobileOrderIntake_MACD_Flow extends ExecDriverClass{

	String testName = this.getClass().getName();

	String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	long startTime=System.nanoTime();

	List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();
	
	List<TestReportTestData> testData = new ArrayList<TestReportTestData>();

	int stepsExecuted;

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

			TestStepReportStructure step03 = StpsSalesMACDFlow.createMACDOrder(driver, testName, stepsExecuted);
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
	
	
	@Test(dependsOnMethods = "step03")
	public void step04() throws Exception {		

		stepsExecuted++;

		try
		{

			TestStepReportStructure step04 = StpsSalesMACDFlow.firstMACDOrderScreen(driver, testName, stepsExecuted);
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
	public void step05() throws Exception {		

		stepsExecuted++;

		try
		{

			TestStepReportStructure step05 = StpsSalesMACDFlow.goToSecondMACDOrderScreen(driver, testName, stepsExecuted);
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
	public void step06() throws Exception {		

		stepsExecuted++;

		try
		{

			TestStepReportStructure step06 = StpsSalesMACDFlow.secondMACDOrderScreen(driver, testName, stepsExecuted, companyContactPerson);
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

			TestStepReportStructure step07 = StpsSalesMACDFlow.submittingMACDOrder(driver, testName, stepsExecuted, companyContactPerson);
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

			TestStepReportStructure step08 = StpsSalesCompany.navigate2FirstOrder(driver, testName, stepsExecuted);
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

			TestStepReportStructure step09 = StpsSalesOrder.nav2Service(driver, testName, stepsExecuted);
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
	
	
	
	@Test(dependsOnMethods = "step09")
	public void step10() throws Exception 
	{	
		stepsExecuted++;

		try
		{

			TestStepReportStructure step10 = StpsSalesService.navigate2CaseScreen(driver, testName, stepsExecuted);
			testExecStructure.add(step10);

			
			if (step10.getStepStatus().toLowerCase().contains("failed")) 
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
	
	
	@AfterTest
	public void afterTest() 
	{
		TestStructure.finishTest(testName, initialTestDate, startTime, stepsExecuted, testExecStructure, testData, driver);
	}


}
