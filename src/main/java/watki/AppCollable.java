package watki;

import java.util.concurrent.*;

public class AppCollable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> watek= () -> {
            TimeUnit.SECONDS.sleep(5);
            return 44;
        };
        ExecutorService executor= Executors.newFixedThreadPool(2);
        Future<Integer> result=executor.submit(watek);
        executor.shutdown();
        System.out.println("Wynik "+result.get());
    }
}
