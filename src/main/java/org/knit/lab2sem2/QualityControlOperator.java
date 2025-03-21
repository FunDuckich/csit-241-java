package org.knit.lab2sem2;

import java.util.concurrent.BlockingQueue;

public class QualityControlOperator extends Thread {
    public final int TIME_TO_INSPECT = 1500;
    private final BlockingQueue<Part> assembledPartsForInspectionQueue;

    public QualityControlOperator(BlockingQueue<Part> assembledPartsForInspectionQueue) {
        this.assembledPartsForInspectionQueue = assembledPartsForInspectionQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Part partToInspect = assembledPartsForInspectionQueue.take();
                Thread.sleep(TIME_TO_INSPECT);
                System.out.println(partToInspect.getId() + " проверена и отправлена на склад");
            } catch (InterruptedException e) {
                System.out.println("Оператор контроля завершил работу.");
            }
        }
        System.out.println("Оператор контроля завершил работу.");
    }
}