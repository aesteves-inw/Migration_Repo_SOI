package homePagePartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import objectMap.sfPartnersCommunity.PartComCompany;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class HomePagePCNavigation 
{
	public static void goToCompanyPageByURL(List<TestLog> logStream, int stepID, WebDriver driver, String testName) throws Exception
    {
        String actionName="Home Page: Go To Company Page By URL";
        
        String partnersURL=ExcelDataFetch.searchDT(0, "PartnersCommunity");
        
        String companyID=ExcelDataFetch.searchDT(2, "idCompanyD02Functional");
        
        String companyURL=partnersURL+"/"+companyID;
        
        System.out.println(companyURL);


				try
				{
					BrowserActions.goToByURL(driver, companyURL);
					
					new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PartComCompany.companyDetails)));

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
