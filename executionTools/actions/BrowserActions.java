package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserActions {
	
	public static boolean isElementPresent(WebDriver driver, String webObject)
	{
		return driver.findElements(By.xpath(webObject)).size() > 0;
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

	//Elements atributes 
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

	// Wait for Element
	public static void explicitWait(WebDriver driver, String elementXpath) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));		
	}

	public static void endSession(WebDriver driver)
	{
				
		if (driver != null)
		{
			driver.close();
			driver.quit();
		}

	}

}
