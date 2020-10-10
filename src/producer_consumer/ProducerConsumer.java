package src.producer_consumer;

public class ProducerConsumer {
    private int bufferSize;
    private int numberOfConsumer;
    private int numberOfProducer;
    private String methodType;

    public ProducerConsumer(int bufferSize, int producers, int consumers, String method) {
        this.bufferSize = bufferSize;
        this.numberOfProducer = producers;
        this.numberOfConsumer = consumers;
        this.methodType = method;
    }

    public void init() {
        this.main();
    }

    public void main() {
        if (methodType == "semaforo") {
            new SemaphoreSolution(this.bufferSize, this.numberOfConsumer, this.numberOfProducer);
        } else {
            new MonitorSolution(this.bufferSize, this.numberOfConsumer, this.numberOfProducer);
        }
    }

    public int getBufferSize() {
        return this.bufferSize;
    }
}
