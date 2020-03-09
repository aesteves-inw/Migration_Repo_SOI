package functionalActions.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Agreement {
	
	public static void navigateToOpportunity(WebDriver driver, int stepID, String optyURL) throws Exception
	{
		String actionName = "Agreement: Navigation to Opportunity";
		
		
		try
		{
			driver.get(optyURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);
			
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
		
	}

}
