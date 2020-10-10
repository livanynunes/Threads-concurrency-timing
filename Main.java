import src.race_conditional.*;
import src.prime_numbers.*;
import src.producer_consumer.*;

public class Main {
    private int count = 0;
    private static final int threadPoolSize = 5;

    public static void main(String[] args) {

        ///// EXERCICIO A-1 RACE CONDITIONAL/////////////////////////////
        WithoutSynchronism ex1_aSync = new WithoutSynchronism();
        // ex1.init();

        WithSynchronism ex1_sync = new WithSynchronism();
        // ex1.init();

        // PrimeNumbers ex2 = new PrimeNumbers();
        // ex2.inti();

        ProducerConsumer ex3 = new ProducerConsumer();
        // ex3.init();

    }
}