package simpleQuoting;

import java.util.List;

import org.openqa.selenium.WebDriver;

import opportunityDirectSales.OpportunityStep;
import testLogBuilder.TestLog;
import testReportComposition.TestStepReportStructure;

public class J1835004000_14 {

	public static void SQ_J1835004000_14_Quick_Sale_Opportunity_CreateProdBasket(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception
	{
		try
		{
			int newStepCounter;
			
			J1835004000_64.SQ_J1835004000_64_QuickSaleOpportunity_OpportunityCreation(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, newStepCounter, testName);
			
			
		}
		catch(Exception e)
		{
			throw new Exception("SQ_J1835004000_14_Quick_Sale_Opportunity_CreateProdBasket");
		}
	}

}
