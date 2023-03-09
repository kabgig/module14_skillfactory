public class Bank {

    private int money = 10000;
    private Object lock = new Object();

    int getMoney() {
        return money;
    }

    void take(int money) {
        synchronized (lock) {
            if (getMoney() >= 1000)
                this.money -= money;
        }

    }

    void repay(int money) {
        synchronized (lock) {
            this.money += money;
        }
    }

    class Client extends Thread {
        @Override
        public void run() {
            while (true) {
                // выдаем кредит, только если
                // есть свободные средства

                take(1000);
                repay(1000);

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
            Thread.sleep(50);
        }
    }

}