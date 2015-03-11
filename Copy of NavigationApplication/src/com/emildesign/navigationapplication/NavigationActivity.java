package com.emildesign.navigationapplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.maps.MyLocationOverlay;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;



public class NavigationActivity extends FragmentActivity implements OnMarkerClickListener{

	
	
	private static final LatLng STARTINGPOINT = new LatLng(40.915823, -73.121903);
	private static final LatLng DESTINATION = new LatLng(40.915962, -73.126264);
	private static final LatLng fra = new LatLng(50.111772, 8.682632);
	private GoogleMap map;
	private SupportMapFragment fragment;
	private LatLngBounds latlngBounds;
	private ImageButton bNavigation;
	private ImageButton bSearch;
	private Polyline newPolyline;
	private boolean isTravelingToDestination = false;
	private int width, height;
	private double LAT,LNG;
    private EditText et ;
    private static String location ;
	private static double DLAT = 40.915962;
	private static double DLNG = -73.126264;
	private LinearLayout ButtomButton;
	private TextView text1;
	private TextView text2;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final Multimap <String,myMarker> myMap = ArrayListMultimap.create();
		myMap.put("sac",new myMarker("sac", 40.914505, -73.124266));
		myMap.put("sac",new myMarker("math tower", 40.915571, -73.126397));
		
	//	et = (EditText)findViewById(R.id.et_location);         
           //get reference to find the button
		//location = et.getText().toString();
       
         //get reference to EditText
		
	
		setContentView(R.layout.activity_navigation);				
		getSreenDimanstions();
	    fragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
		map = fragment.getMap(); 	
		
		map.setMyLocationEnabled(true);
		
		bNavigation = (ImageButton) findViewById(R.id.bNavigation);	
		bSearch = (ImageButton) findViewById(R.id.bSearch);	
		 et = (EditText) findViewById(R.id.et_location);
		   map.setOnMarkerClickListener(this);
		LocationManager lm =  (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		LocationListener ll = new mylocationlistener();
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,ll);   
		
		
		
		    bSearch.setOnClickListener(new View.OnClickListener() {
		    	@Override
			        public void onClick(View v) {
		    		
		    		   map.clear();
			    	  location = et.getText().toString();
			   
			   

				     Collection<myMarker> myMarkerCollection = myMap.get(location);
				     for(myMarker marker_element: myMarkerCollection){
				     map.addMarker(new MarkerOptions()
				     .position((new LatLng(marker_element.getmLatitude(), marker_element.getmLongitude())))
				      .title(marker_element.getmLabel()));
				       LatLng  DESTINATION =new LatLng (DLAT,DLNG);
		    		    map.moveCamera(CameraUpdateFactory.newLatLngZoom(DESTINATION, 13)); 
				     }
			    	 
			    	  
		    	}});
		   
		    map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
				
