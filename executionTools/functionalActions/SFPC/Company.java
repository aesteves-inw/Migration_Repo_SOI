package functionalActions.SFPC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.BrowserActions;

import sfPartnersCommunity.SFPC_Company;

public class Company {

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
	
	public static void createNewOpportunity(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Company: Create New Opportunity";

		

		try
		{
			driver.findElement(By.xpath(SFPC_Company.newOppieButton)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void goToOpportunityScreen(WebDriver driver, int stepID, String testExecutionString) throws Exception
	{
		String actionName="Company: Go to Opportunity Screen";


		String oppieName="OPTY_"+testExecutionString;
		
		
		try
		{
			driver.findElement(By.linkText(oppieName)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}



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

	public static boolean validateCompanyDetailsPage(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Company: Validate Company's Details Page";
		
		
		try
		{
			if(BrowserActions.isElementPresent(driver, SFPC_Company.buttonFollow) && BrowserActions.isElementPresent(driver, SFPC_Company.buttonNewMACDOrder) && BrowserActions.isElementPresent(driver, SFPC_Company.buttonEdit) && BrowserActions.isElementPresent(driver, SFPC_Company.relListNewOPTYButton) && BrowserActions.isElementPresent(driver, SFPC_Company.relListAgreementsLink) && BrowserActions.isElementPresent(driver, SFPC_Company.companyDetails) && BrowserActions.isElementPresent(driver, SFPC_Company.headerCompany))
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
