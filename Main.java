import java.util.ArrayList;
import static java.lang.System.out;
public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter(0);
        Semaphore semaphore = new Semaphore();
        ThreadsTest semTest1 = new ThreadsTest(counter, true, semaphore);
        ThreadsTest semTest2 = new ThreadsTest(counter, false, semaphore);
        Thread t = new Thread(semTest1);
        Thread t1 = new Thread(semTest2);

        t.run();
        t1.run();
        try {
            t.join();
            t1.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(counter.value);
    }
}

