package com.nullpointerworks.intervalometer.model;

public class IntervalProfile 
{
	private boolean isFromFile;
	private boolean isChanged;
	private String profilePath;
	
	private int startDelay;	
	private int exposureTime;	
	private int betweenDelay;	
	private int exposures;
	private String profileName;
	private String profileNotes;
	
	
	public IntervalProfile(boolean fromFile)
	{
		isFromFile = fromFile;
		isChanged = true;
		profilePath = "";
		
		// defaults
		profileName = "New Profile";
		startDelay = 5;
		exposureTime = 30;
		betweenDelay = 10;
		exposures = 999;
	}

	public boolean isFromFile() {return isFromFile;}
	public boolean isChanged() {return isChanged;}
	
	public void setPath(String path) {profilePath = path;}
	public String getPath() {return profilePath;}
	
	public void setProfileName(String pn) {profileName = pn;}
	public void setProfileNotes(String pn) {profileNotes = pn;}

	public String getProfileName() {return profileName;}
	public String getProfileNotes() {return profileNotes;}

	public void setStartDelay(int counter) {startDelay = counter;}
	public int getStartDelay() {return startDelay;}
	
	
	
	
}
