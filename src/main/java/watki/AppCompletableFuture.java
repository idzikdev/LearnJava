package watki;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AppCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(3);
        System.out.println(Thread.currentThread().getName());
        CompletableFuture.runAsync(
                ()-> System.out.println(Thread.currentThread().getName()),executor
        );

        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 44;
        },executor).exceptionally(exception->{
            System.out.println("Błąd");
            return 2;
        })
                .thenApply(r->{
            System.out.println(Thread.currentThread().getName());
            return r*2;
        })
                .thenAccept(r->{
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(r);
                });
        executor.shutdown();
    }
}
