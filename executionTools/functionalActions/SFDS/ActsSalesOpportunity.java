package functionalActions.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import actions.BrowserActions;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceProducts;
import sfSikuli.SalesForceSikuli;

public class ActsSalesOpportunity {

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
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	 */

	public static void inputOpportunityValues(WebDriver driver, String testExecutionString, String testName) throws Exception
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


			//14-02-2020 - Adding Terms&Conditions value to the oppie

			BrowserActions.verticalscrollByVisibleElement(driver, SalesForceOpportunity.additionalInformationTab);

			driver.findElement(By.xpath(SalesForceOpportunity.termsAndConditionsComboBox)).click();

			waitNSOS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.termAndConditionsOption))).click();

			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		}
		catch(Exception e)
		{
			throw new Exception ("Input on Opportunity Screen Failed",e);
		}
	}

	public static void addProductToOppie(WebDriver driver, int stepID, String product) throws Exception
	{
		String actionName="Opportunity: Adding Product. Product: "+product;


		WebDriverWait waitAp2o = new WebDriverWait(driver, 10);

		String product2Add = TestData.searchDT(2,product);


		try
		{
			driver.findElement(By.xpath(SalesForceProducts.inputSearchProducts)).clear();

			driver.findElement(By.xpath(SalesForceProducts.inputSearchProducts)).sendKeys(product2Add);

			driver.findElement(By.xpath(SalesForceProducts.inputSearchProducts)).sendKeys(Keys.ENTER);

			Thread.sleep(3000);

			driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[2]/span/span/label/span[1]")).click();

			driver.findElement(By.xpath(SalesForceProducts.nextButtonScreen)).click();

			waitAp2o.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceProducts.editProductHeader)));

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void editProductConfiguration(WebDriver driver, int tcNumber, int stepID) throws Exception
	{
		String actionName="Opportunity: Editing Product";


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

			BrowserActions.waitUntilElementFade(driver, SalesForceProducts.editProductHeader);
			
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceProducts.editProductHeader)));


			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void findAgreementOnOPTY(WebDriver driver, int stepID) throws Exception
	{

		String actionName="Opportunity: Find Agreement Container on Opportunity Page";


		WebDriverWait waitFAO = new WebDriverWait(driver, 10);

		try
		{

			for(int i=0;i<3;i++)
			{
				waitFAO.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.agreementsContainer)));

				BrowserActions.verticalScrollByPixs(driver, BrowserActions.getYOfElement(driver, SalesForceOpportunity.agreementsContainer));

				Thread.sleep(3000);
			}


			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void closeWonOppie(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Opportunity: Close Won Opportunity";

		WebDriverWait waitCWO = new WebDriverWait(driver, 10);

		try
		{
			
			WebElement closeOPTYLink = BrowserActions.getElementByJSQuery(driver, SalesForceOpportunity.closeOPTYHeaderButton);
			
			System.out.println("isJSElementPresent Debug: "+BrowserActions.isJSElementPresent(driver, SalesForceOpportunity.closeOPTYHeaderButton));
			
			BrowserActions.jsClick(driver, closeOPTYLink);		
						
			WebElement selectCloseButton=BrowserActions.getElementByJSQuery(driver, SalesForceOpportunity.selectCloseMenu);
			
			BrowserActions.jsClick(driver, selectCloseButton);	
			
			waitCWO.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.ctomHeader)));

			Select closedStage = new Select(driver.findElement(By.xpath("//select")));

			closedStage.selectByVisibleText("Closed Won");

			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();

			waitCWO.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesForceOpportunity.ctomHeader)));

			driver.navigate().refresh();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);


			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void orderVisibleOnOpportunityScreen(WebDriver driver, int stepID, String optyName) throws Exception
	{
		 String actionName="Opportunity: Order visibility on Opportunity screen";
		 
			try
			{
				WebElement orderLinkRelatedMenu=driver.findElement(By.xpath(SalesForceOpportunity.ordersContainer));
				
				if (orderLinkRelatedMenu.isDisplayed() == false)
				{
					BrowserActions.verticalscrollByVisibleElement(driver, SalesForceOpportunity.ordersContainer);				
				}

				System.out.println(actionName+" - Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
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
				return false;
			}

			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception (actionName+" - Failed in Step: "+stepID,e);
			}

	 */

	public static boolean productScreenValidation(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Opportunity: Add Product Screen Validation";
		try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceProducts.inputSearchProducts) && BrowserActions.isElementPresent(driver, SalesForceProducts.productsTable))
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
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean opportunityScreenValidation(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Opportunity: Opportunity Page validation";
		try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceOpportunity.optyHeader) && BrowserActions.isElementPresent(driver, SalesForceOpportunity.productContainer))
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
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static boolean soi66opportunityValidation(WebDriver driver, int stepID, String optyName) throws Exception
	{
		String actionName="Opportunity: SOI-66 Validation";
		
		try
		{
			WebElement agreementContainer=driver.findElement(By.xpath(SalesForceOpportunity.agreementsContainer));
			
			WebElement agreementName = agreementContainer.findElement(By.cssSelector("flexipage-tab2#tab-8>slot>flexipage-component2>force-progressive-renderer>slot>slot>flexipage-aura-wrapper>div>div>div>div:nth-of-type(14)>article>div:nth-of-type(2)>div>div>div>div>ul>li>div:nth-of-type(2)>h3>div>a"));
			
			if(agreementName.isDisplayed())
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
			//throw new Exception (actionName+" - Failed in Step: "+stepID,e);
			return false;
		}

	}

	public static boolean validationClosedWonOpty(WebDriver driver, int stepID, String optyName)
	{
		String actionName="Opportunity: Closed Won Opportunity validation";
		
		
		 try
			{
			 	WebElement closedWonMarker = driver.findElement(By.xpath("//lightning-formatted-text[text()='Closed Won']"));
			 	
				if(closedWonMarker.isDisplayed()==true)
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
				System.out.println(e);
				System.out.println(actionName+" - Failed in Step: "+stepID);
				return false;
				
			}
	}

	public static boolean soi68opportunityValidation(WebDriver driver, int stepID, String optyName) throws Exception
	{
		 String actionName="Opportunity: SOI-68 Validation";
		 	 		 
		 try
			{
			 	String orderLink="//a[contains(.,'"+optyName+"')]";
			 	
			 	String ordersNameLink=SalesForceOpportunity.ordersContainer.concat(orderLink);
			 
				if(BrowserActions.isElementPresent(driver, ordersNameLink))
				{
					System.out.println(actionName+" - Succeeded in Step: "+stepID);
					return true;
				}
				else
				{
					System.out.println(actionName+" - Succeeded in Step: "+stepID);
					return false;
				}

			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception (actionName+" - Failed in Step: "+stepID,e);
			}
	}



}
