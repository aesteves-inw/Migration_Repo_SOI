package functionalSteps.SFPC;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import sfDirectSales.SalesForceOrders;
import sfPartnersCommunity.SFPC_Orders;

public class OrderSFPC {
	
	//FUNCTIONAL STEPS CLASS FOR ORDER IN SALESFORCE PARTNERS COMMUNITY
	
	public static TestStepReportStructure orderValidationSOI721(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure orderValidationSOI721;
		
		String stepName="Order Validation according with SOI-721";
		
		String stepNameMin="orderValidationSOI721";
		
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		try
		{
			if(BrowserActions.isElementPresent(driver, SFPC_Orders.orderTypeLabel) && BrowserActions.isElementPresent(driver, SFPC_Orders.orderTypeMACD))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				orderValidationSOI721=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return orderValidationSOI721;
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
			orderValidationSOI721=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return orderValidationSOI721;
		}
	}

	public static TestStepReportStructure nav2AllOrdersListView(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure step;
		
		String stepName="Navigate to 'All Orders' List View Page";
		
		String stepNameMin="nav2AllOrdersListView";
		
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		String url="https://prxittqa-proximus.cs82.force.com/SalesforceforPartners/s/order/csord__Order__c/00B3E000002XCLdUAO?csord__Order__c-filterId=00B58000004rXxlEAE";
		
		try
		{
			driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SFPC_Orders.ordersTable) && BrowserActions.isElementPresent(driver, SFPC_Orders.macdOrders) && BrowserActions.isElementPresent(driver, SFPC_Orders.inputSearchOrders) && BrowserActions.isElementPresent(driver, SFPC_Orders.displayAsTableBtn) && BrowserActions.isElementPresent(driver, SFPC_Orders.listViewControlsBtn) && BrowserActions.isElementPresent(driver, SFPC_Orders.selectListViewButton) && BrowserActions.isElementPresent(driver, SFPC_Orders.ordersFilterLabel))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				step= new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
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
		TestStepReportStructure search4MACDOrders;
		
		
		String stepName="Search for MACD Orders";
		
		String stepNameMin="search4MACDOrders";
		
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		String inputSearchValue="MACD";
		
		try
		{
			driver.findElement(By.xpath(SFPC_Orders.inputSearchOrders)).clear();
			
			driver.findElement(By.xpath(SFPC_Orders.inputSearchOrders)).sendKeys(inputSearchValue);
			
			driver.findElement(By.xpath(SFPC_Orders.inputSearchOrders)).sendKeys(Keys.ENTER);
			
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(SFPC_Orders.ordersTable), inputSearchValue));
			
			String tableVal=driver.findElement(By.xpath(SFPC_Orders.ordersTable)).getText();
			
			if(tableVal.contains(inputSearchValue))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				search4MACDOrders= new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return search4MACDOrders;
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
			search4MACDOrders=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return search4MACDOrders;
		}
	}

	public static TestStepReportStructure nav2FirstMACDOrder(WebDriver driver, WebDriverWait wait, String testName, int stepID) throws Exception
	{
		TestStepReportStructure nav2FirstMACDOrder;
		
		
		String stepName="Navigate to the First MACD Order of the table";
		
		String stepNameMin="nav2FirstMACDOrder";
		
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		try
		{
		
		List<WebElement> macdListedOrders=driver.findElements(By.xpath(SFPC_Orders.macdOrders));
		
		macdListedOrders.get(0).click();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
			if(BrowserActions.isElementPresent(driver, SFPC_Orders.orderTypeLabel) && BrowserActions.isElementPresent(driver, SFPC_Orders.orderTypeMACD) && BrowserActions.isElementPresent(driver, SalesForceOrders.servicesContainer) && BrowserActions.isElementPresent(driver, SFPC_Orders.orderDetails) && BrowserActions.isElementPresent(driver, SFPC_Orders.headerOrderDetail))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				nav2FirstMACDOrder= new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return nav2FirstMACDOrder;
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
			nav2FirstMACDOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return nav2FirstMACDOrder;
		}
		
	}


	

}


/*
		TestStepReportStructure <stepNameMin>;
		
		
		String stepName="Login in Partners Community";
		
		String stepNameMin="loginSFPC";
		
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
*/