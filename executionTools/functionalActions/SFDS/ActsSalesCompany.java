package functionalActions.SFDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceOpportunity;

public class ActsSalesCompany {
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
	
	public static void createNewStandardOpportunity(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Create New Opportunity Screen";
		
		WebDriverWait waitNSOS = new WebDriverWait(driver, 10);

		try
		{	
			
			String rmOpportunitiesListViewlink = driver.findElement(By.xpath(SalesForceCompany.rmOpportunitieslink)).getAttribute("href");
			
			driver.get(rmOpportunitiesListViewlink);
			
			driver.findElement(By.xpath(SalesForceOpportunity.newButton)).click();
			
			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.newOpportunityHeader)));
			
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void findOrderOnCompany(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Company: Find Order Container on Company Page";
		
		
		WebDriverWait waitFOC = new WebDriverWait(driver, 10);

		try
		{

			for(int i=0;i<2;i++)
			{
				waitFOC.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceCompany.articleOrders)));

				BrowserActions.verticalScrollByPixs(driver, BrowserActions.getYOfElement(driver, SalesForceCompany.articleOrders));

				Thread.sleep(3000);
			}


			waitFOC.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceCompany.firstOrderLink)));

			BrowserActions.verticalScrollByPixs(driver, BrowserActions.getYOfElement(driver, SalesForceCompany.firstOrderLink));
			
			
			
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
	
	
	
}
