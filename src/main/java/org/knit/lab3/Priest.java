package org.knit.lab3;

public class Priest extends Player implements Healing {

    public Priest(String name, float posX, float posY) {
        super(name, posX, posY);
        setDamageValue(35);
        setAttackRange(5);
        setMaxHealth(70);
    }


    @Override
    public void heal(Object t) {
        if (checkIsAlive()) {
            if (t instanceof Player) {
                Player target = (Player) t;
                if (calculateDistance(target.getPosX(), target.getPosY()) <= getAttackRange()) {
                    target.increaseHealth(getDamageValue());
                    System.out.println(new StringBuilder().append(getName()).append(" излечил ")
                            .append(target.getName()).append(" на ").append(getDamageValue())
                            .append(" здоровья."));
                } else {
                    System.out.println(new StringBuilder().append(getName()).append(" слишком далеко от ")
                            .append(target.getName()).append("."));
                }
            }
        } else {
            System.out.println("Как мёртвый может лечить?");
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Священник ").append(getName()).append(".")
                .append("\nНаходится на координатах ").append(getPosX()).append(", ").append(getPosY())
                .append(".")
                .append("\nМожет излечить ").append(getDamageValue()).append(" здоровья")
                .append(" на расстоянии ").append(getAttackRange()).append("м.").toString();
    }
}
