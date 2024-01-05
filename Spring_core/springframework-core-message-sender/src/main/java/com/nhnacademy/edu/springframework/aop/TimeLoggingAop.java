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

     // P_cut
     @Pointcut("execution(* com.nhnacademy.edu.springframework.messagesender.DoorayMessageSender.sendMessage(..))")
     public void timeChecking(){}

     //advise
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
