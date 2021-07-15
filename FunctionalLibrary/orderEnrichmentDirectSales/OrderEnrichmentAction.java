package orderEnrichmentDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesOrderEnrichment;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OrderEnrichmentAction 
{
	// Operational Actions

	public static void changeToOrderEnrichmentiFrame(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,30);

		String actionName="Product Basket: Change to Product Basket iframe";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesOrderEnrichment.iframeOrderEnrichment)));

			WebElement iframeOrderEnrichment = driver.findElement(By.xpath(DirSalesOrderEnrichment.iframeOrderEnrichment));

			driver.switchTo().frame(iframeOrderEnrichment);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOrderEnrichment.headerOrderEnrichment)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void selectProductForOEConfig(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="selectProductForOEConfig";


		try
		{
			if(productName == "Enterprise Voice") {driver.findElement(By.xpath("//*[starts-with(text(),'"+productName+"')]")).click();}

			else if (productName == "Professional Internet") {driver.findElement(By.xpath("//*[starts-with(text(),'"+productName+"')]")).click();} 

			else {driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();}

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"specificationsApp\"]/div[2]/div[2]/article/div[2]/iframe")));

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesOrderEnrichment.tabsList)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}




	// Validation Actions
	public static boolean tabsforOEValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="tabsforOEValidation";

		int errorCounter=1;

		boolean validation = false;

		try
		{

			List<WebElement> oeTabsList=driver.findElements(By.xpath(DirSalesOrderEnrichment.tabInTheList));

			for(WebElement oetab:oeTabsList)
			{
				//if (oetab.getText().toLowerCase().contains("contact"))
				if (oetab.isDisplayed())
				{
					System.out.println(oetab.getText());

					if(oetab.getText().contains("CONTACTS")) {

						driver.findElement(By.xpath("//li[@title='Contacts']//a[1]")).click();
						Thread.sleep(5000);
						validation=true;	
					}
					else {validation=true;}

				}
			}

			if(validation == true)
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

	public static void fillDataCapFormEV(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName, String dataCapValue) throws Exception 
	{
		String actionName="fillDataCapFormEV";


		try
		{
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesOrderEnrichment.tabsList)));

			driver.findElement(By.xpath("//li[@title='Data Capture Form']//a[1]")).click();
			
			driver.switchTo().frame(0);
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"addRowBtn\"]")));

			driver.findElement(By.xpath("//*[@id=\"addRowBtn\"]")).click();

			driver.findElement(By.xpath("//*[@id=\"tableBody\"]/tr/td[2]/div/input")).sendKeys(dataCapValue);

			driver.findElement(By.xpath("//*[@id=\"saveBtnMultiple\"]")).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}
	
	public static boolean dataCaptureValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName, String dataCapValue) throws Exception 
	{
		String actionName="fillDataCapFormEV";


		try
		{

			String dataCap = driver.findElement(By.xpath("//*[@id=\"tableBody\"]/tr/td[2]/div/input")).getAttribute("value");
			
		if(dataCap.contains(dataCapValue)) {

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
			return true;
		}
		else {
			return false;
		}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void fillContactEV(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName, String contact) throws Exception 
	{
		String actionName="fillContactEV";


		try
		{
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesOrderEnrichment.tabsList)));

			driver.findElement(By.xpath("//li[@title='Contacts']//a[1]")).click();
			
			driver.switchTo().frame(0);
			
			driver.findElement(By.xpath("//*[@id=\"s2id_Primary:General_Information:Person_0\"]/a")).click();
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"s2id_autogen1_search\"]")));

			driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]")).sendKeys(contact);
			
			Thread.sleep(5000);

			driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li")).click();
			
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}
	
	public static boolean contactValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName, String contact) throws Exception 
	{
		String actionName="fillDataCapFormEV";


		try
		{
			//new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesOrderEnrichment.tabsList)));

			//driver.findElement(By.xpath("//li[@title='Contacts']//a[1]")).click();

			//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"specificationsApp\"]/div[2]/div[2]/article/div[2]/iframe")));

			String contactFilled = driver.findElement(By.xpath("//*[@id=\"select2-chosen-1\"]")).getText();
			
			System.out.println(contactFilled);
			
		if(contactFilled.contains(contact)) {

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
			return true;
		}
		else {
			return false;
		}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

}
