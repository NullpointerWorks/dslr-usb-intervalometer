package com.nullpointerworks.intervalometer.control;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.nullpointerworks.intervalometer.control.interfaces.ActionCommand;
import com.nullpointerworks.intervalometer.model.ProfileManager;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.swing.FileTypeFilter;

public class LoadProfileCommand implements ActionCommand 
{
	private ApplicationView vWindow;
	private ProfileManager mProfileManager;
	private final FileFilter xmlFilter;
	
	public LoadProfileCommand(ApplicationView v, ProfileManager pm)
	{
		vWindow = v;
		mProfileManager = pm;
		xmlFilter = new FileTypeFilter(".xml", "Extensible Markup Language");
	}
	
	@Override
	public void onCommand() 
	{
		JFileChooser chooser = new JFileChooser();
		chooser.addChoosableFileFilter(xmlFilter);
		chooser.setCurrentDirectory(new File("."));
		
		int option = chooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) 
		{
			System.out.println( chooser.getSelectedFile() );
			
			
			
			
			
			
	    }
		
		
		
		
	}
}
