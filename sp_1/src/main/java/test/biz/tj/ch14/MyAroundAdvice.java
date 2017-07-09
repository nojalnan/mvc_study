package test.biz.tj.ch14;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("메소드 실행전 hello...");
		Object ret = invocation.proceed();
		System.out.println("메소드 실행후 hello...");
		return ret;
	}
}
