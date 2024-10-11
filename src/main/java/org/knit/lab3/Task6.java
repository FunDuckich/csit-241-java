package org.knit.lab3;

public class Task6 {
    public void execute() {
        Casting mag = new Mage("Платон", 2, 4);
        Healing priest = new Priest("Панкратов", 1, 3);
        Melee warrior = new Warrior("Егор", 0, 4);

        mag.cast(priest);
        warrior.attack(priest);
        priest.heal(mag);
        warrior.attack(priest);
        warrior.attack(priest);
        mag.cast(priest);
        warrior.attack(warrior);
    }
}
