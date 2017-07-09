package test.biz.tj.ch17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ch17/ioc.xml");
		IPrintMsg printMsg = (IPrintMsg) ctx.getBean("printMsg");
		printMsg.hello1();
		printMsg.hello2();

	}
}
