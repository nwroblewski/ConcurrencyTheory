package Lab2.CounterWithSemaphore;

import Lab2.CounterWithSemaphore.Counter;
import Lab2.CounterWithSemaphore.Semaphore;

public class ThreadsTest implements Runnable {

    final Counter counter;
    boolean inc;
    Semaphore semaphore;

    public ThreadsTest(Counter counter, boolean inc, Semaphore semaphore){
        this.counter = counter;
        this.inc = inc;
        this.semaphore = semaphore;
    }
    public void run() {
        if(inc){
            for(int i = 0; i < 100000; i++){
                semaphore.Proberen();
                this.counter.inc();
                semaphore.Verhogen();
            }
        }
        else{
            for(int i = 0; i < 100000; i++){
                semaphore.Proberen();
                this.counter.dec();
                semaphore.Verhogen();
            }
        }
    }
}

