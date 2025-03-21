package org.knit.lab2sem2;

public class Task7 {
    public static void execute() throws InterruptedException {
        DistributionPoint distributionPoint = new DistributionPoint();
        Producer producer = new Producer(distributionPoint);
        Consumer consumer = new Consumer(distributionPoint);

        producer.start();
        consumer.start();
    }

    public static void main(String[] args) throws InterruptedException {
        execute();
    }
}