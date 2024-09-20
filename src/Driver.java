public class Driver extends User {
    private String vehicleType;
    private boolean availability;

    public Driver(int id, String name, String location, double rating, String vehicleType, NotificationService notificationService) {
        super(id, name, location, rating, notificationService);
        this.vehicleType = vehicleType;
        this.availability = true;
    }

    @Override
    public void recieveNotification(String message) {
        notificationService.sendNotification(this, message);

    }

    public void acceptRide(Trip trip) {
        trip.setStatus(TripStatus.ACCEPTED);
        recieveNotification("You have accepted a new ride.");
    }

    public void updateLocation(String newLocation) {

        this.location = newLocation;

    }

    public void startTrip(Trip trip) {
        trip.setStatus(TripStatus.IN_PROGRESS);
        recieveNotification("Trip started.");
    }

    public void rateRider(Rider rider, double rating) {
        rider.updateRating(rating);
    }



    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


}
