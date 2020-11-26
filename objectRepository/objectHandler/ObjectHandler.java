package objectHandler;

import constants.Constants;
import executionTools.ExecStructure;
import fetchDataFromExcelFiles.ExcelDataFetch;

public class ObjectHandler {

	public static final String ObjectRepositoryFolder=ExecStructure.workingDir+"\\objectRepository";

	public static final String ObjectRepositoryFile=ObjectRepositoryFolder+"\\objectRepository.xlsx";



	public static int indexOfTestObject(String testObject)
	{
		int indexToReturn=0;

		switch(testObject.toLowerCase())
		{
		case"loginpage":
			indexToReturn=0;
			break;
		case"homepage":
			indexToReturn=1;
			break;
		case"company":
			indexToReturn=2;
			break;
		case"companycontactperson":
			indexToReturn=3;
			break;
		case"opportunity":
			indexToReturn=4;
			break;
		case"agreement":
			indexToReturn=5;
			break;
		case"order":
			indexToReturn=6;
			break;
		case"service":
			indexToReturn=7;
			break;
		case"case":
			indexToReturn=8;
			break;
		case"productbasket":
			indexToReturn=9;
			break;
		case"orderenrichment":
			indexToReturn=10;
			break;
		case"discountconsole":
			indexToReturn=11;
			break;
		case"editproductconfigurationscreen":
			indexToReturn=12;
			break;
		case"addoffertobasket":
			indexToReturn=13;
			break;
		default:
			//throw new Exception("Not possible to validate the Test Object. Please review mapping");
			System.out.println("Not possible to validate the Test Object. Please review mapping");
		}

		return indexToReturn;
	}

	public static String getObjectValue(String platform, String testObject, String testElement)
	{
		int indexOfObject=indexOfTestObject(testObject);
		
		String objectValue=null;

		if (platform.equalsIgnoreCase(Constants.directSales) || platform.equalsIgnoreCase(Constants.partnersCommunity))
		{
			String testObjectToSearch=platform+"_"+testElement;

			objectValue=ExcelDataFetch.searchExcel(ObjectRepositoryFile, indexOfObject, testObjectToSearch);

		}
		else
		{
			System.out.println("Not possible to retrieve the Salesforce Platform. Please review objectRepository File.");
			//throw new Exception("Not possible to retrieve the Salesforce Platform. Please review objectRepository File.");
		}
		
		return objectValue;
	}




	/*
	 * public static String getObjectValue(String testObject, String testElement) throws Exception
	{
		int indexOfObject=indexOfTestObject(testObject);

		String objectValue=ExcelDataFetch.searchExcel(ObjectRepositoryFile, indexOfObject, testElement);

		return objectValue;
	}
	 * */


}
