package com.tm.s5.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	@AfterReturning("execution(* com.tm.s5.transfer.Transfer.*())")
	public void cardAfter() {
		System.out.println("=============================");
		System.out.println("카드 결제");
	}
	
	@Around("execution(* com.tm.s5.transfer.Transfer.*(Integer,..))")
	//around를 사용하면 ProceedingJoinPoint필요
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("=============================");
		System.out.println("카드 check in");
		
		Object[] ar = joinPoint.getArgs();
		for (Object object : ar) {
			System.out.println(object);
		}
		
		
		Object obj = joinPoint.proceed();
		System.out.println("카드 check out");
		
		
		return obj;
	}
	
}
