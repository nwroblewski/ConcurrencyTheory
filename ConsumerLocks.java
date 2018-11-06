public class ConsumerLocks implements Runnable {

    private int ILOSC;
    private BoundedBuffer buffer;

    public ConsumerLocks(BoundedBuffer buffer, int ilosc) {
        this.buffer = buffer;
        this.ILOSC = ilosc;
    }

    @Override
    public void run() {
        System.out.println("consumer start");
        for(int i = 0;  i < ILOSC;   i++) {
            try{
                Object message = buffer.take();
                System.out.println(Thread.currentThread().getName()+" "+message);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


