import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    AtomicInteger money = new AtomicInteger(10_000);

    int getMoney() {
        return money.get();
    }

    void take(int money) {
        this.money.addAndGet(-money);
    }

    void repay(int money) {
        this.money.addAndGet(money);
    }

    class Client extends Thread {
        @Override
        public void run() {
            while (true) {
                // выдаем кредит, только если
                // есть свободные средства
                if (getMoney() >= 1000) {
                    take(1000);
                    repay(1000);
                }
            }
        }
    }

    public Bank() {
        new Client().start();
        new Client().start();
        new Client().start();
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while (true) {
            System.out.println(bank.money);
            Thread.sleep(1000);
        }
    }
}