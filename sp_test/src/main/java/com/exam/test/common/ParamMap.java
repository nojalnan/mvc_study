package com.exam.test.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

}
