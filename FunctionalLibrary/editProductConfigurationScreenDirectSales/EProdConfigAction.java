package editProductConfigurationScreenDirectSales;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectMap.sfDirectSales.DirSalesEditProductConfiguration;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import executionTools.*;

public class EProdConfigAction {

	// Operational Action

	public static void changeToEditProductConfigurationiFrame(List<TestLog> logStream, WebDriver driver, int stepID)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String actionName = "Change to Edit Prodcut Configuration iframe";

		try {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(DirSalesEditProductConfiguration.iFrameEditProductConfiguration)));

			WebElement iframeEditProdConfig = driver
					.findElement(By.xpath(DirSalesEditProductConfiguration.iFrameEditProductConfiguration));

			driver.switchTo().frame(iframeEditProdConfig);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step " + stepID);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step " + stepID, e);
		}
	}

	public static void finishConfiguration(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception {
		String actionName = "Finish Configuration on 'Edit Product Configuration' Screen";

		try {
			WebElement footer = driver
					.findElement(By.xpath(DirSalesEditProductConfiguration.footerEditProductConfigurationScreen));

			if (footer.isDisplayed() == false) {
				BrowserActions.scroll2Bottom(driver);
			}

			footer.findElement(By.xpath(DirSalesEditProductConfiguration.buttonFinish)).click();

			new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(footer));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step " + stepID);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step " + stepID, e);
		}
	}

	public static void cancelConfiguration(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception {
		String actionName = "Cancel Configuration on 'Edit Product Configuration' Screen";

		try {
			WebElement footer = driver
					.findElement(By.xpath(DirSalesEditProductConfiguration.footerEditProductConfigurationScreen));

			if (footer.isDisplayed() == false) {
				BrowserActions.scroll2Bottom(driver);
			}

			footer.findElement(By.xpath(DirSalesEditProductConfiguration.buttonCancel)).click();

			new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(footer));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step " + stepID);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step " + stepID, e);
		}
	}

	public static void selectAddress(List<TestLog> logStream, WebDriver driver, int stepID, String address)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String actionName = "Edit Prodcut Configuration: Select Address";

		try {

			WebElement addressSelectField = null;

//			wait.until(ExpectedConditions.presenceOfElementLocated(
//					By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:existingAddress_0\"]")));

//		
//			if (driver.findElements(
//					By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:existingAddress_0\"]")).size()>0)
//			{
//				addressSelectField = driver.findElement(
//						By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:existingAddress_0\"]"));
//			}else if (driver.findElements(
//					By.xpath("//*[@for='Details:Installation_Address___OCK_check:existingAddress_0']/parent::td/div")).size()>0){
//				addressSelectField = driver.findElement(
//						By.xpath("//*[@for='Details:Installation_Address___OCK_check:existingAddress_0']/parent::td/div"));
//			}else if (driver.findElements(
//					By.xpath("//*[@for='Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:existingAddress_0']/parent::td/div")).size()>0) {
//				addressSelectField = driver.findElement(
//						By.xpath("//*[@for='Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:existingAddress_0']/parent::td/div"));
//			}

			addressSelectField = driver.findElement(By
					.xpath("//*[contains(@for,'Installation_Address___OCK_check:existingAddress_0') or contains(@for,'Installation_Address___OCK_Check:existingAddress_0')]/parent::td/div"));

			addressSelectField.click();

			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@title='Address Details']/ancestor::div//input")))
					.sendKeys(address);
