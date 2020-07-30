package functionalActions.CS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import cloudSense.CloudSenseProductBasket;
import execStructure.TestData;



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
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CloudSenseProductBasket.iframeProductBasket)));

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

	public static void pickProductOnAddOfferBasketByTestName(WebDriver driver, int stepID, String testName) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);

		String productToAdd=TestData.getD02ProductToAdd(testName);

		String actionName="Add Offer to Basket: Pick Product - "+productToAdd;


		try
		{
			driver.findElement(By.linkText(productToAdd)).click();

			WebElement productSummary=driver.findElement(By.xpath(CloudSenseProductBasket.summarySection));

			String productVal=productSummary.getText().toString();

			if(productVal.contains(productToAdd))
			{
				driver.findElement(By.xpath(CloudSenseProductBasket.add2OfferButton)).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CloudSenseProductBasket.singleLineItemProduct)));

			}
			else
			{
				throw new Exception ("Not Possible to confirm Product Selection on Step "+stepID);
			}

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void goToEditProductConfigurationScreen(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket Screen: Go To 'Edit Product Configuration' Screen";

		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		try
		{
			driver.findElement(By.xpath(CloudSenseProductBasket.editProductConfigurationButton)).click();
			
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			ActsCSEditProductConfiguration.changeToEditProductConfigurationiFrame(driver, wait, stepID);

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
	 	public static boolean functionName()
	 	{

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
		}

	 */

	public static boolean productBasketScreenValidation(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName="Product Basket: Validation of Product Basket Screen";


		try
		{			
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

	public static boolean productOnProductBasketValidationByTestName(WebDriver driver, int stepID, String testName) throws Exception
	{
		String productToAdd=TestData.getD02ProductToAdd(testName);

		String actionName="Product Basket: Product Added into Product Basket Validation (By TestName)";

		try
		{
			WebElement productBasketTable=driver.findElement(By.xpath(CloudSenseProductBasket.productBasketTable));

			String productBasketLineItemValidation=productBasketTable.getText().toString();

			if(productBasketLineItemValidation.contains(productToAdd))
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
