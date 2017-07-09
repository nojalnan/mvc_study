package test.biz.tj.ch18;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Exam {
	public static void main(String[] args) {
		First f = new First();
		Second s = new Second();
		
		First proxyFirst;
		Second proxySecond;
		
		Pointcut pc = new MyPointcut();
		Advice advice = new MyAdvice();
		
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(f);
		
		proxyFirst = (First)pf.getProxy();
		proxyFirst.one();
		proxyFirst.two();
		
		f = (First)pf.getProxy();
		f.one();
		f.two();
		
		pf = new ProxyFactory();
		pf.addAdvisors(advisor);
		pf.setTarget(s);
		
		proxySecond = (Second) pf.getProxy();
		proxySecond.one();
		proxySecond.two();
	}
}
