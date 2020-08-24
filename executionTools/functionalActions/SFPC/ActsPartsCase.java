package functionalActions.SFPC;

import org.openqa.selenium.WebDriver;

import actions.BrowserActions;
import sfPartnersCommunity.SFPC_Case;

public class ActsPartsCase {
	
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
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
			
			*/
	
	
	
	
	
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
	
	public static boolean validateCasePage(WebDriver driver, int stepID) throws Exception
	{
	 	String actionName="Case: Validate Case's Page";
	 	try
		{
			if(BrowserActions.isElementPresent(driver, SFPC_Case.caseInformation) && 
					BrowserActions.isElementPresent(driver, SFPC_Case.caseCategorization) && 
					BrowserActions.isElementPresent(driver, SFPC_Case.additionalInformation) && 
					BrowserActions.isElementPresent(driver, SFPC_Case.headerCase) && 
					BrowserActions.isElementPresent(driver, SFPC_Case.detailsCase))
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
