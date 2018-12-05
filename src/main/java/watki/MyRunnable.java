package watki;

import java.util.stream.IntStream;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        IntStream.rangeClosed(0,100)
                .forEach(i->System.out.println(i+" Wykonuje się "+MyThread.currentThread().getName()));
    }
}
