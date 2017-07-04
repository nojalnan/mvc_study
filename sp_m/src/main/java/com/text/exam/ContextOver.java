package com.text.exam;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ContextOver {
	public static void main(String[] args) {
		GenericXmlApplicationContext father = new GenericXmlApplicationContext();
		father.load("exam/exam.xml");
		father.refresh();
		
		String str1 = new String("str1");
		
		AppMap am = new AppMap();
		am.setBean("str1", str1);
		
		String str = (String)am.getBean("str1");
		System.out.println(str);

	}
}
