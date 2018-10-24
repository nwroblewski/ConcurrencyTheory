

public class Producer implements Runnable {
    private Buffer buffer;
    private int ILOSC;

    public Producer(Buffer buffer, int ilosc) {
        this.buffer = buffer;
        this.ILOSC = ilosc;
    }

    public void run() {
        System.out.println("Producer start");
        for (int i = 0; i < ILOSC; i++) {
                buffer.put("message " + i);
        }
    }
}



