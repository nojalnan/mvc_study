package test.biz.tj.ch11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodReplaceTest {
	Programmer programmer;

	public void setProgrammer(Programmer programmer) {
		this.programmer = programmer;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc11.xml");
		MethodReplaceTest test = (MethodReplaceTest) context.getBean("methodReplaceTest");
		System.out.println(test.programmer.work());
	}
}
