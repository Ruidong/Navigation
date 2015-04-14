package com.ruidong.navigationapplication;

import android.R.integer;

public class POI
{
    private String poiLabel;
    private String poiLocatoin;
    private String poiFundDetail;
    private String poiPhone;
    private Double poiLatitude;
    private Double poiLongitude;
    private int poiId;
    
    
    public POI()
    {
    	
    }
    
    public POI(String label,String location, String fund_detail, String phone, double latitude, double longitude, int id)
    {
        this.poiLabel = label;
        this.poiLocatoin=location;
        this.poiFundDetail=fund_detail;
        this.poiPhone=phone;
        this.poiLatitude = latitude;
        this.poiLongitude = longitude;
        this.poiId=id;
    }
    
    
    public int getPoiId()
    {
    	return poiId;
    }


	public String getPoiLabel()
    {
        return poiLabel;
    }
    public void setPoiLabel(String Label)
    {
        this.poiLabel = Label;
    }
    
    
    public String getPoiLocation(){
    	return poiLocatoin;
    }
    public void setPoiLocation(String location){
    	this.poiLocatoin=location;
    }
    
    
    public String getPoiFundDetail(){
    	return poiFundDetail;
    }
    public void setmFund_(String poiFundDetail){
    	this.poiFundDetail=poiFundDetail;
    }
    
    
    public String getmPhone(){
    	return this.poiPhone;
    }
    public void setmPhone(String Phone){
    	this.poiPhone=Phone;
    }
    
    
    public Double getmLatitude()
    {
        return poiLatitude;
    }
    public void setmLatitude(Double Latitude)
    {
        this.poiLatitude = Latitude;
    }

    
    public Double getmLongitude()
    {
        return poiLongitude;
    }
    public void setmLongitude(Double Longitude)
    {
        this.poiLongitude = Longitude;
    }
}
