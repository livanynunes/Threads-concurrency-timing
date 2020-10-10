package src.race_conditional;

public class ThreadCounter extends Thread {
    private Counter counter;

    public ThreadCounter(Counter counter) {
        this.counter = counter;
        System.out.println(this.counter);
    }

    public void run() {
        for (int i = 0; i < 10; i++) { // um milhão
            this.counter.setCount();
        }
    }
}
