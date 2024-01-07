package com.nhnacademy.edu.springframework.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeLoggingAop {

     @Pointcut("@annotation(com.nhnacademy.edu.springframework.annotation.HookSendMessage)")
     public void timeChecking(){}

     @Around("timeChecking()")
     public Object print(ProceedingJoinPoint pjp) throws Throwable {
          StopWatch stopWatch = new StopWatch();
          try {
               stopWatch.start();
               Object value = pjp.proceed();
               return value;
          } finally {
               stopWatch.stop();

               System.out.println(pjp.getTarget().getClass().getSimpleName() + "." +
                       pjp.getSignature().getName() + " " + stopWatch.getTotalTimeMillis()+"ms");

          }
     }
}
