package org.knit.lab2sem2;

import java.util.concurrent.BlockingQueue;

public class Stamper extends Thread {
    public final int TIME_TO_STAMP = 1000;
    private final BlockingQueue<Part> blanksForAssemblyQueue;

    public Stamper(BlockingQueue<Part> blanksForAssemblyQueue) {
        this.blanksForAssemblyQueue = blanksForAssemblyQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(TIME_TO_STAMP);
                Part part = new Part(i);
                blanksForAssemblyQueue.put(part);
                System.out.println(part + " создана");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Штамповщик завершил работу.");
    }
}