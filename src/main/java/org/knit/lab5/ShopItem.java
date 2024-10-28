package org.knit.lab5;

import java.util.Objects;

public class ShopItem {
    private final String name;
    private final int shopId;
    private int price;

    public ShopItem(String name, int price, int shopId) {
        this.name = name;
        setNewPrice(price);
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getShopId() {
        return shopId;
    }

    public void setNewPrice(int newPrice) {
        this.price = newPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ShopItem otherItem = (ShopItem) obj;
        return name.equals(otherItem.name) && price == otherItem.price && shopId == otherItem.shopId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, shopId);
    }

    @Override
    public String toString() {
        return "(" + name + ", " + price + ", " + shopId + ")";
    }
}
