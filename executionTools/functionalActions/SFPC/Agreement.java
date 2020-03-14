package functionalActions.SFPC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import actions.BrowserActions;
import execStructure.ExecStructure;
import sfDirectSales.SalesForceAgreement;
import sfPartnersCommunity.SFPC_Agreements;
import sfSikuli.SalesForceSikuli;

public class Agreement {
	
	
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
	
	public static void goToOpportunityScreen(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Agreement: Go to Opportunity";
		
		
		try
		{
			
	
			System.out.println(actionName+" - Succeeded in Step "+stepID);
	
		}
		catch(Exception e)
		{
	
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void addFile2Agreement(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Agreement: Add File to Agreement";
		
		
		Screen screen = new Screen();	
		
		String file2Upload="SimpleOrdering_Dummy_File";
		
		String agreementFileTestData=ExecStructure.workingDir+"\\testData\\"+file2Upload+".pdf";
	
	try
	{
		screen.wait(SalesForceSikuli.uploadFilesPCButton, 20);
		
		screen.click(SalesForceSikuli.uploadFilesPCButton);
		
		screen.wait(SalesForceSikuli.uploadBarFilePathOpenCancel, 20);
		
		screen.find(SalesForceSikuli.filePath);
		
		screen.paste(agreementFileTestData);
		
		screen.click(SalesForceSikuli.openButton);
		
		screen.wait(SalesForceSikuli.uploadFilesDoneSalesforce, 20);
		
		screen.wait(SalesForceSikuli.doneButton, 20);
		
		screen.click(SalesForceSikuli.doneButton);
		
		
		Thread.sleep(10000);
		
								
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
				throw new Exception (actionName+" - Failed in Step: "+stepID,e);
				
			}
	
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println(actionName+" - Failed in Step: "+stepID);
			return false;
		}

	 */

	public static boolean validateAgreementScreen(WebDriver driver, int stepID) throws Exception
	{
		 String actionName="Agreement: Agreement Screen Validation";
		 
		 try
		{
			 //WebElement cssUploadFilesBtn=driver.findElement(By.cssSelector(SFPC_Agreements.cssUploadFilesBtn));
			 
			if(BrowserActions.isElementPresent(driver,SFPC_Agreements.agreementsDetails) && BrowserActions.isElementPresent(driver,SFPC_Agreements.agreementHeader) && BrowserActions.isElementPresent(driver,SFPC_Agreements.filesArea) && BrowserActions.isElementPresent(driver,SFPC_Agreements.addFilesButton))
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

	public static boolean singleFileValidation(WebDriver driver, int stepID)
	{
		String actionName="Agreement: File validation in Files Container";
		
		String file2Upload="SimpleOrdering_Dummy_File";
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		 try
		{
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceAgreement.filesContainer.concat("//a[contains(.,'"+file2Upload+"')]"))));
				//WebElement file = driver.findElement(By.xpath(SalesForceAgreement.filesContainer.concat("//a[contains(.,'"+file2Upload+"')]")));
				
				if (BrowserActions.isElementPresent(driver, SalesForceAgreement.filesContainer.concat("//a[contains(.,'"+file2Upload+"')]")))
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
	
	
	
}
