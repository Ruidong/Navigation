package com.ruidong.comon.parent.fragment;

import java.util.ArrayList;

import android.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public abstract class CategoryFragment extends Fragment {
         
	    private Button doneButton;
	
	   
	     public CategoryFragment(){
	    	 
	     }
	    
	    public  abstract void doneButtonMethod(ArrayList<String> checkedList);//Set a OnclickListener, when user Click the button,
	    										 //generate CateforyFragment object,
	                                             //transmit the user interested data to next fragment.
		
	    	
	     
	   
	     
}
