package com.ruidong.specific.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.ruidong.navigationapplication.OncampusAppService;
import com.ruidong.navigationapplication.POI;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class SbuDailyLifeService implements OncampusAppService {
     	
	public  Multimap <String,POI> dailyMap=ArrayListMultimap.create();
	public boolean dailyFlag= false; 
	
	public SbuDailyLifeService (){
		dailyMap.put("food",new POI("ignite","Stony brook union", "9:00am--10:00pm", "631-681-0001", 40.916905, -73.122228,1));
		dailyMap.put("food",new POI("Starbuck","Roth Food Court", "8:00am--11:00pm", "631-681-0002", 40.910946, -73.123774,2));
		dailyMap.put("food",new POI("Bob's BBQ","West Side Dining","8:00am--11:00pm", "631-681-0003", 40.913021, -73.129868,3));
		dailyMap.put("food",new POI("Wrap-It-Up","Student Activity Center", "8:00am--11:00pm", "631-681-0002", 40.914615, -73.123789,4));
		dailyMap.put("food",new POI("Jasmine","Wang Center", "8:00am--11:00pm", "631-681-0002", 40.915652, -73.119708,5));
		
	}
	
	@Override	
	public Collection<POI> getTargetPOI(String str){
		Collection<POI> myPOICollection = dailyMap.get(str);
		return myPOICollection;
	}
	
	@Override
	public String firstTextInfo(POI POI_element){
		  String str="Location:"+POI_element.getPoiLocation();
		  return str;
	}
	
	@Override
	public String secondTextInfo(POI POI_element){
		 String str="Available Time:"+POI_element.getPoiFundDetail();
		  return str;
	}
	
	@Override
	public boolean checkMap(String str){
		 return dailyMap.containsKey(str);
	}
	
     public ArrayList<String> getTargetListView(POI POI_element){
		  
		 String[] values = new String[] {"Name:  "+POI_element.getPoiLabel(),"Location:  "+POI_element.getPoiLocation(),
				 "Available Time:  "+POI_element.getPoiFundDetail(),"Contact Phone:  "+POI_element.getmPhone(),"1","2","3"};

			    final ArrayList<String> list = new ArrayList<String>();
			    for (int i = 0; i < values.length; ++i) {
			      list.add(values[i]);
			     } 

			        return list;
			      }
			      

			        class StableArrayAdapter extends ArrayAdapter<String> {

			        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

			        public StableArrayAdapter(Context context, int textViewResourceId,
			            List<String> objects) {
			          super(context, textViewResourceId, objects);
			          for (int i = 0; i < objects.size(); ++i) {
			            mIdMap.put(objects.get(i), i);
			          }
			        }

			        @Override
			        public long getItemId(int position) {
			          String item = getItem(position);
			          return mIdMap.get(item);
			        }

			        @Override
			        public boolean hasStableIds() {
			          return true;
			        }

			      }
	 
}
