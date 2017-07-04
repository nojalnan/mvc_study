package com.text.exam;

import java.util.HashMap;

public class AppMap {
	HashMap<String, Object> appMap = new HashMap<String, Object>();
	
	public void setBean(String key, Object value){
		appMap.put(key, value);
	}
	
	public Object getBean(String key){
		return appMap.get(key);
	}
}
