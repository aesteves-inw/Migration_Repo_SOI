package functionalActions.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import execStructure.ExecStructure;
import sfDirectSales.SalesForceAgreement;
import sfSikuli.SalesForceSikuli;

public class Agreement {
	
	public static void navigateToOpportunity(WebDriver driver, int stepID, String optyURL) throws Exception
	{
		String actionName = "Agreement: Navigation to Opportunity";
		
		
		try
		{
			driver.get(optyURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);
			
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
		
	}
	
	public static void addFile2Agreement(WebDriver driver, WebDriverWait wait, int stepID, String file2Upload) throws Exception
	{
		String actionName = "Agreement: Add file to Agreement";
		
		
		Screen screen = new Screen();	

		String agreementFileTestData=ExecStructure.workingDir+"\\testData\\"+file2Upload+".pdf";


		try
		{
			//driver.findElement(By.xpath(SalesForceAgreement.uploadFilesBtn)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[contains(.,'Files')]")));

			WebElement uploadFilesBTN=driver.findElement(By.xpath("//*[starts-with(@id,'file-selector-label-')]/span[1]"));

			uploadFilesBTN.click();
			
			// Sikuli: Snippet for adding File to Agreement
			// ==============================================
			//screen.click(SalesForceSikuli.uploadFilesButton);

			screen.wait(SalesForceSikuli.uploadBarFilePathOpenCancel, 20);

			screen.find(SalesForceSikuli.filePath);

			screen.paste(agreementFileTestData);

			screen.click(SalesForceSikuli.openButton);

			screen.wait(SalesForceSikuli.uploadFilesDoneSalesforce, 20);

			screen.wait(SalesForceSikuli.doneButton, 20);

			screen.click(SalesForceSikuli.doneButton);

			// ==============================================
			
			//Thread.sleep(10000);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			WebElement file = driver.findElement(By.xpath(SalesForceAgreement.filesContainer.concat("//a[contains(.,'"+file2Upload+"')]")));

			if (file.isDisplayed() == false)
			{
				throw new Exception (actionName+" - Failed in Step "+stepID);
			}
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
}
