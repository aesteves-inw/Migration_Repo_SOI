package testFrameworkLibrary;

import java.util.List;

import org.openqa.selenium.WebDriver;

import companyPartCom.CompanyPCStep;
import homePagePartCom.HomePagePCStep;
import loginPagePartCom.LoginPagePCStep;
import opportunityPartCom.OpportunityPCStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class GeneralTestingFramework 
{
		public static void E2EPartnersCommunity(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{
			String user="farmerUser";
			
			try
			{
				LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

				HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);
				
				CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
				
				OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
				throw new Exception(testName+": Test Case Failed on Test Model - PartnersCommunity");
			}
		}
	}

