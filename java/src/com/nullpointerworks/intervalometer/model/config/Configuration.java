package com.nullpointerworks.intervalometer.model.config;

import java.util.List;

public interface Configuration 
{
	boolean getAudioAlarm();
	boolean getVisualAlarm();
	
	List<String> getRecentDevices();
	List<String> getRecentProfiles();
	
	void setRecentDevice(String sn);
	void setRecentProfile(String sn);
}
