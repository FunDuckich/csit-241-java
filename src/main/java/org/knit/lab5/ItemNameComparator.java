package org.knit.lab5;

import java.util.Comparator;

public class ItemNameComparator implements Comparator<ShopItem> {

    @Override
    public int compare(ShopItem o1, ShopItem o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
