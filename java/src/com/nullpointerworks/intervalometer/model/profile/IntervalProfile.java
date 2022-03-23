package com.nullpointerworks.intervalometer.model.profile;

public class IntervalProfile 
{
	private boolean isFromFile;
	private boolean isSaved;
	private String profilePath;
	
	private long startDelay;	
	private long exposureTime;	
	private long betweenDelay;	
	private long exposures;
	private String profileName;
	private String profileNotes;
	
	
	public IntervalProfile(boolean fromFile)
	{
		isSaved = isFromFile = fromFile;
		profilePath = "NewProfile.xml";
		
		// defaults
		profileName = "New Profile";
		startDelay = 5;
		exposureTime = 30;
		betweenDelay = 10;
		exposures = 999;
		profileNotes = "";
	}

	public boolean isFromFile() {return isFromFile;}
	public void isFromFile(boolean b) {isFromFile = b;}
	public boolean isSaved() {return isSaved;}
	public void setSaved(boolean b) {isSaved = b;}
	
	public void setPath(String path) {profilePath = path;}
	public String getPath() {return profilePath;}
	
	public void setProfileName(String pn) {profileName = pn;}
	public void setProfileNotes(String pn) {profileNotes = pn;}

	public String getProfileName() {return profileName;}
	public String getProfileNotes() {return profileNotes;}
	
	public void setStartDelay(long c) {startDelay = c;}
	public long getStartDelay() {return startDelay;}
	
	public void setExposureTime(long c) {exposureTime = c;}
	public long getExposureTime() {return exposureTime;}
	
	public void setBetweenDelay(long c) {betweenDelay = c;}
	public long getBetweenDelay() {return betweenDelay;}
	
	public void setExposures(long e) {exposures = e;}
	public long getExposures() {return exposures;}
}
