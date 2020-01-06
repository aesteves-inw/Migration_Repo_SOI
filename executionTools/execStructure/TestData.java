package execStructure;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import execStructure.*;

public class TestData {
	
	//Chrome Configs
		public static String ChromeDriverPath = ExecStructure.workingDir+"\\lib\\chromedriver.exe";
		
		/*
		public static String ChromeProfilePath = "C:\\Users\\andre.esteves\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
		public static String CHROME_EXTENSION2SALESFORCE_PATH = "C:\\Users\\andre.esteves\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\nnlnikmkkbpgioojghgojoejgcheilic\\0.0.1_0";
		*/
		
		public static String ChromeProfilePath = "C:\\Users\\luis.achas\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
		
		
		
	public static String searchDT(int indexOftheSheet, String val2Search) throws Exception
	{
		String testDataFileID=ExecStructure.workingDir+"\\testData\\testData.xlsx";
		
		DataFormatter formatter = new DataFormatter();
			
		String val2Return=null;
		
		FileInputStream file;
		
		file = new FileInputStream(new File(testDataFileID));
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(indexOftheSheet);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row1 = rowIterator.next();
			String val2Validate = formatter.formatCellValue(row1.getCell(0));
			if (val2Validate.equalsIgnoreCase(val2Search))
			{  
				val2Return=row1.getCell(1).getStringCellValue();
			}
		}
		
		file.close();
		return val2Return;
	} 
	
	public static String tdCompanyName(String testName) throws Exception
	{		
		
		String tdCompanyName;
		
		if(testName.contains("66"))
		{
			tdCompanyName=searchDT(2,"testingCompanySOI66");
		}
		else if(testName.contains("68"))
		{
			tdCompanyName= searchDT(2,"testingCompanySOI68");
		}
		else if(testName.contains("70"))
		{
			tdCompanyName= searchDT(2,"testingCompanySOI70");
		}
		else
		{
			throw new Exception("Not possible to identify Test Case");
		}
		
		return tdCompanyName;
		
	}
	
	public static String tdCompanyID(String testName) throws Exception
	{
		String tdCompanyID;
		
		if(testName.contains("66"))
		{
			tdCompanyID=searchDT(2,"idTestingCompanySOI66");
		}
		else if(testName.contains("68"))
		{
			tdCompanyID= searchDT(2,"idTestingCompanySOI68");
		}
		else if(testName.contains("70"))
		{
			tdCompanyID= searchDT(2,"idTestingCompanySOI70");
		}
		else
		{
			throw new Exception("Not possible to identify Test Case");
		}
		
		return tdCompanyID;
	}
	
	public static int tcDataindex(int tcNumber) throws Exception
	{
		int tcindex;
		
		// add more 
		switch(tcNumber)
		{
		case 1:
			tcindex = 3;
			break;
		case 2:
			tcindex = 4;
			break;
		case 3:
			tcindex = 5;
			break;
		default:
			throw new Exception("Not possible to identify Test Case");
		}
		
		return tcindex;
	}

	public static String[] prodConfiguration(int tcNumber) throws Exception
	{
		String[] pConfig = {TestData.searchDT(tcDataindex(tcNumber), "productContractValue"), TestData.searchDT(tcDataindex(tcNumber), "productContractDuration"), TestData.searchDT(tcDataindex(tcNumber), "productRevenueType"), TestData.searchDT(tcDataindex(tcNumber), "productProductRegime")};
		return pConfig;
	}




}
