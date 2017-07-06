package test.biz.tj.ch05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderManagerApp {
	static OrderManager om;
	
	@Autowired
	public OrderManagerApp(OrderManager om){
		OrderManagerApp.om = om;
	}

	public static void main(String[] args){
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:ioc5.xml");
		om.order();
	}
}
