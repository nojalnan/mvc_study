package com.test.ioc.exam3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ContextOver {
	//Father.xml String클래스 str1;
	//Son.xml String클래스 str1;
	//son Exam클래스 target4
	//target4 setVal1(father의 str1)
	//target4 setVal2(son의 str1)
	//출력
	public static void main(String[] args) {
		GenericXmlApplicationContext father = new GenericXmlApplicationContext();
		father.load("exam/father.xml");
		father.refresh();
		GenericXmlApplicationContext son = new GenericXmlApplicationContext();
		son.load("exam/son.xml");
		son.setParent(father);
		son.refresh();
		Exam target1 = (Exam) son.getBean("target1");
		Exam target2 = (Exam) son.getBean("target2");
		String target3 = (String) son.getBean("father2");
		String target4 = (String) son.getBean("str1");
		System.out.println(target1.getVal1());
		System.out.println(target2.getVal2());
		System.out.println(target3);
		Exam e = (Exam)son.getBean("target4");
		System.out.println(e.getVal1());
		System.out.println(e.getVal2());
	}
}
