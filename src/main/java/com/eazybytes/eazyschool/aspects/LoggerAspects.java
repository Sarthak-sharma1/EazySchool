package com.eazybytes.eazyschool.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Component
@Aspect
public class LoggerAspects {
    @Around("execution(* com.eazybytes.eazyschool..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
    log.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        Object returnObj= joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start,finish).toMillis();
        log.info("Time took to execute " + joinPoint.getSignature().toString() + " method is : "+ timeElapsed);
        log.info(joinPoint.getSignature().toString() + " method execution end");

        return returnObj;
    }

    @AfterReturning(value = "execution(* com.eazybytes.eazyschool..*.*(..))",returning = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
     log.error(joinPoint.getSignature()+ " An exception happened due to : " +exception.getMessage());
    }
}
