package org.knit.lab3;

public class Mage extends Player implements Casting {

    public Mage(String name, float posX, float posY) {
        super(name, posX, posY);
        setDamageValue(15);
        setAttackRange(15);
        setMaxHealth(100);
    }

    @Override
    public void cast(Player target) {
        if (calculateDistance(target.getPosX(), target.getPosY()) <= getAttackRange()) {
            target.decreaseHealth(getDamageValue());
            System.out.println(getName() + " нанёс " + getDamageValue() +
                    " урона " + target.getName());
        }
    }
}
