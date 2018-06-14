package test.thread.lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock可以用来提高某些集合的并发性能。当集合比较大，并且读比写频繁时，可以使用该类。
 * 下面是TreeMap使用ReentrantReadWriteLock进行封装成并发性能提高的一个例子：
 */
public class RWDictionnary {

    private final Map<String,Object> m = new TreeMap<String,Object>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Object get(String key){
        r.lock();
        try{
            return m.get(key);
        }finally {
            r.unlock();
        }
    }

    public Object[] allkeys(){
        r.lock();
        try{
            return m.keySet().toArray();
        }finally {
            r.unlock();
        }
    }


    public Object put(String key,Object value){
        w.lock();
        try{
            return m.put(key,value);
        }finally {
            w.unlock();
        }
    }

    public void clear(){
        w.lock();
        try{
            m.clear();
        }finally {
            w.unlock();
        }
    }





}
