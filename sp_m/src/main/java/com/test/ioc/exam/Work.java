package com.test.ioc.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Work {
	
	@Autowired
	List<Emp> empList;
	public Work(){
//		empList = new ArrayList<Emp>();
//		empList.add(new Programmer());
//		empList.add(new Designer());
	}

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:ioc3.xml");
		Work w = (Work) factory.getBean("work");
		
//		Work w = new Work();
		
		for (Emp e : w.empList) {
			e.work();
			
		}
	}
}
