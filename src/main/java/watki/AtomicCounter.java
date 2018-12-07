package watki;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger count=new AtomicInteger(0);
    public void increase(){
        count.getAndIncrement();
    }
    public int getCount(){
        return count.get();
    }
}
