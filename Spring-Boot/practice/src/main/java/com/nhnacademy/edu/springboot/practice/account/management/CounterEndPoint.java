package com.nhnacademy.edu.springboot.practice.account.management;

import io.micrometer.core.lang.Nullable;
import java.util.concurrent.atomic.AtomicLong;
import lombok.NonNull;
import lombok.experimental.NonFinal;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "counter")
public class CounterEndPoint {
     private final AtomicLong count = new AtomicLong(0L);

     @ReadOperation
     public Long read(){
          return count.get();
     }

     @WriteOperation
     public Long increment(@Nullable Long delta){
          if(delta == null)
               return count.incrementAndGet();
          return count.addAndGet(delta);
     }

     @DeleteOperation
     public Long reset() {
          count.set(0);
          return count.get();
     }

}
