package Lab3.ProducersAndConsumers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    final Lock lock =new ReentrantLock();
    final Condition notEmpty = lock.newCondition();
    final Condition notFull = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException{
        lock.lock();
        try{
            while(count == items.length){
                notFull.await();
            }
            items[putptr] = x;
            putptr = (putptr + 1) % items.length;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException{
        lock.lock();
        try{
            while(count == 0){
                notEmpty.await();
            }
            Object x = items[takeptr];
            takeptr = (takeptr + 1) % items.length;
            --count;
            notFull.signal();
            return x;
        }finally {
            lock.unlock();
        }
    }
}
