package com.ruidong.specific.service.fragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.emildesign.navigationapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.ruidong.comon.parent.fragment.CategoryResultFragment;
import com.ruidong.navigationapplication.BottomButton;
import com.ruidong.navigationapplication.NavigationActivity;
import com.ruidong.navigationapplication.POI;
import com.ruidong.specific.service.SbuDailyLifeService;
import com.ruidong.specific.service.fragment.SbuDailyLifeGridViewAdapter.GridItemView;

import android.R.integer;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

public class SbuCategoryResultFragment extends CategoryResultFragment{
        private ListView list;
        private SbuCategoryResultFragment selfFrag;
        private SbuDailyLifeService dailyService = new SbuDailyLifeService(); 
        
        private ArrayList<String> lableList = new ArrayList<String>();
        private ArrayList<String> detailList = new ArrayList<String>();
       
        private HashMap<Integer, POI> listHashMap1 = new HashMap<Integer, POI>();
        
        private HashMap<String,Integer> listHashMap2= new HashMap<String, Integer>();
        
	    public SbuCategoryResultFragment(){
	    	
	    }
	    
	    
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
	    
	    	View view= super.onCreateView(inflater, container, savedInstanceState);
	    	this.list=super.list;
			
			
			     
			    final SbuDailyLifeListViewAdapter adapter = new SbuDailyLifeListViewAdapter(getActivity(),
			            lableList, detailList);
			            this.list.setAdapter(adapter);
			  
			    this.list.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
					   selfFrag = (SbuCategoryResultFragment) NavigationActivity.resultFragment;
					   FragmentTransaction tran = getFragmentManager().beginTransaction().hide(selfFrag);
					   tran.commit();
					  
					   TextView textView1=(TextView) view.findViewById(R.id.lableText);
					  
					   String str = textView1.getText().toString();  
					  
					   Integer currentPoiId= listHashMap2.get(str);
					   
					   POI currentPoi= listHashMap1.get(currentPoiId);
					   
					   LatLng  latlng =new LatLng (currentPoi.getmLatitude(),currentPoi.getmLongitude());
		               NavigationActivity.map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 13)); 
              	       Marker marker=NavigationActivity.mMarkersHashMap2.get(currentPoi);
              	       
              	       marker.showInfoWindow();
					   
					   NavigationActivity.bottomFrag.setbottomText1(dailyService.firstTextInfo(currentPoi));
			           NavigationActivity.bottomFrag.setbottomText2(dailyService.secondTextInfo(currentPoi));
					   NavigationActivity.bottomFrag.setPOI(currentPoi);
					  
					   FragmentTransaction bottomTran=getFragmentManager().beginTransaction().show(NavigationActivity.bottomFrag);
					   bottomTran.commit();
					   FragmentTransaction hideTran = getFragmentManager().beginTransaction().hide(NavigationActivity.showListFragment);
					   hideTran.commit();
					   
					}
				});        
			            
			    return view;
	    	
		}
	    
	    public  void setTargetList(Collection<POI> resultPoiCollection){
			              
	    	       for(POI PoiElement: resultPoiCollection){
	    	    	   Integer poiId= Integer.valueOf(PoiElement.getPoiId());
	    	    	   listHashMap1.put(poiId,PoiElement);
	    	    	   
	    	    	   String str1 = PoiElement.getPoiLabel();
	    	    	   lableList.add(str1);
	    	    	   String str2 = PoiElement.getPoiFundDetail();
	    	    	   detailList.add(str2);
	    	    	   
	    	    	   
	    	    	   listHashMap2.put(str1, poiId);
	    	    	  
	    	       }
	    	       
	    }
				      

public class SbuDailyLifeListViewAdapter extends BaseAdapter {
	    	  
	   	 private Context context;
	   	 private ArrayList<String> lableList;
	   	 private ArrayList<String> detailList;
	   	 private LayoutInflater listContainer;  
	   	 
	   	 
	   	 public final class ListItemView{
	   		 public TextView title;
	   		 public TextView detail;
	   	 }
	   	 
	   	 public SbuDailyLifeListViewAdapter(Context context, ArrayList<String> lableList,ArrayList<String> detailList){
	   		 
	   		 this.context=context;
	   		 listContainer = LayoutInflater.from(context); 
	   		 this.lableList=lableList;
	   		 this.detailList=detailList;
	   		
	   		 
	   	 }
	   	

	   	@Override
	   	public int getCount() {
	   		
	   		return lableList.size();
	   	}

	   	@Override
	   	public Object getItem(int position) {
	   		// TODO Auto-generated method stub
	   		return null;
	   	}
	       
	   	@Override
	   	public long getItemId(int position) {
	   		// TODO Auto-generated method stub
	   		return 0;
	   	}
	   	    
	    public String getTitle(int checkedID){
	       	 return lableList.get(checkedID);
	       }
	       
	   	@Override
	   	public View getView(int position, View convertView, ViewGroup parent) {
	   		
	   		final int selectedID= position;
	   		ListItemView listItemView= null;
	   		
	   		
	   		if (convertView == null) {   
	               listItemView = new ListItemView();    
	              
	               convertView = listContainer.inflate(R.layout.category_result_adapter, null); 
	   		     
	               
	               listItemView.title=(TextView)convertView.findViewById(R.id.lableText);
	               listItemView.detail=(TextView)convertView.findViewById(R.id.detailedText);
	               
	               listItemView.title.setText((String) lableList.get(position));
	               listItemView.detail.setText((String) detailList.get(position));
	            
	    

	   	    }
	   		return convertView;
	   	}
	   }

	}

	    
	    

