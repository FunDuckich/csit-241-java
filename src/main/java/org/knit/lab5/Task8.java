package org.knit.lab5;

import java.util.Arrays;
import java.util.Random;

public class Task8 {
    ShopItem[] testData = new ShopItem[100];

    public void execute() {
        generateRandomData();
        System.out.println("Массив с тестовыми данными: " + Arrays.toString(testData));
        ShopItem[] nameSortedItems = testData.clone();
        Arrays.sort(nameSortedItems, new ItemNameComparator());
        System.out.println("Товары, отсортированные по названию: " + Arrays.toString(nameSortedItems));
        ShopItem[] priceSortedItems = testData.clone();
        Arrays.sort(priceSortedItems, new ItemPriceComparator());
        System.out.println("Товары, отсортированные по цене: " + Arrays.toString(priceSortedItems));
        ShopItem[] shopIdSortedItems = testData.clone();
        Arrays.sort(shopIdSortedItems, new ItemShopIdComparator());
        System.out.println("Товары, отсортированные по магазину: " + Arrays.toString(shopIdSortedItems));
        System.out.println("\nПары одинаковых товаров:");
        int count = 0;
        for (int i = 0; i < shopIdSortedItems.length - 1; i++) {
            for (int j = i + 1; j < shopIdSortedItems.length; j++) {
                if (testData[i].equals(testData[j])) {
                    System.out.println(testData[i] + ", " + testData[j]);
                    count++;
                }
            }
        }
        System.out.println("Кол-во пар одинаковых товаров: " + count);
    }

    private void generateRandomData() {
        String[] names = {"книга", "ручка", "линейка", "пинал", "карандаш", "ланч-бокс"};

        for (int i = 0; i < testData.length; i++) {
            Random random = new Random();
            int index = random.nextInt(6);
            ShopItem item = new ShopItem(names[index], random.nextInt(3), random.nextInt(100));
            testData[i] = item;
        }
    }
}
