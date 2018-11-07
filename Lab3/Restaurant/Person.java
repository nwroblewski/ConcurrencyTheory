package Lab3.Restaurant;

public class Person implements Runnable{
    int pairId;
    Waiter waiter;

    public Person(int pairId, Waiter waiter){
        this.waiter = waiter;
        this.pairId = pairId;
    }


    @Override
    public void run() {
        waiter.sitDown(this.pairId);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        waiter.getUp(this.pairId);
    }
}
