public enum RideType {
    CARPOOL(30.0, 1.5),
    LUXURY(50.0, 3.0),
    BIKE(20.0, 1.0);

    private final double baseFare;
    private final double pricePerKm;

    RideType(double baseFare, double pricePerKm) {
        this.baseFare = baseFare;
        this.pricePerKm = pricePerKm;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }
}