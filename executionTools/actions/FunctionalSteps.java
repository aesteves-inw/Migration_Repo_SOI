package actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import execReport.TestReportTestData;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceHomePage;
import sfDirectSales.SalesForceNewMACDOrderScreen;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceProducts;
import actions.BrowserActions;

public class FunctionalSteps {

	// Salesforce Direct Sales
	public static TestStepReportStructure loginSalesForce(WebDriver driver, int stepID, String sFEnvironment, String testName) throws Exception
	{
		String loginUserName;
		String loginPassWord;

		try
		{
			if(sFEnvironment == "DS")
			{
				loginUserName = TestData.searchDT(0, "envUserNameITTQA");
				loginPassWord=TestData.searchDT(0, "envPasswordITTQA");
			}
			else if (sFEnvironment == "PC")
			{
				loginUserName = TestData.searchDT(1, "envUserNameITTQA");
				loginPassWord=TestData.searchDT(1, "envPasswordITTQA");
			}
			else
			{
				throw new Exception("Test Failed on Step"+stepID);
			}

			WebElement usernameBox = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.userName));
			WebElement passwordBox = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.passWord));
			WebElement loginBtn = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.loginbtn));

			if (usernameBox.isDisplayed() == true && passwordBox.isDisplayed() == true && loginBtn.isDisplayed() == true) {
				usernameBox.sendKeys(loginUserName);
				passwordBox.sendKeys(loginPassWord);
				loginBtn.click();
			} 
			else
			{
				throw new Exception("Test Failed on Step"+stepID);
			}

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if (BrowserActions.isElementPresent(driver, SalesForceHomePage.header) && BrowserActions.isElementPresent(driver, SalesForceHomePage.headerIcons)) 
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_LoginScreen");
				TestStepReportStructure loginStep = new TestStepReportStructure(stepID, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_LoginScreen");
				return loginStep;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_LoginScreen");
			TestStepReportStructure loginStep = new TestStepReportStructure(stepID, "Login into Salesforce", "Login with success", "Not possible to validate Login Page", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_LoginScreen");
			return loginStep;
		}
	}

	public static TestStepReportStructure navigate2CompanyDetails(WebDriver driver, int stepID, String testName) throws Exception
	{

		String companyURL = TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "accountView")).concat(TestData.tdCompanyID(testName)).concat("/view");

		try
		{

			driver.get(companyURL);

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if (BrowserActions.isElementPresent(driver, SalesForceCompany.followBtn) && BrowserActions.isElementPresent(driver, SalesForceCompany.quickSaleOPTYBtn) && BrowserActions.isElementPresent(driver, SalesForceCompany.companyDetailsHeader) && BrowserActions.isElementPresent(driver, SalesForceCompany.companyDetailsInfo))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2CompDetails");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Company Details", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2CompDetails");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to Company Details");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2CompDetails");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Company Details", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2CompDetails");
			return nav2ComDet;
		}


	}

	public static TestStepReportStructure createStandardOppie(WebDriver driver, int stepID, String testName, String testExecutionString) throws Exception
	{
		try
		{
			FunctionalActionsSFDS.createNewStandardOpportunity(driver);

			FunctionalActionsSFDS.inputOpportunityValues(driver, testExecutionString, testName);

			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesForceProducts.inputSearchProducts) && BrowserActions.isElementPresent(driver, SalesForceProducts.productsTable))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_CreateNewOppie");
				TestStepReportStructure newOppie = new TestStepReportStructure(stepID, "Create new Opportunity", "Opportunity created with success", "Created with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_CreateNewOppie");
				return newOppie;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Create New Opportunity");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_CreateNewOppie");
			TestStepReportStructure newOppie = new TestStepReportStructure(stepID, "Create new Opportunity", "Opportunity created with success", "Not possible to create Opportunity", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_CreateNewOppie");
			return newOppie;
		}
	}

	public static TestStepReportStructure createNewMACDOrder(WebDriver driver, int stepID, String testName, String testExecutionString) throws IOException
	{
		WebDriverWait waitNewMACDOrder = new WebDriverWait(driver, 10);

		String orderName="Order_"+testExecutionString;

		String newOrderCreated="//*[contains(.,'"+orderName+"')]";

		try
		{
			driver.findElement(By.xpath(SalesForceCompany.newMACDOrderButton)).click();

			waitNewMACDOrder.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceNewMACDOrderScreen.headerNewMACDOrder)));

			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).clear();

			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).sendKeys(orderName);

			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.nmoSaveButton)).click();

			waitNewMACDOrder.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(orderName))).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if (BrowserActions.isElementPresent(driver, newOrderCreated))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_NewMACDOrder");
				TestStepReportStructure newMACDOrder = new TestStepReportStructure(stepID, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_NewMACDOrder");
				return newMACDOrder;
			}
			else
			{
				throw new Exception("Validation Failed on Step: "+stepID);

			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_NewMACDOrder");
			TestStepReportStructure newMACDOrder = new TestStepReportStructure(stepID, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_NewMACDOrder");
			return newMACDOrder;
		}
	}

	public static TestStepReportStructure createCloseStandardMobileVoiceOppie(WebDriver driver, int stepID, String testName, String testExecutionString) throws Exception
	{
		try
		{
			FunctionalActionsSFDS.createNewStandardOpportunity(driver);

			FunctionalActionsSFDS.inputOpportunityValues(driver, testExecutionString, testName);

			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			FunctionalActionsSFDS.addProductToOppie(driver, "mobileVoice");

			FunctionalActionsSFDS.editProductConfiguration(driver, 1);

			FunctionalActionsSFDS.closeWonOppie(driver);

			if (BrowserActions.isElementPresent(driver, SalesForceOpportunity.stageClosedWonDetails))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_ClosedWonOppieValidation");
				TestStepReportStructure createCloseStandardMobileVoiceOppie = new TestStepReportStructure(stepID, "Close Won Opportunity Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_ClosedWonOppieValidation");
				return createCloseStandardMobileVoiceOppie;
			}
			else
			{
				throw new Exception("Validation Failed on Step 05");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_ClosedWonOppieValidation");
			TestStepReportStructure createCloseStandardMobileVoiceOppie = new TestStepReportStructure(stepID, "Close Won Opportunity Validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_ClosedWonOppieValidation");
			return createCloseStandardMobileVoiceOppie;
		}
	}

	// Salesforce Partners Community



	// SOI-80

	public static TestStepReportStructure navigate2OrdersList(WebDriver driver, int stepID, String testName) throws Exception
	{

		String ordersListURL = TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "ordersList"));

		try
		{

			driver.get(ordersListURL);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesForceOrders.ordersSearchBar))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2OrdersList");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Orders List", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2OrdersList");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to Orders List");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2OrdersList");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Orders List", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2OrdersList");
			return nav2ComDet;
		}


	}

	public static TestStepReportStructure navigate2MyOrders(WebDriver driver, int stepID, String testName) throws Exception
	{		

		try
		{

			/*driver.findElement(By.xpath(SalesForceOrders.ordersListView)).click();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.findElement(By.xpath(SalesForceOrders.myOrdersOption)).click();*/

			driver.get(TestData.myOrdersURL);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesForceOrders.validateMyOrders))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOders");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOders");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to My Orders");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOrders");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOrders");
			return nav2ComDet;
		}


	}

	public static TestStepReportStructure navigate2SelectFields(WebDriver driver, int stepID, String testName) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try
		{
			driver.findElement(By.xpath(SalesForceOrders.listViewControlsBtn)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOrders.listControlsList)));

			driver.findElement(By.xpath(SalesForceOrders.selectFieldsListOption)).click();

			if(BrowserActions.isElementPresent(driver, SalesForceOrders.validateSelectDisplay))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_navigate2SelectFields");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to Select Fields to Display");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_navigate2SelectFields");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
			return nav2ComDet;
		}


	}

	public static TestStepReportStructure add3fields(WebDriver driver, int stepID, String testName, WebDriverWait wait) throws Exception
	{

		int counter=0;
		int counterVal;

		List<String> optionsSelected=new ArrayList<String>();	

		List<String> originalOptionsSelected=new ArrayList<String>();

		int initialheaderTableColumnsOrder;

		try
		{
			//First Validation Part
			List<WebElement> headerTableColumnsOrder= driver.findElements(By.xpath(SalesForceOrders.headerTableColumnsOrder));

			initialheaderTableColumnsOrder=headerTableColumnsOrder.size();

			for(WebElement hTCO : headerTableColumnsOrder)
			{
				String optionVisible=hTCO.getText();
				originalOptionsSelected.add(optionVisible);
			}

			//Action on Step
			List<WebElement> availableFields= driver.findElements(By.xpath(SalesForceOrders.availableFieldsOptions));

			for(WebElement aF: availableFields)
			{

				String optionSelected=aF.getText();
				optionsSelected.add(optionSelected);
				aF.click();
				driver.findElement(By.xpath(SalesForceOrders.move2VisibleFields)).click();
				counter++;
				if (counter == 3)
				{
					break;
				}
			}

			driver.findElement(By.xpath(SalesForceOrders.selectFieldsSaveBtn)).click();

			//Final Validation
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.successMessage))
			{
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceOrders.successMessage)));

				int headerTableColumnsOrderVal= driver.findElements(By.xpath(SalesForceOrders.headerTableColumnsOrder)).size();

				counterVal=initialheaderTableColumnsOrder+3;

				if(headerTableColumnsOrderVal == counterVal)
				{
					ExecStructure.screenShotTaking(driver, testName, stepID+"_add3fields");
					TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Add 3 Fields", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_add3fields");
					return nav2ComDet;
				}
				else
				{
					throw new Exception("Validation Failed on Step: "+stepID+" - Add 3 Fields");
				}
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Add 3 Fields");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_add3fields");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Add 3 Fields", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_add3fields");
			return nav2ComDet;
		}


	}

	public static TestStepReportStructure remove3fields(WebDriver driver, int stepID, String testName, WebDriverWait wait) throws Exception
	{
		int counter=0;
		int counterVal;

		List<String> optionsSelected=new ArrayList<String>();	

		List<String> originalOptionsSelected=new ArrayList<String>();

		int initialheaderTableColumnsOrder;

		Actions action = new Actions(driver);

		try
		{
			//First Validation Part
			List<WebElement> headerTableColumnsOrder= driver.findElements(By.xpath(SalesForceOrders.headerTableColumnsOrder));

			initialheaderTableColumnsOrder=headerTableColumnsOrder.size();

			for(WebElement hTCO : headerTableColumnsOrder)
			{
				String optionVisible=hTCO.getText();
				originalOptionsSelected.add(optionVisible);
			}

			
			//Action on Step

			int visiblefieldsOptionsCtr;

			for(int i=0;i<6;i++)
			{
				List<WebElement> visiblefieldsOptions= driver.findElements(By.xpath(SalesForceOrders.visiblefieldsOptions));

				visiblefieldsOptionsCtr=visiblefieldsOptions.size();

				int visiblefieldsOptionsIDX=visiblefieldsOptionsCtr-1;

				WebElement lastFTList= driver.findElement(By.xpath("//lightning-dual-listbox/div/div[2]/div/div[5]/div/ul/li/div[@data-index="+visiblefieldsOptionsIDX+"]"));

				action.moveToElement(lastFTList).perform();

				String optionSelected=lastFTList.getText();
				optionsSelected.add(optionSelected);

				lastFTList.click();

				driver.findElement(By.xpath(SalesForceOrders.move2AvailableFields)).click();

				counter++;

				if (counter == 3)
				{
					break;
				}
			}

			driver.findElement(By.xpath(SalesForceOrders.selectFieldsSaveBtn)).click();

			//Final Validation
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.successMessage))
			{
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceOrders.successMessage)));

				int headerTableColumnsOrderVal= driver.findElements(By.xpath(SalesForceOrders.headerTableColumnsOrder)).size();

				counterVal=initialheaderTableColumnsOrder-3;

				if(headerTableColumnsOrderVal == counterVal)
				{
					ExecStructure.screenShotTaking(driver, testName, stepID+"_Remove3fields");
					TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Remove 3 Fields", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Remove3fields");
					return nav2ComDet;
				}
				else
				{
					throw new Exception("Validation Failed on Step: "+stepID+" - Remove 3 Fields");
				}
			}
			else
			{
				throw new Exception("Test Procedure Failed on Step: "+stepID+" - Remove 3 Fields");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Remove3fields");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Remove 3 Fields", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Remove3fields");
			return nav2ComDet;
		}

	}

	public static TestStepReportStructure moveField(WebDriver driver, int stepID, String testName) throws Exception
	{

		try
		{
			List<WebElement> headerTableColumnsOrder= driver.findElements(By.xpath(SalesForceOrders.headerTableColumnsOrder));

			driver.findElement(By.xpath(SalesForceOrders.secondVisiblefieldOption)).click();

			driver.findElement(By.xpath(SalesForceOrders.moveSelectionUp)).click();

			driver.findElement(By.xpath(SalesForceOrders.selectFieldsSaveBtn)).click();

			if(BrowserActions.isElementPresent(driver, SalesForceOrders.successMessage))
			{
				List<WebElement> headerTableColumnsOrderVal= driver.findElements(By.xpath(SalesForceOrders.headerTableColumnsOrder));

				if(headerTableColumnsOrder != headerTableColumnsOrderVal)
				{
					ExecStructure.screenShotTaking(driver, testName, stepID+"_navigate2SelectFields");
					TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
					return nav2ComDet;
				}
				else
				{
					throw new Exception("Validation Failed on Step: "+stepID+" - Navigation to Select Fields to Display");
				}
			}
			else
			{
				throw new Exception("Test Procedure Failed on Step: "+stepID+" - Navigation to Select Fields to Display");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_navigate2SelectFields");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Move Field", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
			return nav2ComDet;
		}


	}

	public static TestStepReportStructure navigate2AllOrders(WebDriver driver, int stepID, String testName) throws Exception
	{

		try
		{

			//driver.findElement(By.xpath(SalesForceOrders.ordersListView)).click();

			driver.get(TestData.allOrdersURL);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			//driver.findElement(By.xpath(SalesForceOrders.allOrdersOption)).click();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesForceOrders.validateAllOrders))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOders");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOders");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to My Orders");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOrders");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOrders");
			return nav2ComDet;
		}


	}

	public static TestStepReportStructure navigate2SelectOrder(WebDriver driver, int stepID, String testName, String orderSelect) throws Exception
	{



		try
		{

			driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr["+orderSelect+"]/th[1]/span[1]/a[1]")).click();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesForceOrders.addServiceButton) && BrowserActions.isElementPresent(driver, SalesForceOrders.submitOrderButton))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2SelectOrder");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to an order", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2SelectOrder");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to an order");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2SelectOrder");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to an order", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2SelectOrder");
			return nav2ComDet;
		}


	}


}
