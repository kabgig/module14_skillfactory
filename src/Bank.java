public class Bank {
    public static int money = 10_000;
    public Bank(int money) {

        new Client(this).start();
        new Client(this).start();
        new Client(this).start();
    }

    public void getMoney() {
        System.out.println(money);
    }
    public synchronized void takeMoney() {
        money -= 1000;
        System.out.println("took 1000 and now it is " + money);
    }
    public synchronized void repayMoney(){
        money += 1000;
        System.out.println("repaid 1000 and now it is " + money);
    }
}
