package com.ruidong.slidebutton;

import java.util.ArrayList;
import java.util.Collection;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TextView;

import com.ruidong.navigationapplication.BottomButton;
import com.ruidong.navigationapplication.POI;
import com.ruidong.specific.service.SbuDailyLifeService;

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    
	
    public ArrayList<BottomButton> bottomButtonList ;
	
    public ViewPagerAdapter(FragmentManager fm, ArrayList<BottomButton> fragments){
    	       super(fm);
    	       this.bottomButtonList=fragments;
    }
	
    
   	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return bottomButtonList.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return bottomButtonList.size();
	}
    
}
