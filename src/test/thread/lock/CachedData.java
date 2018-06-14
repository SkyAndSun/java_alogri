package test.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降低
 */
public class CachedData {

    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData(){
        rwl.readLock().lock();
        //must release read lock before acquiring write lock
        if (!cacheValid){
            rwl.readLock().unlock();
            rwl.writeLock().lock();

           try{
               if(!cacheValid){
                   data = "9999";
                   cacheValid = true;
               }
               rwl.readLock().lock();
           } finally {
               rwl.writeLock().unlock();
           }
        }


    }
}
