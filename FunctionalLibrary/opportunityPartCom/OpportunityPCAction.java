package opportunityPartCom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import objectMap.sfPartnersCommunity.PartComOpportunity;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OpportunityPCAction {
	
	//Operational Actions
	
	public static void createProductBasket(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
		 String actionName="createProductBasket";


			try
			{
				clickNewBasketButtonOnOPTY(logStream, stepID, driver);

				TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}
		
	}
	


	private static void clickNewBasketButtonOnOPTY(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
		 String actionName="clickNewBasketButtonOnOPTY";


			try
			{
				driver.findElement(By.xpath(PartComOpportunity.buttonNewBasketButton)).click();
				
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




	// Validation Actions

	public static boolean opportunityPageValidation(List<TestLog> logStream, String testName, int stepID,
			WebDriver driver) throws Exception 
	{
        String actionName="opportunityPageValidation";
        
        
	     	try
					{
						if(BrowserActions.isElementPresent(driver, PartComOpportunity.optyDetails))
						{
							TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
							return true;
						}
						else
						{
							return false;
						}

					}
					catch(Exception e)
					{
						System.out.println(e);
						TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
						throw new Exception (actionName+" - Failed in Step: "+stepID,e);
					}
	}

	

}
