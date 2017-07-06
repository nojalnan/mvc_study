package test.biz.tj.ch17;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAroundAdvice {
	@Around("execution(* test.biz.tj.ch17.PrintMsg.hello1(..))")
	public void setAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("메소드 실행전 안녕...");
		Object ret = pjp.proceed();
		System.out.println("메소드 실행후 안녕...");
	}
}
