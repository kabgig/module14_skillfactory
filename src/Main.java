import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ExecutorService e = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            int b = i;
            e.submit(new Thread() {
                         @Override
                         public void run() {
                             try {
                                 Thread.sleep(4000);
                             } catch (InterruptedException ex) {
                                 throw new RuntimeException(ex);
                             }
                             System.out.println(b + Thread.currentThread().getName() + " started.");
                         }
                     }
            );
        }
            e.shutdown();
    }
}
