package src.producer_consumer;

public class SemaphoreSolution {

    public SemaphoreSolution(int bufferSize, int numberOfConsumer, int numberOfProducer) {

        Buffer buffer = new Buffer();

        for (int i = 0; i < numberOfConsumer; i++) {
            new ConsumerSem(buffer, bufferSize);
        }
        for (int i = 0; i < numberOfProducer; i++) {
            new ProducerSem(buffer, bufferSize);
        }
    }
}

class ProducerSem implements Runnable {
    Buffer buffer;
    int bufferSize;

    public ProducerSem(Buffer buffer, int bufferSize) {
        this.buffer = buffer;
        this.bufferSize = bufferSize;
        Thread producer = new Thread(this);
        producer.start();
    }

    public void run() {
        for (int i = 0; i < bufferSize; i++) {
            buffer.setBufferElement(i);
        }
    }
}

class ConsumerSem implements Runnable {
    Buffer buffer;
    int bufferSize;

    public ConsumerSem(Buffer buffer, int bufferSize) {
        this.buffer = buffer;
        this.bufferSize = bufferSize;
        Thread consumer = new Thread(this);
        consumer.start();
    }

    public void run() {
        for (int i = 0; i < bufferSize; i++) {
            buffer.getBufferElement();
        }
    }
}