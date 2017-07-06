package test.biz.tj.ch04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderManagerApp {

	public static void main(String[] args){
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:ioc4.xml");
		OrderManager om = (OrderManager)factory.getBean("orderManager");
		om.order();
	}
}
