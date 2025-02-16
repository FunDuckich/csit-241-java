package org.knit.lab1sem2;

public class Task2_3 {
    public static void execute() {
        System.out.println(TransportFactory.createTransport(TripType.BUSINESS).getSpecifications());
    }
}
