public class Consumer implements Runnable {

    private int ILOSC = 10;
    private Buffer buffer;

    public Consumer(Buffer buffer, int ilosc) {
        this.buffer = buffer;
        this.ILOSC = ilosc;
    }

    public void run() {
        System.out.println("consumer start");
        for(int i = 0;  i < ILOSC;   i++) {
//            synchronized (this.buffer) {
                String message = buffer.take();
                System.out.println(Thread.currentThread().getName()+" "+message);
        }
    }
}


