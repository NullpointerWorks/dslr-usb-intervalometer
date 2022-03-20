package com.nullpointerworks.intervalometer.control.menubar;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.config.Configuration;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.model.profile.ProfileIO;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;
import com.nullpointerworks.intervalometer.model.profile.XMLProfileIO;
import com.nullpointerworks.intervalometer.util.PathBuilder;
import com.nullpointerworks.intervalometer.view.swing.FileTypeFilter;

public class LoadProfileCommand implements ActionCommand 
{
	private ProfileManager mProfileManager;
	private final FileFilter xmlFilter;
	private Configuration mConfig;
	private Command cRefreshRecentProfiles;
	private Command cShowProfileCommand;
	private Command cSaveProfileCommand;
	
	public LoadProfileCommand(Command spc, Command rrp, Command csp, ProfileManager pm, Configuration cfg)
	{
		mProfileManager = pm;
		xmlFilter = new FileTypeFilter(".xml", "Extensible Markup Language");
		mConfig = cfg;
		cRefreshRecentProfiles = rrp;
		cShowProfileCommand = spc;
		cSaveProfileCommand = csp;
	}
	
	@Override
	public void onCommand() 
	{
		if (mProfileManager.hasProfile())
		if (!mProfileManager.getStoredProfile().isSaved())
		{
			int opt = JOptionPane.showConfirmDialog(null, "Would you like to save the current profile?", "Unsaved Profile", JOptionPane.OK_CANCEL_OPTION);
			if (opt == JOptionPane.OK_OPTION)
			{
				cSaveProfileCommand.onCommand();
			}
			mProfileManager.setStoredProfile(null);
		}
		
		JFileChooser chooser = new JFileChooser();
		chooser.addChoosableFileFilter(xmlFilter);
		chooser.setCurrentDirectory(new File("."));
		
		int option = chooser.showOpenDialog(null);
		if (option != JFileChooser.APPROVE_OPTION) return;
		
		File path = chooser.getSelectedFile();
		PathBuilder filePath = new PathBuilder(path.getAbsolutePath());
		
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
		mConfig.setRecentProfile( filePath.getAbsolutePath() );
		cRefreshRecentProfiles.onCommand();
	}
}
