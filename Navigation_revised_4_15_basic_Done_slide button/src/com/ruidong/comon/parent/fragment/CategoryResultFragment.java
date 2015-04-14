package com.ruidong.comon.parent.fragment;



import com.emildesign.navigationapplication.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public abstract class CategoryResultFragment extends Fragment{
	
	public ListView list;
	
	public CategoryResultFragment() {
		
	}
       

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view= inflater.inflate(R.layout.category_result, container, false);
	    
		list=(ListView)view.findViewById(R.id.listview);
		
		
		 list.setOnItemClickListener(new AdapterView.OnItemClickListener()  {

		      @Override
		      public void onItemClick(AdapterView<?> parent, final View view,
		          int position, long id) {
		       
							
							// hide this listView, show a specific mark information 
							// window and its corresponding bottomButton
						
		              }
		            });
		 return view;
	}
 	
}