package simpleQuoting;

import java.util.List;

import org.openqa.selenium.WebDriver;

import companyDirectSales.CompanyStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class J1835004000_64 {

	public static void J1835004000_64_TC01_QuickSaleOpportunity_PreFilledFields(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, 
			WebDriver driver, String testName, int stepsExecuted) throws Exception
	{
		try
		{
			stepsExecuted++;

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, stepsExecuted, userProfile);

			stepsExecuted++;

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName, stepsExecuted);

			stepsExecuted++;

			CompanyStep.startQuickSaleOPTY(testExecStructure, logStream, driver, stepsExecuted, testName);

			stepsExecuted++;

			CompanyStep.validateQuickSalePreFilledFields(testExecStructure, logStream, driver, stepsExecuted, testName);
		}
		catch(Exception e)
		{
			//System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}

	}

	public static void J1835004000_64_TC02_QuickSaleOpportunity_OpportunityCreation(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception {

		try
		{

			int newStepCounter;

			J1835004000_64_TC01_QuickSaleOpportunity_PreFilledFields(testExecStructure, logStream, driver, testName, stepsExecuted);

			newStepCounter = testExecStructure.size();

			newStepCounter++;

			CompanyStep.finishQuickSaleOPTYCreation(testExecStructure, logStream, driver, newStepCounter, testName);
			
			newStepCounter++;
			
			CompanyStep.navigateToOpportunityPage(testExecStructure, logStream, driver, newStepCounter, testName);

		}
		catch(Exception e)
		{
			//System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
	}

	

}
