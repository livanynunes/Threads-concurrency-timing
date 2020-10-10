import src.race_conditional.*;
import src.prime_numbers.*;
import src.producer_consumer.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // WithoutSynchronism ex1_aSync = new WithoutSynchronism();
        // ex1_aSync.init();

        // WithSynchronism ex1_sync = new WithSynchronism();
        // ex1_sync.init();

        PrimeNumber ex2 = new PrimeNumber();
        ex2.init();

        // Passar o tamanho do buffer, numero de produtores, numero de consumidores, e
        // metodo (semaforo,monitor), respectivamente
        // ProducerConsumer ex3 = new ProducerConsumer(10, 4, 2, "monitor");
        // ex3.init();

    }
}