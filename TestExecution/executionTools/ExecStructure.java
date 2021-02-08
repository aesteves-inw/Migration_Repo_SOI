package executionTools;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExecStructure {
		
		
		//Working Space
		public static String workingDir = System.getProperty("user.dir");
		
		//Test Runs Repository
		public static String testRunsBasket = workingDir+"\\TestRunsBasket";
		
		//Formatted Date
		public static String todaysDate = formattedDate("yyyy-MM-dd");
		
		
		//Functions to Date Manipulation
		public static String formattedDate(String format) {
			Date myDate = new Date();
			DateFormat df = new SimpleDateFormat(format);
			String str = df.format(myDate);

			return str;

		}
		
		public static String todaysformattedDateddMMMyyyy()
		{
			String finaldate;
			
			String day= formattedDate("dd");
			String month=formattedDate("MMM");
			String year=formattedDate("yyyy");
			
			String monthOutput= month.substring(0, 1).toUpperCase()+month.substring(1);
			
			
			finaldate=day+"-"+monthOutput+"-"+year;
			
			
			return finaldate;
		}
		
		public static String tomorrowFormattedDate() 
		{
			String finalDate;
			
			LocalDate todayDate, tomorrowDate;
			
			todayDate = LocalDate.now();
			
			tomorrowDate=todayDate.plusDays(1);
			
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			finalDate = myFormatObj.format(tomorrowDate);
			

			return finalDate;

		}
		
		
		// Function for Directory creation
		public static void createDirectoryIfNeeded(String directoryName)
		{
			File theDir = new File(directoryName); 

			if (!theDir.exists()) {
				theDir.mkdirs();
				System.out.println("Directory created: "+directoryName);
			}
			
		}
		
		// Function for counting Sub-Directories inside a Directory
		public static int numberOfSubFolders(String Folder) {
			
			File dir = new File(Folder);
			int numberSubfolders = 0;
			File listDir[] = dir.listFiles();
			for (int i = 0; i < listDir.length; i++) {
			    if (listDir[i].isDirectory()) {
			            numberSubfolders++;
			        }
			}
			
			return numberSubfolders;
		}
		
		// Function for building a Test Folder Path
		public static String testFolder(String testName) {
			String tf =  testRunsBasket+"\\"+todaysDate+"\\"+testName;
			return tf;
		}
		
		// Function for building a Test Case Execution Folder
		public static String newTestExecutionFolder(String testName) {
			
			String testCaseFolder = testFolder(testName);		
			Integer execNumber = numberOfSubFolders(testCaseFolder)+1;
			String newExecutionFolderString = testFolder(testName)+"\\"+"Execution_"+execNumber.toString();
			
			return newExecutionFolderString;
		}
		
		// Function for getting the current Test Case Folder Execution
		public static String currentTestExecutionFolder(String testName) {
				
				String testCaseFolder = testFolder(testName);		
				Integer execNumber = numberOfSubFolders(testCaseFolder);
				String currentTestExecutionFolder = testFolder(testName)+"\\"+"Execution_"+execNumber.toString();
				
				return currentTestExecutionFolder;
			}
		
		// Function for creating a new Folder inside the Execution Folder for keeping Screenshots
		public static String testExecutionScreenshotsFolder(String testName) {
			
			String archiveFolder = currentTestExecutionFolder(testName);
			String archiveFolderScreenShots = archiveFolder+"\\ScreenShots";
			createDirectoryIfNeeded(archiveFolderScreenShots);
			
			return archiveFolderScreenShots;
			
			
		}
		
		// Function to create all Folder structure related to the Test Case
		public static void createReportStructure(String testName) 
		{
			createDirectoryIfNeeded(testRunsBasket);
			createDirectoryIfNeeded(testRunsBasket+"\\"+todaysDate);
			createDirectoryIfNeeded(testFolder(testName));
			createDirectoryIfNeeded(newTestExecutionFolder(testName));
		}

		//Function to retrieve Test Execution String from classname
		public static String getTestExecutionString(String testClassName)
		{
			String finalTestExecutionString;
			
			String[] fstDecompName=testClassName.split("_");
			
			/*
			if(fstDecompName[3].equals("PC") || fstDecompName[3].equals("DS"))
			{
				finalTestExecutionString=fstDecompName[0]+"_"+fstDecompName[1]+"_"+fstDecompName[2]+"_"+fstDecompName[3];
			}
			else
			{
				finalTestExecutionString=fstDecompName[0]+"_"+fstDecompName[1]+"_"+fstDecompName[2];
			}
			*/
			
			finalTestExecutionString=fstDecompName[0]+"_"+fstDecompName[1]+"_"+fstDecompName[2]+"_Ex"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testClassName))+"_"+ExecStructure.formattedDate("yyyyMMdd");
			
			return finalTestExecutionString;
			
		}

		
		//Function to Move Files from one Folder To Another. Params: fileName, originPath, finalPath
		public static void moveFile(String fileName, String originPath, String finalPath)
		{
			String currentFileLocation=originPath+"\\"+fileName;
			String finalFileLocation=finalPath+"\\"+fileName;
			
			File file = new File(currentFileLocation);
			
			file.renameTo(new File(finalFileLocation));
			
			file.delete();
			
		}

}



