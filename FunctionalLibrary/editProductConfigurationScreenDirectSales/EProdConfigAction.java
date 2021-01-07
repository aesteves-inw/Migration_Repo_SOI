package editProductConfigurationScreenDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectMap.sfDirectSales.DirSalesEditProductConfiguration;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import executionTools.*;

public class EProdConfigAction {
	
	public static void changeToEditProductConfigurationiFrame(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		String actionName="Change to Edit Prodcut Configuration iframe";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesEditProductConfiguration.iFrameEditProductConfiguration)));

			WebElement iframeEditProdConfig = driver.findElement(By.xpath(DirSalesEditProductConfiguration.iFrameEditProductConfiguration));

			driver.switchTo().frame(iframeEditProdConfig);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static boolean editProductConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="Product Basket: Edit Product Configuration Screen Validation (By Test Name)";
		
		try
		{
			WebElement productToBeConfigured=driver.findElement(By.xpath("//h1[@title='"+productName+"']"));
			
			String productToBeConfiguredValidation=productToBeConfigured.getText().toString();
			
			if(
				BrowserActions.isElementPresent(driver, DirSalesEditProductConfiguration.bannerEditProductConfiguration) &&
				BrowserActions.isElementPresent(driver, DirSalesEditProductConfiguration.productConfigurationLabel) &&
				productToBeConfigured.isDisplayed() && productToBeConfiguredValidation.contains(productName)
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
					TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
					throw new Exception (actionName+" - Failed in Step: "+stepID,e);
				}
	}

}
