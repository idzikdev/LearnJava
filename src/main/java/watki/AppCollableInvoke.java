package watki;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class AppCollableInvoke {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> watek1= () -> {
            TimeUnit.SECONDS.sleep(8);
            return 10;
        };
        Callable<Integer> watek2= () -> {
            TimeUnit.SECONDS.sleep(5);
            return 20;
        };
        Callable<Integer> watek3= () -> {
            TimeUnit.SECONDS.sleep(2);
            return 30;
        };
        List<Callable<Integer>> list= Arrays.asList(watek1,watek2,watek3);
        ExecutorService executor= Executors.newFixedThreadPool(2);
        List<Future<Integer>> futures = executor.invokeAll(list);
        for (Future<Integer> element:futures
             ) {
            System.out.println(element.get());
        }
        Integer integer=executor.invokeAny(list);
        System.out.println(integer);
        executor.shutdown();
    }
}
