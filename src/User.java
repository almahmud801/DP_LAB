public abstract class User {
    private int id;
    protected String name;
    protected String location;
    protected double rating;
    protected NotificationService notificationService;

    public User(int id, String name, String location, double rating, NotificationService notificationService) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.notificationService = notificationService;
    }
    public abstract void recieveNotification(String message);

    public void updateRating(double newRating) {
        this.rating = (this.rating + newRating) / 2;
    }

}
