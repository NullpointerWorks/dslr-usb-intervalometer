package com.nullpointerworks.intervalometer;

import com.nullpointerworks.intervalometer.control.*;
import com.nullpointerworks.intervalometer.control.interfaces.*;
import com.nullpointerworks.intervalometer.model.DeviceManager;
import com.nullpointerworks.intervalometer.model.ProfileManager;
import com.nullpointerworks.intervalometer.model.config.Configuration;
import com.nullpointerworks.intervalometer.model.config.XMLConfiguration;

import com.nullpointerworks.intervalometer.model.nativeinterface.GPIO;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221Device;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221DeviceFactory;
import com.nullpointerworks.intervalometer.util.PathBuilder;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.ProfileJPanel;
import com.nullpointerworks.intervalometer.view.TimeTunerJDialog;
import com.nullpointerworks.intervalometer.view.swing.UILookAndFeel;
import com.nullpointerworks.util.FileUtil;

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
		
		/*
		Mcp2221Device device = mFactory.getDeviceBySerialNumber("0000449396");
		
		device.setGPIOValue(GPIO.GP1, true);
		sleep(1000);
		device.setGPIOValue(GPIO.GP1, false);
		sleep(100);
		
		device.setGPIOValue(GPIO.GP0, true);
		sleep(1000);
		device.setGPIOValue(GPIO.GP0, false);
		sleep(100);
		device.closeConnection();
		
		//*/
		
		ApplicationView vWindow = new ApplicationView("DSLR Intervalometer");
		
		
		Command cRefreshRecentDevices = new RefreshDevicesCommand(vWindow, mConfig, mFactory, mDeviceManager);
		ActionCommand cConnectTo = new ConnectToCommand(vWindow, mFactory, mDeviceManager, mConfig, cRefreshRecentDevices);
		ActionCommand cClearDevHistory = new ClearDevHistoryCommand(cRefreshRecentDevices, mConfig);
		ActionCommand cExitProgram = new ProgramExitCommand(mDeviceManager, mProfileManager);
		ActionCommand cDisconnectDevice = new DisconnectDeviceCommand(vWindow, mDeviceManager);
		
		ActionCommand cNewProfile = new NewProfileCommand(vWindow, mProfileManager);
		ActionCommand cLoadProfile;
		ActionCommand cSaveProfile;
		ActionCommand cSaveAsProfile;
		
		
		
		
		
		vWindow.setClearDevHistoryCommand(cClearDevHistory);
		vWindow.setConnectToCommand(cConnectTo);
		vWindow.setDisconnectCommand(cDisconnectDevice);
		vWindow.setExitCommand(cExitProgram);
		
		vWindow.setNewProfileCommand(cNewProfile);
		
		vWindow.setVisible(true);
		cRefreshRecentDevices.onCommand();
		
		//vWindow.setDisplayTab("<New Profile>", new ProfileJPanel() );
	}
}
