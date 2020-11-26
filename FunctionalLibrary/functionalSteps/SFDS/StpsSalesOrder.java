package functionalSteps.SFDS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.FunctionalActionsSFDS;
import execStructure.TestDataManagement;
import executionTools.BrowserActions;
import executionTools.ExecStructure;
import functionalActions.SFDS.ActsSalesOrder;
import functionalActions.SFDS.ActsSalesService;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceService;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;

public class StpsSalesOrder {
	
	
	// 14-03-2020: Example/Template for steps
				/*
				public static TestStepReportStructure step(WebDriver driver, int stepID, String testName) throws Exception
				{
					TestStepReportStructure step;


					String stepName="step";

					String stepNameMin="step";

					String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


					boolean validation;

					try
					{
						<FUNCTIONAL STEPS>
						
						<FUNCTIONAL STEPS>
						
						<FUNCTIONAL STEPS>

						validation = <FUNCTIONAL STEP FOR VALIDATION>

						if(validation==true)
						{
							ExecStructure.screenShotTaking(driver, testName, evidenceName);
							step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
							return step;
						}
						else
						{
							throw new Exception (stepName+" - Failed in Step: "+stepID);
						}


					}
					catch(Exception e)
					{
						System.out.println(e);
						ExecStructure.screenShotTaking(driver, testName, evidenceName);
						step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
						return step;
					}

				}

			*/
	
	

	// Navigation Steps
	public static TestStepReportStructure nav2Service(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure nav2Service;


		String stepName="Order: Navigate to Service Page";

		String stepNameMin="nav2Service";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		boolean validation;

		try
		{
			ActsSalesOrder.navigateToSingleService(driver, wait, stepID);
			
			ActsSalesService.goToServiceDetails(driver, wait, stepID);
			

			validation = ActsSalesService.validationServicePage(driver, stepID);

			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				nav2Service=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return nav2Service;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			nav2Service=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return nav2Service;
		}
	}


	//Operational Steps
	public static TestStepReportStructure newContractFlow(WebDriver driver, WebDriverWait wait, String testName, int stepID, String companyContactPerson) throws Exception
	{
		TestStepReportStructure step;


		String stepName="New Contract Flow: Service addiction";

		String stepNameMin="newContractFlow";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		try
		{
			FunctionalActionsSFDS.addService2Order(driver, stepID, testName, companyContactPerson);

			String servicelinkXpath=SalesForceOrders.serviceContainer.concat("//a[starts-with(.,'Mobile')]");

			if(BrowserActions.isElementPresent(driver, servicelinkXpath))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return step;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return step;
		}
	}

