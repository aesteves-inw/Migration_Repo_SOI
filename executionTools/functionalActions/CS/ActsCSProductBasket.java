package functionalActions.CS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import cloudSense.CloudSenseProductBasket;



public class ActsCSProductBasket {

	// Regular Actions
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
		 public static void functionName()
		 {
		 String actionName="";


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

	 */

	public static void changeToProductBasketiFrame(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName="Product Basket: Change to Product Basket iframe";


		try
		{

			WebElement iframeProductBasket = driver.findElement(By.xpath(CloudSenseProductBasket.iframeProductBasket));

			driver.switchTo().frame(iframeProductBasket);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CloudSenseProductBasket.productBasketLabel)));

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void changeToDefaultiFrame(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Change to default frame";


		try
		{
			driver.switchTo().defaultContent();

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void openAddProductMenu(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Open Add Product Menu";


		try
		{
			driver.findElement(By.xpath(CloudSenseProductBasket.addProductButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	// Validation Actions
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
					System.out.println(e);
					throw new Exception (actionName+" - Failed in Step: "+stepID,e);
				}

	 */

	public static boolean productBasketScreenValidation(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName="Product Basket: Validation of Product Basket Screen";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CloudSenseProductBasket.iframeProductBasket)));
			
			changeToProductBasketiFrame(driver, wait, stepID);

			if(BrowserActions.isElementPresent(driver, CloudSenseProductBasket.cloneBasketButton) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.syncButton) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.productBasketHeader) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.productBasketName) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.addProductButton) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.opportunityName))
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
			System.out.println(e);

			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean addProductMenuValidation(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Add Product Menu Validation";
		try
		{

			if(BrowserActions.isElementPresent(driver, CloudSenseProductBasket.offerNameHeader) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.offerList) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.add2OfferCancelButton) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.add2OfferButton) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.summarySection) && 
					BrowserActions.isElementPresent(driver, CloudSenseProductBasket.productCatalog))
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
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean soi1312Validation(WebDriver driver, int stepID, String userProfile) throws Exception
	{
		String actionName="Product Basket: Chinese Walls validation (SOI-1312)";
		
		WebDriverWait wait = new WebDriverWait(driver, 7);
		
		try
		{
			//String productCatalogText=driver.findElement(By.xpath(CloudSenseProductBasket.productCatalog)).getText().toString();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("EBU")));
			
			String productCatalogText=driver.findElement(By.xpath(CloudSenseProductBasket.productCatalog)).getText().toString();
			
			if(!productCatalogText.contains("Carrier & Wholesale Solutions") || userProfile=="SysAdmin")
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
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}
}
