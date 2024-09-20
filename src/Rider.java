

 public class Rider extends User {
    private PaymentMethod preferredPaymentMethod;

    public Rider(int id, String name, String location, double rating, PaymentMethod preferredPaymentMethod, NotificationService notificationService) {
        super(id, name, location, rating, notificationService);
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

     public Trip requestRide(String pickupLocation, String dropOffLocation, RideType rideType) {
         Trip trip = new Trip(pickupLocation, dropOffLocation, rideType, this);
         trip.assignDriver();
         return trip;
     }

    public void rateDriver(Driver driver, double rating) {
        driver.updateRating(rating);
    }

    public void makePayment(double amount) {
        preferredPaymentMethod.processPayment(amount);
    }



     @Override
     public void recieveNotification(String message) {
            notificationService.sendNotification(this, message);

     }
 }
