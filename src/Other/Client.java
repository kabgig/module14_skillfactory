package Other;

import Other.Bank;

public class Client extends Thread {
    Bank bank;

    public Client(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while(true){
            bank.takeMoney();
            System.out.println(Thread.currentThread().getName());
            bank.repayMoney();
        }
    }
}
