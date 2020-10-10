package src.race_conditional;

public class WithoutSynchronism {

    Counter counter = new Counter();
    ThreadCounter t1 = new ThreadCounter(counter);
    ThreadCounter t2 = new ThreadCounter(counter);

    public WithoutSynchronism() {
        t1 = new ThreadCounter(counter);
        t2 = new ThreadCounter(counter);
        t1.start();
        t2.start();
        this.init();
    }

    public void init() {

        System.out.println("Resultado: " + counter.getCounter());
    }
}