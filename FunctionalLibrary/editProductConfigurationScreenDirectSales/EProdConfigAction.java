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
	
	//Operational Action

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

	public static void finishConfiguration(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="Finish Configuration on 'Edit Product Configuration' Screen";


		try
		{
			WebElement footer=driver.findElement(By.xpath(DirSalesEditProductConfiguration.footerEditProductConfigurationScreen));

			if (footer.isDisplayed()== false)
			{
				BrowserActions.scroll2Bottom(driver);
			}

			footer.findElement(By.xpath(DirSalesEditProductConfiguration.buttonFinish)).click();

			new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(footer));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void cancelConfiguration(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Cancel Configuration on 'Edit Product Configuration' Screen";


		try
		{
			WebElement footer=driver.findElement(By.xpath(DirSalesEditProductConfiguration.footerEditProductConfigurationScreen));
			
			if (footer.isDisplayed()== false)
			{
				BrowserActions.scroll2Bottom(driver);
			}
			
			footer.findElement(By.xpath(DirSalesEditProductConfiguration.buttonCancel)).click();
			
			new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(footer));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void selectAddress(List<TestLog> logStream, WebDriver driver, int stepID, String address) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String actionName="Change to Edit Prodcut Configuration iframe";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:existingAddress_0\"]")));

			WebElement addressSelectField = driver.findElement(By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:existingAddress_0\"]"));

			addressSelectField.click();
			
			driver.findElement(By.xpath("//*[@id=\"s2id_autogen5_search\"]")).sendKeys(address);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'"+address+"')]")));
			
			driver.findElement(By.xpath("//div[contains(text(),'"+address+"')]")).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void selectTechnologyNOK(List<TestLog> logStream, WebDriver driver, int stepID, String Technology) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String actionName="Change to Edit Prodcut Configuration iframe";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:accessTechnology_0\"]")));

			WebElement technologySelectField = driver.findElement(By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:accessTechnology_0\"]"));

			technologySelectField.click();
			
			Thread.sleep(6000);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	//Validation Action
	
	public static boolean selectAddressValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Address Select Validation";

		try
		{
			WebElement addressField=driver.findElement(By.xpath("//*[@id=\"select2-chosen-5\"]"));
			
			
			System.out.println(addressField.getText());
			
			
			
			String addressValidation= addressField.getText();

			if(
					addressValidation.contains("A Rodenbachlaan,29, Grimbergen, 1850, Belgium")
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
	
	public static boolean selectTechnologyValidationNOK(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Technology Select Validation";

		try
		{
			String errorMessage = driver.switchTo().alert().getText();
			
			
			System.out.println(driver.switchTo().alert().getText());
			
			driver.switchTo().alert().accept();

			if(
					errorMessage.contains("No technology available. Contact TCA Helpdesk for more detailed info.")
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
	
	public static boolean editProductConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="Product Basket: Edit Product Configuration Screen Validation";

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
	
	public static boolean editProductConfigurationECS(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="Product Basket: Edit Product Configuration Screen Validation";

		try
		{
			WebElement productToBeConfigured=driver.findElement(By.xpath("//h1[@title='ECS - "+productName+"']"));

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

	public static boolean editProductConfigurationForD03(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="Product Basket: Edit Product Configuration Screen Validation";
		
		String productName="External Quoted";

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
