package com.nullpointerworks.intervalometer;

import com.nullpointerworks.intervalometer.control.interfaces.*;
import com.nullpointerworks.intervalometer.control.menubar.*;
import com.nullpointerworks.intervalometer.control.pui.ShowProfileInterfaceCommand;
import com.nullpointerworks.intervalometer.control.updaters.*;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.config.Configuration;
import com.nullpointerworks.intervalometer.model.config.XMLConfiguration;

import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221DeviceFactory;
import com.nullpointerworks.intervalometer.model.profile.ProfileManager;
import com.nullpointerworks.intervalometer.util.PathBuilder;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.swing.UILookAndFeel;
import com.nullpointerworks.util.FileUtil;

/*

intervalometer needs a few thins;
- start-up delay
- image exposure time
- delay between images
- number of images to take
- start/stop button

useful things to have:
- audible alarm when done (can be disabled)
  or notify the user by flashing the taskbar to draw attention
- focusing ability for non-astrophotography purposes



*/
public class Application 
{
	public static final String VERSION = "v0.1.0";
	
	static
	{
		//check the system architecture
		//load the native library at runtime
		
		if(System.getProperty("sun.arch.data.model").equals("32"))
		{
			try
			{
			    System.loadLibrary("libmcp2221_jni_x86");
			}
			catch(Exception ex)
			{
			    System.err.println("The specified library does not exist");
			}
		}
		else 
		if(System.getProperty("sun.arch.data.model").equals("64"))
		{
			try
			{
			    System.loadLibrary("libmcp2221_jni_x64");
			}
			catch(Exception ex)
			{
			    System.err.println("The specified library does not exist");
			}
		}
	}

	public static void main(String[] args) 
	{
		new Application();
	}
	
	private Application()
	{
		final String s = FileUtil.getSourceCodePath(Application.class);
		final PathBuilder appURL = new PathBuilder( s.substring(1) );
		UILookAndFeel.setLookAndFeel( UILookAndFeel.WINDOWS );
		
		Configuration mConfig = new XMLConfiguration(appURL);
		Mcp2221DeviceFactory mFactory = new Mcp2221DeviceFactory();
		DeviceManager mDeviceManager = new DeviceManager();
		ProfileManager mProfileManager = new ProfileManager();
		
		ApplicationView vWindow = new ApplicationView("DSLR Intervalometer");

		Command cShowProfileCommand = new ShowProfileInterfaceCommand(vWindow, mProfileManager, mDeviceManager);
		Command cRefreshRecentDevices = new RefreshDevicesCommand(vWindow, mConfig, mFactory, mDeviceManager);
		Command cRefreshRecentProfiles = new RefreshProfilesCommand(vWindow, mConfig, mProfileManager, cShowProfileCommand);
		ActionCommand cConnectTo = new ConnectToCommand(vWindow, mFactory, mDeviceManager, mConfig, cRefreshRecentDevices);
		ActionCommand cClearDevHistory = new ClearDevHistoryCommand(cRefreshRecentDevices, mConfig);
		ActionCommand cExitProgram = new ProgramExitCommand(mDeviceManager, mProfileManager);
		ActionCommand cDisconnectDevice = new DisconnectDeviceCommand(vWindow, mDeviceManager);
		
		ActionCommand cNewProfile = new NewProfileCommand(cShowProfileCommand, mProfileManager);
		ActionCommand cLoadProfile = new LoadProfileCommand(cShowProfileCommand, cRefreshRecentProfiles, mProfileManager, mConfig);
		ActionCommand cClearProHistory = new ClearProHistoryCommand(cRefreshRecentProfiles, mConfig);
		ActionCommand cSaveProfile = new SaveProfileCommand(vWindow, mProfileManager);
		ActionCommand cSaveAsProfile;
		ActionCommand cCloseProfile;
		
		vWindow.setClearDevHistoryCommand(cClearDevHistory);
		vWindow.setClearProHistoryCommand(cClearProHistory);
		vWindow.setConnectToCommand(cConnectTo);
		vWindow.setDisconnectCommand(cDisconnectDevice);
		vWindow.setExitCommand(cExitProgram);
		
		vWindow.setNewProfileCommand(cNewProfile);
		vWindow.setLoadProfileCommand(cLoadProfile);
		vWindow.setSaveProfileCommand(cSaveProfile);
		
		vWindow.setVisible(true);
		cRefreshRecentDevices.onCommand();
		cRefreshRecentProfiles.onCommand();
	}
}
