package com.nullpointerworks.intervalometer.control;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.model.profile.ProfileIO;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;
import com.nullpointerworks.intervalometer.model.profile.XMLProfileIO;
import com.nullpointerworks.intervalometer.util.PathBuilder;

public class AutoLoadCommand implements ActionCommand 
{
	private String profilePath;
	private ProfileManager mProfileManager;
	private Command cShowProfileCommand;
	
	public AutoLoadCommand(String pp, ProfileManager pm, Command spc)
	{
		profilePath = pp;
		mProfileManager = pm;
		cShowProfileCommand = spc;
	}
	
	@Override
	public void onCommand() 
	{
		if (mProfileManager.hasProfile())
		{
			// ask to save first TODO
			
			
			

			mProfileManager.setStoredProfile(null);
		}
		
		PathBuilder filePath = new PathBuilder(profilePath);
		
		IntervalProfile profile = new IntervalProfile(true);
		profile.setPath( filePath.getAbsolutePath() );
		
		ProfileIO builder = new XMLProfileIO();
		if (!builder.read(profile, filePath))
		{
			// show read error TODO
			return;
		}
		
		mProfileManager.setStoredProfile(profile);
		cShowProfileCommand.onCommand();
		
	}
}
