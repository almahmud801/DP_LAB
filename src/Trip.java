
public class Trip {
    private static int tripCounter = 0;
    private int id;
    private String pickupLocation;
    private String dropOffLocation;
    private RideType rideType;
    private TripStatus status;
    private double fare;
    private double distance;
    public Driver driver;
    public Rider rider;
    private NotificationService notificationService;
    private boolean isOngoing;

    public Trip(String pickupLocation, RideType rideType, Rider rider) {
        this.id = ++tripCounter;
        this.pickupLocation = pickupLocation;
        this.rideType = rideType;
        this.status = TripStatus.REQUESTED;
        this.rider = rider;
        this.fare = calculateFare();
        this.distance = calculateDistance();
        this.isOngoing = true;
        rider.recieveNotification("Ride requested successfully.");
    }

    public void setDropOffLocation(String newDropOffLocation) {
        if(this.isOngoing) {
            this.dropOffLocation = newDropOffLocation;
            this.distance = calculateDistance();
            this.fare = calculateFare();

            // Notify rider and driver of change
            rider.receiveNotification("Drop-off location updated to: " + newDropOffLocation);
            if (driver != null) {
                driver.receiveNotification("Rider updated the drop-off location to: " + newDropOffLocation);
            }
        } else {
            rider.receiveNotification("Drop-off location can't be changed");
        }
    }

    public double calculateFare() {
        double baseFare = rideType.getBaseFare();
        double distanceFare = distance * rideType.getPricePerKm();
        double timeFactor = getTimeFactor();
        return (baseFare + distanceFare) * timeFactor;
    }

    private double calculateDistance() {
        return 10.0;
    }

    private double getTimeFactor() {
        int currentHour = java.time.LocalTime.now().getHour();
        return (currentHour >= 22 || currentHour < 6) ? 1.5 : 1.0;
    }

    public void assignDriver() {
        Driver driver = DriverManager.findAvailableDriver(rideType, pickupLocation);
        if (driver != null) {
            this.driver = driver;
            driver.setAvailability(false);
            driver.acceptRide(this);
            rider.recieveNotification("Driver found: " + driver.name);
            driver.recieveNotification("Ride assigned to you.");
        } else {
            rider.recieveNotification("No drivers available.");
            setStatus(TripStatus.CANCELLED);
        }
    }

    public void setStatus(TripStatus status) {
        this.status = status;
        if (status == TripStatus.COMPLETED) {
            completeTrip();
        }
    }

    public void completeTrip() {
        rider.recieveNotification("Trip completed.");
        driver.recieveNotification("Trip completed.");
        rider.makePayment(fare);
        driver.setAvailability(true);
    }
}
