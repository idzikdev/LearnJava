package watki;

public class AppThread {
    public static void main(String[] args) {
        System.out.println("Główny wątek aplikacji "+Thread.currentThread().getName());
        Thread thread1=new MyThread("Wątek nr 1");
        Thread thread2=new MyThread("Wątek nr 2");
        thread1.start();
        thread2.start();
    }
}
