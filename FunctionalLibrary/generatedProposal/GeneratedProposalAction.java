package generatedProposal;

import java.io.File;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;

import testDataFiles.TestDataFiles;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class GeneratedProposalAction 
{

	public static boolean validationOfNonQuotableProducts(List<TestLog> logStream, WebDriver driver, int stepID, String productName,String agreementID) throws Exception 
	{
		String actionName="validationOfNonQuotableProducts";
		
		int errorCounter=0;

		String proposalURL;
		
		String proposalFileName="AgreementSQ_EN - "+agreementID+".pdf";
		
		try
		{
			proposalURL = TestDataFiles.externalFilesRepository+"\\"+proposalFileName;

			File file = new File(proposalURL);

			PDDocument document = PDDocument.load(file);

			PDFTextStripper pdfStripper = new PDFTextStripper();

			String text = pdfStripper.getText(document);

			if(text.contains(productName))
			{
				errorCounter++;
			}
			
			document.close();
		
			if(errorCounter == 0)
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

	public static boolean validationOfQuotableProducts(List<TestLog> logStream, WebDriver driver, int stepID, String productName) throws Exception 
	{
		String actionName="validationOfNonQuotableProducts";
		
		int errorCounter=0;

		String proposalURL;
		
		try
		{
			proposalURL = driver.getCurrentUrl();

			File file = new File(proposalURL);

			PDDocument document = PDDocument.load(file);

			PDFTextStripper pdfStripper = new PDFTextStripper();

			String text = pdfStripper.getText(document);

			if(text.contains(productName))
			{
				errorCounter++;
			}
			
			document.close();
		
			if(errorCounter > 0)
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
	
	
}
