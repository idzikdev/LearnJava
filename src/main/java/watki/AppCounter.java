package watki;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppCounter {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(10);
        Counter counter=new Counter();
        for (int i = 0; i < 100; i++) {
            executor.submit(()->counter.increase());
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(counter.getCount());
    }
}
