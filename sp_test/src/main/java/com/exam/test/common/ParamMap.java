package com.exam.test.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;


public class ParamMap extends HashMap{
	
	private static Logger log = Logger.getLogger(ParamMap.class);

	private static final long serialVersionUID = 1L;

	public ParamMap(){
		super();
	}
	
	public ParamMap(HttpServletRequest request){
		Map map = request.getParameterMap();
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
			this.put(key, request.getParameter(key.toString()));
		}
	}
	
	public ParamMap(Map map){
		if(map != null){
			Iterator it = map.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				this.put(key, map.get(key.toString()));
			}
		}
	}
	public void append(Map map){
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
			this.put(key, map.get(key.toString()));
		}
	}
	
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return super.get(key)==null?new String(""):super.get(key);
	}

	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		value = (value==null?new String(""):value);
		return super.put(key, value);
	}

	public String getString(Object key){
		return getString(key, "");
	}
	
	public String getString(Object key, String defaultString){
		Object value = this.get(key);
		if(value != null && !value.equals("")){
			return value.toString();
		}else{
			if(defaultString == null){
				defaultString = "";
			}
			return defaultString;
		}
	}
	
	public int getInt(Object key){
		try {
			return Integer.parseInt(this.get(key).toString());
		} catch (Exception e) {
			return 0;
		}
	}
	
	public ParamMap getMap(Object key){
		return (ParamMap)super.get(key);
	}
	
	public List getList(Object key){
		return (List)super.get(key);
	}
	
	public String[] getMulti(Object key){
		return getMulti(key, true);
	}
	
	public String[] getMulti(Object key, boolean putType){		
		String mValue = this.getString(key);
		mValue = mValue.replaceAll("\'", "");
		String[] list = mValue.split(",");
		if(putType){
			for(int i=0;i<list.length;i++){
				this.put(key.toString()+"_"+i, list[i]);
			}
		}
		
		return list;
	}
	
	public void setCookies(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				this.put(cookie.getName(), cookie.getValue());
			}
		}
	}
	
	public boolean isEmpty(String key){
		return this.getString(key).equals("");
	}
}
