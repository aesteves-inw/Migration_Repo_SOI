package testFrameworkLibrary;

import java.util.List;

import org.openqa.selenium.WebDriver;

import companyDirectSales.CompanyStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import opportunityDirectSales.OpportunityStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class D02Models 
{
	public static void ToHaveAProductBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception {
		
		try
		{
			stepsExecuted++;

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, stepsExecuted, userProfile);

			stepsExecuted++;

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName, stepsExecuted);

			stepsExecuted++;
			
			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			stepsExecuted++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, stepsExecuted, testName);
			
		}
		catch(Exception e)
		{
			//System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - ToHaveAProductBasket");
		}
}

	
}
