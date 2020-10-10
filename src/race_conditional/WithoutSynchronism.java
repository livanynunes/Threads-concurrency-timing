package src.race_conditional;

public class WithoutSynchronism {

    Counter counter = new Counter();

    public WithoutSynchronism() throws InterruptedException {
        ThreadCounter t1 = new ThreadCounter(counter);
        ThreadCounter t2 = new ThreadCounter(counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public void init() {
        System.out.println("Resultado: " + counter.getCounter());
    }
}