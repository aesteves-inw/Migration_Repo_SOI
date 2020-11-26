package testLogger;

import java.util.List;

import executionTools.ExecStructure;
import testLogBuilder.TestLog;

public class TestLogger

{
	
	public static void logInfo(List<TestLog> logStream, String componentOfTheLog, String messageOfTheLog)
	{
		String signOfTheLog = "INFO";
		
		String timeOfTheLog=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");
		
		logger(logStream, timeOfTheLog, signOfTheLog, componentOfTheLog, messageOfTheLog);
		
	}
	
	public static void logError(List<TestLog> logStream, String componentOfTheLog, String messageOfTheLog, String errorCaptured)
	{
		String signOfTheLog = "ERROR";
		
		String timeOfTheLog=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");
		
		String finalMessageOfTheLog=messageOfTheLog+" - "+errorCaptured;
		
		logger(logStream, timeOfTheLog, signOfTheLog, componentOfTheLog, finalMessageOfTheLog);
		
	}
	
	public static void logDebug(List<TestLog> logStream, String componentOfTheLog, String messageOfTheLog)
	{
		String signOfTheLog = "DEBUG";
		
		String timeOfTheLog=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");
		
		logger(logStream, timeOfTheLog, signOfTheLog, componentOfTheLog, messageOfTheLog);
				
	}
	
	public static void logTrace(List<TestLog> logStream, String componentOfTheLog, String messageOfTheLog)
	{
		
		String signOfTheLog = "TRACE";
		
		String timeOfTheLog=ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss");
		
		logger(logStream, timeOfTheLog, signOfTheLog, componentOfTheLog, messageOfTheLog);
		
		
	}

	
	
	private static void logger(List<TestLog> logStream, String timeOfTheLog, String signOfTheLog, String componentOfTheLog, String messageOfTheLog)
	{
		TestLog log=new TestLog(timeOfTheLog, signOfTheLog, componentOfTheLog, messageOfTheLog);
		
		logStream.add(log);
		
		System.out.println(log.getTimeOfTheLog()+" - "+signOfTheLog+" - "+componentOfTheLog+" - "+messageOfTheLog);
	}


}
