package functionalActions.SFPC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import execStructure.TestData;
import sfPartnersCommunity.SFPC_HomePage;
import sfPartnersCommunity.SFPC_LoginPage;

public class ActsPartsHomePage {

	// Regular Actions
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
	 *String actionName="";


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

	public static void loginSFPC(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Home Page: Login in Salesforce Partners Community";


		String envURL=TestData.searchDT(1, "environmentITTQA");

		String username=TestData.searchDT(1, "envUserNameITTQA");

		String password=TestData.searchDT(1, "envPasswordITTQA");


		try
		{

			driver.get(envURL);

			driver.findElement(By.xpath(SFPC_LoginPage.inputUserame)).sendKeys(username);

			driver.findElement(By.xpath(SFPC_LoginPage.inputPassword)).sendKeys(password);

			driver.findElement(By.xpath(SFPC_LoginPage.loginButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);



			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void navigate2CompanyDetails(WebDriver driver, String testName, int stepID) throws Exception
	{
		String actionName="Home Page: Navigate to Company Details";


		String companyURL=(TestData.searchDT(1, "environmentITTQA")).concat(TestData.searchDT(1, "CompanyDetails")).concat(TestData.tdCompanyID(testName));

		try
		{
			driver.get(companyURL);

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void logoutPC(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Home Page: Logout Partners Community";

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try
		{
			driver.findElement(By.xpath(SFPC_HomePage.profileButton)).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SFPC_HomePage.profileMenuList)));

			driver.findElement(By.xpath(SFPC_HomePage.logoutOption)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);


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
	 *String actionName="";
	 *
	 *boolean validationValue;
	 * 	try
								{
									if()
									{
										validationValue = true;
									}
									else
									{
										validationValue = false;
									}

								}
								catch(Exception e)
								{
									System.out.println(e);
									throw new Exception (actionName+" - Failed in Step: "+stepID,e);
								}

								System.out.println(actionName+" - Succeeded in Step: "+stepID);

								return validationValue;

	 */
	public static boolean validateHomePageScreen(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Home Page: Home Page Screen validation";

		try
		{
			if(BrowserActions.isElementPresent(driver, SFPC_HomePage.headerNavigationBar) && 
					BrowserActions.isElementPresent(driver, SFPC_HomePage.quickCreateButton) && 
					BrowserActions.isElementPresent(driver, SFPC_HomePage.inputSearchBar) && 
					BrowserActions.isElementPresent(driver, SFPC_HomePage.dashboard))
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

	public static boolean validateLogoutHomePage(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Home Page: Logout validation on Partners Community";

		boolean validationValue;
		
		try
		{
			if(BrowserActions.isElementPresent(driver, SFPC_LoginPage.inputUserame) &&  BrowserActions.isElementPresent(driver, SFPC_LoginPage.inputPassword) && BrowserActions.isElementPresent(driver, SFPC_LoginPage.loginButton))
			{
				validationValue = true;
			}
			else
			{
				validationValue = false;
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}

		System.out.println(actionName+" - Succeeded in Step: "+stepID);

		return validationValue;
	}

}
