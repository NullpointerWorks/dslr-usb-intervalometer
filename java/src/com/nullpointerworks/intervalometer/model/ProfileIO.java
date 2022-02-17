package com.nullpointerworks.intervalometer.model;

import com.nullpointerworks.intervalometer.util.PathBuilder;

public interface ProfileIO 
{
	boolean write(IntervalProfile profile, PathBuilder path);
	boolean read(IntervalProfile profile, PathBuilder path);
}
