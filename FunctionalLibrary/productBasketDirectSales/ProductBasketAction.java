package productBasketDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesEditProductConfiguration;
import objectMap.sfDirectSales.DirSalesProductBasket;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProductBasketAction {

	//Operational Actions

	public static void changeToProductBasketiFrame(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,30);

		String actionName="Product Basket: Change to Product Basket iframe";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesProductBasket.iframeProductBasket)));

			WebElement iframeProductBasket = driver.findElement(By.xpath(DirSalesProductBasket.iframeProductBasket));

			driver.switchTo().frame(iframeProductBasket);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.productBasketLabel)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void changeToDefaultiFrame(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Change to default frame";


		try
		{
			driver.switchTo().defaultContent();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
		}
	}

	public static void openAddProductMenu(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Open Add Product Menu";


		try
		{
			driver.findElement(By.xpath(DirSalesProductBasket.addProductButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void syncProductBasket(List<TestLog> logStream, WebDriver driver, int newStepCounter) throws Exception 
	{
		String actionName="syncProductBasket";


		try
		{
			driver.findElement(By.xpath(DirSalesProductBasket.syncButton)).click();


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+newStepCounter);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+newStepCounter, e.toString());
			throw new Exception (actionName+" - Failed in Step "+newStepCounter,e);
		}

	}

	public static void selectLineItem(List<TestLog> logStream, WebDriver driver, int newStepCounter, String productName) throws Exception 
	{
		String actionName="selectLineItem";


		try
		{
			WebElement productBasketTable=driver.findElement(By.xpath(DirSalesProductBasket.productBasketTable));

			List<WebElement> productBasketLineItem=productBasketTable.findElements(By.tagName("li"));

			for(WebElement we : productBasketLineItem)
			{
				if(we.getText().contains(productName))
				{
					we.findElement(By.xpath(DirSalesProductBasket.selectLineItemCheckBox)).click();
					break;
				}
			}			


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+newStepCounter);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+newStepCounter, e.toString());
			throw new Exception (actionName+" - Failed in Step "+newStepCounter,e);
		}

	}

	public static void deleteLineItem(List<TestLog> logStream, WebDriver driver, int newStepCounter) throws Exception 
	{
		String actionName="deleteLineItem";


		try
		{
			WebElement deleteButton = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Delete Product']")));

			deleteButton.click();

			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Delete Product']")));

			driver.findElement(By.xpath("//span[@ng-bind='::LabelsConstant.DELETE_PRODUCTS_CONFIRMATION_DIALOG.BTN_OK']")).click();

			Thread.sleep(5000);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+newStepCounter);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+newStepCounter, e.toString());
			throw new Exception (actionName+" - Failed in Step "+newStepCounter,e);
		}

	}

	public static void expandingECS(List<TestLog> logStream, WebDriver driver, int stepID, String productName) throws Exception 
	{
		String actionName="expandingECS";

		try
		{

			WebElement productBasketTable=driver.findElement(By.xpath(DirSalesProductBasket.productBasketTable));

			List<WebElement> productBasketLineItem=productBasketTable.findElements(By.tagName("li"));

			for(WebElement we : productBasketLineItem)
			{
				if(we.getText().contains(productName))
				{
					we.findElement(By.xpath(DirSalesProductBasket.expandPackageButton)).click();

					break;
				}
			}	

			Thread.sleep(5000);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void goToEditProductConfiguration(List<TestLog> logStream, WebDriver driver, int stepID, String productName) throws Exception
	{
		String actionName="goToEditProductConfiguration";

		try
		{

			//28-01-2021 - Initial approach in how to access the Edit Product Configuration
			/*
			WebElement productBasketTable=driver.findElement(By.xpath(DirSalesProductBasket.productBasketTable));

			List<WebElement> productBasketLines=productBasketTable.findElements(By.tagName("li"));

			for (WebElement we:productBasketLines)
			{
				if (we.getText().contains(productName))
				{
					we.findElement(By.xpath(DirSalesProductBasket.editProductConfigurationButton)).click();
					break;
				}
			}
			 */

			// 28-01-2020 - New approach in how to access the Edit Product Configuration

			WebElement productBasketTable=driver.findElement(By.xpath(DirSalesProductBasket.productBasketTable));

			List<WebElement> productBasketLines=productBasketTable.findElements(By.tagName("li"));

			List<WebElement> productBasketLinesBts=productBasketTable.findElements(By.xpath(DirSalesProductBasket.editProductConfigurationButton));

			for(int i=0;i<productBasketLines.size();i++)
			{
				if (productBasketLines.get(i).getText().contains(productName))
				{
					productBasketLinesBts.get(i).click();
					break;
				}
			}


			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesEditProductConfiguration.iFrameEditProductConfiguration)));		

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void goToDiscountManagementConsole(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="goToDiscountManagementConsole";


		try
		{
			driver.findElement(By.xpath(DirSalesProductBasket.buttonDiscountManagement)).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void goToOrderEnrichmentConsole(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="goToOrderEnrichmentConsole";


		try
		{
			driver.findElement(By.xpath(DirSalesProductBasket.buttonOrderEnrichment)).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}


	public static void fillExistingBillingAccountIdField(List<TestLog> logStream, WebDriver driver, int stepID,
			String textExistingBillingAccountIdField) throws Exception 
	{
		String actionName="fillExistingBillingAccountIdField";


		try
		{
			WebElement inputExistingBillingAccountIdField = driver.findElement(By.xpath(DirSalesProductBasket.inputExistingBillingAccountId));

			inputExistingBillingAccountIdField.clear();

			inputExistingBillingAccountIdField.sendKeys(textExistingBillingAccountIdField);


			
			saveProductBasketChanges(logStream, driver, stepID);
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void fillExistingTechnicalContact(List<TestLog> logStream, WebDriver driver, int stepID,
			String textExistingTechnicalContact) throws Exception 
	{
		String actionName="fillExistingBillingAccountIdField";


		try
		{
			
			
			
						
			WebElement inputProvisioningContact = driver.findElement(By.xpath(DirSalesProductBasket.inputProvisioningContactPerson));

			inputProvisioningContact.sendKeys(textExistingTechnicalContact);
			
			List<WebElement> provlistItem= new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li/div/div[1]")));
			
			
			
			for(int i=0;i<provlistItem.size();i++)
			{
				String validation=provlistItem.get(i).getText().toString();
				
				System.out.println("validation: "+validation);
				
				if(textExistingTechnicalContact.contains(validation))
				{
					provlistItem.get(i).click();
				}
				
			}
				
			
			saveProductBasketChanges(logStream, driver, stepID);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void saveProductBasketChanges(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="saveProductBasketChanges";


		try
		{
			driver.findElement(By.xpath(DirSalesProductBasket.saveButton)).click();
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@role='alert'][text()='Saved successfully']"))).click();
			
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	//Validation Actions
	public static boolean productBasketScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Validation of Product Basket Screen";

		try
		{			
			changeToProductBasketiFrame(logStream, driver, stepID);

			if(BrowserActions.isElementPresent(driver, DirSalesProductBasket.cloneBasketButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.syncButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketHeader) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketName) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.addProductButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.opportunityName))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);


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

	public static boolean productOnProductBasketValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="productOnProductBasketValidation";

		try
		{		
			WebElement productBasketTable=driver.findElement(By.xpath(DirSalesProductBasket.productBasketTable));

			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(productBasketTable.findElements(By.xpath("li/div/div/div/div/div[2][contains(.,'"+productName+"')]"))));

			String productBasketLineItemValidation=productBasketTable.getText().toString();

			if(productBasketLineItemValidation.contains(productName))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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

	public static boolean productOnProductBasketNegativeValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="productOnProductBasketNegativeValidation";

		try
		{		 
			if(BrowserActions.isElementPresent(driver, "//ul/li[text()='"+productName+"']")==false)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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

	public static boolean syncProductBasketPosVal(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="syncProductBasketPosVal";

		try
		{
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.buttonGoToAgreement)));

			boolean isFlagChecked = driver.findElement(By.xpath(DirSalesProductBasket.syncWithPBFlag)).isSelected();

			System.out.println("SyncProductBasketPositive Validation: "+isFlagChecked);

			if (BrowserActions.isElementPresent(driver, DirSalesProductBasket.buttonGoToAgreement) && isFlagChecked)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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

	public static boolean syncProductBasketNegVal(List<TestLog> logStream, WebDriver driver, int newStepCounter) throws Exception 
	{

		String actionName="syncProductBasketNegVal";

		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesProductBasket.errorMessagePB))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+newStepCounter);
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
			TestLogger.logError(logStream, actionName, "Failed in Step "+newStepCounter, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+newStepCounter,e);
		}
	}

	public static boolean expandedECSPackValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="expandedECSPackValidation";

		boolean result;

		try
		{
			switch(productName)
			{
			case "Enterprise Call & Surf Pro with Phone Line":
				result=validateExpandedECSProPhoneLine(logStream, driver, stepID);
				break;
			case "Enterprise Call & Surf Pro with Enterprise Voice":
				result=validateExpandedECSProEV(logStream, driver, stepID);
				break;
			case "Enterprise Call & Surf Pro+ with Phone Line":
				result=validateExpandedECSProPlusPhoneLine(logStream, driver, stepID);
				break;
			case "Enterprise Call & Surf Pro+ with Enterprise Voice":
				result=validateExpandedECSProPlusEV(logStream, driver, stepID);
				break;
			case "Enterprise Call & Surf FullFiber":
				result=validateExpandedECSFullFiber(logStream, driver, stepID);
				break;
			case "Enterprise Call & Surf FullFiber Extended":
				result=validateExpandedECSFullFiberExtended(logStream, driver, stepID);
				break;
			default:
				TestLogger.logInfo(logStream, actionName, TestLogger.logInfo);
				throw new Exception (actionName+" - Failed in Step: "+stepID);
			}

			return result;
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	private static boolean validateExpandedECSProPlusPhoneLine(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateECSProPlusPhoneLine";

		int validation=0;

		try
		{
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

			for(WebElement we:ecsProductExpanded)
			{
				if(we.getText().contains("Internet Pro+") || we.getText().contains("Phone Line") || we.getText().contains("Business Continuity"))
				{
					validation++;
				}
			}

			if(validation > 2)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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

	private static boolean validateExpandedECSProPhoneLine(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateECSProPhoneLine";

		int validation=0;

		try
		{
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

			for(WebElement we:ecsProductExpanded)
			{
				if(we.getText().contains("Internet Pro") || we.getText().contains("Phone Line") || we.getText().contains("Business Continuity"))
				{
					validation++;
				}
			}

			if(validation > 2)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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

	private static boolean validateExpandedECSProEV(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateECSProEV";

		int validation=0;

		try
		{
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

			for(WebElement we:ecsProductExpanded)
			{
				if(we.getText().contains("Internet Pro") || we.getText().contains("Enterprise Voice - Converged") || we.getText().contains("Business Continuity"))
				{
					validation++;
				}
			}

			if(validation > 2)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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

	private static boolean validateExpandedECSProPlusEV(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateECSProPlusEV";

		int validation=0;

		try
		{
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

			for(WebElement we:ecsProductExpanded)
			{
				if(we.getText().contains("Internet Pro+") || we.getText().contains("Enterprise Voice - Converged") || we.getText().contains("Business Continuity"))
				{
					validation++;
				}
			}

			if(validation > 2)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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

	private static boolean validateExpandedECSFullFiber(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateECSFullFiber";

		int validation=0;

		try
		{
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

			for(WebElement we:ecsProductExpanded)
			{
				if(we.getText().contains("FullFiber") || we.getText().contains("Enterprise Voice - Converged") || we.getText().contains("Business Continuity"))
				{
					validation++;
				}
			}

			if(validation > 2)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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

	private static boolean validateExpandedECSFullFiberExtended(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateECSFullFiberExtended";

		int validation=0;

		try
		{
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

			for(WebElement we:ecsProductExpanded)
			{
				if(we.getText().contains("FullFiber Extended") || we.getText().contains("Enterprise Voice - Converged") || we.getText().contains("Business Continuity"))
				{
					validation++;
				}
			}

			if(validation > 2)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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

	public static boolean checkExistingBillingAccountIdField(List<TestLog> logStream, WebDriver driver, int stepID,
			String textExistingBillingAccountIdField) throws Exception 
	{
		String actionName="checkExistingBillingAccountIdField";
		try
		{
			WebElement inputProvisioningContactPerson = driver.findElement(By.xpath(DirSalesProductBasket.inputExistingBillingAccountId));

			System.out.println("Debug of inputProvisioningContactPerson.getText().toString() after val: "+inputProvisioningContactPerson.getAttribute("value"));

			if(textExistingBillingAccountIdField.contains(inputProvisioningContactPerson.getText().toString()))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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


	public static boolean checkExistingTechnicalContact(List<TestLog> logStream, WebDriver driver, int stepID,
			String textExistingTechnicalContact) throws Exception 
	{
		String actionName="checkExistingTechnicalContact";
		
		try
		{
			Thread.sleep(3000);
			
			WebElement inputCheck=driver.findElement(By.xpath(DirSalesProductBasket.inputProvisioningContactPerson));
			
			String inputCheckVal=inputCheck.getAttribute("value");
			
			System.out.println("Debug of inputCheckVal: "+inputCheckVal);
			
			if(inputCheckVal.contains(textExistingTechnicalContact))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
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
