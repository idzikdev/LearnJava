package watki;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppFixedExecutor {
    public static void main(String[] args) {
        Runnable worker1=()->{
            System.out.println("Worker 1 "+Thread.currentThread().getName());
            System.out.println("Idę do przodu");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;
        };
        Runnable worker2=()->{
            System.out.println("Worker 2 "+Thread.currentThread().getName());
            System.out.println("Idę w prawo");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;
        };
        Runnable worker3=()->{
            System.out.println("Worker 3 "+Thread.currentThread().getName());
            System.out.println("Cofam się ");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;
        };
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(worker1);
        executorService.submit(worker2);
        executorService.submit(worker3);
        executorService.shutdown();
    }
}

