public class Buffer {

    public String[] buffer;


    public Buffer(){
        this.buffer = new String[1];
        this.buffer[0] = null;
    }

    public synchronized String take(){
        while(this.buffer[0] == null){
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        String tmp = this.buffer[0];
        this.buffer[0] = null;
        notifyAll();
        return tmp;
    }

    public synchronized void put(String msg){
        while(this.buffer[0] != null){
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Producent produkuje");
        this.buffer[0] = msg;
        notifyAll();
    }
}
