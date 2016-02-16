package org.ll4.test.bvb01.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAOP {
	private static final Logger logger = LogManager.getLogger();
	 
	@Before("execution(* org.ll4.test.bvb01.controllers.*.*(..))")
	 public void before(JoinPoint joinPoint) {
    	String className = joinPoint.getSignature().getDeclaringTypeName();
    	String methodName = joinPoint.getSignature().getName();
		logger.info("{}.{}", className, methodName);
	 }

    @Around("execution(* org.ll4.test.bvb01.controllers.*.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
    	Long t1 = System.currentTimeMillis();
    	Object returnValue = joinPoint.proceed();
    	Long t2 = System.currentTimeMillis();        
    	Long executionTime = t2 - t1;
    	
    	String className = joinPoint.getSignature().getDeclaringTypeName();
    	String methodName = joinPoint.getSignature().getName();
    	System.out.println(className + "." + methodName + "() took " + executionTime + " ms");
    	
    	return returnValue;
    }

}
