package actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceHomePage;
import sfDirectSales.SalesForceNewMACDOrderScreen;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceProducts;
import actions.BrowserActions;

public class FunctionalSteps {
	
	// Salesforce Direct Sales
	public static TestStepReportStructure loginSalesForce(WebDriver driver, int stepID, String sFEnvironment, String testName) throws Exception
	{
		String loginUserName;
		String loginPassWord;
		
		try
		{
			if(sFEnvironment == "DS")
			{
				loginUserName = TestData.searchDT(0, "envUserNameITTQA");
				loginPassWord=TestData.searchDT(0, "envPasswordITTQA");
			}
			else if (sFEnvironment == "PC")
			{
				loginUserName = TestData.searchDT(1, "envUserNameITTQA");
				loginPassWord=TestData.searchDT(1, "envPasswordITTQA");
			}
			else
			{
				throw new Exception("Test Failed on Step"+stepID);
			}
			
			WebElement usernameBox = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.userName));
			WebElement passwordBox = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.passWord));
			WebElement loginBtn = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.loginbtn));
			
			if (usernameBox.isDisplayed() == true && passwordBox.isDisplayed() == true && loginBtn.isDisplayed() == true) {
				usernameBox.sendKeys(loginUserName);
				passwordBox.sendKeys(loginPassWord);
				loginBtn.click();
			} 
			else
			{
				throw new Exception("Test Failed on Step"+stepID);
			}

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if (BrowserActions.isElementPresent(driver, SalesForceHomePage.header) && BrowserActions.isElementPresent(driver, SalesForceHomePage.headerIcons)) 
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_LoginScreen");
				TestStepReportStructure loginStep = new TestStepReportStructure(stepID, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_LoginScreen");
				return loginStep;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_LoginScreen");
			TestStepReportStructure loginStep = new TestStepReportStructure(stepID, "Login into Salesforce", "Login with success", "Not possible to validate Login Page", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_LoginScreen");
			return loginStep;
		}
	}
	
	public static TestStepReportStructure navigate2CompanyDetails(WebDriver driver, int stepID, String testName) throws Exception
	{
						
		String companyURL = TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "accountView")).concat(TestData.tdCompanyID(testName)).concat("/view");
		
		try
		{
			
			driver.get(companyURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if (BrowserActions.isElementPresent(driver, SalesForceCompany.followBtn) && BrowserActions.isElementPresent(driver, SalesForceCompany.quickSaleOPTYBtn) && BrowserActions.isElementPresent(driver, SalesForceCompany.companyDetailsHeader) && BrowserActions.isElementPresent(driver, SalesForceCompany.companyDetailsInfo))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2CompDetails");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Company Details", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2CompDetails");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to Company Details");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2CompDetails");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Company Details", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2CompDetails");
			return nav2ComDet;
		}
		
		
	}
	
	public static TestStepReportStructure createStandardOppie(WebDriver driver, int stepID, String testName, String testExecutionString) throws Exception
	{
		try
		{
			FunctionalActionsSFDS.createNewStandardOpportunity(driver);
			
			FunctionalActionsSFDS.inputOpportunityValues(driver, testExecutionString, testName);
			
			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesForceProducts.inputSearchProducts) && BrowserActions.isElementPresent(driver, SalesForceProducts.productsTable))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_CreateNewOppie");
				TestStepReportStructure newOppie = new TestStepReportStructure(stepID, "Create new Opportunity", "Opportunity created with success", "Created with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_CreateNewOppie");
				return newOppie;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Create New Opportunity");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_CreateNewOppie");
			TestStepReportStructure newOppie = new TestStepReportStructure(stepID, "Create new Opportunity", "Opportunity created with success", "Not possible to create Opportunity", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_CreateNewOppie");
			return newOppie;
		}
	}
	
	public static TestStepReportStructure createNewMACDOrder(WebDriver driver, int stepID, String testName, String testExecutionString) throws IOException
	{
		WebDriverWait waitNewMACDOrder = new WebDriverWait(driver, 10);
		
		String orderName="Order_"+testExecutionString;
		
		String newOrderCreated="//*[contains(.,'"+orderName+"')]";
		
		try
		{
			driver.findElement(By.xpath(SalesForceCompany.newMACDOrderButton)).click();
			
			waitNewMACDOrder.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceNewMACDOrderScreen.headerNewMACDOrder)));
			
			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).clear();
			
			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).sendKeys(orderName);
			
			driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.nmoSaveButton)).click();
					
			waitNewMACDOrder.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(orderName))).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if (BrowserActions.isElementPresent(driver, newOrderCreated))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_NewMACDOrder");
				TestStepReportStructure newMACDOrder = new TestStepReportStructure(stepID, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_NewMACDOrder");
				return newMACDOrder;
			}
			else
			{
				throw new Exception("Validation Failed on Step: "+stepID);
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_NewMACDOrder");
			TestStepReportStructure newMACDOrder = new TestStepReportStructure(stepID, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_NewMACDOrder");
			return newMACDOrder;
		}
	}
	
	public static TestStepReportStructure createCloseStandardMobileVoiceOppie(WebDriver driver, int stepID, String testName, String testExecutionString) throws Exception
	{
		try
		{
			FunctionalActionsSFDS.createNewStandardOpportunity(driver);
			
			FunctionalActionsSFDS.inputOpportunityValues(driver, testExecutionString, testName);
			
			driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			FunctionalActionsSFDS.addProductToOppie(driver, "mobileVoice");
			
			FunctionalActionsSFDS.editProductConfiguration(driver, 1);
			
			FunctionalActionsSFDS.closeWonOppie(driver);
			
			if (BrowserActions.isElementPresent(driver, SalesForceOpportunity.stageClosedWonDetails))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_ClosedWonOppieValidation");
				TestStepReportStructure createCloseStandardMobileVoiceOppie = new TestStepReportStructure(stepID, "Close Won Opportunity Validation", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_ClosedWonOppieValidation");
				return createCloseStandardMobileVoiceOppie;
			}
			else
			{
				throw new Exception("Validation Failed on Step 05");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_ClosedWonOppieValidation");
			TestStepReportStructure createCloseStandardMobileVoiceOppie = new TestStepReportStructure(stepID, "Close Won Opportunity Validation", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_ClosedWonOppieValidation");
			return createCloseStandardMobileVoiceOppie;
		}
	}
	
	// Salesforce Partners Community
	
	
	
	// SOI-80
	public static TestStepReportStructure navigate2OrdersList(WebDriver driver, int stepID, String testName) throws Exception
	{
						
		String ordersListURL = TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "ordersList"));
		
		try
		{
			
			driver.get(ordersListURL);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.ordersSearchBar))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2OrdersList");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Orders List", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2OrdersList");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to Orders List");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2OrdersList");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Orders List", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2OrdersList");
			return nav2ComDet;
		}
		
		
	}

	public static TestStepReportStructure navigate2MyOrders(WebDriver driver, int stepID, String testName) throws Exception
	{		
		
		try
		{
			
			/*driver.findElement(By.xpath(SalesForceOrders.ordersListView)).click();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath(SalesForceOrders.myOrdersOption)).click();*/
			
			driver.get(TestData.myOrdersURL);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.validateMyOrders))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOders");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOders");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to My Orders");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOrders");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOrders");
			return nav2ComDet;
		}
		
		
	}
	
	public static TestStepReportStructure navigate2SelectFields(WebDriver driver, int stepID, String testName) throws Exception
	{
		
		try
		{
			driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
			driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath(SalesForceOrders.listViewControls)).sendKeys(Keys.RETURN);
			
			for(int i = 1; i < 6; i++) {
				String s = String.valueOf(i);
				driver.findElement(By.xpath("(//a[@role='menuitem'])["+s+"]")).sendKeys(Keys.DOWN);
				}
			driver.findElement(By.xpath("(//a[@role='menuitem'])[6]")).sendKeys(Keys.RETURN);
			//driver.findElement(By.xpath(SalesForceOrders.listViewControls)).click();;
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//driver.findElement(By.xpath(SalesForceOrders.selectFieldDisplay)).click();;
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.selectFieldDisplay))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_navigate2SelectFields");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to Select Fields to Display");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_navigate2SelectFields");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
			return nav2ComDet;
		}
		
		
	}
	
	public static TestStepReportStructure add3fields(WebDriver driver, int stepID, String testName) throws Exception
	{
	
		
		try
		{
			
			Actions action=new Actions(driver);
			
			//ArrayList<String> fields = new ArrayList<String>()
					
			String[] fields = {null,null,null};		
			
			//fields[0] = driver.findElement(By.xpath("(//span[@class='slds-media__body']//span)[1]")).getText();
			
			//driver.findElement(By.xpath("(//span[@class='slds-media__body']//span)[1]")).click();
			
			int a = 0;
			
			//action.keyDown(Keys.CONTROL).build().perform();
			//action.keyDown(Keys.SHIFT).build().perform();
			
			for(int i = 1; i < 3; i++) {
				String s = String.valueOf(i);
				//fields[a] = driver.findElement(By.xpath("(//span[@class='slds-media__body']//span)["+s+"]")).getText();
				fields[a] = driver.findElement(By.xpath("(//div[@role='option'])["+s+"]")).getText();
				a++;
				//driver.findElement(By.xpath("(//span[@class='slds-media__body']//span)["+s+"]")).sendKeys(Keys.DOWN);
				action.keyDown(Keys.SHIFT).build().perform();
				driver.findElement(By.xpath("(//div[@role='option'])["+s+"]")).sendKeys(Keys.DOWN);
				action.keyUp(Keys.SHIFT).build().perform();
				if(fields[2] != driver.findElement(By.xpath("(//div[@role='option'])[3]")).getText()) {fields[2] = driver.findElement(By.xpath("(//div[@role='option'])[3]")).getText();}
			}
			
			//action.keyUp(Keys.CONTROL).build().perform();
			//action.keyUp(Keys.SHIFT).build().perform();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//div[@role='option'])[3]")).sendKeys(Keys.TAB, Keys.RETURN);
			//driver.findElement(By.xpath(SalesForceOrders.addButtonField)).click();
			
			//driver.findElement(By.xpath(SalesForceOrders.cancelSubmitterContactField)).click();
			for(int b = 0; b < 3; b++) {
			System.out.println(fields[b]);
			}
			
			driver.findElement(By.xpath("(//div[@role='option'])[3]")).sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.RETURN);
			//for(int c = 2) {}
			//String activeFields = driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/thead[1]/tr[1]/th[]/div[1]/a[1]")).getText();
			
			
			
			//driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			//driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			
			//if(BrowserActions.isElementPresent(driver, SalesForceOrders.firstFieldAdded) && BrowserActions.isElementPresent(driver, SalesForceOrders.secondFieldAdded) && BrowserActions.isElementPresent(driver, SalesForceOrders.thirdFieldAdded))
			if(driver.findElement(By.linkText(fields[0])).isDisplayed() && driver.findElement(By.linkText(fields[1])).isDisplayed()  && driver.findElement(By.linkText(fields[2])).isDisplayed() )
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_add3fields");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Add 3 Fields", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_add3fields");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Add 3 Fields");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_add3fields");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Add 3 Fields", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_add3fields");
			return nav2ComDet;
		}
		
		
	}
	
	public static TestStepReportStructure remove3fields(WebDriver driver, int stepID, String testName) throws Exception
	{
						
		String ordersListURL = TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "ordersList"));
		
		String companyName=TestData.tdCompanyName(testName);
		
		try
		{
			
			Actions action=new Actions(driver);
			/*driver.findElement(By.xpath("//span[text()='Visible Fields']/following-sibling::div")).click();
			action.keyDown(Keys.CONTROL).build().perform();
			driver.findElement(By.xpath("//span[text()='Visible Fields']/following-sibling::div")).sendKeys(Keys.END);
			action.keyUp(Keys.CONTROL).build().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
			action.keyDown(Keys.CONTROL).build().perform();
			driver.findElement(By.xpath("(//span[@title='Order Type'])[2]")).click();
			driver.findElement(By.xpath("(//span[@title='Created By'])[2]")).click();
			driver.findElement(By.xpath("(//span[@title='Owner Alias'])[2]")).click();
			action.keyUp(Keys.CONTROL).build().perform();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath(SalesForceOrders.removeButtonField)).click();
			
			driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			
			Thread.sleep(2000);
			
			if(BrowserActions.isElementPresent(driver, "(//span[@title='Order Type'])[2]") && BrowserActions.isElementPresent(driver, "(//span[@title='Created By'])[2]") && BrowserActions.isElementPresent(driver, "(//span[@title='Owner Alias'])[2]"))
			{
				//throw new Exception("Test Failed on Step: "+stepID+" - Remove 3 Fields");
				ExecStructure.screenShotTaking(driver, testName, stepID+"_remove3fields");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Remove 3 Fields", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_remove3fields");
				return nav2ComDet;
			}
			
			else
			{
				//throw new Exception("Test Failed on Step: "+stepID+" - Remove 3 Fields");
				ExecStructure.screenShotTaking(driver, testName, stepID+"_remove3fields");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Remove 3 Fields", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_remove3fields");
				return nav2ComDet;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_remove3fields");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Remove 3 Fields", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_remove3fields");
			return nav2ComDet;
		}
		
		
	}
	
	public static TestStepReportStructure moveField(WebDriver driver, int stepID, String testName) throws Exception
	{
						
		String ordersListURL = TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "ordersList"));
		
		String companyName=TestData.tdCompanyName(testName);
		
		try
		{
			
			driver.findElement(By.xpath("//*[contains(@id,'selected-list-')]/li[3]/div[1]/span[1]/span[1]")).click();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			for(int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//button[@title='Move selection down']")).click();
			}
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			
			Thread.sleep(2000);
			
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.validateMyOrders))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_navigate2SelectFields");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to Select Fields to Display");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_navigate2SelectFields");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to Select Fields to Display", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_navigate2SelectFields");
			return nav2ComDet;
		}
		
		
	}
	
	public static TestStepReportStructure navigate2AllOrders(WebDriver driver, int stepID, String testName) throws Exception
	{
		
		try
		{
			
			//driver.findElement(By.xpath(SalesForceOrders.ordersListView)).click();
			
			driver.get(TestData.allOrdersURL);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//driver.findElement(By.xpath(SalesForceOrders.allOrdersOption)).click();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.validateAllOrders))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOders");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOders");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to My Orders");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2MyOrders");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to My Orders", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2MyOrders");
			return nav2ComDet;
		}
		
		
	}

	public static TestStepReportStructure navigate2SelectOrder(WebDriver driver, int stepID, String testName, String orderSelect) throws Exception
	{
						
		
		
		try
		{
			
			driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr["+orderSelect+"]/th[1]/span[1]/a[1]")).click();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.addServiceButton) && BrowserActions.isElementPresent(driver, SalesForceOrders.submitOrderButton))
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2SelectOrder");
				TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to an order", "Validation with success", "Validated with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2SelectOrder");
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to an order");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, stepID+"_Navigate2SelectOrder");
			TestStepReportStructure nav2ComDet = new TestStepReportStructure(stepID, "Navigation to an order", "Validation with success", "Not possible to validate", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_Navigate2SelectOrder");
			return nav2ComDet;
		}
		
		
	}
	

}
