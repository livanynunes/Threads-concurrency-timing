package src.producer_consumer;

public class Monitor {
    private int buffer[];
    private int counter = 0;
    private int currentPosition = 0;
    private int nextPosition = 0;

    public Monitor(int bufferSize) {
        this.buffer = new int[bufferSize];
    }

    public synchronized void add(int element) {
        if (this.counter == this.buffer.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        this.buffer[this.nextPosition] = element;
        this.nextPosition = (this.nextPosition + 1) % this.buffer.length;
        this.counter = this.counter + 1;
        if (counter == 1)
            notify();

    }

    public synchronized int remove() {

        if (this.counter == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        int element = this.buffer[this.currentPosition];
        this.currentPosition = (this.currentPosition + 1) % this.buffer.length;
        this.counter = this.counter - 1;
        if (this.counter == this.buffer.length - 1)
            notify();

        return element;
    }

    public int getBufferSize() {
        return this.buffer.length;
    }

}
