package com.test.ioc.exam;

import java.util.ArrayList;
import java.util.List;

public class Work2 {
	
	List<Emp> empList;
	
	public Work2(){
		empList = new ArrayList<Emp>();
	}
	
	public static void main(String[] args) {
		
		Work2 w = new Work2();
		Programmer p = new Programmer();
		Designer d = new Designer();
		
		w.empList.add(d);
		w.empList.add(p);
		
//		for (Emp e : w.empList) {
//			e.work();
//}
		for(int i = 0; i < w.empList.size(); i++) {
			Emp e = w.empList.get(i);
			e.work();
		}
	}

}
