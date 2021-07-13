package productBasketDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import editProductConfigurationScreenDirectSales.EProdConfigAction;
import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesEditProductConfiguration;
import objectMap.sfDirectSales.DirSalesProductBasket;
import objectMap.sfPartnersCommunity.PartComProductBasket;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProductBasketAction {

	//Operational Actions

	public static void changeToProductBasketiFrame(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{

		String actionName="Product Basket: Change to Product Basket iframe";
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement iframeProductBasket = null;


		try
		{
			
			Thread.sleep(3000);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesProductBasket.iframeProductBasket)));
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.iframeProductBasket)));
			
			driver.findElements(By.tagName("iframe"));
			
//			int numberOfFrames = driver.findElements(By.tagName("iframe")).size();
//			System.out.println("no. of iframes are " + numberOfFrames);

//			WebElement iframeProductBasket = driver.findElement(By.xpath(DirSalesProductBasket.iframeProductBasket));
			
			Boolean existIframeDS = driver.findElements(By.xpath(DirSalesProductBasket.iframeProductBasket)).size() != 0;
			
			Boolean existIframePC = driver.findElements(By.xpath("//iframe[@title='Visualforce Page component container']")).size() != 0;
			
			if(existIframeDS==true) {
				iframeProductBasket = driver.findElement(By.xpath(DirSalesProductBasket.iframeProductBasket));

			}else if (existIframePC==true) {
				iframeProductBasket = driver.findElement(By.xpath("//iframe[@title='Visualforce Page component container']"));

			}

			driver.switchTo().frame(iframeProductBasket);
			
