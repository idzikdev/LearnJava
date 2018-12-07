package watki;

import java.util.concurrent.*;

public class AppCompletableFutureMerging1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Long> idFuture=CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getUserId();
        });

        CompletableFuture<Void> future=idFuture.thenCompose(id->CompletableFuture.supplyAsync((()->{
            return getDiscount(id);
        })).thenAccept(i-> System.out.println(i)));
        //future.get();
    }
    public static Long getUserId(){
        return 144L;
    }
    public static Double getDiscount(Long id){
        return 1.4;
    }
}
