package functionalActions.SFPC;

import org.openqa.selenium.WebDriver;

import actions.BrowserActions;
import sfPartnersCommunity.SFPC_Orders;

public class ActsPartsOrders {

	// Regular Actions
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
	 *String actionName="";


						try
						{
							<JAVA CODE>

							System.out.println(actionName+" - Succeeded in Step "+stepID);

						}
						catch(Exception e)
						{

							throw new Exception (actionName+" - Failed in Step "+stepID,e);
						}

	 */




	// Validation Actions
	/*02-03-2020:LMA
	 * sketch for every validation functions
	 *=====================================
	 *String actionName="";
	 * 	try
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

	public static boolean ordersListViewPageValidation(WebDriver driver, int stepID) throws Exception
	{
		boolean validation;
		
		String actionName="Order: List View Page Validation";
		
		
		try
		{
			if(
					BrowserActions.isElementPresent(driver, SFPC_Orders.ordersTable) && 
					BrowserActions.isElementPresent(driver, SFPC_Orders.listViewControlsBtn) && 
					BrowserActions.isElementPresent(driver, SFPC_Orders.refreshButton) && 
					BrowserActions.isElementPresent(driver, SFPC_Orders.bannerHeader) && 
					(!(BrowserActions.isElementPresent(driver, SFPC_Orders.newOrderButton)))
					)
			{
				validation = true;
			}
			else
			{
				validation = false;
			}
			
			System.out.println(actionName+" - Succeeded in Step: "+stepID);
			return validation;

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}
}