//			int numberOfFrames2 = driver.findElements(By.tagName("iframe")).size();
//			System.out.println("no. of iframes are " + numberOfFrames2);

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

	public static void changeToProductBasketiFramePC(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,30);

		String actionName="Product Basket: Change to Product Basket iframe";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PartComProductBasket.iframeProductBasket)));

			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.iframeProductBasket)));

			WebElement iframeProductBasket = driver.findElement(By.xpath(PartComProductBasket.iframeProductBasket));

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
			//driver.findElement(By.xpath(DirSalesProductBasket.syncButton)).click();

			WebElement syncButton = driver.findElement(By.xpath(DirSalesProductBasket.syncButton));

			BrowserActions.jsClick(driver, syncButton);


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
//			List<WebElement> productBasketLineItem=driver.findElements(By.xpath("//li[@role='treeitem']"));
			
			
			for(WebElement we : productBasketLineItem)
			{
				if(we.getText().contains(productName))
				{

					we.findElement(By.xpath(DirSalesProductBasket.selectLineItemCheckBox)).click();

					WebElement selectLineItemCheckBox = we.findElement(By.xpath(DirSalesProductBasket.selectLineItemCheckBox));

					BrowserActions.jsClick(driver, selectLineItemCheckBox);

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
					//we.findElement(By.xpath(DirSalesProductBasket.expandPackageButton)).click();

					BrowserActions.jsClick(driver, we.findElement(By.xpath(DirSalesProductBasket.expandPackageButton)));

					break;
				}
			}	

			Thread.sleep(10000);

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
					//productBasketLinesBts.get(i).click();

					BrowserActions.jsClick(driver, productBasketLinesBts.get(i));
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
			Thread.sleep(2000);

			WebElement inputExistingBillingAccountIdField = driver.findElement(By.xpath(DirSalesProductBasket.inputExistingBillingAccountId));

			inputExistingBillingAccountIdField.clear();

			inputExistingBillingAccountIdField.sendKeys(textExistingBillingAccountIdField);

			Thread.sleep(2000);

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
		String actionName="fillExistingTechnicalContact";

		try
		{
			/*WebElement inputProvisioningContact = driver.findElement(By.xpath(DirSalesProductBasket.inputProvisioningContactPerson));

			inputProvisioningContact.sendKeys(textExistingTechnicalContact);

			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id=\"select2-results-6\"]/li[1]")).click();

			 */

			//BrowserActions.jsClick(driver, contactList);

			/*
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
			 */

			//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"select2-drop\"]")));

			//WebElement provlistItem = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/div/div[1]")));
			WebElement provlistItem = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-results-6\"]/li[1]")));

			provlistItem.click();

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
			WebElement saveButton=driver.findElement(By.xpath(DirSalesProductBasket.saveButton));

			Thread.sleep(1000);

			BrowserActions.jsClick(driver, saveButton);

			Thread.sleep(1000);

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

	public static void saveEditProductBasketChanges(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="saveEditProductBasketChanges";


		try
		{
			WebElement saveButton=driver.findElement(By.xpath(DirSalesProductBasket.saveButton));

			Thread.sleep(1000);

			BrowserActions.jsClick(driver, saveButton);

			Thread.sleep(1000);





			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void cancelProductBasketChanges(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="cancelProductBasketChanges";


		try
		{
			WebElement cancelButton=driver.findElement(By.xpath(DirSalesProductBasket.cancelButton));


			BrowserActions.jsClick(driver, cancelButton);

			Thread.sleep(1000);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}


	}

	public static void fillNewBillingAccountAddress(List<TestLog> logStream, WebDriver driver, int stepID, String newBillingAddress) throws Exception 
	{
		String actionName="fillNewBillingAccountAddress";


		try
		{
			driver.findElement(By.xpath(DirSalesProductBasket.inputNewBillingAccountAddress)).sendKeys(newBillingAddress);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void fillExistingBillingAccountIdFieldNoSave(List<TestLog> logStream, WebDriver driver, int stepID,
			String existingBillingAccountIdField) throws Exception 
	{
		String actionName="fillExistingBillingAccountIdFieldNoSave";


		try
		{
			WebElement inputExistingBillingAccountIdField = driver.findElement(By.xpath(DirSalesProductBasket.inputExistingBillingAccountId));

			inputExistingBillingAccountIdField.clear();

			inputExistingBillingAccountIdField.sendKeys(existingBillingAccountIdField);






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
			Thread.sleep(3000);
			
			changeToDefaultiFrame(logStream, driver, stepID);
			
			changeToProductBasketiFrame(logStream, driver, stepID);
			
//			int size = driver.findElements(By.tagName("iframe")).size();
//		    System.out.println("Total Frames after changeToProductBasketiFrame --" + size);
//		    System.out.println("Element Sync is in current iFrame: --" + BrowserActions.isElementPresent(driver, DirSalesProductBasket.syncButton));


			if(BrowserActions.isElementPresent(driver, DirSalesProductBasket.cloneBasketButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.syncButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketHeader) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketName) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.addProductButton))
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

	public static boolean productBasketScreenValidationPC(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Validation of Product Basket Screen";

		try
		{	
			changeToDefaultiFrame(logStream, driver, stepID);

			changeToProductBasketiFramePC(logStream, driver, stepID);


			if(BrowserActions.isElementPresent(driver, DirSalesProductBasket.cloneBasketButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.syncButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketHeader) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketName) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.addProductButton))
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

	public static boolean validateProductBasketScreen(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Validation of Product Basket Screen";
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"brandBand_2\"]/div/div/div[2]/div/force-aloha-page/div/iframe")));

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.iframeProductBasket)));

		WebElement iframeProductBasket = driver.findElement(By.xpath("//*[@id=\"brandBand_2\"]/div/div/div[2]/div/force-aloha-page/div/iframe"));

		driver.switchTo().frame(iframeProductBasket);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.productBasketLabel)));

		TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		try
		{	
			if(//BrowserActions.isElementPresent(driver, DirSalesProductBasket.cloneBasketButton) && 
					//BrowserActions.isElementPresent(driver, DirSalesProductBasket.syncButton)) //&& 
					//BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketHeader) && 
					//BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketName) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.addProductButton))
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
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

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
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

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
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"basket-table\"]/div[2]/div/ul/li/div/div/div/div[3]/ul")));

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
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

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
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

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
			List<WebElement> ecsProductExpanded = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ng-scope']")));

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
			WebElement inputExistingBillingAccountId = driver.findElement(By.xpath(DirSalesProductBasket.inputExistingBillingAccountId));

			System.out.println("Debug of inputExistingBillingAccountId.getText().toString() after val: "+inputExistingBillingAccountId.getAttribute("value"));

			if(textExistingBillingAccountIdField.contains(inputExistingBillingAccountId.getText().toString()))
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

	public static boolean internetEditConfigValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="internetEditConfigValidation";
		try
		{
			EProdConfigAction.changeToEditProductConfigurationiFrame(logStream, driver, stepID);

			String internetEditConfigHeader1 = driver.findElement(By.xpath("//p[text()='Product Configuration']")).getText();
			String internetEditConfigHeader2 = driver.findElement(By.xpath("//h1[text()='ECS - Professional Internet']")).getText();

			//if(internetEditConfigHeader1 == "Product Configuration" || internetEditConfigHeader2 == "ECS - Professional Internet")
			if(driver.findElement(By.xpath("//p[text()='Product Configuration']")).isDisplayed() || driver.findElement(By.xpath("//h1[text()='ECS - Professional Internet']")).isDisplayed())
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
			Thread.sleep(5000);

			WebElement inputCheck=driver.findElement(By.xpath("//div[@class='select2-container select2-allowclear ng-pristine ng-untouched ng-valid']"));

			String inputCheckVal=inputCheck.getText();

			System.out.println("Debug of inputCheckVal: "+inputCheckVal);

			if(inputCheckVal.contains(textExistingTechnicalContact))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				TestLogger.logTrace(logStream, actionName, "Failed in Step: "+stepID+". Validation: False");
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

	public static boolean validationNewBillingAccountAddressNegVal(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception 
	{
		String actionName="validationNewBillingAccountAddressNegVal";
		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesProductBasket.errorMessageBillingConfiguration))
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

	public static boolean fillNewBillingAccountAddressValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String newBillingAddress) throws Exception 
	{
		String actionName="fillNewBillingAccountAddressValidation";
		try
		{
			String newBillingAddressVal=driver.findElement(By.xpath(DirSalesProductBasket.inputNewBillingAccountAddress)).getAttribute("value");

			if(newBillingAddressVal.contains(newBillingAddress))
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

	public static boolean selectAddressEditProduct(List<TestLog> logStream, WebDriver driver, int stepID,
			String address) throws Exception 
	{
		String actionName="selectAddressEditProduct";
		try
		{
			BrowserActions.ScrollByElement(driver, "xpath", "//*[@id=\"configurationContainer\"]/div/div/div[2]/div[3]/h3");

			driver.findElement(By.xpath("//*[@id=\"select2-chosen-3\"]")).click();

			driver.findElement(By.xpath("//*[@id=\"s2id_autogen3_search\"]")).sendKeys(address);

			WebElement addressSelect = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+address+"')]")));

			String addressConfirmation = addressSelect.getText();

			System.out.println(addressConfirmation);

			addressSelect.click();

			if(addressConfirmation.contains(address))
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

	public static boolean technologyValidationOCK(List<TestLog> logStream, WebDriver driver, int stepID,
			String technology) throws Exception 
	{
		String actionName="selectAddressEditProduct";

		boolean validation = false;

		try
		{
			driver.findElement(By.xpath("//*[@id=\"s2id_Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:accessTechnology_0\"]")).click();

			WebElement technologySelect = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='select2-drop']//ul)[2]")));
			
			technologySelect.getText();

			String technologyList = driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]")).getText();

			System.out.println(driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]")).getText());

			switch(technology) {

			case "COPPER":
				if(technologyList.contains("VDSL2") || technologyList.contains("ADSL2+E"))
				{
					TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
					validation = true;
					driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li[1]")).click();
				}
				else
				{
					validation =  false;
				}
				break;
			case "FIBER":
				if(technologyList.contains("GPON"))
				{
					TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
					validation =  true;
					driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li[1]")).click();
				}
				else
				{
					validation =  false;
				}
				break;
			case "BOTH":
				if(technologyList.contains("VDSL2") || technologyList.contains("ADSL2+E") && technologyList.contains("GPON"))
				{
					TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
					validation =  true;
					driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li[1]")).click();
				}
				else
				{
					validation =  false;
				}
			break;

			}

			if(validation == true) {
				return true;
			}
			else {return false;}

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static void fillProvisioningContactPerson(List<TestLog> logStream, WebDriver driver, int stepID,
			String textProvisioningContactPersonField) throws Exception 
	{
		String actionName="fillProvisioningContactPerson";


		try
		{
			WebElement inputProvisioningContactPerson = driver.findElement(By.xpath(DirSalesProductBasket.inputProvisioningContactPerson));

			inputProvisioningContactPerson.clear();
			
			inputProvisioningContactPerson.sendKeys(textProvisioningContactPersonField);
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+textProvisioningContactPersonField+"')]"))).click();;

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

	public static boolean checkProvisioningContactPersonFieldDetails(List<TestLog> logStream, WebDriver driver, int stepID,
			String textProvisioningContactPersonField) throws Exception 
	{
		String actionName="checkProvisioningContactPersonFieldDetails";
		try
		{
			WebElement inputProvisioningContactPerson = driver.findElement(By.xpath(DirSalesProductBasket.inputProvisioningContactPerson));

			System.out.println("Debug of inputProvisioningContactPerson.getText().toString() after val: "+inputProvisioningContactPerson.getAttribute("value"));

			if(textProvisioningContactPersonField.contains(inputProvisioningContactPerson.getText().toString()))
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
