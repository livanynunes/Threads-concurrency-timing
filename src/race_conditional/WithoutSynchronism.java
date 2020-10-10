package src.race_conditional;

public class WithoutSynchronism {

    Counter counter = new Counter();

    public WithoutSynchronism() {

        ThreadCounter t1 = new ThreadCounter(counter);
        ThreadCounter t2 = new ThreadCounter(counter);

        t1.start();
        t2.start();
    }

    public void init() {
        System.out.println("Resultado: " + counter.getCounter());
    }
}