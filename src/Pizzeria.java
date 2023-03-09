import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Pizzeria {
    BlockingDeque<Thread> pizzaOrders = new LinkedBlockingDeque(2);

    void order(String pizzaName) throws InterruptedException {

        long start = System.currentTimeMillis();

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