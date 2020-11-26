package testReportComposition;

public class TestReportTestData {
	
	//Test Data Elements
	
	String objectType;
	String objectName;
	String objectInfo;
	String objectAdditional;
	
	public TestReportTestData(String objectType, String objectName, String objectInfo, String objectAdditional)
	{
		this.objectType=objectType;
		this.objectName=objectName;
		this.objectInfo=objectInfo;
		this.objectAdditional=objectAdditional;
	}
	
	public String getObjectType()
	{
		return objectType;
	}
	
	public String getObjectName()
	{
		return objectName;
	}
	
	public String getObjectInfo()
	{
		return objectInfo;
	}

	public String getObjectAdditional()
	{
		return objectAdditional;
	}


}
