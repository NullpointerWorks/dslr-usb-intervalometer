package com.nullpointerworks.intervalometer;

import com.nullpointerworks.intervalometer.model.config.Configuration;
import com.nullpointerworks.intervalometer.model.nativeinterface.Mcp2221DeviceFactory;
import com.nullpointerworks.intervalometer.view.ApplicationView;
import com.nullpointerworks.intervalometer.view.swing.UILookAndFeel;

public class Application 
{
	public static final String VERSION = "v0.1.0";
	
	static
    {
        //check the system architecture
        if(System.getProperty("sun.arch.data.model").equals("32"))
        {
            try
            {
                System.loadLibrary("libmcp2221_jni_x86");   //load the native library at runtime
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
                System.loadLibrary("libmcp2221_jni_x64");   //load the native library at runtime
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
		UILookAndFeel.setLookAndFeel( UILookAndFeel.WINDOWS );
		
		Configuration mConfig;
		Mcp2221DeviceFactory mFactory = new Mcp2221DeviceFactory();
		
		
		
		
		
		
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
		
		
		ApplicationView vWindow = new ApplicationView("DSLR Intervalometer", 640, 480);
		vWindow.setVisible(true);
		
		
	}
	
	
	
	private void sleep(int i) 
	{
		try 
		{
			Thread.sleep(i);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
