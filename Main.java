import Lab2.CounterWithSemaphore.Counter;
import Lab2.CounterWithSemaphore.Semaphore;
import Lab2.CounterWithSemaphore.ThreadsTest;
import Lab3.PrinterRoom.PrinterRoom;
import Lab3.PrinterRoom.Worker;
import Lab3.Restaurant.Person;
import Lab3.Restaurant.Waiter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        LAB2 EX1 - COUNTER SYNCHRONIZED WITH MY OWN SEMAPHORE IMPLEMENTATION PART


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

        //LAB2 EX2 - SHOP WITH LIMITED SHOPPING CARTS USING MY OWN IMPLEMENTATION OF COUNTER SEMAPHORE
//        int clientsNumber = 10;
//        Shopify shop = new Shopify(20);
//        Client[] clients = new Client[clientsNumber];
//        Thread[] threads = new Thread[clientsNumber];
//
//        // Creating clients
//        for(int i = 0; i < clientsNumber; i++) clients[i] = new Client(shop);
//
//        // Creating clients threads
//        for(int i = 0; i < clientsNumber; i++) threads[i] = new Thread(clients[i]);
//
//
//        //Starting clients threads
//        for(int i = 0; i< clientsNumber; i++) threads[i].start();
//
//
//        //Joining threads
//        for(int i = 0; i < clientsNumber; i++){
//            try{
//                threads[i].join();
//            }
//            catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        }

        //LAB3 EX1 - USAGE OF BOUNDED BUFFER FOR PRODUCERS AND CONSUMERS PROBLEM
//        int consumersNumber = 2;
//        int ilosc = 60;
//
//        BoundedBuffer buffer = new BoundedBuffer();
//        ConsumerLocks[] consumers = new ConsumerLocks[2];
//        ProducerLocks producer = new ProducerLocks(buffer,ilosc);
//        Thread[] threads = new Thread[3]; // 2 consumers, one producer
//
//        //Creating producer thread
//        threads[0] = new Thread(producer);
//
//
//        // Creating consumers
//        for(int i = 0; i < consumersNumber; i++)
//            consumers[i] = new ConsumerLocks(buffer,ilosc/consumersNumber);
//
//        // Creating consumers threads
//        for(int i = 1; i < 3; i++){
//            threads[i] = new Thread(consumers[i - 1]);
//        }
//
//        // Starting all threads
//        for(Thread thread: threads){
//            thread.start();
//        }
//
//        //Joining threads
//        for(Thread thread: threads){
//            try{
//                thread.join();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }


        //LAB3 EX2 - PRINTER ROOM SIMULATION
        int workersNumber = 20;
        int printersNumber = 4;
        PrinterRoom room = new PrinterRoom(printersNumber);
        Worker[] workers = new Worker[workersNumber];
        Thread[] workersThreads = new Thread[workersNumber];


        //Creating workers
        for(int i = 0; i < workersNumber; i++) workers[i] = new Worker(i,room);

        //Creating workers threads
        for(int i = 0; i < workersNumber; i++) workersThreads[i] = new Thread(workers[i]);

        //Starting workers threads
        for(Thread thread: workersThreads) thread.start();

        //Joining workers threads
        for(Thread thread: workersThreads){
            try{
                thread.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }



        // LAB3 EX3 - POOR RESTAURANT SIMULATION - ONLY ONE TABLE
        int N = 15;
        List<Thread> threads = new ArrayList<Thread>();
        Waiter waiter = new Waiter(N);
        for(int i = 0; i < N; i++){
            threads.add(new Thread(new Person(i,waiter)));
            threads.add(new Thread(new Person(i,waiter)));
        }

        for(Thread thread: threads) thread.start();
        for(Thread thread: threads){
            try{
                thread.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

