public class Main {
    public static void main(String[] args) {
        PaymentMethod paymentMethod = new CardPayment();
        NotificationService notificationService = new SMSNotificationService();

        Rider rider = new Rider(1, "Alice", "Uptown", 4.0, paymentMethod, notificationService);
        Trip trip = rider.requestRide("Uptown", "Downtown", RideType.CARPOOL);

        // Simulate trip completion
        if (trip.driver != null) {
            trip.setStatus(TripStatus.COMPLETED);
            rider.rateDriver(trip.driver, 5.0);
            trip.driver.rateRider(rider, 4.5);
        }

        // Admin operations
        Admin admin = new Admin(1, "Admin", "System Administrator");
        admin.viewTripHistory();
        admin.handleDispute();
    }
}
