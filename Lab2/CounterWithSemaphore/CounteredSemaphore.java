package Lab2.CounterWithSemaphore;

public class CounteredSemaphore {
    public int counter;

    public CounteredSemaphore(int counter){
        this.counter = counter;
    }

    //TAKE
    public synchronized void Proberen(){
        while(this.counter == 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.counter += -1;
    }

    //GIVE
    public synchronized void Verhogen(){
        notifyAll();
        this.counter +=1;
    }
}
