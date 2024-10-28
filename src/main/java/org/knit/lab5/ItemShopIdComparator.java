package org.knit.lab5;

import java.util.Comparator;

public class ItemShopIdComparator implements Comparator<ShopItem> {

    @Override
    public int compare(ShopItem o1, ShopItem o2) {
        return Integer.compare(o1.getShopId(), o2.getShopId());
    }
}
