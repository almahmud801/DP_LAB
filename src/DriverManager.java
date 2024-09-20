public class DriverManager {
    public static Driver findAvailableDriver(RideType rideType, String pickupLocation) {
        return new Driver(1, "John Doe", pickupLocation, 4.5, rideType.name(), new SMSNotificationService());
    }

}
