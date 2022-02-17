package com.nullpointerworks.intervalometer.model.profile;

public class IntervalProfile 
{
	private boolean isFromFile;
	private boolean isChanged;
	private String profilePath;

	private String profileName;
	private String profileNotes;
	
	
	public IntervalProfile(boolean fromFile)
	{
		isFromFile = fromFile;
		isChanged = true;
		profileName = "Unnamed Profile";
		profilePath = "";
	}

	public boolean isFromFile() {return isFromFile;}
	public boolean isChanged() {return isChanged;}

	public String getPath() 
	{
		return profilePath;
	}
	
	
	
	
	
	
}
