package testLogBuilder;

public class TestLog {
	
	String timeOfTheLog;
	String signOfTheLog;
	String componentOfTheLog;
	String messageOfTheLog;
	
	public TestLog(String timeOfTheLog, String signOfTheLog, String componentOfTheLog, String messageOfTheLog)
	{
		this.timeOfTheLog=timeOfTheLog;
		this.signOfTheLog=signOfTheLog;
		this.componentOfTheLog=componentOfTheLog;
		this.messageOfTheLog=messageOfTheLog;
	}
	
	public String getTimeOfTheLog()
	{
		return timeOfTheLog;
	}
	
	public String getSignOfTheLog()
	{
		return signOfTheLog;
	}
	
	public String getComponentOfTheLog()
	{
		return componentOfTheLog;
	}
	
	public String getMessageOfTheLog()
	{
		return messageOfTheLog;
	}

}
