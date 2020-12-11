package sq.J1835004000_64;

import executionDriver.ExecDriverClass;
import executionTools.ExecStructure;
import executionTools.TestStructure;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import testLogBuilder.TestLog;
import testReportComposition.TestReportTestData;
import testReportComposition.TestStepReportStructure;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import companyDirectSales.CompanyStep;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;

public class SQ_J1835004000_64_QuickSaleOpportunity_PreFilledFields extends ExecDriverClass
{

	String testName = "SQ_J1835004000_64_Quick_Sale_Opportunity_PreFilledFields";

	String initialTestDate=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");

	long startTime=System.nanoTime();

	List<TestStepReportStructure> testExecStructure = new ArrayList<TestStepReportStructure>();

	List<TestReportTestData> testData = new ArrayList<TestReportTestData>();

	List<TestLog> logStream = new ArrayList<TestLog>();

	int stepsExecuted; 

	@BeforeTest
	public void beforeMethod() 
	{
		TestStructure.startTest(logStream,testName);
	}

	@Test
	public void loginSFDS() throws Exception
	{
		stepsExecuted++;

		String userProfile="salesUser";

		LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, stepsExecuted, userProfile);

	}

	@Test(dependsOnMethods ="loginSFDS")
	public void goToCompanyDetailsPage() throws Exception
	{
		stepsExecuted++;
		
		HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName, stepsExecuted);
	}
	
	@Test(dependsOnMethods ="goToCompanyDetailsPage")
	public void quickSaleOnCompany() throws Exception
	{
		stepsExecuted++;
		
		CompanyStep.startQuickSaleOPTY(testExecStructure, logStream, driver, stepsExecuted, testName);
	}
	
	@Test(dependsOnMethods ="quickSaleOnCompany")
	public void quickSaleOPTYPreFilledFields() throws Exception
	{
		stepsExecuted++;
		
		CompanyStep.validateQuickSalePreFilledFields(testExecStructure, logStream, driver, stepsExecuted, testName);
	}
		

	@AfterClass
	public void afterMethod() 
	{
		TestStructure.finishTest(testName, initialTestDate, startTime, stepsExecuted, testExecStructure, testData, driver, logStream);
	}

}
