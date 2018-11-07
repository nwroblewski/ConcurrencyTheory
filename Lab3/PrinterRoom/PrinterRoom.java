package Lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterRoom {
    final private Lock lock = new ReentrantLock();
    List<Boolean> availablePrinters;
    final private Condition allTaken = lock.newCondition();

    public PrinterRoom(int printerNumber){
        this.availablePrinters = new ArrayList<Boolean>();
        //setting all printers to be available
        for(int i = 0; i < printerNumber; i++) availablePrinters.add(true);
    }

    public int reservePrinter() {
        lock.lock();
        int printerNumber = 0;
        try{
            while((printerNumber = availablePrinters.indexOf(true)) == -1){
                allTaken.await();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        availablePrinters.set(printerNumber,false);
        lock.unlock();
        return printerNumber;
    }

    public void freePrinter(int printerNumber){
        lock.lock();
        availablePrinters.set(printerNumber,true);
        allTaken.signal();
        lock.unlock();
    }
}
