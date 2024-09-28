package org.knit.lab3;

public class Task6 {
    public void execute() {
        Casting mag1 = new Mage("Платон", 2, 4);
        Player mag2 = new Mage("Панкратов", 1, 3);
        mag1.cast(mag2);
    }
}
