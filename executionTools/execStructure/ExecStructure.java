package execStructure;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ExecStructure {
		
		
		//Working Space
		public static String workingDir = System.getProperty("user.dir");
		
		//Test Runs Repository
		public static String testRunsBasket = workingDir+"\\TestRunsBasket";
		
		//Formatted Date
		public static String todaysDate = formattedDate("yyyy-MM-dd");
		
		//Function to Format Date
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
		
		// Function to create all Folder structure related to the Test Casae
		public static void createReportStructure(String testName) {
			createDirectoryIfNeeded(testRunsBasket);
			createDirectoryIfNeeded(testRunsBasket+"\\"+todaysDate);
			createDirectoryIfNeeded(testFolder(testName));
			createDirectoryIfNeeded(newTestExecutionFolder(testName));
			
		}
		
		// Function to Take Screen Shots from WebDriver
		public static void screenShotTaking(WebDriver driver, String TestName, String shotName) throws IOException {
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  	FileHandler.copy(scrFile, new File(ExecStructure.testExecutionScreenshotsFolder(TestName)+"\\"+shotName+".png"));
		  	System.out.println("ScreenShot Taken - Location: "+ExecStructure.testExecutionScreenshotsFolder(TestName)+"\\"+shotName+".png");
	    	
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

		


}



