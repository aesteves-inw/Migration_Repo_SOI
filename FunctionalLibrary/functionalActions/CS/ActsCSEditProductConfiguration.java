package functionalActions.CS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import execStructure.TestDataManagement;
import executionTools.BrowserActions;

public class ActsCSEditProductConfiguration 
{
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
	
	public static void changeToEditProductConfigurationiFrame(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName="Change to Edit Prodcut Configuration iframe";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CloudSenseEditProductConfiguration.iFrameEditProductConfiguration)));

			WebElement iframeEditProdConfig = driver.findElement(By.xpath(CloudSenseEditProductConfiguration.iFrameEditProductConfiguration));

			driver.switchTo().frame(iframeEditProdConfig);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	
	//End of Configuration
	public static void finishConfiguration(WebDriver driver, int stepID) 
	{
		// TODO Auto-generated method stub

	}
	
	public static void cancelConfiguration(WebDriver driver, int stepID)
	{
		
	}


	// Validation Actions
		/*
		 * 02-03-2020:LMA
		 
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
	
	public static boolean goToEditProductConfigurationScreenValidationByTestName(WebDriver driver, int stepID, String testName) throws Exception 
	{
		String actionName="Product Basket: Edit Product Configuration Screen Validation (By Test Name)";
		
		String product = TestDataManagement.getD02ProductToAdd(testName);
		
		try
		{
			WebElement productToBeConfigured=driver.findElement(By.xpath("//h1[@title='"+product+"']"));
			
			String productToBeConfiguredValidation=productToBeConfigured.getText().toString();
			
			if(
				BrowserActions.isElementPresent(driver, CloudSenseEditProductConfiguration.bannerEditProductConfiguration) &&
				BrowserActions.isElementPresent(driver, CloudSenseEditProductConfiguration.productConfigurationLabel) &&
				productToBeConfigured.isDisplayed() && productToBeConfiguredValidation.contains(product)
				)
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
