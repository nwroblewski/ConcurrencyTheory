import java.util.ArrayList;
import static java.lang.System.out;
public class Main {

    public static void main(String[] args) {

        // COUNTER SYNCHRONIZED WITH MY OWN SEMAPHORE IMPLEMENTATION PART


        //        Counter counter = new Counter(0);
//        Semaphore semaphore = new Semaphore();
//        ThreadsTest semTest1 = new ThreadsTest(counter, true, semaphore);
//        ThreadsTest semTest2 = new ThreadsTest(counter, false, semaphore);
//        Thread t = new Thread(semTest1);
//        Thread t1 = new Thread(semTest2);

//        t.run();
//        t1.run();
//        try {
//            t.join();
//            t1.join();
//        }
//        catch(InterruptedException e){
//            e.printStackTrace();
//        }
//        System.out.println(counter.value);

        // SHOP WITH LIMITED SHOPPING CARTS USING MY OWN IMPLEMENTATION OF COUNTER SEMAPHORE
        int clientsNumber = 10;
        Shopify shop = new Shopify(4);
        Client[] clients = new Client[clientsNumber];
        Thread[] threads = new Thread[clientsNumber];

        // Creating clients
        for(int i = 0; i < clientsNumber; i++) clients[i] = new Client(shop);

        // Creating clients threads
        for(int i = 0; i < clientsNumber; i++) threads[i] = new Thread(clients[i]);


        //Starting clients threads
        for(int i = 0; i< clientsNumber; i++) threads[i].start();


        //Joining threads
        for(int i = 0; i < clientsNumber; i++){
            try{
                threads[i].join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

