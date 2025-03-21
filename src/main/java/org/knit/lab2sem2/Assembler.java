package org.knit.lab2sem2;

import java.util.concurrent.BlockingQueue;

public class Assembler extends Thread {
    public final int TIME_TO_ASSEMBLE = 2000;
    private final BlockingQueue<Part> blanksForAssemblyQueue;
    private final BlockingQueue<Part> assembledPartsForInspectionQueue;

    public Assembler(BlockingQueue<Part> blanksForAssemblyQueue, BlockingQueue<Part> assembledPartsForInspectionQueue) {
        this.blanksForAssemblyQueue = blanksForAssemblyQueue;
        this.assembledPartsForInspectionQueue = assembledPartsForInspectionQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Part partToAssemble = blanksForAssemblyQueue.take();
                Thread.sleep(TIME_TO_ASSEMBLE);
                assembledPartsForInspectionQueue.put(partToAssemble);
                System.out.println(partToAssemble + " обработана");
            } catch (InterruptedException e) {
                System.out.println("Сборщик завершил работу.");
            }
        }
        System.out.println("Сборщик завершил работу.");
    }
}