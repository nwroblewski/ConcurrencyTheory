package Lab2.ShopSimulation;

import Lab2.CounterWithSemaphore.CounteredSemaphore;

public class Shopify {

    public int baskets;
    public CounteredSemaphore semaphore;

    public Shopify(int baskets) {
        this.baskets = baskets;
        this.semaphore = new CounteredSemaphore(baskets);
    }
}
