public class Client implements Runnable{

    public Shopify shop;

    public Client(Shopify shop){
        this.shop = shop;
    }


    @Override
    public void run() {
        System.out.println("Klient wchodzi do sklepu");
        System.out.println("Klient czeka na koszyk");
        shop.semaphore.Proberen();
        System.out.println("Klient pobrał koszul i wykonuje zakupy");
        System.out.println("Klient skończył zakupy");
        shop.semaphore.Verhogen();
    }
}
