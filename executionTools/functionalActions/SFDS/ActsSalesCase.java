package functionalActions.SFDS;

import org.openqa.selenium.WebDriver;

import actions.BrowserActions;
import sfDirectSales.SalesforceCase;

public class ActsSalesCase {
	
	
	
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
	 *		String actionName = "";
			
			
			
			try
			{
				<JAVA CODE>
				
				System.out.println(actionName+" - Succeeded in Step "+stepID);
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}
			
			*/
	public static void goToCaseDetailstab()
	{
		 	String actionName = "";
			
			
			
			try
			{
				<JAVA CODE>
				
				System.out.println(actionName+" - Succeeded in Step "+stepID);
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}
	}
	
	
	/*02-03-2020:LMA
	 * sketch for every validation functions
	 *=====================================
	 	String actionName="";
	 	try
		{
			if()
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
			
			*/
	
	public static boolean validationCasePage(WebDriver driver, int stepID) throws Exception
	{
	 	String actionName="Case: Case screen Validation";
	 	try
		{
			if(BrowserActions.isElementPresent(driver, SalesforceCase.keyDetailsArticle) && BrowserActions.isElementPresent(driver, SalesforceCase.filesContainer))
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

}
