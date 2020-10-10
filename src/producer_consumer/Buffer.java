package src.producer_consumer;

import java.util.concurrent.Semaphore;

public class Buffer {
    private int bufferElement;
    private static Semaphore semaphoreConsumer = new Semaphore(0);
    private static Semaphore semaphoreProducer = new Semaphore(1);

    public void getBufferElement() {
        try {
            semaphoreConsumer.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("-- [" + bufferElement + "]");
        semaphoreProducer.release();
    }

    public void setBufferElement(int value) {
        try {
            semaphoreProducer.acquire();
        } catch (InterruptedException e) {
            System.out.print(e);
        }

        this.bufferElement = value;
        System.out.println("++ [" + bufferElement + "]");
        semaphoreConsumer.release();
    }
}
