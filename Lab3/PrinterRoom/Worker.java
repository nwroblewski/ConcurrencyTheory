package Lab3;

public class Worker implements Runnable{
    private PrinterRoom room;  //printer room monitor
    private int workerid;

    public Worker(int workerid, PrinterRoom room){
        this.workerid = workerid;
        this.room = room;
    }


    @Override
    public void run() {
        System.out.println("Pracownik o id: " + workerid + " czeka na wydrukowanie bardzo ważnych rzeczy.");
        int printerNumber = room.reservePrinter();
        System.out.println("Pracownik o id: " + workerid + " drukuje bardzo ważne rzeczy.");
        room.freePrinter(printerNumber);
    }
}
