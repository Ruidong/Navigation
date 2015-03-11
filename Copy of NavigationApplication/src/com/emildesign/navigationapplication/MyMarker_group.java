package com.emildesign.navigationapplication;

import java.util.ArrayList;

public class MyMarker_group {
	
	    private String mLabel;
	    private Double mLatitude;
	    private Double mLongitude;
	    private ArrayList<myMarker> mList;

	    public MyMarker_group(String label, Double latitude, Double longitude,ArrayList<myMarker> list)
	    {
	        this.mLabel = label;
	        this.mLatitude = latitude;
	        this.mLongitude = longitude;
	        this.mList=list;
	    }
	    
	  
	    public String getmLabel()
	    {
	        return mLabel;
	    }

	    public void setmLabel(String mLabel)
	    {
	        this.mLabel = mLabel;
	    }

	    public Double getmLatitude()
	    {
	        return mLatitude;
	    }

	    public void setmLatitude(Double mLatitude)
	    {
	        this.mLatitude = mLatitude;
	    }

	    public Double getmLongitude()
	    {
	        return mLongitude;
	    }

	    public void setmLongitude(Double mLongitude)
	    {
	        this.mLongitude = mLongitude;
	    }
	}
