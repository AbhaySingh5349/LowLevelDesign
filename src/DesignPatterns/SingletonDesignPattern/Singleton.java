package DesignPatterns.SingletonDesignPattern;
import java.util.concurrent.atomic.AtomicInteger;

public class Singleton {
    private static volatile Singleton instance;
//    private static int instanceCount = 0;
    private static AtomicInteger instanceCount = new AtomicInteger(0);

    private Singleton() {
//        instanceCount++;
        instanceCount.incrementAndGet();
    }


    public static Singleton getClassInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public static int getInstanceCount() {
//        return instanceCount;
        return instanceCount.get();
    }
}
