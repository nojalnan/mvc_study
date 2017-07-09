package test.biz.tj.ch13_1;

import java.util.HashMap;

public class AppMap {
	
	AppMap(String str){
		String key = str.split("</key><value>")[0];
		String value = str.split("</key><value>")[1];
		key = key.replaceAll("<key>", "");
		value = value.replaceAll("</value>", "");
		setBean(key,value);
	}

	HashMap<String, Object> appMap = new HashMap<String, Object>();
	
	public void setBean(String key, Object value){
		appMap.put(key, value);
	}
	
	public Object getBean(String key){
		return appMap.get(key);
	}
}
