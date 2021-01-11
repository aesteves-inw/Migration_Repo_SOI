package agreementDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class AgreementNavigation 
{
	// Navigation Steps from Agreement to Other Objects/Screens
	
	public static void goToOpportunityPage(List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
    {
        String actionName="Agreement - Navigation to Opportunity Page";
        
        String optyName=TestCasesData.getOPTYName(testName);


				try
				{
					driver.findElement(By.linkText(optyName)).click();
					
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

					TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

				}
				catch(Exception e)
				{
					System.out.println(e);
					TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}

    }
	
}
