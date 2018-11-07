package Lab2.ShopSimulation;

import Lab2.ShopSimulation.Shopify;

public class Client implements Runnable{

    public Shopify shop;

    public Client(Shopify shop){
        this.shop = shop;
    }


    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName() + "Client came to the shop");
        //System.out.println(Thread.currentThread().getName() +"Client is waiting for cart");
        shop.semaphore.Proberen();
        System.out.println(shop.semaphore.counter + "Carts left");
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        //System.out.println(Thread.currentThread().getName() + "Client took a cart and started shopping");
       // System.out.println(Thread.currentThread().getName() + "Client finished his shopping");
        shop.semaphore.Verhogen();
    }
}
