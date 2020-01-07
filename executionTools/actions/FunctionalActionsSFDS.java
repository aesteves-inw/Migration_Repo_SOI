package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceProducts;

public class FunctionalActionsSFDS {
	
	
	
	public static void createNewStandardOpportunity(WebDriver driver) throws Exception
	{
		WebDriverWait waitNSOS = new WebDriverWait(driver, 10);
		
		try
		{			
			driver.findElement(By.xpath(SalesForceCompany.rmOpportunitieslink)).click();
			
			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceCompany.newOpportunityButton))).click();
			
			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.newOpportunityHeader)));
		}
		catch(Exception e)
		{
			throw new Exception ("Navigation failed to New Opportunity Screen",e);
		}
	}
	
	public static void inputOpportunityValues(WebDriver driver, String testExecutionString) throws Exception
	{
		WebDriverWait waitNSOS = new WebDriverWait(driver, 10);
		
		String optyName="OPTY_"+testExecutionString;
		
		String optyStage=TestData.searchDT(2, "optyStage");
		
		String optyForecastCategory=TestData.searchDT(2, "optyForecastCategory");
		
		try
		{
			driver.findElement(By.xpath(SalesForceOpportunity.inputOpportunityName)).clear();
			
			driver.findElement(By.xpath(SalesForceOpportunity.inputOpportunityName)).sendKeys(optyName);
			
			driver.findElement(By.xpath(SalesForceOpportunity.inputCloseDate)).clear();
			
			driver.findElement(By.xpath(SalesForceOpportunity.inputCloseDate)).sendKeys(ExecStructure.formattedDate("dd/MM/yyyy"));
			
			driver.findElement(By.xpath(SalesForceOpportunity.selectStage)).click();
			
			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyStage+"']"))).click();
			
			driver.findElement(By.xpath(SalesForceOpportunity.selectForecastCategory)).click();
			
			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyForecastCategory+"']"))).click();
						
			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		}
		catch(Exception e)
		{
			throw new Exception ("Input on Opportunity Screen Failed",e);
		}
	}

	public static void addProductToOppie(WebDriver driver, String product) throws Exception
	{
		WebDriverWait waitAp2o = new WebDriverWait(driver, 10);
		
		String product2Add = TestData.searchDT(2,product);
		
		try
		{
			driver.findElement(By.xpath(SalesForceProducts.inputSearchProducts)).clear();
			
			driver.findElement(By.xpath(SalesForceProducts.inputSearchProducts)).sendKeys(product2Add);
			
			waitAp2o.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='"+product2Add+"']"))).click();
			
			driver.findElement(By.xpath(SalesForceProducts.nextButtonScreen)).click();
			
			waitAp2o.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceProducts.editProductHeader)));
			
		}
		catch(Exception e)
		{
			throw new Exception ("Add Product To Opportunity Failed",e);
		}
	}

	public static void editProductConfiguration(WebDriver driver, int tcNumber) throws Exception
	{
		String[] config2Apply=TestData.prodConfiguration(tcNumber);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		try
		{

			driver.findElement(By.xpath(SalesForceProducts.totalContractValue)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceProducts.inputContractValue))).sendKeys(config2Apply[0]);
			
			driver.findElement(By.xpath(SalesForceProducts.contractDuration)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceProducts.inputContratDuration))).sendKeys(config2Apply[1]);
			
			driver.findElement(By.xpath(SalesForceProducts.revenueType)).click();
			driver.findElement(By.xpath(SalesForceProducts.revenueType)).click();
			driver.findElement(By.linkText(config2Apply[2])).click();
			
			BrowserActions.ScrollByPixs(driver, 100, 0);
			
			driver.findElement(By.xpath(SalesForceProducts.productRegimeType)).click();
			driver.findElement(By.xpath(SalesForceProducts.productRegimeType2)).click();
			driver.findElement(By.linkText(config2Apply[3])).click();
			
			driver.findElement(By.xpath(SalesForceProducts.saveButtonEdit)).click();
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceProducts.editProductHeader)));
						
		}
		catch(Exception e)
		{
			throw new Exception ("Edit Product Configuration Failed",e);
		}
	}

	public static void closeWonOppie(WebDriver driver) throws Exception
	{
		WebDriverWait waitCWO = new WebDriverWait(driver, 10);
		
		try
		{
			
			driver.findElement(By.xpath(SalesForceOpportunity.closeOPTYHeaderButton)).click();
			
			driver.findElement(By.xpath(SalesForceOpportunity.selectCloseMenu)).click();
			
			waitCWO.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.ctomHeader)));
			
			Select closedStage = new Select(driver.findElement(By.xpath("//select")));
			
			closedStage.selectByVisibleText("Closed Won");
			
			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();
			
			waitCWO.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceOpportunity.ctomHeader)));
			
			driver.navigate().refresh();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		}
		catch(Exception e)
		{
			throw new Exception ("Closing Won Opportunity - Failed",e);
		}
	}
	
	public static void addFile2Agreement(WebDriver driver, String testExecutionString)
	{
		
	}

}



