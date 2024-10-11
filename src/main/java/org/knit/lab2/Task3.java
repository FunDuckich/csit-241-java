package org.knit.lab2;

import java.util.Objects;
import java.util.Scanner;

public class Task3 {
    private double first;
    private double second;
    private String operator;

    public void execute() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Введите первое число (или 'exit'): ");
            String inp = in.next();
            if (Objects.equals(inp, "exit")) {
                in.close();
                break;
            }
            first = Double.parseDouble(inp);
            System.out.print("Введите оператор (+, -, *, /): ");
            operator = in.next();
            System.out.print("Введите второе число: ");
            second = in.nextDouble();
            Calculator calc = new Calculator(first, second, operator);
        }
        in.close();
    }

    static class Calculator {
        final double a;
        final double b;
        final String op;

        public Calculator(double a, double b, String op) {
            this.a = a;
            this.b = b;
            this.op = op;

            calculate();
        }

        public void add() {
            double res = a + b;
            System.out.println("Результат: " + res + "\n");
        }

        public void subtract() {
            double res = a - b;
            System.out.println("Результат: " + res + "\n");
        }

        public void multiply() {
            double res = a * b;
            System.out.println("Результат: " + res + "\n");
        }

        public void divide() {
            if (b == 0) {
                System.out.println("Делить на ноль нельзя!" + "\n");
            } else {
                double res = a / b;
                System.out.println("Результат: " + res + "\n");
            }
        }

        private void calculate() {
            if (op.equals("+")) {
                add();
            }
            if (op.equals("-")) {
                subtract();
            }
            if (op.equals("*")) {
                multiply();
            }
            if (op.equals("/")) {
                divide();
            }
        }
    }
}
