package test.biz.tj.ch18;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object o = invocation.proceed();
		System.out.println("나의 충고를 받아랏");
		return o;
	}
}