//			driver.findElement(By.xpath("//*[@id=\"s2id_autogen5_search\"]")).sendKeys(address);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + address + "')]")));

			driver.findElement(By.xpath("//div[contains(text(),'" + address + "')]")).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step " + stepID);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step " + stepID, e);
		}
	}

	public static void selectAddressECS(List<TestLog> logStream, WebDriver driver, int stepID, String address)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String actionName = "Select Address";

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(
					"s2id_Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:existingAddress_0")));

			WebElement addressSelectField = driver.findElement(By.id(
					"s2id_Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:existingAddress_0"));

			addressSelectField.click();

			driver.findElement(By.xpath("//*[@id=\"s2id_autogen3_search\"]")).sendKeys(address);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + address + "')]")));

			driver.findElement(By.xpath("//div[contains(text(),'" + address + "')]")).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step " + stepID);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step " + stepID, e);
		}
	}

	public static void selectTechnologyNOK(List<TestLog> logStream, WebDriver driver, int stepID, String Technology)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String actionName = "Change to Edit Prodcut Configuration iframe";

		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:accessTechnology_0\"]")));

			WebElement technologySelectField = driver.findElement(
					By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:accessTechnology_0\"]"));

			technologySelectField.click();

			Thread.sleep(6000);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step " + stepID, e);
		}
	}

	// Validation Action

	public static boolean selectAddressValidation(List<TestLog> logStream, WebDriver driver, int stepID, String address)
			throws Exception {
		String actionName = "Product Basket: Address Select Validation";

		try {
			WebElement addressField;

//			WebElement addressField=driver.findElement(By.xpath("//*[@id=\"select2-chosen-5\"]"));

//			WebElement addressField = driver.findElement(By.xpath(
//					"//*[@id='s2id_Details:Installation_Address___OCK_Check:existingAddress_0']//span[@class='select2-chosen']"));

//			if (driver.findElements(
//					By.xpath("//*[@id='s2id_Details:Installation_Address___OCK_Check:existingAddress_0']//span[@class='select2-chosen']")).size()>0)
//			{
//				addressField = driver.findElement(By.xpath(
//						"//*[@id='s2id_Details:Installation_Address___OCK_Check:existingAddress_0']//span[@class='select2-chosen']"));
//			}else{
//				addressField = driver.findElement(By.xpath(
//						"//*[@for='Details:Installation_Address___OCK_check:existingAddress_0']/parent::td/div"));
//			}

			addressField = driver.findElement(By
					.xpath("//*[contains(@for,'Installation_Address___OCK_check:existingAddress_0') or contains(@for,'Installation_Address___OCK_Check:existingAddress_0')]/parent::td/div"));

			System.out.println(addressField.getText());

			String addressValidation = addressField.getText();

			if (
//					addressValidation.contains("A Rodenbachlaan,29, Grimbergen, 1850, Belgium")
			addressValidation.contains(address)) {
				System.out.println(actionName + " - Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step: " + stepID, e);
		}
	}

	public static boolean selectTechnologyValidationNOK(List<TestLog> logStream, WebDriver driver, int stepID)
			throws Exception {
		String actionName = "Product Basket: Technology Select Validation";

		try {
			String errorMessage = driver.switchTo().alert().getText();

			System.out.println(driver.switchTo().alert().getText());

			driver.switchTo().alert().accept();

			if (errorMessage.contains("No technology available. Contact TCA Helpdesk for more detailed info.")) {
				System.out.println(actionName + " - Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step: " + stepID, e);
		}
	}

	public static boolean editProductConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception {
		String actionName = "Product Basket: Edit Product Configuration Screen Validation";

		try {
			WebElement productToBeConfigured = driver.findElement(By.xpath("//h1[@title='" + productName + "']"));

			String productToBeConfiguredValidation = productToBeConfigured.getText().toString();

			if (BrowserActions.isElementPresent(driver, DirSalesEditProductConfiguration.bannerEditProductConfiguration)
					&& BrowserActions.isElementPresent(driver,
							DirSalesEditProductConfiguration.productConfigurationLabel)
					&& productToBeConfigured.isDisplayed() && productToBeConfiguredValidation.contains(productName)) {
				System.out.println(actionName + " - Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step: " + stepID, e);
		}
	}

	public static boolean editProductConfigurationECS(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception {
		String actionName = "Product Basket: Edit Product Configuration Screen Validation";

		try {
			WebElement productToBeConfigured = driver.findElement(By.xpath("//h1[@title='ECS - " + productName + "']"));

			String productToBeConfiguredValidation = productToBeConfigured.getText().toString();

			if (BrowserActions.isElementPresent(driver, DirSalesEditProductConfiguration.bannerEditProductConfiguration)
					&& BrowserActions.isElementPresent(driver,
							DirSalesEditProductConfiguration.productConfigurationLabel)
					&& productToBeConfigured.isDisplayed() && productToBeConfiguredValidation.contains(productName)) {
				System.out.println(actionName + " - Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step: " + stepID, e);
		}
	}

	public static boolean editProductConfigurationECSInternet(List<TestLog> logStream, WebDriver driver, int stepID)
			throws Exception {
		String actionName = "Product Basket: Edit Product Configuration Screen Validation";

		try {

			WebElement productToBeConfigured = driver
					.findElement(By.xpath("//h1[@title='ECS - Professional Internet']"));

			String productToBeConfiguredText = driver
					.findElement(By.xpath("//h1[@title='ECS - Professional Internet']")).getText();

			String productToBeConfiguredValidation = productToBeConfigured.getText().toString();

			if (BrowserActions.isElementPresent(driver, DirSalesEditProductConfiguration.bannerEditProductConfiguration)
					&& BrowserActions.isElementPresent(driver,
							DirSalesEditProductConfiguration.productConfigurationLabel)
					&& productToBeConfigured.isDisplayed()
					&& productToBeConfiguredValidation.contains(productToBeConfiguredText)) {
				System.out.println(actionName + " - Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step: " + stepID, e);
		}
	}

	public static boolean editProductConfigurationECSEV(List<TestLog> logStream, WebDriver driver, int stepID)
			throws Exception {
		String actionName = "Product Basket: Edit Product Configuration Screen Validation";

		try {

			WebElement productToBeConfigured = driver.findElement(By.xpath("//h1[@title='ECS - Enterprise Voice']"));

			String productToBeConfiguredText = driver.findElement(By.xpath("//h1[@title='ECS - Enterprise Voice']"))
					.getText();

			String productToBeConfiguredValidation = productToBeConfigured.getText().toString();

			if (BrowserActions.isElementPresent(driver, DirSalesEditProductConfiguration.bannerEditProductConfiguration)
					&& BrowserActions.isElementPresent(driver,
							DirSalesEditProductConfiguration.productConfigurationLabel)
					&& productToBeConfigured.isDisplayed()
					&& productToBeConfiguredValidation.contains(productToBeConfiguredText)) {
				System.out.println(actionName + " - Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step: " + stepID, e);
		}
	}

	public static boolean editProductConfigurationECSBC(List<TestLog> logStream, WebDriver driver, int stepID)
			throws Exception {
		String actionName = "Product Basket: Edit Product Configuration Screen Validation";

		try {

			WebElement productToBeConfigured = driver.findElement(By.xpath("//h1[@title='ECS - Business Continuity']"));

			String productToBeConfiguredText = driver.findElement(By.xpath("//h1[@title='ECS - Business Continuity']"))
					.getText();

			String productToBeConfiguredValidation = productToBeConfigured.getText().toString();

			if (BrowserActions.isElementPresent(driver, DirSalesEditProductConfiguration.bannerEditProductConfiguration)
					&& BrowserActions.isElementPresent(driver,
							DirSalesEditProductConfiguration.productConfigurationLabel)
					&& productToBeConfigured.isDisplayed()
					&& productToBeConfiguredValidation.contains(productToBeConfiguredText)) {
				System.out.println(actionName + " - Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step: " + stepID, e);
		}
	}

	public static boolean editProductConfigurationForD03(List<TestLog> logStream, WebDriver driver, int stepID)
			throws Exception {
		String actionName = "Product Basket: Edit Product Configuration Screen Validation";

		String productName = "External Quoted";

		try {
			WebElement productToBeConfigured = driver.findElement(By.xpath("//h1[@title='" + productName + "']"));

			String productToBeConfiguredValidation = productToBeConfigured.getText().toString();

			if (BrowserActions.isElementPresent(driver, DirSalesEditProductConfiguration.bannerEditProductConfiguration)
					&& BrowserActions.isElementPresent(driver,
							DirSalesEditProductConfiguration.productConfigurationLabel)
					&& productToBeConfigured.isDisplayed() && productToBeConfiguredValidation.contains(productName)) {
				System.out.println(actionName + " - Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step: " + stepID, e);
		}
	}

	public static boolean validateAccessTechnologyOptions(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception {
		String actionName = "Edit Product Configuration: Access Techology Options' Validation";

		WebDriverWait wait = new WebDriverWait(driver, 30);

		Actions actions = new Actions(driver);

		List<String> listAccessTechnologies = Arrays.asList("VDSL2", "READSLE", "ADSL2+E", "GPON", "VDSL", "ADSL","ADSLE","ADSL2+TV");

		List<String> tableResultHeader = Arrays.asList("Access Network Type", "Access Technology", "Specification Type",
				"Max Num of Possible Voice Channels");

		Boolean validationNoDuplicates = true;
		String productName = null;

		try {
			
			//In case the product to be configured is phone Line - Part 1
			String xPathPhoneLineName = "//*[text()='Product Configuration']/following-sibling::h1";
			
			if(BrowserActions.isElementPresent(driver, xPathPhoneLineName)==true) {
				productName= driver.findElement(By.xpath(xPathPhoneLineName)).getText().trim();
			}
			
			//End of condition - Part 1 - for Phone Line product
			
			driver.findElement(By
					.xpath("//*[contains(@for,'Installation_Address___OCK_check:accessTechnology_0') or contains(@for,'Installation_Address___OCK_Check:accessTechnology_0')]/parent::td/div"))
					.click();

			
			for (String header : tableResultHeader) {

				validationNoDuplicates = BrowserActions.isElementPresent(driver,
						DirSalesEditProductConfiguration.dropDownListAccessTechologyField + "//div[@title='" + header
								+ "']");

				if (validationNoDuplicates == false) {

					TestLogger.logDebug(logStream,
							"Product Configuration: Validate Access Tenochnology Field No Duplicates Options",
							"The header '" + header + "' is not present in the table's result");
					break;
				} else {
					System.out.println("Header '" + header + "' is present.");
				}
			}

			List<WebElement> tableResutsRows = driver
					.findElements(By.xpath(DirSalesEditProductConfiguration.dropDownListAccessTechologyField
							+ "//li//div[@class='rTableRow']"));

			if (tableResutsRows.size() > 0) {

				for (WebElement row : tableResutsRows) {
					
					if (row != tableResutsRows.get(0)) {

						String accessTechnologyOption = row.getText();

						System.out.println("Acess Technology on row " + tableResutsRows.indexOf(row) + ": "
								+ accessTechnologyOption);
						
						//In case the product to be configured is phone Line - Part 2
						if (productName.contentEquals("Phone Line")==true && accessTechnologyOption.contains("COPPER xDSL VOICEGRADE")==false) {
							
							TestLogger.logDebug(logStream,
									"Product Configuration: Validate Access Tenochnology Field Options",
									productName+ " - OCK Check - Invalid entry found: \n\s" + "Access Technology on row " + tableResutsRows.indexOf(row) + ": "
											+ accessTechnologyOption);
							
							validationNoDuplicates = false;

						}else if(productName.contentEquals("Phone Line")==true && accessTechnologyOption.contains("COPPER xDSL VOICEGRADE")==true) {
							TestLogger.logDebug(logStream,
									"Product Configuration: Validate Access Tenochnology Field Options",
									"Phone Line - OCK Check - Valid entry found on row " + tableResutsRows.indexOf(row)) ;
						}
						
						// End of condition - Part 2 - for Phone Line product
					}
				}
			}else {
				validationNoDuplicates = false;
			}


			if (validationNoDuplicates) {
				System.out.println(actionName + " - Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step: " + stepID, e);
		}
	}

}
