package src.race_conditional;

import java.util.concurrent.Semaphore;

public class ThreadCounter extends Thread {
    private Counter counter;
    private Semaphore semaphore;
    private boolean isSynchronous;

    public ThreadCounter(Counter counter) {
        this.counter = counter;
        this.isSynchronous = false;
    }

    public ThreadCounter(Counter counter, Semaphore semaphore) {
        this.counter = counter;
        this.semaphore = semaphore;
        this.isSynchronous = true;
    }

    public void run() {
        if (isSynchronous == false) {

            for (int i = 0; i < 1000000; i++) {
                this.counter.setCount();
            }
        } else {
            try {
                this.semaphore.acquire();

                for (int i = 0; i < 1000000; i++) {
                    this.counter.setCount();
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            this.semaphore.release();

        }
    }
}
