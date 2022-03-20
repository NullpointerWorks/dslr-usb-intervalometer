package com.nullpointerworks.intervalometer.control.menubar;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.profile.ProfileIO;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;
import com.nullpointerworks.intervalometer.model.profile.XMLProfileIO;
import com.nullpointerworks.intervalometer.util.PathBuilder;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.swing.FileTypeFilter;

public class SaveProfileCommand implements ActionCommand 
{
	private ApplicationView vWindow;
	private ProfileManager mProfileManager;
	private final FileFilter xmlFilter;
	
	public SaveProfileCommand(ApplicationView v, ProfileManager pm)
	{
		vWindow = v;
		mProfileManager = pm;
		xmlFilter = new FileTypeFilter(".xml", "Extensible Markup Language");
	}
	
	@Override
	public void onCommand() 
	{
		if (!mProfileManager.hasProfile())
		{
			// no profile to save
			return;
		}
		
		PathBuilder filePath = null;
		var profile = mProfileManager.getStoredProfile();
		if (!profile.isFromFile())
		{
			JFileChooser chooser = new JFileChooser();
			chooser.addChoosableFileFilter(xmlFilter);
			chooser.setCurrentDirectory(new File("."));
			int option = chooser.showSaveDialog(null);
			if (option == JFileChooser.APPROVE_OPTION) 
			{
				var path = chooser.getSelectedFile();
				filePath = new PathBuilder(path.getAbsolutePath());
				profile.setPath(filePath.getAbsolutePath());
		    }
			else
			{
				return;
			}
		}
		else
		{
			filePath = new PathBuilder(profile.getPath());
		}
		
		ProfileIO builder = new XMLProfileIO();
		if (builder.write(profile, filePath))
		{
			
			vWindow.setDisplayTabTitle(profile.getProfileName());
			vWindow.setSaveAsEnabled(true);
		}
		else
		{
			// error TODO
		}
	}
}
