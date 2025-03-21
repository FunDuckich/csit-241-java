package org.knit.lab2sem2;

import java.util.ArrayList;
import java.util.List;

public class DistributionPoint {
    private final List<String> storage;

    public DistributionPoint() {
        this.storage = new ArrayList<>();
    }

    public synchronized void produceItem(String item) throws InterruptedException {
        int MAX_STORAGE_SIZE = 3;
        while (storage.size() >= MAX_STORAGE_SIZE) {
            System.out.println("Склад заполнен. Производитель ждет...");
            wait();
        }
        storage.add(item);
        System.out.println("Производитель произвел: " + item + ". Товаров на складе: " + storage.size());
        notify();
    }

    public synchronized String consumeItem() throws InterruptedException {
        while (storage.isEmpty()) {
            System.out.println("Склад пуст. Потребитель ждет...");
            wait();
        }
        String item = storage.remove(0);
        notify();
        return item;
    }

    public synchronized int getItemCount() {
        return storage.size();
    }
}