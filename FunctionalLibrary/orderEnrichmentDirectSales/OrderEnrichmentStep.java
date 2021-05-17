package orderEnrichmentDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.TestExecutionReport;
import objectMap.sfDirectSales.DirSalesOrderEnrichment;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class OrderEnrichmentStep {

	public static void changeProduct(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Order Enrichment: Change Product";

		String stepNameMin="changeProduct";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame(driver.findElement(By.xpath(DirSalesOrderEnrichment.iframeOrderEnrichment)));
			
			OrderEnrichmentAction.selectProductForOEConfig(logStream, driver, stepID, productName);

			OrderEnrichmentAction.tabsforOEValidation(logStream, driver, stepID);

			validation=OrderEnrichmentAction.tabsforOEValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				TestLogger.logTrace(logStream, stepNameMin, "Failed in Step: "+stepID+". Validation: False");
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
}