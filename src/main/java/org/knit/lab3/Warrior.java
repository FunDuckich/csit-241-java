package org.knit.lab3;

public class Warrior extends Player implements Melee {

    public Warrior(String name, float posX, float posY) {
        super(name, posX, posY);
        setDamageValue(25);
        setAttackRange(1);
        setMaxHealth(150);
    }

    @Override
    public void attack(Object t) {
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
                    System.out.println("Зарезать себя нельзя!");
                }
            }
        }
        else {
            System.out.println("Будучи мёртвым ты даже меч не поднимеш");
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Мечник ").append(getName()).append(".")
                .append("\nНаходится на координатах ").append(getPosX()).append(", ").append(getPosY())
                .append(".")
                .append("\nМожет нанести ").append(getDamageValue()).append(" урона")
                .append(" на расстоянии ").append(getAttackRange()).append("м.").toString();
    }
}