	public static TestStepReportStructure submitOrder(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure submitOrder;


		String stepName="Submitting the Order";

		String stepNameMin="submitOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);


		try
		{
			driver.findElement(By.xpath(SalesForceOrders.submitOrderButton)).click();


			if(BrowserActions.isElementPresent(driver, SalesForceOrders.orderSubmittedSuccess))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				submitOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
				return submitOrder;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			submitOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);;
			return submitOrder;
		}
	}

	



	// SOI-80

	public static TestStepReportStructure navigate2OrdersList(WebDriver driver, int stepID, String testName) throws Exception
	{

		String ordersListURL = TestDataManagement.searchDT(0, "environmentITTQA").concat(TestDataManagement.searchDT(0, "ordersList"));

		try
		{

			driver.get(ordersListURL);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesForceOrders.ordersSearchBar))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2OrdersList");
				TestStepReportStructure nav2OrderList = new TestStepReportStructure(stepID, "Navigation to Orders List", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2OrdersList");
				return nav2OrderList;
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
			TestStepReportStructure nav2OrderList = new TestStepReportStructure(stepID, "Navigation to Orders List", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2OrdersList");
			return nav2OrderList;
		}


	}

	public static TestStepReportStructure navigate2MyOrders(WebDriver driver, int stepID, String testName) throws Exception
	{		

		try
		{

			driver.get(TestDataManagement.myOrdersURL);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesForceOrders.validateMyOrders))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOders");
				TestStepReportStructure nav2MyOrders = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOders");
				return nav2MyOrders;
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
			TestStepReportStructure nav2MyOrders = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOrders");
			return nav2MyOrders;
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
				TestStepReportStructure nav2SelFields = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
				return nav2SelFields;
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
			TestStepReportStructure nav2SelFields = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
			return nav2SelFields;
		}


	}

	public static TestStepReportStructure add3fields(WebDriver driver, int stepID, String testName, WebDriverWait wait) throws Exception
	{

		int counter=0;
		int counterVal;
		int initialheaderTableColumnsOrder;

		List<String> optionsSelected=new ArrayList<String>();	

		List<String> originalOptionsSelected=new ArrayList<String>();


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

				counterVal=initialheaderTableColumnsOrder+counter;

				if(headerTableColumnsOrderVal == counterVal)
				{
					ExecStructure.screenShotTaking(driver, testName, stepID+"_add3fields");
					TestStepReportStructure add3fields = new TestStepReportStructure(stepID, "Add 3 Fields", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_add3fields");
					return add3fields;
				}
				else
				{
					throw new Exception("Validation Failed on Step: "+stepID+" - Add 3 Fields");
				}
			}
			else
			{
				throw new Exception("Test Procedure Failed on Step: "+stepID+" - Add 3 Fields");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_add3fields");
			TestStepReportStructure add3fields = new TestStepReportStructure(stepID, "Add 3 Fields", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_add3fields");
			return add3fields;
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

				counterVal=initialheaderTableColumnsOrder-counter;

				if(headerTableColumnsOrderVal == counterVal)
				{
					ExecStructure.screenShotTaking(driver, testName, stepID+"_Remove3fields");
					TestStepReportStructure remove3fields = new TestStepReportStructure(stepID, "Remove 3 Fields", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Remove3fields");
					return remove3fields;
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
			TestStepReportStructure remove3fields = new TestStepReportStructure(stepID, "Remove 3 Fields", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Remove3fields");
			return remove3fields;
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
					TestStepReportStructure moveField = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
					return moveField;
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
			TestStepReportStructure moveField = new TestStepReportStructure(stepID, "Move Field", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
			return moveField;
		}


	}

	public static TestStepReportStructure navigate2AllOrders(WebDriver driver, int stepID, String testName) throws Exception
	{

		try
		{

			//driver.findElement(By.xpath(SalesForceOrders.ordersListView)).click();

			driver.get(TestDataManagement.allOrdersURL);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			//driver.findElement(By.xpath(SalesForceOrders.allOrdersOption)).click();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesForceOrders.validateAllOrders))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOders");
				TestStepReportStructure nav2AllOrders = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOders");
				return nav2AllOrders;
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
			TestStepReportStructure nav2AllOrders = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOrders");
			return nav2AllOrders;
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
				TestStepReportStructure nav2SelOrder = new TestStepReportStructure(stepID, "Navigation to an order", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2SelectOrder");
				return nav2SelOrder;
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
			TestStepReportStructure nav2SelOrder = new TestStepReportStructure(stepID, "Navigation to an order", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2SelectOrder");
			return nav2SelOrder;
		}


	}




	
	// SOI-721
	
	public static TestStepReportStructure go2OrderListView(WebDriver driver, WebDriverWait wait, String testName, int stepID) throws Exception
	{
		TestStepReportStructure step;
		
		String stepName="Go To Order List View";
		String stepNameMin="go2OrderListView";
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		boolean validation;
		
		try
		{
			ActsSalesOrder.nav2OrdersListView(driver, stepID);
			
			validation=ActsSalesOrder.orderListViewPageValidation(driver, wait, stepID);
			
			if (validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return step;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return step;
		}
	}

	public static TestStepReportStructure search4MACDOrders(WebDriver driver, WebDriverWait wait, String testName, int stepID) throws Exception
	{
		TestStepReportStructure step;
		
		String stepName="Search for MACD Orders";
		String stepNameMin="search4MACDOrders";
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		String inputvalue="MACD";
		
		try
		{
			ActsSalesOrder.changeOrdersListFilter(driver, wait, stepID, "All Orders");
			
			ActsSalesOrder.searchOrdersList(driver, wait, stepID, inputvalue);
			
			String tableText=driver.findElement(By.xpath(SalesForceOrders.ordersTable)).getText(); 
			
			if (tableText.contains(inputvalue))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return step;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return step;
		}
	}

	public static TestStepReportStructure navigateToFirstMACDOrder(WebDriver driver, WebDriverWait wait, String testName, int stepID) throws Exception
	{
		TestStepReportStructure navigateToFirstMACDOrder;
		String stepName="Navigate to the first MACD Order on the Table";
		String stepNameMin="navigateToFirstMACDOrder";
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		try
		{
			driver.findElement(By.xpath(SalesForceOrders.firstOrderNameLink)).click();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			boolean validation=ActsSalesOrder.orderPageValidation(driver, stepID);
			
			if(validation)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigateToFirstMACDOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return navigateToFirstMACDOrder;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			navigateToFirstMACDOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return navigateToFirstMACDOrder;
		}
	}

	public static TestStepReportStructure orderValidationSOI721(WebDriver driver, WebDriverWait wait, String testName, int stepID) throws Exception
	{
		TestStepReportStructure step;
		
		String stepName="Order Validation according with SOI-721";
		String stepNameMin="orderValidationSOI721";
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.orderTypeLabel) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderTypeMACD))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return step;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return step;
		}
	}

	

}	


/*
TestStepReportStructure step;


String stepName="Agreement: Navigate to Opportunity";

String stepNameMin="navigate2Opportunity";

String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

try
{

	if()
	{
		ExecStructure.screenShotTaking(driver, testName, evidenceName);
		step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
		return step;
	}
	else
	{
		throw new Exception (stepName+" - Failed in Step: "+stepID);
	}
}
catch(Exception e)
{
	System.out.println(e);
	ExecStructure.screenShotTaking(driver, testName, evidenceName);
	step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
	return step;
}
 */