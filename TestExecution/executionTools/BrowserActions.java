package executionTools;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserActions {

	//Navigation by URL
	public static void goToByURL(WebDriver driver, String url)
	{
		driver.get(url);

		//07-12-2020 - To review after
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}



	//URL Manipulation
	public static String getRecordIDByURL(WebDriver driver)
	{
		String optyRecordID;

		String OPTYURL=driver.getCurrentUrl();

		String[] arrOfOPTYURL=OPTYURL.split("/");

		optyRecordID=arrOfOPTYURL[6];

		return optyRecordID;
	}



	//Browser Actions
	public static void refreshPage(WebDriver driver)
	{
		driver.navigate().refresh();

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	}

	public static void waitUntilElementFade(WebDriver driver, String xpath) throws Exception
	{

		for(int i=0;i<10;i++)
		{
			if(BrowserActions.isElementPresent(driver, xpath)==true)
			{
				Thread.sleep(1000);
			}
			else
			{
				break;
			}
		}

	}

	public static void jsClickByXpath(WebDriver driver, String xpath)
	{
		WebElement element = driver.findElement(By.xpath(xpath));

		jsClick(driver, element);
	}

	public static void jsClick(WebDriver driver, By locator) 
	{
		jsClick(driver, driver.findElement(locator));
	}

	public static void jsClick(WebDriver driver, WebElement elem) 
	{
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].click();", elem
				);
		try { Thread.sleep(1000L); }
		catch (InterruptedException ie) { ; /* ignore */ }
	}



	// Function to Take Screen Shots from WebDriver
	public static void screenShotTaking(WebDriver driver, String TestName, String shotName) throws IOException 
	{

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(ExecStructure.testExecutionScreenshotsFolder(TestName)+"\\"+shotName+".png"));
		System.out.println("ScreenShot Taken - Location: "+ExecStructure.testExecutionScreenshotsFolder(TestName)+"\\"+shotName+".png");

	}




	//Elements validation
	public static boolean isElementPresent(WebDriver driver, String webObject)
	{
		return driver.findElements(By.xpath(webObject)).size() > 0;
	}

	public static WebElement expandRootElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = (WebElement) (js).executeScript("return arguments[0].shadowRoot",element);
		return ele;
	}

	public static boolean isElementPresent(WebDriver driver, String value, String webObject) throws Exception
	{
		switch(value)
		{
		case "xpath":
			return driver.findElements(By.xpath(webObject)).size() > 0;
		case "linkText":
			return driver.findElements(By.linkText(webObject)).size() > 0;
		case "partialLinkText":
			return driver.findElements(By.partialLinkText(webObject)).size() > 0;
		default:
			throw new Exception("Please specify the value of the WebObject you want to validate. Received: "+value); 
		}
	}

	public static boolean isClickable(WebDriver driver, WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);

			wait.until(ExpectedConditions.elementToBeClickable(element));

			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}

	}

	public static boolean isJSElementPresent(WebDriver driver, String jsElement) throws Exception
	{

		WebElement element = getElementByJSQuery(driver, jsElement);

		if (element == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}




	//Elements attributes 
	public static int getXOfElement(WebDriver driver, String WebObject) throws Exception
	{
		try
		{
			WebElement element = driver.findElement(By.xpath(WebObject));
			Point elementToValidate = element.getLocation();
			int xCoordinateOfElement = elementToValidate.getX();
			return xCoordinateOfElement;
		}
		catch(Exception e)
		{
			throw new Exception("Not possible to find the element by the following Xpath: "+WebObject); 
		}
	}

	public static int getYOfElement(WebDriver driver, String WebObject) throws Exception
	{
		try
		{
			WebElement element = driver.findElement(By.xpath(WebObject));
			Point elementToValidate = element.getLocation();
			int xCoordinateOfElement = elementToValidate.getY();
			return xCoordinateOfElement;
		}
		catch(Exception e)
		{
			throw new Exception("Not possible to find the element by the following Xpath: "+WebObject); 
		}
	}



	// Elements Manipulation
	public WebElement getElementbyXpath(WebDriver driver, String attribute, String nameOfSalesforceComponent)
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(@"+attribute+", '"+nameOfSalesforceComponent+"')]"));
		return element;
	}

	public static WebElement getElementByJSQuery(WebDriver driver, String queryToExec) throws Exception
	{
		try
		{
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			WebElement element = (WebElement) jsExecutor.executeScript(queryToExec);


			return element;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("getElementByJSQuery: Not possible to locate element: "+queryToExec,e);
		}

	}



	// Scrolls
	public static void verticalscrollByVisibleElement(WebDriver driver, String webObject) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(webObject)));
	}

	public static void verticalScrollByPixs(WebDriver driver, int pixeisNumber)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+pixeisNumber+")");
	}

	public static void ScrollByPixs(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

	public static void ScrollByElement(WebDriver driver, String value, String webObject) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		switch(value)
		{
		case "xpath":
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(webObject)));
			break;
		case "linkText":
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText(webObject)));
			break;
		case "partialLinkText":
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.partialLinkText(webObject)));
			break;
		default:
			throw new Exception("Please specify the value of the WebObject you want to validate. Received: "+value); 
		}
	}

	public static void scroll2Bottom(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}



	// End of Session
	public static void endSession(WebDriver driver) 
	{

		if (driver != null)
		{
			driver.close();
			
			driver.quit();
		}

		/*try
		{
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

	}



	//PDF Validation
	public static boolean pdfPositiveValidation(String fileLocation, String textToValidate) throws Exception
	{
		int Counter=0; 

		File file = new File(fileLocation);

		PDDocument document = PDDocument.load(file);

		PDFTextStripper pdfStripper = new PDFTextStripper();

		String text = pdfStripper.getText(document);

		if(text.contains(textToValidate))
		{
			Counter++;
		}

		if(Counter>0)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public static boolean pdfNegativeValidation(String fileLocation, String textToValidate) throws Exception
	{
		int Counter=0; 

		File file = new File(fileLocation);

		PDDocument document = PDDocument.load(file);

		PDFTextStripper pdfStripper = new PDFTextStripper();

		String text = pdfStripper.getText(document);

		if(text.contains(textToValidate))
		{
			Counter++;
		}

		if(Counter==0)
		{
			return true;
		}
		else
		{
			return false;
		}

	}




}
