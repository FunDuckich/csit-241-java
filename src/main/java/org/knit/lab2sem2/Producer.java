package org.knit.lab2sem2;

public class Producer extends Thread {
    public final int TIME_OF_PRODUCING = 500;
    private final DistributionPoint distributionPoint;

    public Producer(DistributionPoint distributionPoint) {
        this.distributionPoint = distributionPoint;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 6) { // Produce 5 items
            try {
                i++;
                Thread.sleep(TIME_OF_PRODUCING);
                distributionPoint.produceItem("Товар " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Производитель завершил производство.");
    }
}