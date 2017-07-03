package com.test.ioc.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Work {
	
//	List<Emp> empList;

	public Work(){

	}

	public static void main(String[] args) {
<<<<<<< HEAD
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc4.xml");
		Working dev = (Working) context.getBean("working");
		dev.work();
//		Work w = new Work();
=======
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:ioc3.xml");
		Work w = (Work) factory.getBean("work");
>>>>>>> branch 'master' of https://github.com/nojalnan/mvc_study.git
		
//		for (Emp e : w.empList) {
//			e.work();
			
//		}
	}
}
