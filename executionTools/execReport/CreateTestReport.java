package execReport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import execStructure.ExecStructure;

public class CreateTestReport {
	public CreateTestReport(List<TestStepReportStructure> testReport, TestReportHeaderStructure testHeader, List<TestReportTestData> testData){
		
		try {
	        
	        StringBuilder htmlSB = new StringBuilder();
	        
	        htmlSB.append("<!DOCTYPE html>");
	        
	        htmlSB.append("<html><head><title>"+testHeader.getTestName()+"</title></head>");
	       
	        htmlSB.append("<style>");
	        
	        htmlSB.append("body{font-family: Calibri;}");
	               
			htmlSB.append("h2{text-align: center; font-size: 30; margin-left: auto; margin-right: auto;}");
	        
			htmlSB.append("div.testreport{background-color: white; color: black; width: 85%; text-align: justify; margin-left: auto; margin-right: auto; border: 1px solid black; padding: 5px; line-height: 1.5;}");
			
			htmlSB.append("td.reportheader{width: 50%}");
			
			htmlSB.append("table{width: 85%;}");
	        
			htmlSB.append("table, th, td {border:1px solid black;text-align: center;}");
	        
			htmlSB.append("td.passed{color:green; font-weight: bold;}");
	        
			htmlSB.append("td.failed{color: red;font-weight: bold;}");
			
	        htmlSB.append("</style>");
			
	        htmlSB.append("<body>");
			
	        htmlSB.append("<br><br><br>");
			
	        htmlSB.append("<div class=\"testreport\">");
			
	        htmlSB.append("<h2> Test Execution Report</h2>");
	        
	        htmlSB.append("<table align=\"center\" border=\"1\" bordercolor=\"#000000\">");
	        
	        htmlSB.append("<caption><h3>Execution Information</h3></caption>");
	        
	        htmlSB.append("<tr><td class=\"reportheader\">");
			
	        htmlSB.append("<p><b>Test Name: </b>"+testHeader.getTestName()+"</p>");
			
	        htmlSB.append("<p><b>Execution Date: </b>"+ExecStructure.formattedDate("dd-MM-YYYY")+"</p>");
			
	        htmlSB.append("<p><b>Execution ID: </b>"+ExecStructure.numberOfSubFolders(ExecStructure.testFolder(testHeader.getTestName()))+"</p>");
	        
	        htmlSB.append("<p><b>Test Status: </b>"+ReportStructure.testFinalStatus(testReport)+"</p>");
	        
	        htmlSB.append("</td><td class=\"reportheader\">");
	        
	        htmlSB.append("<p><b>Start Date: </b>"+testHeader.getInitialTestDate()+"</p>");
	        
	        htmlSB.append("<p><b>Finish Date: </b>"+testHeader.getFinalTestDate()+"</p>");
	        
	        htmlSB.append("<p><b>Duration: </b>"+ReportStructure.timeConversion(ReportStructure.estimatedDuration(testHeader.getStartTime(), testHeader.getFinishTime()))+"</p>");
	        
	        htmlSB.append("<p><b>Steps Executed: </b>"+testHeader.getStepsExecuted()+"</p>");
	        
	        htmlSB.append("</td></tr></table><br>");
	        
	        htmlSB.append("<table align=\"center\" border=\"1\" bordercolor=\"#000000\">");
	        
	        htmlSB.append("<caption><h3>Test Data Information</h3></caption>");
	        
	        htmlSB.append("<tr><td><b>Object Type</b></td><td><b>Object Name</b></td><td><b>Object Information</b></td><td><b>Object Additional Information</b></td></tr>");
	        
	        for(TestReportTestData td: testData)
	        {
	        	htmlSB.append("<tr><td>"+td.getObjectType()+"</td><td>"+td.getObjectName()+"</td><td>"+td.getObjectInfo()+"</td><td>");
	        	
	        	if (td.getObjectInfo() == "URL")
	        	{
	        		htmlSB.append("<a href="+td.getObjectAdditional()+">"+td.getObjectAdditional()+"<a>");
	        	}
	        	else
	        	{
	        		htmlSB.append(td.getObjectAdditional());
	        	}
	        	
	        	htmlSB.append("</td></tr>");
	        }
	        
	        htmlSB.append("</td></tr></table><br>");
	        	            
	        htmlSB.append("<table align=\"center\" border=\"1\" bordercolor=\"#000000\">");
	        
	        htmlSB.append("<caption><h3>Test Procedure Information</h3></caption>");
	        
	        htmlSB.append("<tr><td><b>Step ID</b></td><td><b>Description</b></td><td><b>Expected Outcome</b></td><td><b>Actual Outcome</b></td><td><b>Step Status</b></td><td><b>TimeStamp</b></td><td><b>Evidence Name</b></td></tr>");
	        
	        for(TestStepReportStructure ts : testReport) {
	        	htmlSB.append("<tr><td>"+ts.getRepStepID()+"</td><td>"+ts.getStepDescription()+"</td><td>"+ts.getExpectedOutcome()+"</td><td>"+ts.getActualOutcome()+"</td>");
	        	
	        	if (ts.getStepStatus().equalsIgnoreCase("passed")) 
	        	{
	        		htmlSB.append("<td class=\"passed\">"+ts.getStepStatus());
	        	}
	        	else 
	        	{
	        			htmlSB.append("<td class=\"failed\">"+ts.getStepStatus());
	        	}
	        	
	        	
		        	htmlSB.append("</td><td>"+ts.getTimeStamp()+"</td>");
		        	htmlSB.append("<td><a href=\"./ScreenShots/"+ts.getScreenshotName()+".png\">"+ts.getScreenshotName()+"</a></td></tr>");
		        }
		        
		        
		        htmlSB.append("</table></body></html>");
		        
		        WriteToFile(htmlSB.toString(),"testExecutionReport.html", testHeader.getTestName());
		   
			
				}catch(Exception e) {
					System.out.println(e);
				}
					
				}
		

	public static void WriteToFile(String fileContent, String fileName, String testName) throws IOException {
				        String executionPath = ExecStructure.currentTestExecutionFolder(testName);
				        String tempFile = executionPath + File.separator+fileName;
				        File file = new File(tempFile);
				        // if file does exists, then delete and create a new file
				        if (file.exists()) {
				            try {
				                File newFileName = new File(executionPath + File.separator+ "backup_"+fileName);
				                file.renameTo(newFileName);
				                file.createNewFile();
				            } catch (IOException e) {
				                e.printStackTrace();
				            }
				        }
				        //write to file with OutputStreamWriter
				        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
				        Writer writer=new OutputStreamWriter(outputStream);
				        writer.write(fileContent);
				        writer.close();
				
				    }

	}



