package watki;

public class Counter {
    private int count=0;
    public void increase(){
        synchronized (this){
            count=count+1;
        }
    }
    public int getCount(){
        return count;
    }
}
