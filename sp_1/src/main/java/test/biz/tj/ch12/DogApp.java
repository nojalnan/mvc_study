package test.biz.tj.ch12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "ch12/dog.xml", "ch12/dog_bean.xml" });
		DogManager dManager = (DogManager) context.getBean("dogManager");
		dManager.bark();
	}
}
