package com.nullpointerworks.intervalometer.view.swing.plaf.darkskies;

import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;

public class DarkSkiesLookAndFeel extends BasicLookAndFeel 
{
	private static final long serialVersionUID = -3126115685200493397L;

	@Override
	public String getName() 
	{
		return "Dark Skies";
	}

	@Override
	public String getID() 
	{
		return getName();
	}

	@Override
	public String getDescription() 
	{
		return "Nullpointer Works Look and Feel";
	}

	@Override
	public boolean isNativeLookAndFeel() 
	{
		return false;
	}

	@Override
	public boolean isSupportedLookAndFeel() 
	{
		return true;
	}
	
	protected void initClassDefaults(UIDefaults table)
    {
        super.initClassDefaults(table);
        final String darkPackageName = "com.nullpointerworks.intervalometer.view.swing.plaf.darkskies.";
		
        Object[] uiDefaults = 
        {
                "ButtonUI", darkPackageName + "DarkSkiesButtonUI",/*
              "CheckBoxUI", darkPackageName + "DarkSkiesCheckBoxUI",
              "ComboBoxUI", darkPackageName + "DarkSkiesComboBoxUI",
           "DesktopIconUI", darkPackageName + "DarkSkiesDesktopIconUI",
           "FileChooserUI", darkPackageName + "DarkSkiesFileChooserUI",
         "InternalFrameUI", darkPackageName + "DarkSkiesInternalFrameUI",
                 "LabelUI", darkPackageName + "DarkSkiesLabelUI",
    "PopupMenuSeparatorUI", darkPackageName + "DarkSkiesPopupMenuSeparatorUI",
           "ProgressBarUI", darkPackageName + "DarkSkiesProgressBarUI",
           "RadioButtonUI", darkPackageName + "DarkSkiesRadioButtonUI",
             "ScrollBarUI", darkPackageName + "DarkSkiesScrollBarUI",
            "ScrollPaneUI", darkPackageName + "DarkSkiesScrollPaneUI",
             "SeparatorUI", darkPackageName + "DarkSkiesSeparatorUI",
                "SliderUI", darkPackageName + "DarkSkiesSliderUI",
             "SplitPaneUI", darkPackageName + "DarkSkiesSplitPaneUI",
            "TabbedPaneUI", darkPackageName + "DarkSkiesTabbedPaneUI",
             "TextFieldUI", darkPackageName + "DarkSkiesTextFieldUI",
          "ToggleButtonUI", darkPackageName + "DarkSkiesToggleButtonUI",
               "ToolBarUI", darkPackageName + "DarkSkiesToolBarUI",
               "ToolTipUI", darkPackageName + "DarkSkiesToolTipUI",
                  "TreeUI", darkPackageName + "DarkSkiesTreeUI",
              "RootPaneUI", darkPackageName + "DarkSkiesRootPaneUI",//*/
        };
        
        table.putDefaults(uiDefaults);
    }
	
	
	
}
