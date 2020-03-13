package functionalActions.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actions.BrowserActions;
import execStructure.TestData;
import sfDirectSales.SalesForceHomePage;

public class HomePage {

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

					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}

	 */

	public static void login(WebDriver driver, int stepID, String userProfile) throws Exception
	{
		String actionName="HomePage: Login in Salesforce - Direct Sales";

		String envURL=TestData.searchDT(0, "environmentITTQA");

		String[] user = TestData.getSalesforceUser(userProfile);


		String loginUserName=user[0];

		String loginPassWord=user[1];


		try
		{
			driver.get(envURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			WebElement usernameBox = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.userName));
			WebElement passwordBox = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.passWord));
			WebElement loginBtn = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.loginbtn));

			if (usernameBox.isDisplayed() == true && passwordBox.isDisplayed() == true && loginBtn.isDisplayed() == true) 
			{
				usernameBox.sendKeys(loginUserName);
				passwordBox.sendKeys(loginPassWord);
				loginBtn.click();
			} 
			else
			{
				throw new Exception (actionName+" - Failed in Step "+stepID);
			}
			
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
	 *String actionName="";
	 * 	try
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
					throw new Exception (actionName+" - Failed in Step: "+stepID,e);
				}

	 */

	public static boolean loginValidation(WebDriver driver, int stepID) throws Exception
	{
		String actionName="HomePage: Login Validation";
		
		
		try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceHomePage.header) && BrowserActions.isElementPresent(driver, SalesForceHomePage.headerIcons))
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

}
