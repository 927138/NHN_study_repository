package com.nhnacademy.edu.springframework.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class TimeLoggingAdvice {

     public Object print(ProceedingJoinPoint pjp) throws Throwable {
          StopWatch stopWatch = new StopWatch();
          try {
               stopWatch.start();
               Object value = pjp.proceed();

               return value;
          } finally {
               stopWatch.stop();
               System.out.println(pjp.getTarget().getClass().getSimpleName() + "."
                       + pjp.getSignature().getName() + " "
                       + stopWatch.getTotalTimeMillis()+"ms");

          }
     }
}
