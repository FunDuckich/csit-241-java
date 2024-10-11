package org.knit.lab1;

public class Task1 {

    public void execute() {
        String line = "";
        for (int i = 1; i <= 100; i++) {
            line += i;
            if (i != 100) {
                line += ",";
            }
            if (i % 10 == 0) {
                line += "\n";
            }
        }
        System.out.println(line);
    }
}
