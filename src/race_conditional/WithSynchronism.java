package src.race_conditional;

import java.util.concurrent.Semaphore;

public class WithSynchronism {

    Semaphore semaphore = new Semaphore(1);

    Counter counter = new Counter();

    public WithSynchronism() throws InterruptedException {
        ThreadCounter t1 = new ThreadCounter(counter, semaphore);
        ThreadCounter t2 = new ThreadCounter(counter, semaphore);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public void init() {
        System.out.println("Resultado com semáforo: " + counter.getCounter());
    }
}
