package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class BasicController {
	protected Map<String, String> paramMap;
	
	public BasicController(HttpServletRequest req){
		Iterator<String> it = req.getParameterMap().keySet().iterator();
		this.paramMap = new HashMap<String, String>();
		while(it.hasNext()){
			String key = it.next().toString();
			String value = req.getParameter(key);
			this.paramMap.put(key, value);
		}
	}
}
