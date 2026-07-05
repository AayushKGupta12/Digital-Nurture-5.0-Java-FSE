package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {

        System.out.println("LOG: About to execute -> " + joinPoint.getSignature().getName());

    }
}