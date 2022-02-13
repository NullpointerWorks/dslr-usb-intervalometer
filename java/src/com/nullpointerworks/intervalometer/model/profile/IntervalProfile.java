package com.nullpointerworks.intervalometer.model.profile;

public class IntervalProfile 
{
	private boolean isFromFile;
	private boolean isChanged;
	private String profileName;

	private String profilePath;
	
	public IntervalProfile(boolean fromFile, String name)
	{
		isFromFile = fromFile;
		isChanged = true;
		profileName = name;
		
		profilePath = "/UnnamedProfile.xml";
	}
	
	
	
}
