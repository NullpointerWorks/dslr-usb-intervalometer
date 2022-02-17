package com.nullpointerworks.intervalometer.model;

public class ProfileManager 
{
	private IntervalProfile stored = null;
	public synchronized void setStoredProfile(IntervalProfile pro) {stored = pro;}
	public synchronized IntervalProfile getStoredProfile() {return stored;}
	public synchronized void clearStoredProfile() {setStoredProfile(null);}
	public synchronized boolean hasProfile() {return stored != null;}
}
