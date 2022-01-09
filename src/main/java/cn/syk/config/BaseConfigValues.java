package cn.syk.config;

import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author syk
 * @date 2021/12/6 17:52
 **/
@Configuration
public class BaseConfigValues {
    public AtomicInteger count = new AtomicInteger(0);

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount() {
        count.addAndGet(1);
    }
    /* public synchronized  void setCount() {
        this.count++;
    }*/
   /*
   private Lock lock = new ReentrantLock();
   public  void setCount() {
       lock.lock();
       this.count++;
       lock.unlock();
   }*/
}
