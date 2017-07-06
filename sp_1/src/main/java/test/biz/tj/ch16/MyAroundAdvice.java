package test.biz.tj.ch16;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAroundAdvice {
	public void setAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("메소드 실행전 안녕...");
		Object ret = pjp.proceed();
		System.out.println("메소드 실행후 안녕...");
	}
}
