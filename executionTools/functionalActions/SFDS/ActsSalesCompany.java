package functionalActions.SFDS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public static void ordersShowMoreMenu(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Company: Show more Actions on orders area";


		try
		{
			WebElement showMoreActions = BrowserActions.getElementByJSQuery(driver, SalesForceCompany.showMoreActionsOrder);
			
			BrowserActions.jsClick(driver, showMoreActions);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	
	public static void goToOrdersListViewPageFromCompany(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Company: Go to Company's Orders List View";


		try
		{
			WebElement orderslistViewLink = BrowserActions.getElementByJSQuery(driver, SalesForceCompany.ordersLinkRelatedMenu);
			
			BrowserActions.jsClick(driver, orderslistViewLink);
			
			
			

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
	
	public static boolean orderActionsMenuValidation(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Company: Order Actions on Related Menu";
		
		  	try
					{
		  		
		  			List<WebElement> menuActions = driver.findElements(By.tagName("a"));
		  			
						if(menuActions.size() > 0)
						{
							System.out.println(actionName+" - Succeeded in Step: "+stepID);
							return true;
						}
						else
						{
							System.out.println(actionName+" - Succeeded in Step: "+stepID);
							return false;
						}

					}
					catch(Exception e)
					{
						throw new Exception (actionName+" - Failed in Step: "+stepID,e);
					}
	}
	
}
