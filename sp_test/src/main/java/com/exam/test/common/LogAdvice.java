package com.exam.test.common;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAdvice {

	protected static final Logger log = Logger.getLogger(LogAdvice.class);
	
	@Around("execution(* com.myspring..*(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		Signature signature = joinPoint.getSignature();
		log.info("PerformanceTraceAdvice : " + signature.toShortString() + " Start");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			log.info("PerformanceTraceAdvice : " +signature.toShortString() + " RunTime : "+(System.currentTimeMillis() - start)+"ms");
		}
	}
}
