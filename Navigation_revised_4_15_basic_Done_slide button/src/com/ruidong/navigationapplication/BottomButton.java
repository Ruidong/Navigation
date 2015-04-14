package com.ruidong.navigationapplication;


import com.emildesign.navigationapplication.R;
import com.ruidong.specific.service.fragment.SbuDailySumView;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BottomButton extends Fragment{
	
	    private TextView text1;
	    private TextView text2;
	    public Fragment dailySumViewBot;
	    private LinearLayout bottombutton;
	    public boolean DailySumFlag;
	    private POI bottomButtonPOI;
	    String msg1,msg2;
        public BottomButton() {
        	
        }

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			View view= inflater.inflate(R.layout.bottom_button, container, false);
			
		
	         text1=(TextView)view.findViewById(R.id.textView1);
	         text2=(TextView)view.findViewById(R.id.textView2);
	         bottombutton=(LinearLayout)view.findViewById(R.id.bottomInFra);
	         
	         bottombutton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					SbuDailySumView dailySumView = new SbuDailySumView ();
					dailySumView.setPOI(bottomButtonPOI);
					
					dailySumView.setMsg(msg1,msg2);
				    FragmentTransaction dailySumViewStart = getFragmentManager().beginTransaction().add(R.id.summaryView,dailySumView);
				    dailySumViewStart.show(dailySumView);
				    dailySumViewStart.commit();
				    dailySumViewBot=dailySumView;
				    DailySumFlag=true;
				}
			});
	      
	        return view;
       }
	   
		public void setPOI(POI currentPOI){
			this.bottomButtonPOI=currentPOI;
		}
		
	   
	   public void setbottomText1(String str){
		     this.msg1=str;
		     text1.setText(str);
	   }
		
	   public void setbottomText2(String str){
		     this.msg2=str;
		     text2.setText(str);
	   }
	   
	   
}
