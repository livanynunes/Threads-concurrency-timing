package src.producer_consumer;

import java.util.Random;

public class MonitorSolution {

    private int bufferSize;

    public MonitorSolution(int bufferSize, int numberOfConsumer, int numberOfProducer) {
        this.bufferSize = bufferSize;
        Monitor monitor = new Monitor(this.bufferSize);
        System.out.println("producer " + monitor);

        for (int i = 0; i < numberOfProducer; i++) {
            new ProducerMon(monitor);

        }
        for (int i = 0; i < numberOfConsumer; i++) {
            new ConsumerMon(monitor);
        }
    }

}

class ProducerMon implements Runnable {
    Monitor monitor;

    public ProducerMon(Monitor monitor) {
        this.monitor = monitor;
        Thread producer = new Thread(this);
        producer.start();
    }

    public void run() {
        while (true) {
            Random rand = new Random();
            int element = rand.nextInt(this.monitor.getBufferSize()) + 1;
            System.out.println("++[" + element + "]");
            this.monitor.add(element);
        }
    }
}

class ConsumerMon implements Runnable {
    Monitor monitor;

    public ConsumerMon(Monitor monitor) {
        this.monitor = monitor;
        Thread consumer = new Thread(this);
        consumer.start();
    }

    public void run() {
        while (true) {

            int element = monitor.remove();
            System.out.println("--[" + element + "]");
        }
    }
}
