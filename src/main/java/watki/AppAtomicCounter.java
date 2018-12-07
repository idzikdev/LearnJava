package watki;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppAtomicCounter {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(10);
        AtomicCounter counter=new AtomicCounter();
        for (int i = 0; i < 100; i++) {
            executor.submit(()->counter.increase());
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(counter.getCount());
    }
}
