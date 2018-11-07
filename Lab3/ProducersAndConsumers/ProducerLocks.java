package Lab3.ProducersAndConsumers;

import Lab3.ProducersAndConsumers.BoundedBuffer;

public class ProducerLocks implements Runnable {

    private int ILOSC;
    private BoundedBuffer buffer;

    public ProducerLocks(BoundedBuffer buffer, int ilosc){
        this.buffer = buffer;
        this.ILOSC = ilosc;
    }


    @Override
    public void run() {
        for(int i = 0; i < ILOSC; i++){
            try{
                buffer.put("wiadomosc" + i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
