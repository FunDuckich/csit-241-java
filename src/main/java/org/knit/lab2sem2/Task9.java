package org.knit.lab2sem2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Task9 {
    public static void execute() throws InterruptedException {
        BlockingQueue<Part> blanksForAssemblyQueue = new LinkedBlockingQueue<>(5);
        BlockingQueue<Part> assembledPartsForInspectionQueue = new LinkedBlockingQueue<>(5);

        Stamper stamper = new Stamper(blanksForAssemblyQueue);
        Assembler assembler = new Assembler(blanksForAssemblyQueue, assembledPartsForInspectionQueue);
        QualityControlOperator qualityControlOperator = new QualityControlOperator(assembledPartsForInspectionQueue);

        stamper.start();
        assembler.start();
        qualityControlOperator.start();

        stamper.join();

        assembler.join();
        qualityControlOperator.join();

        System.out.println("Конвейер сборки завершил работу.");
    }
}