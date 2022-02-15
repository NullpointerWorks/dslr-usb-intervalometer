package com.nullpointerworks.intervalometer.model.profile;

public class IntervalProfile 
{
	private boolean isFromFile;
	private boolean isChanged;
	private String profileName;
	
	private String profilePath;
	
	public IntervalProfile(boolean fromFile)
	{
		isFromFile = fromFile;
		isChanged = true;
		profileName = "UnnamedProfile";
		profilePath = "/UnnamedProfile.xml";
	}

	public boolean isFromFile() {return isFromFile;}
	public boolean isChanged() {return isChanged;}

	public String getPath() 
	{
		return profilePath;
	}
	
}
