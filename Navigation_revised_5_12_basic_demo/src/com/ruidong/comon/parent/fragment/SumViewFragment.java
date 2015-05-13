package com.ruidong.comon.parent.fragment;

import com.ruidong.navigationapplication.POI;





import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class SumViewFragment extends Fragment{
         
	     public POI poi;
	     
	     public SumViewFragment(){
	    	 
	     }
	     

	 	public abstract void setPOI(POI currentPOI);


		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			return null;
		}
	 	
	 	
	     
}