				@Override
				public void onMapClick(LatLng arg0) {
				         ButtomButton.setVisibility(View.INVISIBLE);
					
				}
			});
		    
		    
		    
		    
		    
		    
		    bNavigation.setOnClickListener(new View.OnClickListener() {	
																	
			

			@Override
			public void onClick(View v) {											
				//hideSoftKeyboard(v);
				//get the place entered
				
				
					
				//Editable newTxt=(Editable)et.getText(); 
			//	String location = newTxt.toString();
			//	if(location=="s")
			//	{
			//		DLNG=-73.900566;
			//    	DLAT=40.590093;
			//		
			//	}
				

				LatLng  DESTINATION =new LatLng (DLAT,DLNG);
				LatLng  STARTINGPOINT = new LatLng(LAT,LNG);
				 map.moveCamera(CameraUpdateFactory.newLatLngZoom(STARTINGPOINT, 13));
				if (!isTravelingToDestination)
				{										
					
					findDirections(  STARTINGPOINT.latitude,  STARTINGPOINT.longitude,DESTINATION.latitude, DESTINATION.longitude, GMapV2Direction.MODE_WALKING);
				}
				//else
				//{
				//	isTravelingToParis = false;
				//	findDirections( AMSTERDAM.latitude, AMSTERDAM.longitude, FRANKFURT.latitude, FRANKFURT.longitude, GMapV2Direction.MODE_WALKING );  
				//}
			}
		});
		
		
		
	}
	
	
    class mylocationlistener implements LocationListener{


	@Override
	public  void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		if(location != null)
		{
			double lon = location.getLongitude();
			double lat = location.getLatitude();
			 LAT = lat;
			 LNG = lon;
			
		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	

	}
	
	@Override
	protected void onResume() {
		
		super.onResume();
    	latlngBounds = createLatLngBoundsObject(STARTINGPOINT, DESTINATION);
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width, height, 150));

	}

	public void handleGetDirectionsResult(ArrayList<LatLng> directionPoints) {
		PolylineOptions rectLine = new PolylineOptions().width(5).color(Color.BLUE);

		for(int i = 0 ; i < directionPoints.size() ; i++) 
		{          
			rectLine.add(directionPoints.get(i));
		}
		if (newPolyline != null)
		{
			newPolyline.remove();
		}
		newPolyline = map.addPolyline(rectLine);
		if (isTravelingToDestination)
		{
			latlngBounds = createLatLngBoundsObject(STARTINGPOINT, DESTINATION);
	        map.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width, height, 300));
		}
		//else
		//{
		//	latlngBounds = createLatLngBoundsObject(AMSTERDAM, FRANKFURT);
	  //      map.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width, height, 150));
		//}
		
	}
	
	// infoWindowAdaper need future working.
	/*public class UserInfoWindowAdapter implements InfoWindowAdapter {
	        LayoutInflater inflater = null;
	        
	    	
	    	 public UserInfoWindowAdapter( LayoutInflater inflater) {
	                      this.inflater=inflater;
	    	 }
	    	@Override
	    	public View getInfoWindow(Marker marker) {
	    		return null;
	    	}
	    	
	    	@Override
	    	public View getInfoContents(Marker marker) {
	    		
	    	View infoWindows= inflater.inflate(R.layout.activity_navigation, null);
	    	TextView title = (TextView)infoWindows.findViewById(R.id.title);
	    	TextView description = (TextView)infoWindows.findViewById(R.id.snippet);
	    	
	    	title.setText(marker.getTitle());
	    	description.setText(marker.getSnippet());
	    	
	    	return (infoWindows);	

	    	}
	    }*/
	
	public  boolean onMarkerClick(final Marker marker) {
        double x=marker.getPosition().latitude;
		
        LatLng destination= marker.getPosition();
        DLAT=destination.latitude;
        DLNG=destination.longitude;
        text1=(TextView)findViewById(R.id.textView1);
		text2=(TextView)findViewById(R.id.textView2);
        ButtomButton=(LinearLayout)findViewById(R.id.BottomButton);
        text1.setText(marker.getTitle());
        text2.setText(marker.getTitle());
        ButtomButton.setVisibility(View.VISIBLE);
		return false ;
    }
	
	

	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.navigation, menu);
        return true;
}

	
	
	
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	    case R.id.bNormal:
	       map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	        break;
	    case R.id.bSatellite:
	    	map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	        break;
	    case R.id.bHybrid:
	    	map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
	        break;
	    case R.id.bTerrain:
	    	map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
	        break;
	   
	        }
	        return super.onOptionsItemSelected(item);
	    }
	
	
	

	
	
	
	
	
	
	private void getSreenDimanstions()
	{
		Display display = getWindowManager().getDefaultDisplay();
		width = display.getWidth(); 
		height = display.getHeight(); 
	}
	
	private LatLngBounds createLatLngBoundsObject(LatLng firstLocation, LatLng secondLocation)
	{
		if (firstLocation != null && secondLocation != null)
		{
			LatLngBounds.Builder builder = new LatLngBounds.Builder();    
			builder.include(firstLocation).include(secondLocation);
			
			return builder.build();
		}
		return null;
	}
	
	public void findDirections(double fromPositionDoubleLat, double fromPositionDoubleLong, double toPositionDoubleLat, double toPositionDoubleLong, String mode)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put(GetDirectionsAsyncTask.USER_CURRENT_LAT, String.valueOf(fromPositionDoubleLat));
		map.put(GetDirectionsAsyncTask.USER_CURRENT_LONG, String.valueOf(fromPositionDoubleLong));
		map.put(GetDirectionsAsyncTask.DESTINATION_LAT, String.valueOf(toPositionDoubleLat));
		map.put(GetDirectionsAsyncTask.DESTINATION_LONG, String.valueOf(toPositionDoubleLong));
		map.put(GetDirectionsAsyncTask.DIRECTIONS_MODE, mode);
		
		GetDirectionsAsyncTask asyncTask = new GetDirectionsAsyncTask(this);
		asyncTask.execute(map);	
	}
}
