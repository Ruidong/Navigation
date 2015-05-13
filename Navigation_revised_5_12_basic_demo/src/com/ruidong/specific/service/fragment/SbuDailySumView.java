package com.ruidong.specific.service.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.emildesign.navigationapplication.R;
import com.ruidong.comon.parent.fragment.SumViewFragment;
import com.ruidong.navigationapplication.BottomButton;
import com.ruidong.navigationapplication.NavigationActivity;
import com.ruidong.navigationapplication.POI;

public class SbuDailySumView extends SumViewFragment{
	private TextView text1;
	private TextView text2;
	private ImageView listDetialedImage;
	private ListView listView;
	private LinearLayout listViewMainButton;
	private POI poi=new POI();
    private LinearLayout detailedListView;
	private String msg1,msg2;
	private Button hideListViewButton;
	private Fragment selfFragment;
	private BottomButton bottomButton;
	public SbuDailySumView(){
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view= inflater.inflate(R.layout.daily_sum_view, container, false);
	    
		detailedListView=(LinearLayout)view.findViewById(R.id.myDetailedListView);
		listViewMainButton=(LinearLayout)view.findViewById(R.id.ListViewMainButton);
	    text1=(TextView)view.findViewById(R.id.textView3);
	    text2=(TextView)view.findViewById(R.id.textView4);
	    listDetialedImage=(ImageView)view.findViewById(R.id.ListViewImage);
	    listView=(ListView)view.findViewById(R.id.listview);
	    hideListViewButton=(Button)view.findViewById(R.id.hideListView);
	    setListText();
	    
	    
	    hideListViewButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
			bottomButton= NavigationActivity.bottomFrag;
			selfFragment= bottomButton.dailySumViewBot;	
            FragmentTransaction tran=getFragmentManager().beginTransaction().remove(selfFragment);
            tran.commit();
				
			}
		});
	    
	    
	    
	    ArrayList<String> listInfo=getTargetList();
	    final StableArrayAdapter adapter = new StableArrayAdapter(getActivity(),
	            android.R.layout.simple_list_item_1, listInfo);
	            listView.setAdapter(adapter);
      
        return view;
   }
        
	@Override
	public void setPOI(POI currentPOI){
		this.poi=currentPOI;
	}
	
	public void setMsg(String str1,String str2){
		this.msg1=str1;
		this.msg2=str2;
	}
	
	
	private void setListText(){
	     text1.setText(msg1);
	     text2.setText(msg2);
    }
	
	private ArrayList<String> getTargetList(){
		  
		 String[] values = new String[] {"Name:  "+poi.getPoiLabel(),"Location:  "+poi.getPoiLocation(),
				 "Available Time:  "+poi.getPoiFundDetail(),"Contact Phone:  "+poi.getmPhone()};

			    final ArrayList<String> list = new ArrayList<String>();
			    for (int i = 0; i < values.length; ++i) {
			      list.add(values[i]);
			     }

			        return list;
  }
			      

    private  class StableArrayAdapter extends ArrayAdapter<String> {

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
