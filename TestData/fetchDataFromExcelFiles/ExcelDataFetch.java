package fetchDataFromExcelFiles;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testDataFiles.TestDataFiles;

public class ExcelDataFetch {

	//Fetch Data

	public static String searchDT(int indexOftheSheet, String val2Search)
	{
		String testDataFileID=TestDataFiles.testDataFile;

		String testDataValue=searchExcel(testDataFileID, indexOftheSheet, val2Search);

		return testDataValue;

	}

	public static String searchExcel(String testDataFileID, int indexOftheSheet, String val2Search)
	{
		DataFormatter formatter = new DataFormatter();

		String val2Return=null;

		FileInputStream file;

		try {

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
				wb.close();
				file.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		return val2Return;
	}

}
