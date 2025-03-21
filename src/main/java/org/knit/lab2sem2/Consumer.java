package org.knit.lab2sem2;

public class Consumer extends Thread {
    public final int TIME_OF_CONSUMING = 2000; // Time to consume an item
    private final DistributionPoint distributionPoint;

    public Consumer(DistributionPoint distributionPoint) {
        this.distributionPoint = distributionPoint;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 6) { // Consume 5 items
            try {
                i++;
                String item = distributionPoint.consumeItem();
                System.out.println("Потребитель забрал: " + item + ". Осталось на складе: " + distributionPoint.getItemCount());
                Thread.sleep(TIME_OF_CONSUMING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Потребитель завершил потребление.");
    }
}