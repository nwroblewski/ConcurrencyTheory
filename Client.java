public class Client implements Runnable{

    public Shopify shop;

    public Client(Shopify shop){
        this.shop = shop;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Klient wchodzi do sklepu");
        System.out.println(Thread.currentThread().getName() +"Klient czeka na koszyk");
        shop.semaphore.Proberen();
        System.out.println(Thread.currentThread().getName() + "Klient pobrał koszyk i wykonuje zakupy");
        System.out.println(Thread.currentThread().getName() + "Klient skończył zakupy");
        shop.semaphore.Verhogen();
    }
}
