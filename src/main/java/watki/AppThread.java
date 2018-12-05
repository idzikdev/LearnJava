package watki;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AppThread {
    public static void main(String[] args) {
        System.out.println("Główny wątek aplikacji "+Thread.currentThread().getName());
        Thread thread1=new MyThread("Wątek nr 1");
        Thread thread2=new MyThread("Wątek nr 2");
        Runnable runnable1=new MyRunnable();
        Thread thread3=new Thread(runnable1,"Wątek nr 3");
        Runnable runnable2=new Runnable() {
            @Override
            public void run() {
                IntStream.rangeClosed(0,100)
                        .forEach(i->System.out.println(i+" Wykonuje się "+MyThread.currentThread().getName()));
            }
        };
        Thread thread4=new Thread(runnable2,"Wątek nr 4");
        Thread thread5=new Thread(()->IntStream.rangeClosed(0,100)
                .forEach(i->System.out.println(i+" Wykonuje się "+MyThread.currentThread().getName())),"Wątek nr 5");
//        thread1.start();
//        thread2.start();
//        thread3.start();
        thread4.start();
        try {
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread5.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
