package org.knit.lab3;

public class Mage extends Player implements Casting {

    public Mage(String name, float posX, float posY) {
        super(name, posX, posY);
        setDamageValue(15);
        setAttackRange(15);
        setMaxHealth(100);
    }

    @Override
    public void cast(Object t) {
        if (checkIsAlive()) {
            if (t instanceof Player) {
                if (t != this) {
                    Player target = (Player) t;
                    if (calculateDistance(target.getPosX(), target.getPosY()) <= getAttackRange()) {
                        target.decreaseHealth(getDamageValue());
                        System.out.println(new StringBuilder().append(getName()).append(" нанёс ")
                                .append(getDamageValue()).append(" урона ").append(target.getName())
                                .append("."));
                    } else {
                        System.out.println(new StringBuilder().append(getName()).append(" слишком далеко от ")
                                .append(target.getName()).append("."));
                    }
                }
                else {
                    System.out.println("Зачем себя очернять магией?");
                }
            }
        }
        else {
            System.out.println("Мёрвые не кастуют лол....");
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Маг ").append(getName()).append(".")
                .append("\nНаходится на координатах ").append(getPosX()).append(", ").append(getPosY())
                .append(".")
                .append("\nМожет нанести ").append(getDamageValue()).append(" урона")
                .append(" на расстоянии ").append(getAttackRange()).append("м.").toString();
    }
}
