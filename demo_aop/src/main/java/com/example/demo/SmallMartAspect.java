package com.example.demo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SmallMartAspect {

	@Pointcut("execution(* com.example.demo.SmallmartInterface.*(..))")
	public void getProduct1(){
		
	}
	
	@Pointcut("args(String)")
	public void getProduct2(){
		
	}
	
	@Before("getProduct1() && getProduct2()")
	public void logBefore(JoinPoint jp){
		System.out.println("실행전1 logBefore()");
		jp.getSignature().getName();
		
	}
	
	@After("getProduct1()")
	public void logAfter(JoinPoint jp){
		System.out.println("실행후2 logAfter()");
		jp.getSignature().getName();
	}
	
	@AfterReturning(pointcut = "getProduct1()", returning = "result")
	public void logAfterReturning(JoinPoint jp, Object result){
		System.out.println("실행후2 logAfterReturning()");
		jp.getSignature().getName();
		System.out.println("결과값 = " + result);
	}
	
	@Around("getProduct1()")
	public String logAround(ProceedingJoinPoint pip)throws Throwable{
		System.out.println("logAround()1");
		pip.getSignature().getName();
		Arrays.toString(pip.getArgs());
		String s = (String)pip.proceed();
		System.out.println("logAround()2");
		return "asdfasdfsdaf";
	}
	
	@AfterThrowing(pointcut = "getProduct1()", throwing = "error")
	public void logAfter(JoinPoint jp, Throwable error){
		System.out.println("에러일 경우 실행후 logAfter()");
		jp.getSignature().getName();
		System.out.println("에러 : " + error);
	}
}
