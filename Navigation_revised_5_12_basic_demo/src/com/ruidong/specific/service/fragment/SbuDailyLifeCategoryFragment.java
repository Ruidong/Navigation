package com.ruidong.specific.service.fragment;

import java.util.ArrayList;
import java.util.Collection;




import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.emildesign.navigationapplication.R;
import com.ruidong.comon.parent.fragment.CategoryFragment;
import com.ruidong.navigationapplication.NavigationActivity;
import com.ruidong.navigationapplication.POI;
import com.ruidong.navigationapplication.ShowListButton;
import com.ruidong.specific.service.SbuDailyLifeService;

public class SbuDailyLifeCategoryFragment extends CategoryFragment{
    
	private GridView grid;
	private Button button;
	private SbuDailyLifeGridViewAdapter adapter;
	public static final ArrayList<String> categories = new ArrayList<String>();
	public SbuCategoryResultFragment resultFragment;	
	public ShowListButton showListFragment;
    private SbuDailyLifeService service= NavigationActivity.dailyService;
    private NavigationActivity activity = new NavigationActivity();
	public  Collection<POI> resultPoiCollection = null ;
    
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
				
		View view= inflater.inflate(R.layout.daily_category_view, container, false);
		
		
		button=(Button)view.findViewById(R.id.DoneButton);
		grid=(GridView)view.findViewById(R.id.gridView);
		button.setOnClickListener(new ClickEvent());
		
		
		
		categories.add("food");
		categories.add("coffee");
		categories.add("gym");
		categories.add("library");
		categories.add("store");
		categories.add("mesuem");
		
		adapter = new SbuDailyLifeGridViewAdapter(getActivity(), categories);
		grid.setAdapter(adapter);
          
		
        
	    return view;
	
		
	
		
	}
	

      
	class ClickEvent implements OnClickListener{   
		  
        @Override  
        public void onClick(View v) {   
            // TODO Auto-generated method stub   
            ArrayList<String> checkedList=new ArrayList<String>();   
            for(int i = 0; i < categories.size(); i++) {   
                if(adapter.hasChecked(i)){
                	checkedList.add(adapter.getTitle(i));
                }
            }
            doneButtonMethod(checkedList);
            
        }   
           
    }   
	
	
	@Override
	public void doneButtonMethod(ArrayList<String> checkedList) {
		 Fragment selfFragment= NavigationActivity.MenuFragment;
		 FragmentTransaction tran=getFragmentManager().beginTransaction().remove(selfFragment);
         tran.commit();
         
         for(String str:checkedList){
        	 resultPoiCollection = service.getTargetPOI(str);  	 
         }
         
         
         resultFragment = new SbuCategoryResultFragment();
         resultFragment.setTargetList(resultPoiCollection);
         NavigationActivity.resultFragment=resultFragment;
         
         FragmentTransaction resultTran=getFragmentManager().beginTransaction().add(R.id.Category_result_Container,resultFragment);
         resultTran.commit();
         
         
         showListFragment = new ShowListButton();
         NavigationActivity.showListFragment=showListFragment;
         
  		 FragmentTransaction showTran= getFragmentManager().beginTransaction().add(R.id.showListButton, showListFragment);
  		 showTran.commit();
  		 FragmentTransaction hideTran= getFragmentManager().beginTransaction().hide(showListFragment);
  		 hideTran.commit();
  	
       
         activity.addMarker(resultPoiCollection);
         
         activity.setBottomButtonFragmentList(resultPoiCollection);
         
         service.dailyFlag=true;
         
         NavigationActivity.myMarkerCollection=resultPoiCollection;
             
	}

	      
	   
}
