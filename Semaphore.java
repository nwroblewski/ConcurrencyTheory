public class Semaphore {
    public boolean taken = false;

    //TAKE
    public synchronized void Proberen(){
        while(this.taken) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
        this.taken = true;
    }

    //GIVE
    public synchronized void Verhogen(){
        if(this.taken){
            notifyAll();
            this.taken = false;
        }
    }
}
