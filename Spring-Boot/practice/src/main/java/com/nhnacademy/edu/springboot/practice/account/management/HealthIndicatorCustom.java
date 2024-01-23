package com.nhnacademy.edu.springboot.practice.account.management;

import java.util.concurrent.atomic.AtomicBoolean;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthIndicatorCustom implements HealthIndicator {

     private final AtomicBoolean check = new AtomicBoolean(false);

     @Override
     public Health health() {
          if (check.get()) {
               return Health.down().withDetail("Error Code", "hello").build();
          }
          return Health.up().build();
     }

     public void setCheck(boolean ch){
          this.check.set(ch);
     }

     @Override
     public Health getHealth(boolean includeDetails) {
          return HealthIndicator.super.getHealth(includeDetails);
     }
}
