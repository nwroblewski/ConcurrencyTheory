package Lab3.Restaurant;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waiter {

    private final Lock lock = new ReentrantLock();
    private Condition[] both; // condition for locking the pair if only one person has made a request
    private int[] requests;   // how many ppl from pair have made requests - we need 2 obviously
    private Condition isTaken = lock.newCondition();
    private int clients = 0;

    public Waiter(int N){
        both = new Condition[N];
        requests = new int[N];
        for(int i = 0; i < N; i++){
            requests[i] = 0;
            both[i] = lock.newCondition();
        }
    }
    public void sitDown(int pairId){
        lock.lock();
        try{
            System.out.println("Osoba z pary o id: " + pairId + " złożyła zamówienie na stolik");
            requests[pairId]++;
            if(requests[pairId] < 2){
                both[pairId].await();
            }
            else{
                while(clients > 0){
                    isTaken.await();
                }
                clients = 2;
                System.out.println("Para o id: " + pairId + " siadła przy stoliku.");
                both[pairId].signal();
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        lock.unlock();
    }

    public void getUp(int pairID){
        lock.lock();
        try{
            clients--;
            if(clients == 0){
                System.out.println("Para o id: " + pairID + " wstała od stołu");
                isTaken.signal();
            }
        }finally {
            lock.unlock();
        }
    }
}
