package functionalActions.SFPC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceOpportunity;
import sfPartnersCommunity.SFPC_Opportunity;
import sfPartnersCommunity.SFPC_Products;

public class Opportunity {

	// Regular Actions
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
		String actionName="";
	
	
		try
		{
			<JAVA CODE>
	
			System.out.println(actionName+" - Succeeded in Step "+stepID);
	
		}
		catch(Exception e)
		{
	
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	 */

	public static void opportunityNewOpportunityScreen(WebDriver driver, WebDriverWait wait, int stepID, String testExecutionString) throws Exception
	{
		String actionName="Opportunity: Create New Opportunity (1st Screen)";

		String oppiename="OPTY_"+testExecutionString;


		String optyStage=TestData.searchDT(2, "optyStage");

		String optyForecastCategory=TestData.searchDT(2, "optyForecastCategory");

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Opportunity.newOpportunityHeader)));

			driver.findElement(By.xpath(SFPC_Opportunity.inputOpportunityName)).clear();
			driver.findElement(By.xpath(SFPC_Opportunity.inputOpportunityName)).sendKeys(oppiename);

			driver.findElement(By.xpath(SFPC_Opportunity.inputCloseDate)).clear();
			driver.findElement(By.xpath(SFPC_Opportunity.inputCloseDate)).sendKeys(ExecStructure.formattedDate("dd/MM/yyyy"));

			driver.findElement(By.xpath(SFPC_Opportunity.selectStage)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyStage+"']"))).click();

			driver.findElement(By.xpath(SFPC_Opportunity.selectForecastCategory)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+optyForecastCategory+"']"))).click();

			driver.findElement(By.xpath(SFPC_Opportunity.saveButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);


			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void goToAddProductScreen(WebDriver driver, WebDriverWait wait, int stepID, String testExecutionString) throws Exception
	{
		String actionName="Opportunity: Go to 'Add Products' screen";


		try
		{
			driver.findElement(By.linkText("Products")).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath(SFPC_Opportunity.addProductBtn)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void configNewMobileOpportunity(WebDriver driver, WebDriverWait wait, int stepID, String testExecutionString) throws Exception
	{
		String actionName="Opportunity: Product Configuration of Mobile Voice";
		

		String mobileVoice=TestData.searchDT(3, "mobileVoice");

		String mobileVoiceProduct="//div[@title='"+mobileVoice+"']";


		try
		{
			driver.findElement(By.xpath(SFPC_Products.inputSearchProducts)).sendKeys(mobileVoice);
			
			//driver.findElement(By.xpath(SFPC_Products.inputSearchProducts)).sendKeys(Keys.ENTER);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mobileVoiceProduct))).click();

			driver.findElement(By.xpath(SFPC_Products.nextButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);


			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{

			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void configProductConfiguration(WebDriver driver, WebDriverWait wait, int stepID, String testExecutionString) throws Exception
	{
		String actionName="Opportunity: Edit Product Configuration";
		
		
		
		
		String[] config2Apply=TestData.prodConfiguration(1);	
		
		try
		{
			driver.findElement(By.xpath(SFPC_Products.totalContractValue)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Products.inputContractValue))).sendKeys(config2Apply[0]);
			
			driver.findElement(By.xpath(SFPC_Products.contractDuration)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SFPC_Products.inputContratDuration))).sendKeys(config2Apply[1]);
			
			driver.findElement(By.xpath(SFPC_Products.revenueType)).click();
			driver.findElement(By.xpath(SFPC_Products.revenueType2)).click();
			driver.findElement(By.linkText(config2Apply[2])).click();
			
			BrowserActions.ScrollByPixs(driver, 100, 0);
			
			driver.findElement(By.xpath(SFPC_Products.productRegime)).click();
			driver.findElement(By.xpath(SFPC_Products.productRegime2)).click();
			driver.findElement(By.linkText(config2Apply[3])).click();
			
			
			driver.findElement(By.xpath(SFPC_Products.saveButton)).click();
			
			
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SFPC_Products.saveButton)));
			
			
	
			System.out.println(actionName+" - Succeeded in Step "+stepID);
	
		}
		catch(Exception e)
		{
	
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void goToAgreementScreen(WebDriver driver, int stepID, String testExecutionString) throws Exception
	{
		String actionName="Opportunity: Navigate to Agreement Screen";
		
		String oppiename="OPTY_"+testExecutionString;
		
		String generatedAgreement=(SFPC_Opportunity.agreementsArea).concat("//a[contains(.,'"+oppiename+"')]");
		
		try
		{
			driver.findElement(By.xpath(generatedAgreement)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
	
			System.out.println(actionName+" - Succeeded in Step "+stepID);
	
		}
		catch(Exception e)
		{
	
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	
	// Validation Actions
	/*02-03-2020:LMA
	 * sketch for every validation functions
	 *=====================================
	 String actionName="";
	  	try
		{
			if()
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				throw new Exception (actionName+" - Failed in Step "+stepID);
			}

		}
		catch(Exception e)
		{
				System.out.println(actionName+" - Failed in Step: "+stepID);
				return false;
		}

	 */
	
	public static boolean opportunityScreenValidation(WebDriver driver, int stepID)
	{
		String actionName="Opportunity: Opportunity screen validation";
	  	try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceOpportunity.optyHeader) && BrowserActions.isElementPresent(driver, SalesForceOpportunity.productContainer))
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				throw new Exception (actionName+" - Failed in Step "+stepID);
			}

		}
		catch(Exception e)
		{
				System.out.println(actionName+" - Failed in Step: "+stepID);
				return false;
		}
	}

	public static boolean newOpportunityDetailsPage(WebDriver driver, String testName, int stepID, String testExecutionString) throws Exception
	{
		String actionName="Opportunity: OPTY's Details Page validation";

		String oppieName="OPTY_"+testExecutionString;


		try
		{
			WebElement oppieLink=driver.findElement(By.linkText(oppieName));


			if(oppieLink.isDisplayed())
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
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean addProductsScreenValidation(WebDriver driver, String testName, int stepID, String testExecutionString) throws Exception
	{
		String actionName="Opportunity: Add Products Screen Validation";
		try
		{
			if(BrowserActions.isElementPresent(driver,SFPC_Products.addProductsHeader) && BrowserActions.isElementPresent(driver,SFPC_Products.inputSearchProducts) && BrowserActions.isElementPresent(driver,SFPC_Products.nextButton) && BrowserActions.isElementPresent(driver,SFPC_Products.cancelButton) && BrowserActions.isElementPresent(driver,SFPC_Products.productTable))
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
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean configAddProductConfiguration(WebDriver driver, String testName, int stepID, String testExecutionString) throws Exception
	{
		String actionName="Opportunity: validation of Product Configuration";
		
		try
		{
			if(BrowserActions.isElementPresent(driver,SFPC_Products.headerEditSelectedProducts) && BrowserActions.isElementPresent(driver,SFPC_Products.backButton) && BrowserActions.isElementPresent(driver,SFPC_Products.totalContractValue) && BrowserActions.isElementPresent(driver,SFPC_Products.contractDuration) && BrowserActions.isElementPresent(driver,SFPC_Products.revenueType) && BrowserActions.isElementPresent(driver,SFPC_Products.productRegime))
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
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean soi66validation(WebDriver driver, WebDriverWait wait, String testName, int stepID, String testExecutionString) throws Exception
	{
		 String actionName="Opportunity: SOI-66 Validation";
		 
		 String oppiename="OPTY_"+testExecutionString;
		 
		 String mobileVoice=TestData.searchDT(3, "mobileVoice");
		 
		 String lineItemOppie=(SFPC_Opportunity.productsArea).concat("//a[contains(.,'"+mobileVoice+"')]");
		 
		 String generatedAgreement=(SFPC_Opportunity.agreementsArea).concat("//a[contains(.,'"+oppiename+"')]");
		 
		  	try
			{
		  		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(SFPC_Opportunity.agreementsArea), oppiename));
		  		
				if(BrowserActions.isElementPresent(driver, lineItemOppie) && BrowserActions.isElementPresent(driver, generatedAgreement))
				{
					System.out.println(actionName+" - Succeeded in Step: "+stepID);
					return true;
				}
				else
				{
					throw new Exception (actionName+" - Failed in Step: "+stepID);
				}

			}
			catch(Exception e)
			{
				System.out.println(actionName+" - Failed in Step: "+stepID);
				return false;
			}

}

	
}