package test.biz.tj.ch06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Work {

	@Autowired
	List<Emp> empList;
	
	public Work(){
	}
	
	public static void main(String[] args){

		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("classpath:ioc6.xml");
		
		Work w = (Work)factory.getBean("work");
		
		for(Emp e : w.empList){
			e.work();
		}
	}
}
