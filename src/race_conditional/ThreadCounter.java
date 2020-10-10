package src.race_conditional;

public class ThreadCounter extends Thread {
    private Counter counter;

    public ThreadCounter(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            this.counter.setCount();
        }
    }
}
