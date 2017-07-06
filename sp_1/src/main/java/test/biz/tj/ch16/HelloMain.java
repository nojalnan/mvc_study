package test.biz.tj.ch16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ch16/ioc.xml");
		IPrintMsg printMsg = (IPrintMsg) ctx.getBean("testMsg");
		printMsg.hello1();
		printMsg.hello2();

	}
}
