package com.ruidong.navigationapplication;

import java.util.Collection;

public interface OncampusAppService {
        
	public String firstTextInfo(POI POI_element);
	
	
	public String secondTextInfo(POI POI_element);
		

	public Collection<POI> getTargetPOI(String str);
	

	public boolean checkMap(String str);
	
}
