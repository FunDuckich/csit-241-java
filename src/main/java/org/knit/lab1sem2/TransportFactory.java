package org.knit.lab1sem2;

public class TransportFactory {
    public static Transport createTransport(TripType tripType) {
        switch (tripType) {
            case FAMILY:
                return new FamilyVan();
            case BUSINESS:
                return new BusinessCar();
            case DELIVERY:
                return new Motorbike();
            default:
                throw new IllegalArgumentException("Invalid trip type");
        }
    }
}
