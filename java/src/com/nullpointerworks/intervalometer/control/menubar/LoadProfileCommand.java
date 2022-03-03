package com.nullpointerworks.intervalometer.control.menubar;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.control.interfaces.Command;
import com.nullpointerworks.intervalometer.model.profile.IntervalProfile;
import com.nullpointerworks.intervalometer.model.profile.ProfileIO;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;
import com.nullpointerworks.intervalometer.model.profile.XMLProfileIO;
import com.nullpointerworks.intervalometer.util.PathBuilder;
import com.nullpointerworks.intervalometer.view.swing.FileTypeFilter;

public class LoadProfileCommand implements ActionCommand 
{
	private Command cShowProfileCommand;
	private ProfileManager mProfileManager;
	private final FileFilter xmlFilter;
	
	public LoadProfileCommand(Command spc, ProfileManager pm)
	{
		cShowProfileCommand = spc;
		mProfileManager = pm;
		xmlFilter = new FileTypeFilter(".xml", "Extensible Markup Language");
	}
	
	@Override
	public void onCommand() 
	{
		JFileChooser chooser = new JFileChooser();
		chooser.addChoosableFileFilter(xmlFilter);
		chooser.setCurrentDirectory(new File("."));
		
		int option = chooser.showOpenDialog(null);
		if (option != JFileChooser.APPROVE_OPTION) return;
		
		var path = chooser.getSelectedFile();
		PathBuilder filePath = new PathBuilder(path.getAbsolutePath());
		
		IntervalProfile profile = new IntervalProfile(true);
		profile.setPath( filePath.getAbsolutePath() );
		
		ProfileIO builder = new XMLProfileIO();
		if (!builder.read(profile, filePath))
		{
			// show read error
			return;
		}
		
		mProfileManager.setStoredProfile(profile);
		
		
		cShowProfileCommand.onCommand();
	}
}
