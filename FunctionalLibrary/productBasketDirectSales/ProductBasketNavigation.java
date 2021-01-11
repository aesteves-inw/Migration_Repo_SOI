package productBasketDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectMap.sfDirectSales.DirSalesAgreement;
import objectMap.sfDirectSales.DirSalesProductBasket;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProductBasketNavigation 
{
	public static void goToAgreement(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		
		String actionName="Product Basket: Go To Agreement (After Sync)";


		try
		{
			WebElement buttonGoToAgreement = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.buttonGoToAgreement)));

			buttonGoToAgreement.click();
			
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, stepID);
			
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesAgreement.detailsAgreement)));
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
}
