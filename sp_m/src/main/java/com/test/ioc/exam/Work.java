package com.test.ioc.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Work {
	
//	List<Emp> empList;

	public Work(){
//		empList = new ArrayList<Emp>();
//		empList.add(new Programmer());
//		empList.add(new Designer());
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc4.xml");
		Working dev = (Working) context.getBean("working");
		dev.work();
//		Work w = new Work();
		
//		for (Emp e : w.empList) {
//			e.work();
			
//		}
	}
}
