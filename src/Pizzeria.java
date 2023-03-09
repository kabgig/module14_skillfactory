import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Pizzeria {
    long start;

    public Pizzeria() {
        start = System.currentTimeMillis();
    }

    BlockingDeque<Thread> pizzaOrders = new LinkedBlockingDeque(2);

    void order(String pizzaName) throws InterruptedException {
        long now = System.currentTimeMillis();
        if (now - start > 5000) {
            System.out.println("Too late <5000ms");
        } else {
            Thread wagon = new Thread() {
                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(pizzaName + " is delivered");
                    pizzaOrders.poll();
                }
            };
            boolean added = pizzaOrders.offer(wagon, 250, TimeUnit.MILLISECONDS);

            if (added) wagon.start();
            else System.out.println(pizzaName + " is NOT delivered");
        }
    }
}