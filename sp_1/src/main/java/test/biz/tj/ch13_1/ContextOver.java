package test.biz.tj.ch13_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ContextOver {
	public static void main(String[] args) {
		GenericXmlApplicationContext father = new GenericXmlApplicationContext();
		father.load("ch13_1/exam.xml");
		father.refresh();
		String str = (String)father.getBean("str1");
		System.out.println(str);
	}
}
