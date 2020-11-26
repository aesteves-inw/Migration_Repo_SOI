package testReportComposition;

public class TestReportHeaderStructure {

	//Report Header Elements
	String testName;
	String initialTestDate;
	String finalTestDate;
	long startTime;
	long finishTime;
	int stepsExecuted;


	//Constructor for Test Header Object
	public TestReportHeaderStructure(String testName, String initialTestDate, String finalTestDate, long startTime, long finishTime, int stepsExecuted)
	{
		this.testName=testName;
		this.initialTestDate=initialTestDate;
		this.finalTestDate=finalTestDate;
		this.startTime=startTime;
		this.finishTime=finishTime;
		this.stepsExecuted=stepsExecuted;

	}
	
	public String getTestName()
	{
		return testName;
	}
	
	public String getInitialTestDate()
	{
		return initialTestDate;
	}

	public String getFinalTestDate()
	{
		return finalTestDate;
	}

	public long getStartTime()
	{
		return startTime;
	}

	public long getFinishTime()
	{
		return finishTime;
	}

	public int getStepsExecuted()
	{
		return stepsExecuted;
	}
}

