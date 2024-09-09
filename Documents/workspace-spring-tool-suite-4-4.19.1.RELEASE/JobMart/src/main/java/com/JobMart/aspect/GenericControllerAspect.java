package com.JobMart.aspect;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GenericControllerAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Before("execution(* com.JobMart.controller.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before executing: " + joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "execution(* com.JobMart.controller.*.*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("After returning from: " + joinPoint.getSignature());
		System.out.println("Result: " + result);
	}

	@Around("execution(* com.JobMart.controller.*.*(..))")
	public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.nanoTime();
		Object retval = pjp.proceed();
		long end = System.nanoTime();
		String methodName = pjp.getSignature().getName();
		logger.info("Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
		return retval;
	}

	@AfterThrowing(pointcut = "execution(* com.JobMart.controller.*.*(..))")
	public void afterThrowing(JoinPoint joinPoint) {
		System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
	}

}
