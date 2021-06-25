package addOfferToBasketDirectSales;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesAddOfferToBasket;
import objectMap.sfDirectSales.DirSalesProductBasket;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class AddOfferToBasketAction {

	//Operational Actions

	public static void pickProductOnAddOfferBasket(List<TestLog> logStream, WebDriver driver, int stepID, String productToAdd) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String actionName="Add Offer to Basket: Pick Product - "+productToAdd;


		try
		{
			
			BrowserActions.ScrollByElement(driver, "linkText", productToAdd);
			
			driver.findElement(By.linkText(productToAdd)).click();

			WebElement productSummary=driver.findElement(By.xpath(DirSalesAddOfferToBasket.summarySection));

			String productVal=productSummary.getText().toString();

			if(productVal.contains(productToAdd))
			{
				driver.findElement(By.xpath(DirSalesAddOfferToBasket.add2OfferButton)).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.singleLineItemProduct)));

			}
			else
			{
				throw new Exception ("Not Possible to confirm Product Selection on Step "+stepID);
			}

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	
	public static void pickMultipleProductsFromSectionOnAddOfferBasket(List<TestLog> logStream, WebDriver driver, int stepID, List<String> listProductsName) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String actionName="Add Offer to Basket: Pick Products From a Section - "+listProductsName;

		Boolean validation= false;

		try
		{
			for (String productToAdd : listProductsName) {
	        	
				productToAdd.trim();
				
				BrowserActions.ScrollByElement(driver, "linkText", productToAdd);
				
				if(driver.findElements(By.linkText(productToAdd)).size() > 1)
				{
					driver.findElements(By.linkText(productToAdd)).get(1).click();
				}
				else
				{
					driver.findElement(By.linkText(productToAdd)).click();
				}
			
				Thread.sleep(1000);
				
			}
			
			for (String productToAdd : listProductsName) {
	        	
				productToAdd.trim();
				
				WebElement productSummary=driver.findElement(By.xpath(DirSalesAddOfferToBasket.summarySection));
				
				String productVal=productSummary.getText().toString();
				
				validation = productVal.contains(productToAdd);
				
				if(validation==false) break;
			}

			if(validation==true)
			{
				driver.findElement(By.xpath(DirSalesAddOfferToBasket.add2OfferButton)).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.singleLineItemProduct)));

			}
			else
			{
				throw new Exception ("Not Possible to confirm  Multiple Products Selection on Step "+stepID);
			}

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

	public static boolean addProductMenuValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="addProductMenuValidation";



		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.offerNameHeader) && 
					BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.offerList) && 
					BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.add2OfferCancelButton) && 
					BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.add2OfferButton) && 
					//BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.summarySection) && 
					BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.productCatalog))
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

	public static boolean categorieProductMenuValidation(List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		String actionName="categorieProductMenuValidation";

//		driver.findElement(By.linkText("")).isDisplayed();

		try
		{
						
//			if(driver.findElement(By.linkText("Adv Telco Sol")).isDisplayed() && 
//					driver.findElement(By.linkText("Advanced Workplace")).isDisplayed() && 
//					driver.findElement(By.linkText("Cloud solution")).isDisplayed() && 
//					driver.findElement(By.linkText("Compute & Storage")).isDisplayed() && 
//					driver.findElement(By.linkText("Fix Internet")).isDisplayed() && 
//					driver.findElement(By.linkText("IOT & Analytics")).isDisplayed() && 
//					driver.findElement(By.linkText("Mass Market")).isDisplayed() && 
//					driver.findElement(By.linkText("Mobile")).isDisplayed() && 
//					driver.findElement(By.linkText("Netw Conn & Serv")).isDisplayed() && 
//					driver.findElement(By.linkText("Next Gen Comm")).isDisplayed() && 
//					driver.findElement(By.linkText("Special project")).isDisplayed() && 
//					driver.findElement(By.linkText("Voice")).isDisplayed()
//					)
			WebElement categoryECSPack= driver.findElement(By.xpath(DirSalesProductBasket.categoryECSPack));
			
			WebElement categoryConvergedOfferrings= driver.findElement(By.xpath(DirSalesProductBasket.categoryConvergedOfferrings));

			WebElement categoryStandaloneOfferings= driver.findElement(By.xpath(DirSalesProductBasket.categoryStandaloneOfferings));

			WebElement categoryStandaloneOfferings_Internet= driver.findElement(By.xpath(DirSalesProductBasket.categoryStandaloneOfferings_Internet));

			WebElement categoryStandaloneOfferings_Voice= driver.findElement(By.xpath(DirSalesProductBasket.categoryStandaloneOfferings_Voice));
			
			WebElement categoryExternallyQuotedProducts= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts));
			
			WebElement categoryExternallyQuotedProducts_AdvTelcoSol= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_AdvTelcoSol));
			
			WebElement categoryExternallyQuotedProducts_AdvancedWorkplace= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_AdvancedWorkplace));
			
			WebElement categoryExternallyQuotedProducts_ComputeStorage= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_ComputeStorage));
			
			WebElement categoryExternallyQuotedProducts_DNSWebhosting= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_DNSWebhosting));
			
			WebElement categoryExternallyQuotedProducts_EnterprisePackTogether= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_EnterprisePackTogether));
			
			WebElement categoryExternallyQuotedProducts_IOTAnalytics= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_IOTAnalytics));
			
			WebElement categoryExternallyQuotedProducts_MassMarket= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_MassMarket));
			
			WebElement categoryExternallyQuotedProducts_Mobile= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_Mobile));
			
			WebElement categoryExternallyQuotedProducts_NetwConnServ= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_NetwConnServ));
			
			WebElement categoryExternallyQuotedProducts_NextGenComm= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_NextGenComm));
			
			WebElement categoryExternallyQuotedProducts_Voice= driver.findElement(By.xpath(DirSalesProductBasket.categoryExternallyQuotedProducts_Voice));

			
			if(	//Validations on Category Enterprise Call & Surf (Pack)
				categoryECSPack.isDisplayed() && categoryECSPack.getText().contains("Enterprise Call & Surf")&&
				categoryECSPack.getText().contains("Enterprise Call & Surf Pro with Phone Line")&&
				categoryECSPack.getText().contains("Enterprise Call & Surf Pro with Enterprise Voice")&&
				categoryECSPack.getText().contains("Enterprise Call & Surf Pro+ with Phone Line")&&
				categoryECSPack.getText().contains("Enterprise Call & Surf Pro+ with Enterprise Voice")&&
				categoryECSPack.getText().contains("Enterprise Call & Surf FullFiber")&&
				categoryECSPack.getText().contains("Enterprise Call & Surf FullFiber Extended")&&
				
				//Validations on Category Converged Offerings
				categoryConvergedOfferrings.isDisplayed() && categoryConvergedOfferrings.getText().contains("Internet & Phone Line") &&
				
				//Validations on Category Standalone Offerings
				categoryStandaloneOfferings.isDisplayed() && categoryStandaloneOfferings.getText().contains("Internet") && categoryStandaloneOfferings.getText().contains("Voice")&&
				
					//Validations on Sub Category Internet from Standalone Offerings
					categoryStandaloneOfferings_Internet.getText().contains("Professional Internet")&&
					
					//Validations on Sub Category Voice from Standalone Offerings
					categoryStandaloneOfferings_Voice.getText().contains("Phone Line")&&	
					categoryStandaloneOfferings_Voice.getText().contains("Voice Continuity")&&	
					categoryStandaloneOfferings_Voice.getText().contains("Enterprise Voice")&&
			
				//Validations on Category Externally Quoted Products
				categoryExternallyQuotedProducts.isDisplayed() &&
				
					//Validations on Sub Category Adv Telco Sol
					categoryExternallyQuotedProducts.getText().contains("Adv Telco Sol") &&
						categoryExternallyQuotedProducts_AdvTelcoSol.getText().contains("M2M KORE")&&
						
					//Validations on Sub Category Advanced Workplace
					categoryExternallyQuotedProducts.getText().contains("Advanced Workplace") &&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("PABX")&&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("Temporary rental PABX")&&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("Cloud Mail Security")&&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("Bizz Call Connect - Partner installer")&&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("Voice Assist")&&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("Microsoft Office 365")&&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("EM+S (Microsoft)")&&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("PABX/Call Connect - Partner installer")&&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("Personal Cloud")&&
						categoryExternallyQuotedProducts_AdvancedWorkplace.getText().contains("Workspace_One (Airwatch)")&&
				
					//Validations on Sub Category Compute & Storage
					categoryExternallyQuotedProducts.getText().contains("Compute & Storage") &&
						categoryExternallyQuotedProducts_ComputeStorage.getText().contains("Housing (not BiLAN)")&&
						categoryExternallyQuotedProducts_ComputeStorage.getText().contains("Hosting (Shared)")&&
						categoryExternallyQuotedProducts_ComputeStorage.getText().contains("Proximus Azure Services")&&
						categoryExternallyQuotedProducts_ComputeStorage.getText().contains("Cloud vContainer")&&

						
					//Validations on Sub Category DNS/Webhosting
					categoryExternallyQuotedProducts.getText().contains("DNS/Webhosting") &&
						categoryExternallyQuotedProducts_DNSWebhosting.getText().contains("DNS")&&
						
					//Validations on Sub Category DNS/Webhosting
					categoryExternallyQuotedProducts.getText().contains("Enterprise Pack Together") &&
						categoryExternallyQuotedProducts_EnterprisePackTogether.getText().contains("Enterprise Pack Together")&&
							
					//Validations on Sub Category IOT & Analytics
					categoryExternallyQuotedProducts.getText().contains("IOT & Analytics") &&
						categoryExternallyQuotedProducts_IOTAnalytics.getText().contains("Internet of Things")&&
						
					//Validations on Sub Category Mass Market
					categoryExternallyQuotedProducts.getText().contains("Mass Market") &&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("CPE")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Bizz Call Connect")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Mobile BONE")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Mass Market")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Mass Market")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Joint Offer")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Multiline")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Pack (with mobile)")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Pack (without mobile)")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Proximus TV")&&
						categoryExternallyQuotedProducts_MassMarket.getText().contains("Proximus TV App (TV Everywhere)")&&
					
					//Validations on Sub Category Mobile
					categoryExternallyQuotedProducts.getText().contains("Mobile") &&
						categoryExternallyQuotedProducts_Mobile.getText().contains("Mobile Prepaid")&&
						categoryExternallyQuotedProducts_Mobile.getText().contains("Engage")&&
						
					//Validations on Sub Category Mass Market
					categoryExternallyQuotedProducts.getText().contains("Netw Conn & Serv") &&
						categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Leased Line")&&
						categoryExternallyQuotedProducts_NetwConnServ.getText().contains("IP Pack on BiLAN/Explore")&&
						categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Split Plan-IFE/PFE")&&
						categoryExternallyQuotedProducts_NetwConnServ.getText().contains("E-Line")&&
						categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Explore")&&
						categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Split Plan/IFE Tool")&&
						categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Temporary xDSL Fast Internet")&&
						categoryExternallyQuotedProducts_NetwConnServ.getText().contains("SDWAN")&&
						categoryExternallyQuotedProducts_NetwConnServ.getText().contains("SDWAN International")&&
						
					//Validations on Sub Category Next Gen Comm
					categoryExternallyQuotedProducts.getText().contains("Next Gen Comm") &&
						categoryExternallyQuotedProducts_NextGenComm.getText().contains("Interact")&&
						categoryExternallyQuotedProducts_NextGenComm.getText().contains("SMS Solutions Pack")&&
						categoryExternallyQuotedProducts_NextGenComm.getText().contains("SMS Solution")&&
						categoryExternallyQuotedProducts_NextGenComm.getText().contains("Proximus DocDrop")&&
						categoryExternallyQuotedProducts_NextGenComm.getText().contains("Conversational Chatbot")&&
						categoryExternallyQuotedProducts_NextGenComm.getText().contains("Secure Mail")&&
						
					//Validations on Sub Category Voice
					categoryExternallyQuotedProducts.getText().contains("Voice") &&
						categoryExternallyQuotedProducts_Voice.getText().contains("Temporary ISDN")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("Marketing Number International")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("Directory Number (DDI/ISDN)")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("PRA")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("Marketing Number Mobile")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("Elevator Line")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("VMS")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("DDI on PRA")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("PRA over IAD30")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("Temporary PSTN")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("Tariff Plan")&&
						categoryExternallyQuotedProducts_Voice.getText().contains("Marketing Number")&&
						
					//Validations categories removed  
					categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Explore BiLAN Teleworking")==false &&
					categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Explore International with voice")==false &&
					categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Explore Mobile Worker")==false &&
					categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Explore Mono with voice")==false &&
					categoryExternallyQuotedProducts_NetwConnServ.getText().contains("Explore Mono without voice")==false)
			{
//				BrowserActions.verticalscrollByVisibleElement(driver, DirSalesProductBasket.categoryStandaloneOfferings);
//				BrowserActions.screenShotTaking(driver,testName, actionName);
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
