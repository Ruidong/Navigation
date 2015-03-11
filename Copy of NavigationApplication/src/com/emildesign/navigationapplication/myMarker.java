package com.emildesign.navigationapplication;

public class myMarker
{
    private String mLabel;
    private Double mLatitude;
    private Double mLongitude;

    public myMarker(String label, Double latitude, Double longitude)
    {
        this.mLabel = label;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
    }
    
    public myMarker returnMarker(double latitude){
    	  
    	if(this.mLatitude==latitude)
    	return this;
    	else
        return null;
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
